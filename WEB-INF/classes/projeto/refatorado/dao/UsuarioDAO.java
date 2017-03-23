package projeto.refatorado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.refatorado.model.Usuario;

public class UsuarioDAO {

	public void adicionar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(usuario, senha) VALUES (?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getSenha());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Usuario usuario) {
		String sqlDelete = "DELETE FROM usuario WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarSenha(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET senha=? WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getSenha());
			stm.setInt(2, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario buscaPorId(int id) {
		Usuario usuario = null;

		String sqlSelect = "SELECT * FROM usuario WHERE id=" + id;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setSenha(rs.getString("senha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return usuario;
	}

	public List<Usuario> listarTodos() {

		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario usuario;

		String sqlSelect = "SELECT * FROM usuario";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setSenha(rs.getString("senha"));

					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public boolean acesso(Usuario usuario) {

		boolean acesso = false;

		String sqlSelect = "SELECT * FROM usuario WHERE usuario=? AND senha=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getSenha());

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					acesso = true;
				} else {
					acesso = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return acesso;
	}

}
