package br.com.BO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.DAO.ProdutoDAO;
import br.com.entidade.Produto;

public class ProdutoBO {

	public boolean cadastro(Produto produto) throws ClassNotFoundException, SQLException {
	ProdutoDAO DAO = new ProdutoDAO();
	return DAO.cadastrar(produto);
		
	}

	public static List<Produto> listarTodos() throws ClassNotFoundException, SQLException {
	
		return ProdutoDAO.listarTodos();
	}
	
	

	public static Produto consutarPorId(int Id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ProdutoDAO.consultarPorId(Id);
	}

	public static void alterarProduto(Produto produto) throws ClassNotFoundException, SQLException {
		ProdutoDAO.alterarProduto(produto);
		
	}

	public static void excluirProduto(Produto produto) throws ClassNotFoundException, SQLException {
		ProdutoDAO.excluirProduto(produto);
		
	}

}
