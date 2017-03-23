package projeto.refatorado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.refatorado.model.Produto;

public class ProdutoDAO {

	public void criar(Produto produto) {
		
		System.out.println(produto.toString());
		
		String sqlInsert = "INSERT INTO produto(categoria, descricao, fornecedor, valorCompra, valorVenda, quantidade, imagem) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, produto.getCategoria());
			stm.setString(2, produto.getDescricao());
			stm.setString(3, produto.getFornecedor());
			stm.setDouble(4, produto.getValorCompra());
			stm.setDouble(5, produto.getValorVenda());
			stm.setInt(6, produto.getQuantidade());
			stm.setBytes(7, produto.getImagem());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Produto produto) {
		String sqlUpdate = "UPDATE produto SET categoria=?, descricao=?, fornecedor=?, valorCompra=?, valorVenda=?, quantidade=?, imagem=?  WHERE id=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, produto.getCategoria());
			stm.setString(2, produto.getDescricao());
			stm.setString(3, produto.getFornecedor());
			stm.setDouble(4, produto.getValorCompra());
			stm.setDouble(5, produto.getValorVenda());
			stm.setInt(6, produto.getQuantidade());
			stm.setBytes(7, produto.getImagem());
			stm.setLong(8, produto.getId());
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
		String sqlSelect = "SELECT categoria, descricao, fornecedor, valorCompra, valorVenda, quantidade, imagem, id FROM produto WHERE produto.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setLong(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {					
					produto.setCategoria(rs.getString("categoria"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setFornecedor(rs.getString("fornecedor"));
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

}
