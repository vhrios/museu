package entity;

public class Usuario {

	private String nome;
	private String cpf;
	private boolean gerente;
	private String login;
	private String senha;

	public Usuario(String nome, String cpf, boolean gerente, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.gerente = gerente;
		this.login = login;
		this.senha = senha;
	}

	public Usuario() {
		this("", "", false, "", "");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
