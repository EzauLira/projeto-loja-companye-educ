package br.com.cdb.companye.principal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import br.com.cdb.companye.pessoa.Cliente;
import br.com.cdb.companye.estoque.Produtos;
import br.com.cdb.companye.vendas.RealizarVendas;

public class Main {

	public static void main(String[] args) {
		String color = "\u001B[47;1;30m", g = "\u001B[1;92m", n = "\u001B[1;1m", m = "\u001B[1;35m", c = "\u001B[1;36m",
				y = "\u001B[1;33m", r = "\u001B[1;91m", stop = "\u001B[0m";

		try {

			try (Scanner input = new Scanner(System.in)) {
				List<Cliente> gc = new ArrayList<>();
				List<Produtos> pd = new ArrayList<>();

				String conf;
				for (int i = 0; i < 73; i++) {
					System.out.print("=");
				}
				System.out.println(color + "\nOlá, ADM! Bem-vindo de volta à sua loja Companye.Educ!!!"
						+ "\n ▼ Escolha uma opção ▼" + stop);

				for (int i = 0; i < 73; i++) {
					System.out.print("=");
				}

				while (true) {
					System.out.println(c+"\n 🗒️ MENU PRINCIPAL 🗒️:\n"+stop 
									   +n+"(1) - Gestão de clientes \n" 
									   + "(5) - Gestão de Estoque\n" 
									   + "(9) - Realizar vendas\n"
									   + "(10) - Sair\n"+stop 
									   +g+"Escolha uma opção: "+stop);
					
					int menu = input.nextInt();
					if(menu == 1) {
						System.out.println(c +"🗒️ MENU CLIENTES 🗒️\n"+ stop 
										  +n+"(2) - Cadastrar cliente\n"
										  +"(3) - Ver clientes\n"
										  +"(4) - Remover clientes\n"
										  +"(0) - Voltar\n"+stop
										  +g+"Escolha uma opção: "+stop);
						menu = input.nextInt();
					}else if(menu == 5) {
						System.out.println(c +" 🗒️ MENU PRODUTOS 🗒️\n"+stop
										  +n+"(6) - Cadastrar cursos\n"
										  +"(7) - Ver cursos\n"
								          +"(8) - Remover cursos\n"
								          +"(0) - Voltar\n"+stop
										  +g+"Escolha uma opção: "+stop);
						menu = input.nextInt();
					}
					switch (menu) {
					case 2:
						// Cadastro Cliente
						do {
							Cliente cliente = new Cliente();

							input.nextLine();

							System.out.println(c + "📍 CADASTRO DE NOVO CLIENTE 📍\n" + stop 
											 + y + "Nome: " + stop);
							String nome = input.nextLine();
							cliente.setNome(nome);

							System.out.println(y + "Endereco: " + stop);
							String endereco = input.nextLine();
							
							cliente.endereco(endereco);

							System.out.println(y + "Email: " + stop);
							String email = input.nextLine();
							cliente.email(email);

							System.out.println(y + "Telefone: " + stop);
							long telefone = input.nextLong();
							cliente.telefone(telefone);

							System.out.println(y + "Ano de nascimento: " + stop);
							int nascimento = input.nextInt();
							cliente.nascimento(nascimento);

							input.nextLine();

							System.out.println(y + "Senha: " + stop);
							String senha = input.nextLine();
							cliente.senha(senha);

							cliente.apresentacao();

							System.out.println(y + "Confirma os dados do cliente?" + stop);
							conf = input.next();
							input.nextLine();

							gc.add(cliente);

						} while (conf.equals("n") || conf.equals("n"));
						System.out.println(n + "\nCadastrando...." + stop + g + "\nCliente cadastrado!\n" + stop);

						System.out.println(m + "Sua loja possuí um total de: " + stop + n + gc.size() + stop + m
								+ " Clientes cadastrados." + stop + m + "\nVá em " + stop + n
								+ "(Gestão de clientes -> Ver clientes)" + stop + m + " para visualizá-los" + stop);

						break;
					case 3:
						// Ver cliente
						for (Cliente ver : gc) {
							System.out.println(ver);
						}
						if (gc.isEmpty()) {
							System.out.println(
									r + "Não há nada aqui! Cadastre novos clientes para visualizá-los.\n" + stop);
						}

						break;
					case 4:
						// Remover cliente
						System.out.println(y + "Digite o ID do cliente que deseja remover: " + stop);
						int removC = input.nextInt();

						System.out.println(r + "Tem certeza que deseja remover o cliente de número " + stop + n + removC
								+ stop + n + " (S / N): " + stop);

						String confirma = input.next();

						int sizeList = gc.size();

						if (confirma.equals("s") || confirma.equals("S")) {
							gc.removeIf(remov -> remov.getNum() == removC);

							if (gc.size() < sizeList) {
								System.out.println(g + "Cliente Removido com sucesso" + stop);
							} else {
								System.out.println(r + "Cliente de número " + stop + n + removC + stop + r
										+ " não encontrado" + stop);
							}
						}

						break;
					case 6:
						// Cadastro produto

						Produtos pdt = new Produtos();

						input.nextLine();
						System.out.println(c + "📍 CADASTRO DE PRODUTO 📍\n" + stop 
									+ y + "Digite o nome do curso: " + stop);
						String produto = input.nextLine();

						if (!produto.equals(pdt.getNome())) {
							pdt.setNome(produto);
						}

						System.out.println(y + "Digite uma descrição:" + stop);
						String descricao = input.nextLine();

						if (!descricao.equals(pdt.getDescricao())) {
							pdt.setDescricao(descricao);
						}

						System.out.println(y + "Digite o preço: " + stop);
						double preco = input.nextDouble();
						pdt.setPreco(preco);

						System.out.println(y + "Digite a quantidade de vagas:" + stop);
						int quantidade = input.nextInt();

						if (!descricao.equals(pdt.getQuantidade())) {
							pdt.setQuantidade(quantidade);
						}

						pd.add(pdt);

						System.out.println(m + "Você possui um total de " + stop + n + pd.size() + stop + m
								+ " Cursos cadastrados." + "\nVá em " + stop + n + "(Gestão de estoque -> Ver Cursos)"
								+ stop + m + " para visualizá-los" + stop);

						break;
					case 7:
						// Ver produtos
						for (Produtos ver : pd) {
							System.out.println(ver);
						}
						if (pd.isEmpty()) {
							System.out
									.println(r + "Não há nada aqui! Cadastre novos cursos para visuaizá-los.\n" + stop);
						}

						break;
					case 8:
						// Remover produtos
						System.out.println(y + "Digite o ID do curso que deseja remover: " + stop);
						int removP = input.nextInt();

						System.out.println(r + "Tem certeza que deseja remover o curso de número " + stop + n + removP
								+ stop + r + " (S / N): " + stop);

						String confirmaP = input.next();

						int sizeListP = pd.size();

						if (confirmaP.equals("s") || confirmaP.equals("S")) {
							pd.removeIf(remov -> remov.getNum() == removP);

							if (pd.size() < sizeListP) {
								System.out.println(g + "Curso removido com sucesso" + stop);
							} else {
								System.out.println(r + "Curso de número " + stop + n + removP + stop + r
										+ " não encontrado" + stop);
							}
						}

						break;
					case 9:
						// Realizar vendas

						System.out.println(y + "Digite o ID do cliente que deseja comprar o curso: " + stop);
						int idCliente = input.nextInt();

						System.out.println(y + "Digite o ID do curso:" + stop);
						int idProduto = input.nextInt();

						System.out.println(y + "Digite a quantidade de acessos que será vendido:" + stop);
						int quantidade1 = input.nextInt();

						Cliente cliente = null;
						for (Cliente pessoa : gc) {
							if (pessoa.getNum() == idCliente) {
								cliente = pessoa;
								break;
							}
						}

						if (cliente == null) {
							System.out.println(r + "Cliente não encontrado!" + stop);
							break;
						}

						Produtos produtoComprado = null;
						for (Produtos produto1 : pd) {
							if (produto1.getNum() == idProduto) {
								produtoComprado = produto1;
								break;
							}
						}

						if (produtoComprado == null) {
							System.out.println(r + "Curso não encontrado!" + stop);
							break;
						}

						RealizarVendas venda = new RealizarVendas(cliente, produtoComprado, quantidade1);
						venda.realizarVenda();

						break;

					case 10:
						// Sair
						for (int i = 0; i < 19; i++) {
							System.out.print("=");
						}

						System.out.println(g + "\nPROGRAMA ENCERRADO" + stop);

						for (int i = 0; i < 19; i++) {
							System.out.print("=");
						}
						System.exit(0);

						break;

					}
				}
			}
		} catch (Exception e) {
			System.out.println(r + "Erro de exceção! - Favor colocar um número ao invés de uma letra." + stop);
		}
	}
}
