package livraria.test;

import livraria.controller.LivrariaController;
import livraria.model.LivroClassico;
import livraria.model.LivroHQ;

public class Testes {

	public static void main(String[] args) {

		LivrariaController livros = new LivrariaController();

		System.out.println("---------- TESTES -----------");

		System.out.println("\n\n--------- CADASTRAR ---------");

		livros.cadastrar(new LivroClassico("Memórias de um sargento de milícias", "Martin Claret", livros.gerarNumero(),
				2012, 206, 15, 19.99f, "Manuel Antônio de Almeida", "Romance"));

		livros.cadastrar(new LivroClassico("Dom Casmurro", "Principis", livros.gerarNumero(), 2019, 208, 20, 25.99f,
				"Machado de Assis", "Ficção Literária"));

		livros.cadastrar(new LivroHQ("Turma da Mônica Jovem", "Panini", livros.gerarNumero(), 2018, 130, 10, 12.99f,
				"Mauricio de Sousa"));
		livros.cadastrar(
				new LivroHQ("Angola Janga", "Veneta", livros.gerarNumero(), 2017, 432, 18, 59.99f, "Marcelo D'Salete"));

		System.out.println("\n\n--------- LISTAR ---------");
		livros.listaProdutos();

		System.out.println("\n\n--------- BUSCAR ---------");
		livros.procurarPorId(2);
		livros.procurarPorId(4);

		System.out.println("\n\n------- ATUALIZAR --------");
		livros.atualizar(new LivroClassico("Dom Casmurro", "Principis", 1, 2019, 208, 20, 10.00f,
				"Machado de Assis", "Ficção Literária"));

		System.out.println("\n\n--------- APAGAR ---------");
		livros.deletar(3);

		System.out.println("\n\n--------- VENDA ---------");
		livros.venda(1, 15);

		System.out.println("\n\n--------- LISTAR ---------");
		livros.listaProdutos();
	}
}
