package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Autor;
import entity.Instituicao;
import entity.Obra;

public class ObraDAO implements IObra{

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

	@Override
	public boolean manter(Obra o) throws SQLException {
		PreparedStatement ps;
		if (o.getId() == 0) {
			String sql = "INSERT INTO obra (titulo, apelido, dia, mes, ano, periodo, altura, largura, profundidade, valor, biografia, autor_id, instituicao_id, categoria, tecnica, movimento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getTitulo());
			ps.setString(2, o.getApelido());
			ps.setInt(3, o.getDia());
			ps.setInt(4, o.getMes());
			ps.setInt(5, o.getAno());
			ps.setString(6, o.getPeriodo());
			ps.setFloat(7, o.getAltura());
			ps.setFloat(8, o.getLargura());
			ps.setFloat(9, o.getProfundidade());
			ps.setDouble(10, o.getValor());
			ps.setString(11, o.getBiografia());
			ps.setInt(12, o.getAutor().getId());
			ps.setInt(13, o.getInstituicao().getId());
			ps.setString(14, o.getCategoria());
			ps.setString(15, o.getTecnica());
			ps.setString(16, o.getMovimento());
		} else {
			String sql = "UPDATE obra SET titulo = ?, apelido = ?, dia = ?, mes = ?, ano = ?, periodo = ?, altura = ?, largura = ?, profundidade = ?, valor = ?, biografia = ?, autor_id = ?, instituicao_id = ?, categoria = ?, tecnica = ?, movimento = ? WHERE id = ?";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getTitulo());
			ps.setString(2, o.getApelido());
			ps.setInt(3, o.getDia());
			ps.setInt(4, o.getMes());
			ps.setInt(5, o.getAno());
			ps.setString(6, o.getPeriodo());
			ps.setFloat(7, o.getAltura());
			ps.setFloat(8, o.getLargura());
			ps.setFloat(9, o.getProfundidade());
			ps.setDouble(10, o.getValor());
			ps.setString(11, o.getBiografia());
			ps.setInt(12, o.getAutor().getId());
			ps.setInt(13, o.getInstituicao().getId());
			ps.setString(14, o.getCategoria());
			ps.setString(15, o.getTecnica());
			ps.setString(16, o.getMovimento());
			ps.setInt(17, o.getId());
		}

		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação da Obra, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next() || o.getId()!=0) {
				int id = o.getId()==0 ? idsGerados.getInt(1) : o.getId();
				o.setId(id);
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação da Obra, ID não capturado.");
			}
		}
	}

	@Override
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

	@Override
	public Obra pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT titulo, apelido, dia, mes, ano, periodo, altura, largura, profundidade, valor, biografia, autor_id, instituicao_id, categoria, tecnica, movimento FROM obra WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Obra o = new Obra();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			o.setId(id);
			o.setTitulo(rs.getString("titulo"));
			o.setApelido(rs.getString("apelido"));
			o.setDia(rs.getInt("dia"));
			o.setMes(rs.getInt("mes"));
			o.setAno(rs.getInt("ano"));
			o.setPeriodo(rs.getString("periodo"));
			o.setAltura(rs.getFloat("altura"));
			o.setLargura(rs.getFloat("largura"));
			o.setProfundidade(rs.getFloat("profundidade"));
			o.setValor(rs.getDouble("valor"));
			o.setBiografia(rs.getString("biografia"));
			o.setAutor(new AutorDAO().pesquisarPorID(rs.getInt("autor_id")));
			o.setInstituicao(new InstituicaoDAO().pesquisarPorID(rs.getInt("instituicao_id")));
			o.setCategoria(rs.getString("categoria"));
			o.setTecnica(rs.getString("tecnica"));
			o.setMovimento(rs.getString("movimento"));
		} else {
			o = null;
		}
		ps.close();
		return o;
	}

	@Override
	public Obra pesquisarPorTitulo(String titulo) throws SQLException {
		String sql = "SELECT id, apelido, dia, mes, ano, periodo, altura, largura, profundidade, valor, biografia, autor_id, instituicao_id, categoria, tecnica, movimento FROM obra WHERE titulo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, titulo);

		Obra o = new Obra();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			o.setId(rs.getInt("id"));
			o.setTitulo(titulo);
			o.setApelido(rs.getString("apelido"));
			o.setDia(rs.getInt("dia"));
			o.setMes(rs.getInt("mes"));
			o.setAno(rs.getInt("ano"));
			o.setPeriodo(rs.getString("periodo"));
			o.setAltura(rs.getFloat("altura"));
			o.setLargura(rs.getFloat("largura"));
			o.setProfundidade(rs.getFloat("profundidade"));
			o.setValor(rs.getDouble("valor"));
			o.setBiografia(rs.getString("biografia"));
			o.setAutor(new AutorDAO().pesquisarPorID(rs.getInt("autor_id")));
			o.setInstituicao(new InstituicaoDAO().pesquisarPorID(rs.getInt("instituicao_id")));
			o.setCategoria(rs.getString("categoria"));
			o.setTecnica(rs.getString("tecnica"));
			o.setMovimento(rs.getString("movimento"));
		} else {
			o = null;
		}
		ps.close();
		return o;
	}

	@Override
	public List<Obra> carregarTodos() throws SQLException {
		String sql = "SELECT id, titulo, apelido, dia, mes, ano, periodo, altura, largura, profundidade, valor, biografia, autor_id, instituicao_id, categoria, tecnica, movimento FROM obra";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Obra> oList = new ArrayList<Obra>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Obra o = new Obra();
			o.setId(rs.getInt("id"));
			o.setTitulo(rs.getString("titulo"));
			o.setApelido(rs.getString("apelido"));
			o.setDia(rs.getInt("dia"));
			o.setMes(rs.getInt("mes"));
			o.setAno(rs.getInt("ano"));
			o.setPeriodo(rs.getString("periodo"));
			o.setAltura(rs.getFloat("altura"));
			o.setLargura(rs.getFloat("largura"));
			o.setProfundidade(rs.getFloat("profundidade"));
			o.setValor(rs.getDouble("valor"));
			o.setBiografia(rs.getString("biografia"));
			
			Autor a = new AutorDAO().pesquisarPorID(rs.getInt("autor_id"));
			o.setAutor(a);
			
			Instituicao i = new InstituicaoDAO().pesquisarPorID(rs.getInt("instituicao_id"));
			o.setInstituicao(i);
			
			o.setCategoria(rs.getString("categoria"));
			o.setTecnica(rs.getString("tecnica"));
			o.setMovimento(rs.getString("movimento"));
			oList.add(o);
		}

		ps.close();
		return oList;
	}

}