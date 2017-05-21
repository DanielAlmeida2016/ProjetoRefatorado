package projeto.refatorado.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.refatorado.model.ItensNota;
import projeto.refatorado.model.Nota;
import projeto.refatorado.model.Produto;

public class ItensNotaDAO {
	
	Produto produto;

	public long gerarItensNota(Produto produto, long notaId, int qtdComprada) throws IOException{
		String sqlInsert = "INSERT INTO itens_nota (prodId, notaId, qtdComprada) VALUES (?, ?, ?);";

		ItensNota itens = new ItensNota();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setLong(1, produto.getId());
			stm.setLong(2, notaId);
			stm.setInt(3, qtdComprada);
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					itens.setId(rs.getLong(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens.getId();
	}

	public void excluirItensNota(long id) {
		String sqlDelete = "DELETE FROM itens_nota WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setLong(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public ItensNota carregarItensNota(long id) {
		ItensNota itens = new ItensNota();
		itens.setId(id);
		String sqlSelect = "SELECT prodId, notaId, qtdComprada, id FROM itens_nota WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setLong(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					itens.setProdId(rs.getLong("prodId"));
					itens.setNotaId(rs.getLong("nota"));
					itens.setQtdComprada(rs.getInt("qtdComprada"));
					itens.setId(rs.getLong("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return itens;
	} */

	/* public ArrayList<ItensNota> listarTodosItensNota(long id) {
		ArrayList<ItensNota> itens = new ArrayList<ItensNota>();
		String sqlSelect = "select * from itens_nota where idNota = " + id;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					ItensNota in = new ItensNota();
					in.setId(rs.getLong("id"));
					//in.setProdId(rs.getLong("prodId"));
					in.setNotaId(rs.getLong("notaId"));
					in.setQtdComprada(rs.getInt("qtdComprada"));

					itens.add(in);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return itens;
	} */

}
