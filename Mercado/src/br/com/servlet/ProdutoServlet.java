package br.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.ProdutoBO;
import br.com.entidade.Produto;

public class ProdutoServlet extends HttpServlet {

	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		acao = req.getParameter("acao");
		String msg = null;
		Produto produto = new Produto();
		ProdutoBO produtoBO = new ProdutoBO();

		HttpSession session = req.getSession();
		if ((session.getAttribute("user") != null && session.getAttribute("senha") != null)) {
			if (acao.equals("inserir")) {
				try {
					produto.setNome(req.getParameter("nome"));
					produto.setPreco(Double.parseDouble(req.getParameter("preco")));
					produto.setFornecedor(req.getParameter("fornecedor"));

					boolean verificacao = produtoBO.cadastro(produto);

					if (verificacao) {
						msg = "O novo produto " + produto.getNome() + " foi cadastrado.";

					} else {
						msg = "O novo produto " + produto.getNome() + " não foi cadastrado.";

					}

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao cadastrar um novo produto\n" + e;

				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/produto.jsp").forward(req, resp);
				}

			} else if (acao.equals("Listar")) {
				try {

					List<Produto> Lista = ProdutoBO.listarTodos();
					req.setAttribute("Lista", Lista);
					req.getRequestDispatcher("jsp/produto/listaProdutos.jsp").forward(req, resp);

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/produto.jsp").forward(req, resp);

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao listar os produtos cadastrados.\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/produto.jsp").forward(req, resp);

				}

			} else if (acao.equals("ConsultarProduto")) {
				try {
					produto = 	produtoBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					req.setAttribute("produto", produto);
					req.getRequestDispatcher("jsp/produto/alterarProduto.jsp").forward(req, resp);

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/produto.jsp").forward(req, resp);

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao culsutar o produto que iria se alterado!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/cliente.jsp").forward(req, resp);

				}
			} else if (acao.equals("Alterar")) {
				try {

					produto.setId((Integer.parseInt(req.getParameter("id"))));
					produto.setNome(req.getParameter("nome"));
					produto.setPreco(Double.parseDouble(req.getParameter("preco")));
					produto.setFornecedor(req.getParameter("fornecedor"));
					produtoBO.alterarProduto(produto);
					msg = "O novo produto " + produto.getNome() + " foi alterado com suscesso!!!.";

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao alterar o produto!\n" + e;

				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/produto.jsp").forward(req, resp);
				}

			} else if (acao.equals("Excluir")) {
				try {

					produto = produtoBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					produtoBO.excluirProduto(produto);
					msg = "O  produto " + produto.getNome() + " foi excluido com suscesso!!!.";

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao excluir o produto!\n" + e;

				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/produto.jsp").forward(req, resp);
				}
			}else{
				System.out.println("Erro na Acao...");
			}

		} else {
			resp.sendRedirect("../Mercado/index.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
