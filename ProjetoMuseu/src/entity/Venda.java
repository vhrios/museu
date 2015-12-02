package entity;

import java.util.Date;

public class Venda {

	private Date data;
	private int qtdInteiro;
	private int qtdMeia;
	private double valorTotal;
	private String formaPagamento;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQtdInteiro() {
		return qtdInteiro;
	}
	public void setQtdInteiro(int qtdInteiro) {
		this.qtdInteiro = qtdInteiro;
	}
	public int getQtdMeia() {
		return qtdMeia;
	}
	public void setQtdMeia(int qtdMeia) {
		this.qtdMeia = qtdMeia;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}
