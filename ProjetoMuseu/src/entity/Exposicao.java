package entity;

import java.sql.Time;
import java.util.Date;

public class Exposicao {
	
	private int id;
	private String tituloExibicao;
	private Date dataInicio;
	private Date dataFim;
	private int exibicaoEspecial;
	private Time hora;
	
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
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
	public int getExibicaoEspecial() {
		return exibicaoEspecial;
	}
	public void setExibicaoEspecial(int exibicaoEspecial) {
		this.exibicaoEspecial = exibicaoEspecial;
	}

}
