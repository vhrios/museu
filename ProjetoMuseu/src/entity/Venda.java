package entity;

public class Venda {

	private int id;
	private int qtdInteiro;
	private int qtdMeio;
	private float valorTotal;
	private String tipoPagamento;
	private Ingresso ingresso;

	public Venda(int id, int qtdInteiro, int qtdMeio, float valorTotal, String tipoPagamento, Ingresso ingresso) {
		this.id = id;
		this.qtdInteiro = qtdInteiro;
		this.qtdMeio = qtdMeio;
		this.valorTotal = valorTotal;
		this.tipoPagamento = tipoPagamento;
		this.ingresso = ingresso;
	}

	public Venda() {
		this(0, 0, 0, 0, "", new Ingresso());
	}

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

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

}
