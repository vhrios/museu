package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Exposicao;
import entity.Ingresso;

public class IngressoImpl implements IIngresso{
	
	Connection c;
	
	public IngressoImpl() {
		GenericConnection cg = new ConnectionImpl();
		c = cg.getConnection();
	}

	@Override
	public void insereIngresso(Ingresso i, int e) throws SQLException {
		String sql = "INSERT INTO ingresso (id_exposicao, precoSemana, precoFimDeSemana, qtdIngresso) VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, e);
		ps.setDouble(2, i.getPrecoSemana());
		ps.setDouble(3, i.getPrecoFimDeSemana());
		ps.setInt(4, i.getLimiteIngresso());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void insereExposicao(Exposicao e) throws SQLException {
		String sql = "INSERT INTO exposicao (titulo, dataInicio, dataFim, exibicaoEspecial, horario) VALUES (?,?,?,?,?)";
		PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ps.setString(1, e.getTituloExibicao());
			java.sql.Date dtI = new java.sql.Date(e.getDataInicio().getTime());
			ps.setDate(2, dtI);
			java.sql.Date dtF = new java.sql.Date(e.getDataFim().getTime());
			ps.setDate(3, dtF);
			ps.setInt(4, e.getExibicaoEspecial());
//			ps.setString(5, e.getHorario());
			ps.executeUpdate();
			ps.close();
	}

	@Override
	public int buscaIdExposicao() throws SQLException {
		String sql = "select id, horario from exposicao";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int e = 0;
		while (rs.next()) {
			e = (rs.getInt("id"));
		}
		return e;
	}

	@Override
	public List<Exposicao> consultaNomeExposicao(String data) throws SQLException {
		String sql = "SELECT titulo, CONVERT(varchar(5), horario, 108) as hora from exposicao "
				+ "where ? >= dataInicio and ? <= dataFim";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, data);
		ps.setString(2, data);
		ResultSet rs = ps.executeQuery();
		List<Exposicao> lista = new ArrayList<Exposicao>();
		while (rs.next()) {
			Exposicao expo = new Exposicao();
			expo.setTituloExibicao(rs.getString("titulo"));
			SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
			Date horario;
			try {
				horario = formatador.parse(rs.getString("hora"));
				Time time = new Time(horario.getTime());
				expo.setHora(time);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			lista.add(expo);
		}
		return lista;
	}

}