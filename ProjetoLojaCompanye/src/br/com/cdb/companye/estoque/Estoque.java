package br.com.cdb.companye.estoque;

public interface Estoque {

	public String getNome();

	public void setNome(String nome);

	public String getDescricao();

	public void setDescricao(String descricao);

	public int getQuantidade();

	public void setQuantidade(int quantidade);

	public double getPreco();

	public void setPreco(double preco);
	
	public String toString();

}
