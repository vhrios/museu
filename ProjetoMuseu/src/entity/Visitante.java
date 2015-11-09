package entity;

public class Visitante {

	private int id;
	private boolean sexo;
	private String escolaridade;
	private String locomocao;
	private int idade;
	private Pais pais;

	public Visitante(int id, boolean sexo, String escolaridade, String locomocao, int idade, Pais pais) {
		this.id = id;
		this.sexo = sexo;
		this.escolaridade = escolaridade;
		this.locomocao = locomocao;
		this.idade = idade;
		this.pais = pais;
	}

	public Visitante() {
		this(0, false, "", "", 0, new Pais());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getLocomocao() {
		return locomocao;
	}

	public void setLocomocao(String locomocao) {
		this.locomocao = locomocao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
