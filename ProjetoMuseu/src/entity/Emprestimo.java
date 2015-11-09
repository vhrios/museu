package entity;

import java.util.Date;
import java.util.List;

public class Emprestimo {

	private int id;
	private String status;
	private String tituloExibicao;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private String observacao;
	private Instituicao instituicao;

	private List<Obra> obras;

	public Emprestimo(int id, String status, String tituloExibicao, Date dataEmprestimo, Date dataDevolucao,
			String observacao, Instituicao instituicao, List<Obra> obras) {
		this.id = id;
		this.status = status;
		this.tituloExibicao = tituloExibicao;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.observacao = observacao;
		this.instituicao = instituicao;
		this.setObras(obras);
	}

	public Emprestimo() {
		this(0, "", "", null, null, "", new Instituicao(), null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTituloExibicao() {
		return tituloExibicao;
	}

	public void setTituloExibicao(String tituloExibicao) {
		this.tituloExibicao = tituloExibicao;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

}
