package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cidade;
import entity.Estado;
import entity.Instituicao;
import entity.Pais;

public class InstituicaoDAO implements IInstituicao{

	/*
	 * private int id;
	 * private String nome;
	 * private String endereco;
	 * private String numero;
	 * private String cep;
	 * private String contato;
	 * private String cargo;
	 * private String telefone;
	 * private String email;
	 * private Pais pais;
	 * private Estado estado;
	 * private Cidade cidade;
	 */

	private Connection c;

	public InstituicaoDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public boolean manter(Instituicao i) throws SQLException {
		PreparedStatement ps;
		if (i.getId() == 0) {
			String sql = "INSERT INTO instituicao (nome, endereco, numero, cep, contato, cargo, telefone, email, pais_id, estado_id, cidade_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, i.getNome());
			ps.setString(2, i.getEndereco());
			ps.setString(3, i.getNumero());
			ps.setString(4, i.getCep());
			ps.setString(5, i.getContato());
			ps.setString(6, i.getCargo());
			ps.setString(7, i.getTelefone());
			ps.setString(8, i.getEmail());
			ps.setInt(9, i.getPais().getId());
			ps.setInt(10, i.getEstado().getId());
			ps.setInt(11, i.getCidade().getId());
		} else {
			String sql = "UPDATE atividade SET nome = ?, endereco = ?, numero = ?, cep = ?, contato = ?, cargo = ?, telefone = ?, email = ?, pais_id = ?, estado_id = ?, cidade_id = ? WHERE id = ?";
			ps = c.prepareStatement(sql);
			ps.setString(1, i.getNome());
			ps.setString(2, i.getEndereco());
			ps.setString(3, i.getNumero());
			ps.setString(4, i.getCep());
			ps.setString(5, i.getContato());
			ps.setString(6, i.getCargo());
			ps.setString(7, i.getTelefone());
			ps.setString(8, i.getEmail());
			ps.setInt(9, i.getPais().getId());
			ps.setInt(10, i.getEstado().getId());
			ps.setInt(11, i.getCidade().getId());
			ps.setInt(12, i.getId());
		}

		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na cria��o da Institui��o, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				i.setId(idsGerados.getInt(1));
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na cria��o da Institui��o, ID n�o capturado.");
			}
		}
	}

	@Override
	public boolean apagar(Instituicao i) throws SQLException {
		if (i.getId() != 0) {
			String sql = "DELETE instituicao WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, i.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualiza��o da Institui��o, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualiza��o da Institui��o, ID n�o recebido no par�metro.");
	}

	@Override
	public Instituicao pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT nome, endereco, numero, cep, contato, cargo, telefone, email, pais_id, estado_id, cidade_id FROM instituicao WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Instituicao i = new Instituicao();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			i.setId(id);
			i.setNome(rs.getString("nome"));
			i.setEndereco(rs.getString("endereco"));
			i.setNumero(rs.getString("numero"));
			i.setCep(rs.getString("cep"));
			i.setContato(rs.getString("contato"));
			i.setCargo(rs.getString("cargo"));
			i.setTelefone(rs.getString("telefone"));
			i.setEmail(rs.getString("email"));
			i.setPais(new PaisDAO().pesquisarPorID(rs.getInt("pais")));
			i.setEstado(new EstadoDAO().pesquisarPorID(rs.getInt("estado")));
			i.setCidade(new CidadeDAO().pesquisarPorID(rs.getInt("cidade")));
		} else {
			i = null;
		}
		ps.close();
		return i;
	}

	@Override
	public Instituicao pesquisarPorNome(String nome) throws SQLException {
		String sql = "SELECT id, endereco, numero, cep, contato, cargo, telefone, email, pais_id, estado_id, cidade_id FROM instituicao WHERE nome = '?'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);

		Instituicao i = new Instituicao();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			i.setId(rs.getInt("id"));
			i.setNome(nome);
			i.setEndereco(rs.getString("endereco"));
			i.setNumero(rs.getString("numero"));
			i.setCep(rs.getString("cep"));
			i.setContato(rs.getString("contato"));
			i.setCargo(rs.getString("cargo"));
			i.setTelefone(rs.getString("telefone"));
			i.setEmail(rs.getString("email"));
			Pais p = new PaisDAO().pesquisarPorID(rs.getInt("pais"));
			i.setPais(p);
			Estado e = new EstadoDAO().pesquisarPorID(rs.getInt("estado"));
			i.setEstado(e);
			Cidade c = new CidadeDAO().pesquisarPorID(rs.getInt("cidade"));
			i.setCidade(c);
		} else {
			i = null;
		}
		ps.close();
		return i;
	}

	@Override
	public List<Instituicao> carregarTodos() throws SQLException {
		String sql = "SELECT id, nome, endereco, numero, cep, contato, cargo, telefone, email, pais_id, estado_id, cidade_id FROM atividade";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Instituicao> iList = new ArrayList<Instituicao>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Instituicao i = new Instituicao();
			i.setId(rs.getInt("id"));
			i.setNome(rs.getString("nome"));
			i.setEndereco(rs.getString("endereco"));
			i.setNumero(rs.getString("numero"));
			i.setCep(rs.getString("cep"));
			i.setContato(rs.getString("contato"));
			i.setCargo(rs.getString("cargo"));
			i.setTelefone(rs.getString("telefone"));
			i.setEmail(rs.getString("email"));
			Pais p = new PaisDAO().pesquisarPorID(rs.getInt("pais"));
			i.setPais(p);
			Estado e = new EstadoDAO().pesquisarPorID(rs.getInt("estado"));
			i.setEstado(e);
			Cidade c = new CidadeDAO().pesquisarPorID(rs.getInt("cidade"));
			i.setCidade(c);
			
			iList.add(i);
		}

		ps.close();
		return iList;
	}

}