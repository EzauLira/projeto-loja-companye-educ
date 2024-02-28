package br.com.cdb.companye.vendas;

import br.com.cdb.companye.pessoa.Cliente;
import br.com.cdb.companye.estoque.Produtos;

public class RealizarVendas implements Venda {
	String g = "\u001B[1;92m", n = "\u001B[1;1m", r = "\u001B[1;91m", stop = "\u001B[0m";

	private Cliente cliente;
	private Produtos produto;
	private int quantidade;

	public RealizarVendas(Cliente cliente, Produtos produto, int quantidade) {
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	@Override
	public void realizarVenda() {
		if (produto.getQuantidade() >= quantidade) {
			cliente.setSaldo(cliente.getSaldo() - produto.getPreco() * quantidade);
			produto.setQuantidade(produto.getQuantidade() - quantidade);
			System.out.println(g + "Venda realizada com sucesso!" 
					+ "\nCliente " + stop + n + cliente.getNome() + stop
					+ g + " de ID " + stop + n + cliente.getNum() 
					+ g + " possui um saldo de " + stop + n + cliente.getSaldo() + stop 
					+ g + " \nAgora seu curso " + stop + n + produto.getNome() + stop 
					+ g + " de ID " + stop + n + produto.getNum() + stop 
					+ g + " tem um total de " + stop + n + produto.getQuantidade() + stop 
					+ g + " vagas." + stop);
		} else {
			System.out.println(r + "Vagas insuficiente para realizar a venda." + stop);
		}
	}

}