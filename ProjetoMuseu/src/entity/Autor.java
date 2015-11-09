package entity;

import java.util.List;

public class Autor {

	private int id;
	private String nome;
	private String dataNasc;
	private String dataObito;
	private String iniAtividade;
	private String fimAtividade;
	private String descricao;
	private Pais pais;

	private List<Atividade> atividades;

	public Autor(int id, String nome, String dataNasc, String dataObito, String iniAtividade, String fimAtividade,
			String descricao, Pais pais, List<Atividade> atividades) {
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.dataObito = dataObito;
		this.iniAtividade = iniAtividade;
		this.fimAtividade = fimAtividade;
		this.descricao = descricao;
		this.pais = pais;
		this.setAtividades(atividades);
	}

	public Autor() {
		this(0, "", "", "", "", "", "", new Pais(), null);
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getDataObito() {
		return dataObito;
	}

	public void setDataObito(String dataObito) {
		this.dataObito = dataObito;
	}

	public String getIniAtividade() {
		return iniAtividade;
	}

	public void setIniAtividade(String iniAtividade) {
		this.iniAtividade = iniAtividade;
	}

	public String getFimAtividade() {
		return fimAtividade;
	}

	public void setFimAtividade(String fimAtividade) {
		this.fimAtividade = fimAtividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

}
