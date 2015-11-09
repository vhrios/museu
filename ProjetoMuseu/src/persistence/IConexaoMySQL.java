package persistence;

import java.sql.Connection;

public interface IConexaoMySQL {

	public Connection connect();

	public void disconnect();

	public void disconnect(Connection c);

	public boolean isConnected();

}
