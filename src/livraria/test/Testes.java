package livraria.test;

import livraria.model.LivroClassico;
import livraria.model.LivroHQ;

public class Testes {

	public static void main(String[] args) {

		// titulo, editora, id, ano, paginas, quantidade, preco, autor, genero
		LivroClassico livro1 = new LivroClassico("Memórias de um sargento de milícias", "Martin Claret", 01, 2012, 206,
				15, 19.99f, "Manuel Antônio de Almeida", "Romance");
		LivroClassico livro2 = new LivroClassico("Dom Casmurro", "Principis", 02, 2019, 208, 20, 25.99f,
				"Machado de Assis", "Ficção Literária");

		// titulo, editora, id, ano, paginas, quantidade, preco, quadrinista
		LivroHQ hq1 = new LivroHQ("Turma da Mônica Jovem", "Panini", 03, 2018, 130, 10, 12.99f, "Mauricio de Sousa");
		LivroHQ hq2 = new LivroHQ("Angola Janga", "Veneta", 04, 2017, 432, 18, 59.99f, "Marcelo D'Salete");

		livro1.visualizarInformacoes();
		livro1.venda(2);
		livro1.visualizarInformacoes();
		
		hq1.venda(11);
		
		hq2.visualizarInformacoes();
		hq2.venda(4);
		hq2.visualizarInformacoes();
	}
}
