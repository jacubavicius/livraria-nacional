package livraria;

import java.io.IOException;
import java.util.InputMismatchException;
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
		System.out.println("|             (1) Registrar venda                   |");
		System.out.println("|             (2) Cadastrar um produto              |");
		System.out.println("|             (3) Listar todos os produtos          |");
		System.out.println("|             (4) Buscar produto por ID             |");
		System.out.println("|             (5) Atualizar um produto              |");
		System.out.println("|             (6) Apagar produto                    |");
		System.out.println("|             (7) Sair                              |");
		System.out.println("|                                                   |");
		System.out.println(" --------------------------------------------------- ");
		System.out.print("\n Entre com a opção desejada: ");

		try {			
			opcao = entrada.nextInt();			
		} catch (InputMismatchException e) {
			System.out.println("\nDigite valores inteiros!");
			entrada.nextLine();
			opcao = 0;
		}

		switch (opcao) {
		case 1:
			System.out.println(" Registrar venda\n\n");
			break;
		case 2:
			System.out.println(" Cadastrar um produto\n\n");
			break;
		case 3:
			System.out.println(" Listar todos os produtos\n\n");
			break;
		case 4:
			System.out.println(" Buscar produto por ID\n\n");
			break;
		case 5:
			System.out.println(" Atualizar um produto\n\n");
			break;
		case 6:
			System.out.println(" Apagar produto\n\n");
			break;
		case 7:
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
	
	public static void keyPress() {
		
		try {
			
			System.out.println("Pressione enter para continuar...");
			System.in.read();
			
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
