package livraria.repository;

import livraria.model.Livro;

public interface LivrariaRepository {

	public void cadastrar(Livro livro);
	public void listaProdutos();
	public void procurarPorId(int id);
	public void atualizar(Livro livro);
	public void deletar(int quantidade);
	
	public void venda(int id, int quantidade);
}
