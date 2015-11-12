package entity;

import java.util.Date;

public class Ingresso {

	private int id;
	private String tituloExibicao;
	private Date dataInicio;
	private Date dataFim;
	private boolean exibicaoEspecial;
	private float precoSemana;
	private float precoFimDeSemana;
	private Autor autor;
	private int limiteIngresso;

	public Ingresso(int id, String tituloExibicao, Date dataInicio, Date dataFim, boolean exibicaoEspecial,
			float precoSemana, float precoFimDeSemana, Autor autor, int limiteIngresso) {
		this.id = id;
		this.tituloExibicao = tituloExibicao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.exibicaoEspecial = exibicaoEspecial;
		this.precoSemana = precoSemana;
		this.precoFimDeSemana = precoFimDeSemana;
		this.autor = autor;
		this.limiteIngresso = limiteIngresso;
	}

	public Ingresso() {
		this(0, "", null, null, false, 0, 0, new Autor(), 0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTituloExibicao() {
		return tituloExibicao;
	}

	public void setTituloExibicao(String tituloExibicao) {
		this.tituloExibicao = tituloExibicao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isExibicaoEspecial() {
		return exibicaoEspecial;
	}

	public void setExibicaoEspecial(boolean exibicaoEspecial) {
		this.exibicaoEspecial = exibicaoEspecial;
	}

	public float getPrecoSemana() {
		return precoSemana;
	}

	public void setPrecoSemana(float precoSemana) {
		this.precoSemana = precoSemana;
	}

	public float getPrecoFimDeSemana() {
		return precoFimDeSemana;
	}

	public void setPrecoFimDeSemana(float precoFimDeSemana) {
		this.precoFimDeSemana = precoFimDeSemana;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getLimiteIngresso() {
		return limiteIngresso;
	}

	public void setLimiteIngresso(int limiteIngresso) {
		this.limiteIngresso = limiteIngresso;
	}
}
