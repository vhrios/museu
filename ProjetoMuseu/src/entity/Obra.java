package entity;

public class Obra {

	private int id;
	private String titulo;
	private String apelido;
	private String data;
	private String periodo;
	private float altura;
	private float largura;
	private float profundidade;
	private double valor;
	private String biografia;
	private Autor autor;
	private Instituicao instituicao;
	private String categoria;
	private String tipo;
	private String movimento;

	public Obra(int id, String titulo, String apelido, String data, String periodo, float altura, float largura,
			float profundidade, double valor, String biografia, Autor autor, Instituicao instituicao, String categoria,
			String tipo, String movimento) {
		this.id = id;
		this.titulo = titulo;
		this.apelido = apelido;
		this.data = data;
		this.periodo = periodo;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
		this.valor = valor;
		this.biografia = biografia;
		this.autor = autor;
		this.instituicao = instituicao;
		this.categoria = categoria;
		this.tipo = tipo;
		this.movimento = movimento;
	}

	public Obra() {
		this(0, "", "", "", "", 0, 0, 0, 0, "", new Autor(), new Instituicao(), "", "", "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}

}
