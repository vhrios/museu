package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Obra;
import entity.Emprestimo;

public class EmprestimoObraDAO implements IEmprestimoObra {
	private Connection c;

	public EmprestimoObraDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public boolean manter(List<Obra> obras, Emprestimo emprestimo) throws SQLException {
		if (obras.size() != 0) {
			String sql = "INSERT INTO emprestimo_obra (obra_id, emprestimo_id) VALUES (?,?)";
			PreparedStatement ps = c.prepareStatement(sql, Statement.SUCCESS_NO_INFO);

			int i = 0;
			for (Obra atividade : obras) {
				ps.setInt(1, atividade.getId());
				ps.setInt(2, emprestimo.getId());
				ps.addBatch();

				i++;

				if (i % 1000 == 0 || i == obras.size()) {
					ps.executeBatch();
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean apagar(List<Obra> obras, Emprestimo emprestimo) throws SQLException {
		if (emprestimo.getId() != 0) {
			String sql = "DELETE emprestimo_obra WHERE emprestimo_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualiza��o do Emprestimo, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualiza��o do Emprestimo, ID n�o recebido no par�metro.");
	}

	@Override
	public List<Obra> pesquisarPorEmprestimo(int i) throws SQLException {
		String sql = "SELECT obra_id FROM museu.emprestimo_obra WHERE emprestimo_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);

		List<Obra> aList = new ArrayList<Obra>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			aList.add(new ObraDAO().pesquisarPorID(rs.getInt("obra_id")));
		}
		ps.close();
		return aList;
	}

}