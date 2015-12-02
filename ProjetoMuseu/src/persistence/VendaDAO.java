package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Venda;

public class VendaDAO implements IVenda {

	/*
	 * private int id; private int qtdInteiro; private int qtdMeio; private
	 * float valorTotal; private String tipoPagamento; private Ingresso
	 * ingresso; private boolean reserva;
	 */

	private Connection c;

	public VendaDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public boolean manter(Venda v) throws SQLException {
		if (v.getId() == 0) {
			String sql = "INSERT INTO venda (qtdInteiro, qtdMeio, valorTotal, tipoPagamanto, ingresso_id, reserva) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, v.getQtdInteiro());
			ps.setInt(2, v.getQtdMeia());
			ps.setFloat(3, (float) v.getValorTotal());
			ps.setString(4, v.getFormaPagamento());
			ps.setBoolean(6, false);// v.isReverva());

			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na criação da Atividade, sem linhas afetadas.");
			}

			try (ResultSet idsGerados = ps.getGeneratedKeys()) {
				if (idsGerados.next()) {
					v.setId(idsGerados.getInt(1));
					ps.close();
					return true;
				} else {
					throw new SQLException("Falha na criação da Atividade, ID não capturado.");
				}
			}
		} else {
			return false;
		}
	}

	@Override
	public Venda pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT qtdInteiro, qtdMeio, valorTotal, tipoPagamanto, ingresso_id, reserva FROM venda WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Venda v = new Venda();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			v.setId(id);
			v.setQtdInteiro(rs.getInt("qtdInteiro"));
			v.setQtdMeia(rs.getInt("qtdMeio"));
			v.setValorTotal(rs.getFloat("valorTotal"));
			v.setFormaPagamento(rs.getString("tipoPagamento"));
			// v.setReserva(rs.getBoolean("reserva"));
		} else {
			v = null;
		}
		ps.close();
		return v;
	}

	@Override
	public List<Venda> carregarTodos() throws SQLException {
		String sql = "SELECT id, qtdInteiro, qtdMeio, valorTotal, tipoPagamanto, ingresso_id, reserva FROM venda";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Venda> vList = new ArrayList<Venda>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Venda v = new Venda();
			v.setId(rs.getInt("id"));
			v.setQtdInteiro(rs.getInt("qtdInteiro"));
			v.setQtdMeia(rs.getInt("qtdMeio"));
			v.setValorTotal(rs.getFloat("valorTotal"));
			v.setFormaPagamento(rs.getString("tipoPagamento"));
			// v.setReserva(rs.getBoolean("reserva"));
			vList.add(v);
		}

		ps.close();
		return vList;
	}

}