package br.com.cdb.companye.pessoa;

public interface Pessoa {

	public String getNome();
	
	public void setNome(String nome);

	public String endereco(String endereco);

	public String email(String email);

	public String senha(String senha);

	public long telefone(long telefone);

	public long nascimento(long nascimento);

	public void apresentacao();

	public String toString();

	public void setSaldo(double saldo);

	double getSaldo();
}
