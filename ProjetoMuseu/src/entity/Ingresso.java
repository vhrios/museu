package entity;

public class Ingresso {

	private int id;
	private double precoSemana;
	private double precoFimDeSemana;
	private int limiteIngresso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecoSemana() {
		return precoSemana;
	}
	public void setPrecoSemana(double precoSemana) {
		this.precoSemana = precoSemana;
	}
	public double getPrecoFimDeSemana() {
		return precoFimDeSemana;
	}
	public void setPrecoFimDeSemana(double precoFimDeSemana) {
		this.precoFimDeSemana = precoFimDeSemana;
	}
	public int getLimiteIngresso() {
		return limiteIngresso;
	}
	public void setLimiteIngresso(int limiteIngresso) {
		this.limiteIngresso = limiteIngresso;
	}
	
}
