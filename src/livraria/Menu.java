package livraria;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int opcao;

		System.out.println(" --------------------------------------------------- ");
		System.out.println("|                                                   |");
		System.out.println("|                 LIVRARIA NACIONAL                 |");
		System.out.println("|                                                   |");
		System.out.println(" --------------------------------------------------- ");
		System.out.println("|                                                   |");
		System.out.println("|             (1) Cadastrar um produto              |");
		System.out.println("|             (2) Listar todos os produtos          |");
		System.out.println("|             (3) Buscar produto por ID             |");
		System.out.println("|             (4) Atualizar um produto              |");
		System.out.println("|             (5) Apagar produto                    |");
		System.out.println("|             (6) Sair                              |");
		System.out.println("|                                                   |");
		System.out.println(" --------------------------------------------------- ");
		System.out.print("\n Entre com a opção desejada: ");

		opcao = entrada.nextInt();

		switch (opcao) {
		case 1:
			System.out.println(" Cadastrar um produto\n\n");
			break;
		case 2:
			System.out.println(" Listar todos os produtos\n\n");
			break;
		case 3:
			System.out.println(" Buscar produto por ID\n\n");
			break;
		case 4:
			System.out.println(" Atualizar um produto\n\n");
			break;
		case 5:
			System.out.println(" Apagar produto\n\n");
			break;
		case 6:
			System.out.println("\n Sistema encerrado!");
			sobre();
			entrada.close();
			System.exit(0);
			break;
		default:
			System.out.println("\nOpção Inválida!\n");
			break;
		}
	}
	
	public static void sobre() {
		System.out.println("\n --------------------------------------------------- ");
		System.out.println("  Projeto Desenvolvido por: Gabriella Jacubavicius  ");
		System.out.println("  github.com/jacubavicius                           ");
		System.out.println(" --------------------------------------------------- ");
	}
}
