package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.Conexao;
import br.com.entidade.Cliente;
import br.com.entidade.Carro;

public class ClienteDAO {

	public boolean cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
		//Alterações..
		String SQL = "insert into cliente (nome, email, telefone, sexo) values (?,?,?,?)";
		Connection con = Conexao.getConexao();
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(SQL);
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getEmail());
				ps.setString(3, cliente.getTelefone());
				ps.setString(4, String.valueOf(cliente.getSexo()));
				ps.execute();
				con.close();

			} catch (SQLException e) {
				return false;
			}
			return true;
		}
		return false;

	}

	public static List<Cliente> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		Cliente cliente = null;
		

		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement query = con.prepareStatement("SELECT id, nome, email, telefone, sexo FROM cliente ");
			ResultSet result = query.executeQuery();

			while (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt(1));
				cliente.setNome(result.getString(2));
				cliente.setEmail(result.getString(3));
				cliente.setTelefone(result.getString(4));
				cliente.setSexo(result.getString(5).charAt(0));
				lista.add(cliente);

			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}
	
	public static void excluirCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM cliente WHERE id = ? ");
			ps.setInt(1, cliente.getId());
			ps.execute();
			con.close();
			System.out.println("se ferreou!!!!!!!!!!!!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static Cliente consultarPorId(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		Cliente cliente = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT id, nome, email, telefone, sexo FROM cliente  WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setSexo(rs.getString("sexo").charAt(0));
			}
			con.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cliente;
		
	}
	public static void alterarProduto(Cliente cliente) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE cliente  set nome = ?,  email = ?, telefone = ?, sexo = ? WHERE id = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, String.valueOf(cliente.getSexo()));
			ps.setInt(5, cliente.getId());

			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
