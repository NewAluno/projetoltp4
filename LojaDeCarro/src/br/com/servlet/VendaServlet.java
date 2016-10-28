package br.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.CarroBO;
import br.com.BO.ClienteBO;
import br.com.entidade.Carro;
import br.com.entidade.Cliente;

public class VendaServlet extends HttpServlet {
	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao = req.getParameter("acao");
		HttpSession session = req.getSession();
		String msg = null;
		ClienteBO clienteBO = new ClienteBO();
		CarroBO carroBO = new CarroBO();

		if ((session.getAttribute("user") != null && session.getAttribute("senha") != null)) {
			
			if(acao.equals("Vender")){

				try {

					List<Cliente> clientes;
					clientes = clienteBO.listarTodos();
					req.setAttribute("clientes", clientes);
					
					List<Carro> carros;
					carros = carroBO.listarTodos();
					req.setAttribute("carros", carros);
					
					req.getRequestDispatcher("jsp/venda/RealizarVenda.jsp").forward(req, resp);

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
					msg = "Chame o suporte e peça para que Verifique o driver de coneção com o Mysql!" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/venda.jsp").forward(req, resp);

				} catch (SQLException e) {
					
					msg = "	Erro ao listar os clientes disponíveis!\n" + e;
					e.printStackTrace();
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
