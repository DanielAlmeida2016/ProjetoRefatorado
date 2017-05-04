package projeto.refatorado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.refatorado.model.Produto;

public class ProdutoDAO {

	public void criar(Produto produto) {

		String sqlInsert = "INSERT INTO produto(categoria, descricao, valorCompra, valorVenda, quantidade, imagem) VALUES (?, ?, ?, ?, ?, ?);";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, produto.getCategoria());
			stm.setString(2, produto.getDescricao());
			stm.setDouble(3, produto.getValorCompra());
			stm.setDouble(4, produto.getValorVenda());
			stm.setInt(5, produto.getQuantidade());
			stm.setBytes(6, produto.getImagem());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					produto.setId(rs.getLong(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Produto produto) {
		String sqlUpdate = "UPDATE produto SET categoria=?, descricao=?, valorCompra=?, valorVenda=?, quantidade=?, imagem=?  WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, produto.getCategoria());
			stm.setString(2, produto.getDescricao());
			stm.setDouble(3, produto.getValorCompra());
			stm.setDouble(4, produto.getValorVenda());
			stm.setInt(5, produto.getQuantidade());
			stm.setBytes(6, produto.getImagem());
			stm.setLong(7, produto.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluir(Produto produto) {
		String sqlDelete = "DELETE FROM produto WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setLong(1, produto.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Produto carregar(long id) {
		Produto produto = new Produto();
		produto.setId(id);
		String sqlSelect = "SELECT categoria, descricao, valorCompra, valorVenda, quantidade, imagem, id FROM produto WHERE produto.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setLong(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					produto.setCategoria(rs.getString("categoria"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setValorCompra(rs.getDouble("valorCompra"));
					produto.setValorVenda(rs.getDouble("valorVenda"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setImagem(rs.getBytes("imagem"));
					produto.setId(rs.getLong("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return produto;
	}

	public Produto buscarDescricao(String descricao) {
		Produto produto = new Produto();
		produto.setDescricao(descricao);
		String sqlSelect = "SELECT * FROM produto WHERE produto.descricao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, descricao);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					produto.setCategoria(rs.getString("categoria"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setValorCompra(rs.getDouble("valorCompra"));
					produto.setValorVenda(rs.getDouble("valorVenda"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setImagem(rs.getBytes("imagem"));
					produto.setId(rs.getLong("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return produto;
	}

	public List<Produto> listarTodosProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		String sqlSelect = "select * from produto";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					// criando o objeto Contato
					Produto produto = new Produto();
					produto.setId(rs.getLong("id"));
					produto.setCategoria(rs.getString("categoria"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setValorCompra(rs.getDouble("valorCompra"));
					produto.setValorVenda(rs.getDouble("valorVenda"));

					produtos.add(produto);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return produtos;
	}

	public List<Produto> listarPorCategoria(String categoria) {
		List<Produto> produtos = new ArrayList<Produto>();
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		String sqlSelect = "SELECT * FROM produto WHERE categoria produto.categoria =?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					produto.setId(rs.getLong("id"));
					produto.setCategoria(rs.getString("categoria"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setValorCompra(rs.getDouble("valorCompra"));
					produto.setValorVenda(rs.getDouble("valorVenda"));

					produtos.add(produto);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return produtos;
	}

	public int getQuantidade(int id) {

		int quantidade = 0;

		String sqlUpdate = "Select quantidade from produto where id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery()) {

				if (rs.next()) {
					quantidade = rs.getInt("quantidade");
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}

	public void adicionarEstoque(int quantidade, long prdoId) {
		Produto produto = new Produto();
		String sqlUpdate = "UPDATE produto set quantidade = ? where id =? ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, quantidade);
			stm.setLong(2, produto.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
