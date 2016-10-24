package br.com.entidade;

import java.util.List;

public class Venda {
	private List<Produto> listaTemporaria;
	private List<Produto> carinho;
	
	public List<Produto> getCarinho() {
		return carinho;
	}

	public void setCarinho(List<Produto> carinho) {
		this.carinho = carinho;
	}

	private Cliente cliente;

	public List<Produto> getListaTemporaria() {
		return listaTemporaria;
	}

	public void setListaTemporaria(List<Produto> listaTemporaria) {
		this.listaTemporaria = listaTemporaria;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
