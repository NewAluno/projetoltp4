package br.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.ClienteBO;
import br.com.BO.ProdutoBO;
import br.com.entidade.Cliente;
import br.com.entidade.Produto;
import br.com.entidade.Venda;

public class VendaServlet extends HttpServlet {
	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao = req.getParameter("acao");
		Venda venda = new Venda();
		Cliente cliente = new Cliente();
		Produto produto = new Produto();
		ClienteBO clienteBO = new ClienteBO();
		ProdutoBO produtoBO = new ProdutoBO();
		String msg = null;

		HttpSession session = req.getSession();
		req.getSession().setAttribute("venda", venda);

		if ((session.getAttribute("user") != null && session.getAttribute("senha") != null)) {

			if (acao.equals("BuscarCliente")) {
				try {

					List<Cliente> clientes = clienteBO.listarTodos();
					req.setAttribute("clientes", clientes);
					req.getRequestDispatcher("jsp/venda/listaClientes.jsp").forward(req, resp);

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao listar os clientes!!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);

				}

			} else if (acao.equals("EscolherCliente")) {

				try {
					cliente = clienteBO.consultarPorId(Integer.parseInt(req.getParameter("id")));
					venda.setCliente(cliente);
					req.getSession().setAttribute("venda", venda);
					msg = "Foi escolhido o cliente " + cliente.getNome() + " para esta venda!";
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao escolher o cliente!\n" + e;

				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);
				}

			} else if (acao.equals("ListarProduto")) {
				try {

					List<Produto> Lista = produtoBO.listarTodos();
					req.setAttribute("Lista", Lista);
					req.getRequestDispatcher("jsp/venda/listaProdutos.jsp").forward(req, resp);

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao listar os clientes!!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);

				}
			}else if(acao.equals("EscolherProduto")){
				try {
					produto = produtoBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					venda = (Venda) session.getAttribute("venda");
					venda.setProduto(produto);
					session.setAttribute("venda", venda);
					msg = "Produto"+produto.getNome()+" foi adicionado ao carinho com sucesso!";
					
				} catch (NumberFormatException e) {
					msg="Vish, numero em um formato errado.\n "+e;
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!\n" + e;
					e.printStackTrace();
					
				} catch (SQLException e) {
				  msg="erro ao adicionar o produto ao carinho.\n"+e;
					e.printStackTrace();
				}catch(Exception e){
					msg = "temos um problemão.\n"+e;
				}finally {
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);
				}
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
