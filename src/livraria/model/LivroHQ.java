package livraria.model;

public class LivroHQ extends Livro {

	private String quadrinista;
	
	public LivroHQ(String titulo, String editora, int id, int ano, int paginas, int quantidade, float preco, String quadrinista) {
		super(titulo, editora, id, ano, paginas, quantidade, preco);
		this.quadrinista = quadrinista;
	}

	public String getQuadrinista() {
		return quadrinista;
	}

	public void setQuadrinista(String quadrinista) {
		this.quadrinista = quadrinista;
	}

	@Override
	public void visualizarInformacoes() {
		super.visualizarInformacoes();
		System.out.println("Quadrinista: " + this.quadrinista + "\n\n");
	}	
	
}
