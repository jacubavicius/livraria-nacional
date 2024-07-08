package livraria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.controller.LivrariaController;
import livraria.model.LivroClassico;
import livraria.model.LivroHQ;
import livraria.test.Testes;
import livraria.uteis.Cores;

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
			System.out.println("|                 " + Cores.ANSI_GREEN_BACKGROUND_BRIGHT + "LIVRARIA NACIONAL"  + Cores.TEXT_RESET + "                 |");
			System.out.println("|                                                   |");
			System.out.println(" --------------------------------------------------- ");
			System.out.println("|                                                   |");
			System.out.println("|             (1) Registrar venda                   |");
			System.out.println("|             (2) Cadastrar um produto              |");
			System.out.println("|             (3) Listar todos os produtos          |");
			System.out.println("|             (4) Buscar produto por ID             |");
			System.out.println("|             (5) Atualizar um produto              |");
			System.out.println("|             (6) Apagar produto                    |");
			System.out.println("|             (0) Sair                              |");
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
				System.out.println("\n --------------------------------------------------- ");
				System.out.println("|                  REGISTRAR VENDA                  |");
				System.out.println(" --------------------------------------------------- ");
				
				System.out.print("Informe o ID do livro: ");
				id = entrada.nextInt();
				
				System.out.print("Informe a quantidade vendida: ");
				quantidade = entrada.nextInt();
				
				livros.venda(id, quantidade);
				
				keyPress();
				break;
			case 2:
				System.out.println("\n --------------------------------------------------- ");
				System.out.println("|                 CADASTRAR PRODUTO                 |");
				System.out.println(" --------------------------------------------------- ");
				
				id = livros.gerarNumero();

				System.out.print("\nInforme o título do livro: ");
				entrada.nextLine();
				titulo = entrada.nextLine();
				
				System.out.print("Informe a editora: ");
				editora = entrada.nextLine();
				
				System.out.print("Informe o ano: ");
				ano = entrada.nextInt();
				
				System.out.print("Informe a quantidade de páginas: ");
				paginas = entrada.nextInt();
				
				System.out.print("Quantas unidades deseja adicionar ao estoque? ");
				quantidade = entrada.nextInt();
				
				System.out.print("Informe o valor de venda: R$");
				preco = entrada.nextFloat();
				
				do {
					System.out.print("Informe o tipo - (1) Classico ou (2) HQ: ");
					tipo = entrada.nextInt();
				} while (tipo < 1 && tipo > 2);

				switch (tipo) {
				case 1:
					System.out.print("Informe o autor: ");
					entrada.nextLine();
					autor = entrada.nextLine();
					System.out.print("Informe o gênero literário: ");
					genero = entrada.nextLine();

					livros.cadastrar(new LivroClassico(titulo, editora, id, ano, paginas, quantidade, preco, autor, genero));
					break;
				case 2:
					System.out.print("Informe o quadrinista: ");
					entrada.nextLine();
					quadrinista = entrada.nextLine();

					livros.cadastrar(new LivroHQ(titulo, editora, id, ano, paginas, quantidade, preco, quadrinista));
					break;
				}
				
				keyPress();
				break;
			case 3:
				System.out.println("\n --------------------------------------------------- ");
				System.out.println("|              LISTAR TODOS OS PRODUTOS             |");
				System.out.println(" --------------------------------------------------- ");
				
				livros.listaProdutos();
				keyPress();
				break;
			case 4:
				System.out.println("\n --------------------------------------------------- ");
				System.out.println("|                BUSCAR PRODUTO POR ID              |");
				System.out.println(" --------------------------------------------------- ");

				System.out.print("\nDigite o ID do livro: ");
				id = entrada.nextInt();

				livros.procurarPorId(id);
				keyPress();
				break;
			case 5:
				System.out.println("\n --------------------------------------------------- ");
				System.out.println("|              ATUALIZAR DADOS DE PRODUTO           |");
				System.out.println(" --------------------------------------------------- ");

				System.out.print("\nInforme o ID do livro: ");
				id = entrada.nextInt();

				var buscarLivro = livros.buscarNaColletion(id);

				if (buscarLivro != null) {

					System.out.print("\nInforme o título do livro: ");
					entrada.nextLine();
					titulo = entrada.nextLine();

					System.out.print("Informe a editora: ");
					editora = entrada.nextLine();

					System.out.print("Informe o ano: ");
					ano = entrada.nextInt();

					System.out.print("Informe a quantidade de páginas: ");
					paginas = entrada.nextInt();

					System.out.print("Quantas unidades deseja adicionar ao estoque? ");
					quantidade = entrada.nextInt();

					System.out.print("Informe o valor de venda: R$");
					preco = entrada.nextFloat();

					do {
						System.out.print("Informe o tipo - (1) Classico ou (2) HQ: ");
						tipo = entrada.nextInt();
					} while (tipo < 1 && tipo > 2);

					switch (tipo) {
					case 1:
						System.out.print("Informe o autor: ");
						entrada.nextLine();
						autor = entrada.nextLine();

						System.out.print("Informe o gênero literário: ");
						genero = entrada.nextLine();

						livros.atualizar(new LivroClassico(titulo, editora, id, ano, paginas, quantidade, preco,
								autor, genero));
						break;
					case 2:
						System.out.println("Informe o quadrinista: ");
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
				System.out.println("\n --------------------------------------------------- ");
				System.out.println("|                    APAGAR PRODUTO                 |");
				System.out.println(" --------------------------------------------------- ");
				
				System.out.print("\nInforme o ID do livro: ");
				id = entrada.nextInt();
				
				livros.deletar(id);
				
				keyPress();
				break;
			case 0:
				System.out.println("\nSistema encerrado.");
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
		System.out.println("\n ---------------------------------------------------");
		System.out.println("| Desenvolvido por: Gabriella Jacubavicius          |");
		System.out.println("| github.com/jacubavicius                           |");
		System.out.println(" ---------------------------------------------------");
	}

	public static void keyPress() {

		try {
			System.out.println("\nPressione ENTER para continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("\nVocê pressionou uma tecla diferente de ENTER!");
		}
	}
}
