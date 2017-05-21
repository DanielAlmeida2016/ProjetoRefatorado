package projeto.refatorado.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import projeto.refatorado.model.ItensNota;
import projeto.refatorado.model.Nota;

public class NotaDAO {

	public long gerarNota(Nota nota) throws IOException{

		String sqlInsert = "INSERT INTO nota (data, fornecedor, cnpj, observacao) VALUES (?, ?, ?, ?);";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			Date data = new Date();
			Timestamp timestamp = new Timestamp(data.getTime());
			
			stm.setTimestamp(1, timestamp);
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
		String sqlDelete = "DELETE FROM nota WHERE idNota = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setLong(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	public Nota carregarNota(long id) {
		Nota nota = new Nota();
		List<ItensNota> itens = null;
		ItensNota itemNota = null;
		nota.setId(id);
		String sqlSelect = "select n.data, n.fornecedor, n.cnpj, n.observacao, it.qtdComprada FROM nota n "
				+ "inner join itens_nota it on n.idNota = it.idNota " 
				+ "inner join produto p on it.id = p.id;";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setLong(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					nota.setData(rs.getTimestamp("data"));
					nota.setFornecedor(rs.getString("fornecedor"));
					nota.setCnpj(rs.getString("cnpj"));
					nota.setObservacao(rs.getString("observacao"));

					try (ResultSet rs1 = stm.executeQuery();) {
						if (rs1.next()) {
							itemNota.setId(rs1.getLong("id"));
							itemNota.getProduto().setCategoria(rs1.getString("categoria"));
							itemNota.getProduto().setDescricao(rs1.getString("descricao"));
							itemNota.getProduto().setQuantidade(rs.getInt("quantidade"));
							itemNota.getProduto().setValorCompra(rs1.getDouble("valorCompra"));
							itemNota.getProduto().setValorVenda(rs1.getDouble("valorVenda"));
							itemNota.setQtdComprada(rs1.getInt("qtdComprada"));	
							
							itens.add(itemNota);
							
							nota.setItensNota(itens);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
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
		List<Nota> notas = null;
		List<ItensNota> itens = null;
		ItensNota itemNota = null;
		
		String sqlSelect = "select * from nota";
		long idNota = 0;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					Nota nota = new Nota();
					nota.setId(rs.getLong("id"));
					nota.setData(rs.getTimestamp(	"data"));
					nota.setFornecedor(rs.getString("fornecedor"));
					nota.setCnpj(rs.getString("cnpj"));
					nota.setObservacao(rs.getString("observacao"));
					
					try (ResultSet rs1 = stm.executeQuery();) {
						if (rs1.next()) {
							itemNota.setId(rs1.getLong("id"));
							itemNota.getProduto().setCategoria(rs1.getString("categoria"));
							itemNota.getProduto().setDescricao(rs1.getString("descricao"));
							itemNota.getProduto().setQuantidade(rs.getInt("quantidade"));
							itemNota.getProduto().setValorCompra(rs1.getDouble("valorCompra"));
							itemNota.getProduto().setValorVenda(rs1.getDouble("valorVenda"));
							
							itemNota.setQtdComprada(rs1.getInt("qtdComprada"));

							itens.add(itemNota);
							
							nota.setItensNota(itens);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					notas.add(nota);
					//notas.add(itens);
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
