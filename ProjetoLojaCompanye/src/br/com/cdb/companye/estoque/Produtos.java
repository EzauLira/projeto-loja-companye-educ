package br.com.cdb.companye.estoque;

public class Produtos implements Estoque {
	String g = "\u001B[1;92m", n = "\u001B[1;1m", r = "\u001B[1;91m", stop = "\u001B[0m";

	private String nome, descricao;
	private int quantidade;
	private double preco;
	private static int nextNum = 1;
	private int num;

	public Produtos() {
		this.num = nextNum++;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;

	}

	@Override
	public String getDescricao() {

		return descricao;
	}

	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public double getPreco() {
		return preco;
	}

	@Override
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String toString() {
		return "\n" + g + "ID do curso: " + stop + n + num + stop + g + "\nNome do curso: " + stop + n + nome + stop + g
				+ "\nDescrição: " + stop + n + descricao + stop + g + "\nPreço do curso: " + stop + n + preco + stop + g
				+ "\nVagas abertas: " + stop + n + quantidade + stop + "\n";

	}
}
