package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.banco.Conexao;
import br.com.entidade.Carro;
import sun.applet.Main;

public class CarroDAO {

	public boolean cadastrar(Carro carro) throws ClassNotFoundException, SQLException {
		String SQL = "insert into carro (nome, preco, fornecedor) values (?,?,?)";
		Connection con = Conexao.getConexao();
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(SQL);
				ps.setString(1, carro.getNome());
				ps.setDouble(2, carro.getPreco());
				ps.setString(3, carro.getFornecedor());
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

	public static List<Carro> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		Carro carro = null;
		String sql = "SELECT id, nome, preco, fornecedor FROM carro ";
		
		List<Carro> lista = new ArrayList<Carro>();
		try {
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();
			
			while (result.next()) {
				carro = new Carro();
				carro.setId(result.getInt(1));
				carro.setNome(result.getString(2));
				carro.setPreco(result.getDouble(3));
				carro.setFornecedor(result.getString(4));
				lista.add(carro);

			}
			
			result.close();
			query.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	public static Carro consultarPorId(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		Carro carro = null;
		try {
			
			PreparedStatement ps = con.prepareStatement("SELECT id, nome, preco, fornecedor FROM carro  WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setNome(rs.getString("nome"));
				carro.setPreco((rs.getDouble("preco")));
				carro.setFornecedor(rs.getString("fornecedor"));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return carro;
	}

	public static void alterarCarro(Carro carro) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE carro  set nome = ?,  preco = ?, fornecedor = ? WHERE id = ?");
			ps.setString(1, carro.getNome());
			ps.setDouble(2, carro.getPreco());
			ps.setString(3, carro.getFornecedor());
			ps.setInt(4, carro.getId());

			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void excluirCarro(Carro carro) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM carro WHERE id = ? ");
			ps.setInt(1, carro.getId());
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	


}
