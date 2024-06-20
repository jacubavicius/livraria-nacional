package livraria.controller;

import java.util.ArrayList;

import livraria.model.Livro;
import livraria.repository.LivrariaRepository;

public class LivrariaController implements LivrariaRepository {

	private ArrayList<Livro> listaLivros = new ArrayList<Livro>();
	int numero = 0;

	@Override
	public void cadastrar(Livro livro) {
		listaLivros.add(livro);
		System.out.println("\n" + livro.getTitulo() + " foi cadastrado com sucesso!");
	}

	@Override
	public void listaProdutos() {
		for (var livro : listaLivros) {
			livro.visualizarInformacoes();
		}

	}

	@Override
	public void procurarPorId(int id) {
		var buscarLivro = buscarNaColletion(id);

		if (buscarLivro != null)
			buscarLivro.visualizarInformacoes();
		else
			System.out.println("\nID " + id + " não encontrado!");
	}

	@Override
	public void atualizar(Livro livro) {
		var buscarLivro = buscarNaColletion(livro.getId());

		if (buscarLivro != null) {
			listaLivros.set(listaLivros.indexOf(buscarLivro), livro);
			System.out.println("\nLivro '" + livro.getTitulo() + "' foi atualizado com sucesso!");
		} else {
			System.out.println("\nLivro não encontrado. Tente outro ID!");
		}
	}

	@Override
	public void deletar(int id) {
		var livro = buscarNaColletion(id);

		if (livro != null) {
			if (listaLivros.remove(livro) == true)
				System.out.println("\nLivro '" + livro.getTitulo() + "' foi removido com sucesso!");
			else
				System.out.println("\nLivro '" + livro.getTitulo() + "' não foi encontrado!");

		}
	}

	@Override
	public void venda(int id, int quantidade) {
		var livro = buscarNaColletion(id);

		if (livro != null) {
			livro.venda(quantidade);
			System.out.println("\n Venda efetuada com sucesso!");
		} else {
			System.out.println("\nLivro '" + livro.getTitulo() + "' não foi encontrado!");
		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Livro buscarNaColletion(int numero) {

		for (var livro : listaLivros) {
			if (livro.getId() == numero) {
				return livro;
			}
		}

		return null;
	}
}
