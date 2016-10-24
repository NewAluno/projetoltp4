package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.banco.Conexao;
import br.com.entidade.Produto;
import sun.applet.Main;

public class ProdutoDAO {

	public boolean cadastrar(Produto produto) throws ClassNotFoundException, SQLException {
		String SQL = "insert into produto (nome, preco, fornecedor) values (?,?,?)";
		Connection con = Conexao.getConexao();
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(SQL);
				ps.setString(1, produto.getNome());
				ps.setDouble(2, produto.getPreco());
				ps.setString(3, produto.getFornecedor());
				ps.execute();
				ps.close();
				con.close();

			} catch (SQLException e) {
				return false;
			}
			return true;
		}
		return false;

	}

	public static List<Produto> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		Produto produto = null;
		String sql = "SELECT id, nome, preco, fornecedor FROM produto ";
		
		List<Produto> lista = new ArrayList<Produto>();
		try {
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();
			
			while (result.next()) {
				produto = new Produto();
				produto.setId(result.getInt(1));
				produto.setNome(result.getString(2));
				produto.setPreco(result.getDouble(3));
				produto.setFornecedor(result.getString(4));
				lista.add(produto);

			}
			
			result.close();
			query.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	public static Produto consultarPorId(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		Produto produto = null;
		try {
			
			PreparedStatement ps = con.prepareStatement("SELECT id, nome, preco, fornecedor FROM produto  WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco((rs.getDouble("preco")));
				produto.setFornecedor(rs.getString("fornecedor"));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return produto;
	}

	public static void alterarProduto(Produto produto) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE produto  set nome = ?,  preco = ?, fornecedor = ? WHERE id = ?");
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());
			ps.setString(3, produto.getFornecedor());
			ps.setInt(4, produto.getId());

			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void excluirProduto(Produto produto) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM produto WHERE id = ? ");
			ps.setInt(1, produto.getId());
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	


}
