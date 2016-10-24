package br.com.BO;

import java.sql.SQLException;
import java.util.List;

import br.com.DAO.ClienteDAO;
import br.com.DAO.ProdutoDAO;
import br.com.entidade.Cliente;
import br.com.entidade.Produto;

public class ClienteBO {
	 private static ClienteDAO dao = new ClienteDAO();
	public void cadastar(Cliente cliente) throws ClassNotFoundException, SQLException {
		
		dao.cadastrar(cliente);
		
	}

	public static List<Cliente> listarTodos() throws ClassNotFoundException, SQLException {
		
		return dao.listarTodos();
	}

	public Cliente consultarPorId(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.consultarPorId(id);
	}

	public void excluirCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
		dao.excluirCliente(cliente);
		
	}

	public void alterarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
		dao.alterarProduto(cliente);
		
	}

}
