package projeto.refatorado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.refatorado.model.Nota;

public class NotaDAO {

	public long gerarNota(Nota nota) {

		String sqlInsert = "INSERT INTO nota values (data, fornecedor, cnpj, observacao) VALUES (?, ?, ?, ?);";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setDate(1, (Date) nota.getData());
			stm.setString(2, nota.getFornecedor());
			stm.setString(3, nota.getCnpj());
			stm.setString(4, nota.getObservacao());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					nota.setId(rs.getLong(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nota.getId();

	}

	public void excluirNota(long id) {
		String sqlDelete = "DELETE FROM nota WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setLong(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Nota carregarNota(long id) {
		Nota nota = new Nota();
		nota.setId(id);
		String sqlSelect = "SELECT data, fornecedor, cnpj, observacao, id FROM nota WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setLong(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					nota.setData(rs.getDate("data"));
					nota.setFornecedor(rs.getString("fornecedor"));
					nota.setCnpj(rs.getString("cnpj"));
					nota.setObservacao(rs.getString("observacao"));
					nota.setId(rs.getLong("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return nota;
	}

	public List<Nota> listarTodasNotas() {
		List<Nota> notas = new ArrayList<Nota>();
		String sqlSelect = "select * from nota";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					Nota nota = new Nota();
					nota.setId(rs.getLong("id"));
					nota.setData(rs.getDate("data"));
					nota.setFornecedor(rs.getString("fornecedor"));
					nota.setCnpj(rs.getString("cnpj"));
					nota.setObservacao(rs.getString("observacao"));

					notas.add(nota);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return notas;
	}

}
