package livraria.model;

public abstract class Livro {

	private String titulo;
	private String editora;
	private int id;
	private int ano;
	private int paginas;
	private int quantidade;
	private float preco;
	
	public Livro(String titulo, String editora, int id, int ano, int paginas, int quantidade, float preco) {
		this.titulo = titulo;
		this.editora = editora;
		this.id = id;
		this.ano = ano;
		this.paginas = paginas;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public boolean venda(int quantidade) {
		
		if(this.getQuantidade() < quantidade || this.getQuantidade() == 0) {
			System.out.println("Produto esgotado!\n\n");
			return false;
		}
		else {
			this.setQuantidade(this.getQuantidade() - quantidade);
			return true;
		}
	}
	
	public void visualizarInformacoes() {
		System.out.println("Título: " + this.titulo);
		System.out.println("ID: " + this.id);
		System.out.println("Editora: " + this.editora);
		System.out.println("Ano: " + this.ano);
		System.out.println("Páginas: " + this.paginas);
		System.out.println("Preço: " + this.preco);
		System.out.println("Quantidades disponíveis: " + this.quantidade);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	

	public int getAno() {
		return ano;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
