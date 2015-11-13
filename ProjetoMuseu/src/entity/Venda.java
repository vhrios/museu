package entity;

public class Venda {

	private int id;
	private int qtdInteiro;
	private int qtdMeio;
	private float valorTotal;
	private String tipoPagamento;
	private String nomeExposicao;
	private boolean reserva;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdInteiro() {
		return qtdInteiro;
	}

	public void setQtdInteiro(int qtdInteiro) {
		this.qtdInteiro = qtdInteiro;
	}

	public int getQtdMeio() {
		return qtdMeio;
	}

	public void setQtdMeio(int qtdMeio) {
		this.qtdMeio = qtdMeio;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getNomeExposicao() {
		return nomeExposicao;
	}

	public void setNomeExposicao(String nomeExposicao) {
		this.nomeExposicao = nomeExposicao;
	}

	public boolean isReverva() {
		return reserva;
	}

	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}
}
