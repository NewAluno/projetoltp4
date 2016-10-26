package br.com.entidade;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	private List<Carro> carinho = new ArrayList<>();
	private Cliente cliente = new Cliente();
	
	public List<Carro> getCarinho() {
		return carinho;
	}

	public void setCarinho(List<Carro> carinho) {
		this.carinho = carinho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setProduto(Carro produto){
		carinho.add(produto);
		for (Carro pro : carinho) {
			System.out.println(pro.getNome());
		}
	}

}
