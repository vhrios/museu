package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Obra;

public class ObraDAO {

	/*
	 * private int id;
	 * private String titulo;
	 * private String apelido;
	 * private String data;
	 * private String periodo;
	 * private float altura;
	 * private float largura;
	 * private float profundidade;
	 * private double valor;
	 * private String biografia;
	 * private Autor autor;
	 * private Instituicao instituicao;
	 * private String categoria;
	 * private String tipo;
	 * private String movimento;
	 */

	private Connection c;

	public ObraDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public ObraDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Obra o) throws SQLException {
		PreparedStatement ps;
		if (o.getId() == 0) {
			String sql = "INSERT INTO obra (titulo, apelido, data, periodo, altura, largura, profundidade, valor, biografia, autor_id, instituicao_id, categoria, tipo, movimento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getTitulo());
			ps.setString(2, o.getApelido());
			ps.setString(3, o.getData());
			ps.setString(4, o.getPeriodo());
			ps.setFloat(5, o.getAltura());
			ps.setFloat(6, o.getLargura());
			ps.setFloat(7, o.getProfundidade());
			ps.setDouble(8, o.getValor());
			ps.setString(9, o.getBiografia());
			ps.setInt(10, o.getAutor().getId());
			ps.setInt(11, o.getInstituicao().getId());
			ps.setString(12, o.getCategoria());
			ps.setString(13, o.getTipo());
			ps.setString(14, o.getMovimento());
		} else {
			String sql = "UPDATE obra SET titulo = ?, apelido = ?, data = ?, periodo = ?, altura = ?, largura = ?, profundidade = ?, valor = ?, biografia = ?, autor_id = ?, instituicao_id = ?, categoria = ?, tipo = ?, movimento = ? WHERE id = ?";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getTitulo());
			ps.setString(2, o.getApelido());
			ps.setString(3, o.getData());
			ps.setString(4, o.getPeriodo());
			ps.setFloat(5, o.getAltura());
			ps.setFloat(6, o.getLargura());
			ps.setFloat(7, o.getProfundidade());
			ps.setDouble(8, o.getValor());
			ps.setString(9, o.getBiografia());
			ps.setInt(10, o.getAutor().getId());
			ps.setInt(11, o.getInstituicao().getId());
			ps.setString(12, o.getCategoria());
			ps.setString(13, o.getTipo());
			ps.setString(14, o.getMovimento());
			ps.setInt(15, o.getId());
		}

		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação da Obra, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				o.setId(idsGerados.getInt(1));
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação da Obra, ID não capturado.");
			}
		}
	}

	public boolean apagar(Obra o) throws SQLException {
		if (o.getId() != 0) {
			String sql = "DELETE obra WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualização da Obra, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualização da Obra, ID não recebido no parâmetro.");
	}

	public Obra pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT titulo, apelido, data, periodo, altura, largura, profundidade, valor, biografia, autor_id, instituicao_id, categoria, tipo, movimento FROM obra WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Obra o = new Obra();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			o.setId(id);
			o.setTitulo(rs.getString("titulo"));
			o.setApelido(rs.getString("apelido"));
			o.setData(rs.getString("data"));
			o.setPeriodo(rs.getString("periodo"));
			o.setAltura(rs.getFloat("altura"));
			o.setLargura(rs.getFloat("largura"));
			o.setProfundidade(rs.getFloat("profundidade"));
			o.setValor(rs.getDouble("valor"));
			o.setBiografia(rs.getString("biografia"));
			o.setAutor(new AutorDAO().pesquisarPorID(rs.getInt("autor_id")));
			o.setInstituicao(new InstituicaoDAO().pesquisarPorID(rs.getInt("instituicao_id")));
			o.setCategoria(rs.getString("categoria"));
			o.setTipo(rs.getString("tipo"));
			o.setMovimento(rs.getString("movimento"));
		} else {
			o = null;
		}
		ps.close();
		return o;
	}

	public Obra pesquisarPorTitulo(String titulo) throws SQLException {
		String sql = "SELECT id, apelido, data, periodo, altura, largura, profundidade, valor, biografia, autor, instituicao, categoria, tipo, movimento FROM obra WHERE titulo = '?'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, titulo);

		Obra o = new Obra();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			o.setId(rs.getInt("id"));
			o.setTitulo(titulo);
			o.setApelido(rs.getString("apelido"));
			o.setData(rs.getString("data"));
			o.setPeriodo(rs.getString("periodo"));
			o.setAltura(rs.getFloat("altura"));
			o.setLargura(rs.getFloat("largura"));
			o.setProfundidade(rs.getFloat("profundidade"));
			o.setValor(rs.getDouble("valor"));
			o.setBiografia(rs.getString("biografia"));
			o.setAutor(new AutorDAO().pesquisarPorID(rs.getInt("autor_id")));
			o.setInstituicao(new InstituicaoDAO().pesquisarPorID(rs.getInt("instituicao_id")));
			o.setCategoria(rs.getString("categoria"));
			o.setTipo(rs.getString("tipo"));
			o.setMovimento(rs.getString("movimento"));
		} else {
			o = null;
		}
		ps.close();
		return o;
	}

	public List<Obra> carregarTodos() throws SQLException {
		String sql = "SELECT id, titulo, apelido, data, periodo, altura, largura, profundidade, valor, biografia, autor, instituicao, categoria, tipo, movimento FROM obra";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Obra> oList = new ArrayList<Obra>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			oList.add(new Obra(rs.getInt("id"), rs.getString("titulo"), rs.getString("apelido"), rs.getString("data"),
					rs.getString("periodo"), rs.getFloat("altura"), rs.getFloat("largura"), rs.getFloat("profundidade"),
					rs.getDouble("valor"), rs.getString("biografia"),
					new AutorDAO().pesquisarPorID(rs.getInt("autor_id")),
					new InstituicaoDAO().pesquisarPorID(rs.getInt("autor_id")), rs.getString("categoria"),
					rs.getString("tipo"), rs.getString("movimento")));
		}

		ps.close();
		return oList;
	}

}