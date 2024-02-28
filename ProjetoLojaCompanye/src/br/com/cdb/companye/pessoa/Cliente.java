package br.com.cdb.companye.pessoa;

public class Cliente implements Pessoa {
	String g = "\u001B[1;92m", n = "\u001B[1;1m", r = "\u001B[1;91m", stop = "\u001B[0m";

	private String nome, endereco, email, senha;
	private long telefone, nascimento, num;
	private double saldo;
	private static int nextNum = 1;

	public Cliente() {
		this.num = nextNum++;
		this.saldo = 100;
	}

	public long getNum() {
		return num;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String endereco(String endereco) {
		return this.endereco = endereco;
	}

	@Override
	public String email(String email) {
		return this.email = email;
	}

	@Override
	public String senha(String senha) {
		return this.senha = senha;
	}

	@Override
	public long telefone(long telefone) {
		return this.telefone = telefone;
	}

	@Override
	public long nascimento(long nascimento) {
		if (nascimento >= 2010) {
			System.out.println(r + "O cadastro não pode ser concluído, pois o cliente é menor de idade." + stop);
			System.exit(0);
		}

		return this.nascimento = nascimento;
	}

	@Override
	public double getSaldo() {
		return saldo;
	}

	@Override
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public void apresentacao() {
		System.out.println(g + "\nNome: " + stop + n + getNome() + stop + g + "\nEndereço: " + stop + n
				+ endereco(endereco) + stop + g + "\nEmail: " + stop + n + email(email) + stop + g + "\nTelefone: "
				+ stop + n + telefone(telefone) + stop + g + "\nAno de nascimento: " + stop + n + nascimento(nascimento)
				+ stop + g + "\nSenha: " + stop + n + senha(senha) + stop);

	}

	@Override
	public String toString() {
		return "\n" + g + "ID do cliente: " + stop + n + num + stop + g + "\nCliente: " + stop + n + nome + stop + g
				+ "\nEndereço: " + stop + n + endereco + stop + g + "\nEmail: " + stop + n + email + stop + g
				+ "\nTelefone: " + stop + n + telefone + stop + g + "\nAno de nascimento: " + stop + n + nascimento
				+ stop + g + "\nSenha: " + stop + n + senha + stop + g + "\nSaldo: " + stop + n + saldo + stop + "\n";
	}

}
