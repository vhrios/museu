package entity;

public class Estado {

	private int id;
	private String nome;
	private Pais pais;

	public Estado(int id, String nome, Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	public Estado() {
		this(0, "", new Pais());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
