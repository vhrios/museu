package entity;

public class Instituicao {

	private int id;
	private String nome;
	private String endereco;
	private String numero;
	private String cep;
	private String contato;
	private String cargo;
	private String telefone;
	private String email;
	private Pais pais;
	private Estado estado;
	private Cidade cidade;

	public Instituicao(int id, String nome, String endereco, String numero, String cep, String contato, String cargo,
			String telefone, String email, Pais pais, Estado estado, Cidade cidade) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.contato = contato;
		this.cargo = cargo;
		this.telefone = telefone;
		this.email = email;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
	}

	public Instituicao() {
		this(0, "", "", "", "", "", "", "", "", new Pais(), new Estado(), new Cidade());
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
