package br.com.entidade;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	private List<Produto> carinho = new ArrayList<>();
	private Cliente cliente = new Cliente();
	
	public List<Produto> getCarinho() {
		return carinho;
	}

	public void setCarinho(List<Produto> carinho) {
		this.carinho = carinho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setProduto(Produto produto){
		carinho.add(produto);
		for (Produto pro : carinho) {
			System.out.println(pro.getNome());
		}
	}

}
