package entity;

import java.util.List;

public class Autor {

	private int id;
	private String nome;
	private int diaN;
	private int mesN;
	private int anoN;
	private int diaM;
	private int mesM;
	private int anoM;
	private int diaIniAtv;
	private int mesIniAtv;
	private int anoIniAtv;
	private int diaFimAtv;
	private int mesFimAtv;
	private int anoFimAtv;
	private String descricao;
	private String pais;
	private List<String> atividades;

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

	public int getDiaN() {
		return diaN;
	}

	public void setDiaN(int diaN) {
		this.diaN = diaN;
	}

	public int getMesN() {
		return mesN;
	}

	public void setMesN(int mesN) {
		this.mesN = mesN;
	}

	public int getAnoN() {
		return anoN;
	}

	public void setAnoN(int anoN) {
		this.anoN = anoN;
	}

	public int getDiaM() {
		return diaM;
	}

	public void setDiaM(int diaM) {
		this.diaM = diaM;
	}

	public int getMesM() {
		return mesM;
	}

	public void setMesM(int mesM) {
		this.mesM = mesM;
	}

	public int getAnoM() {
		return anoM;
	}

	public void setAnoM(int anoM) {
		this.anoM = anoM;
	}

	public int getDiaIniAtv() {
		return diaIniAtv;
	}

	public void setDiaIniAtv(int diaIniAtv) {
		this.diaIniAtv = diaIniAtv;
	}

	public int getMesIniAtv() {
		return mesIniAtv;
	}

	public void setMesIniAtv(int mesIniAtv) {
		this.mesIniAtv = mesIniAtv;
	}

	public int getAnoIniAtv() {
		return anoIniAtv;
	}

	public void setAnoIniAtv(int anoIniAtv) {
		this.anoIniAtv = anoIniAtv;
	}

	public int getDiaFimAtv() {
		return diaFimAtv;
	}

	public void setDiaFimAtv(int diaFimAtv) {
		this.diaFimAtv = diaFimAtv;
	}

	public int getMesFimAtv() {
		return mesFimAtv;
	}

	public void setMesFimAtv(int mesFimAtv) {
		this.mesFimAtv = mesFimAtv;
	}

	public int getAnoFimAtv() {
		return anoFimAtv;
	}

	public void setAnoFimAtv(int anoFimAtv) {
		this.anoFimAtv = anoFimAtv;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<String> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<String> atividades) {
		this.atividades = atividades;
	}

}
