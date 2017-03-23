package projeto.refatorado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.refatorado.model.Cliente;

public class ClienteDAO {

	/*
	 * private Cliente cliente;
	 * 
	 * public ClienteDAO() { cliente = new Cliente(); }
	 */

	public void criar(Cliente cliente) {
		String sqlInsert = "INSERT INTO cliente(nome, rg, cpf, telefone, email) VALUES (?, ?, ?, ?, ?);";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getRg());
			stm.setString(3, cliente.getCpf());
			stm.setString(4, cliente.getTelefone());
			stm.setString(5, cliente.getEmail());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Cliente cliente) {
		String sqlDelete = "DELETE FROM cliente WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, cliente.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void atualizar(Cliente cliente) {
		String sqlUpdate = "UPDATE cliente SET nome=?, rg=?, cpf=?, telefone=?, email=? WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getRg());
			stm.setString(3, cliente.getCpf());
			stm.setString(4, cliente.getTelefone());
			stm.setString(5, cliente.getEmail());
			stm.setInt(6, cliente.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Cliente buscaPorId(int id) {
		Cliente cliente = null;

		String sqlSelect = "SELECT * FROM cliente WHERE id=" + id;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setRg(rs.getString("cpf"));
					cliente.setCpf(rs.getString("rg"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEmail(rs.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return cliente;
	}

	public List<Cliente> listarTodos() {

		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente cliente;

		String sqlSelect = "SELECT * FROM cliente";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setRg(rs.getString("cpf"));
					cliente.setCpf(rs.getString("rg"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEmail(rs.getString("email"));

					lista.add(cliente);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;

	}

}
