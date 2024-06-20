package livraria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.controller.LivrariaController;
import livraria.model.LivroClassico;
import livraria.model.LivroHQ;
import livraria.test.Testes;

public class Menu {

	public static void main(String[] args) {

		LivrariaController livros = new LivrariaController();

		Scanner entrada = new Scanner(System.in);

		int opcao, tipo, id, ano, paginas, quantidade;
		String titulo, editora, genero, autor, quadrinista;
		float preco;
		
		while (true) {

			System.out.println(" --------------------------------------------------- ");
			System.out.println("|                                                   |");
			System.out.println("|                 LIVRARIA NACIONAL                 |");
			System.out.println("|                                                   |");
			System.out.println(" --------------------------------------------------- ");
			System.out.println("|                                                   |");
			System.out.println("|             (1) Registrar venda                   |");
			System.out.println("|             (2) Cadastrar um produto              |");
			System.out.println("|             (3) Listar todos os produtos          |");
			System.out.println("|             (4) Buscar produto por ID             |");
			System.out.println("|             (5) Atualizar um produto              |");
			System.out.println("|             (6) Apagar produto                    |");
			System.out.println("|             (7) Sair                              |");
			System.out.println("|                                                   |");
			System.out.println(" --------------------------------------------------- ");
			System.out.print("\nEntre com a opção desejada: ");

			try {
				opcao = entrada.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				entrada.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1:
				System.out.println("\nRegistrar venda\n");
				
				System.out.println("Digite o ID do livro: ");
				id = entrada.nextInt();
				
				System.out.println("Digite a quantidade vendida: ");
				quantidade = entrada.nextInt();
				
				livros.venda(id, quantidade);
				
				keyPress();
				break;
			case 2:
				id = livros.gerarNumero();
				System.out.println("\nCadastrar um produto\n");

				System.out.print("Digite o título do livro: ");
				entrada.nextLine();
				titulo = entrada.nextLine();

				System.out.print("Digite a editora: ");
				editora = entrada.nextLine();

				System.out.print("Digite o ano: ");
				ano = entrada.nextInt();

				System.out.print("Digite a quantidade de páginas: ");
				paginas = entrada.nextInt();

				System.out.print("Digite a quantidade de exemplares que deseja adicionar ao estoque: ");
				quantidade = entrada.nextInt();

				System.out.print("Digite o valor de venda: ");
				preco = entrada.nextFloat();

				do {
					System.out.print("Digite o tipo (1. Classico ou 2. HQ): ");
					tipo = entrada.nextInt();
				} while (tipo < 1 && tipo > 2);

				switch (tipo) {
				case 1:
					System.out.print("Digite o autor: ");
					entrada.nextLine();
					autor = entrada.nextLine();

					System.out.print("Digite o gênero literário: ");
					genero = entrada.nextLine();

					livros.cadastrar(
							new LivroClassico(titulo, editora, id, ano, paginas, quantidade, preco, autor, genero));
					break;
				case 2:
					System.out.println("Digite o quadrinista: ");
					entrada.nextLine();
					quadrinista = entrada.nextLine();

					livros.cadastrar(new LivroHQ(titulo, editora, id, ano, paginas, quantidade, preco, quadrinista));
					break;
				}
				keyPress();
				break;
			case 3:
				System.out.println("\nListar todos os produtos: \n");
				livros.listaProdutos();
				keyPress();
				break;
			case 4:
				System.out.println("\nBuscar produto por ID\n");

				System.out.println("Digite o ID do livro: ");
				id = entrada.nextInt();

				livros.procurarPorId(id);
				keyPress();
				break;
			case 5:
				System.out.println("\nAtualizar dados de um produto\n");

				System.out.println("Digite o ID do livro: ");
				id = entrada.nextInt();

				var buscarLivro = livros.buscarNaColletion(id);

				if (buscarLivro != null) {

					System.out.print("Digite o título do livro: ");
					entrada.nextLine();
					titulo = entrada.nextLine();

					System.out.print("Digite a editora: ");
					editora = entrada.nextLine();

					System.out.print("Digite o ano: ");
					ano = entrada.nextInt();

					System.out.print("Digite a quantidade de páginas: ");
					paginas = entrada.nextInt();

					System.out.print("Digite a quantidade de exemplares que deseja adicionar ao estoque: ");
					quantidade = entrada.nextInt();

					System.out.print("Digite o valor de venda: ");
					preco = entrada.nextFloat();

					do {
						System.out.print("Digite o tipo (1. Classico ou 2. HQ): ");
						tipo = entrada.nextInt();
					} while (tipo < 1 && tipo > 2);

					switch (tipo) {
					case 1:
						System.out.print("Digite o autor: ");
						entrada.nextLine();
						autor = entrada.nextLine();

						System.out.print("Digite o gênero literário: ");
						genero = entrada.nextLine();

						livros.atualizar(new LivroClassico(titulo, editora, id, ano, paginas, quantidade, preco,
								autor, genero));
						break;
					case 2:
						System.out.println("Digite o quadrinista: ");
						entrada.nextLine();
						quadrinista = entrada.nextLine();

						livros.atualizar(
								new LivroHQ(titulo, editora, id, ano, paginas, quantidade, preco, quadrinista));
						break;
						}
				}

				keyPress();
				break;
			case 6:
				System.out.println("\nApagar produto\n");
				
				System.out.println("Digite o ID do livro: ");
				id = entrada.nextInt();
				
				livros.deletar(id);
				
				keyPress();
				break;
			case 7:
				System.out.println("\nSistema encerrado!");
				sobre();
				entrada.close();
				System.exit(0);
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}

	}

	public static void sobre() {
		System.out.println("\n --------------------------------------------------- ");
		System.out.println("  Projeto Desenvolvido por: Gabriella Jacubavicius  ");
		System.out.println("  github.com/jacubavicius                           ");
		System.out.println(" --------------------------------------------------- ");
	}

	public static void keyPress() {

		try {
			System.out.println("Pressione enter para continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
