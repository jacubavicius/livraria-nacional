package livraria.model;

public class LivroClassico extends Livro {

	private String autor;
	private String genero;
	
	public LivroClassico(String titulo, String editora, int id, int ano, int paginas, int quantidade, float preco, String autor, String genero) {
		super(titulo, editora, id, ano, paginas, quantidade, preco);
		this.autor = autor;
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public void visualizarInformacoes() {
		super.visualizarInformacoes();
		System.out.println("Autor: " + this.autor);
		System.out.println("Gênero: " + this.genero + "\n\n");
	}	
}
