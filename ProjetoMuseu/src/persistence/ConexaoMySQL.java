package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements IConexaoMySQL {

	private String host;
	private String port;
	private String user;
	private String pass;
	private String database;
	private boolean connected;

	public Connection c;

	public ConexaoMySQL(String host, String portNumber, String database, String user, String pass) {
		this.pass = pass;
		this.user = user;
		this.host = host;
		this.port = portNumber;
		this.database = database;
		this.connected = false;
	}
	
	public ConexaoMySQL(){
		this("127.0.0.1", "3306", "museu", "root", "root");
		//port 3306
	}
	
	public Connection connect() {
		String url;
		String userName = this.user;
		String passName = this.pass;
		url = "jdbc:mysql://" + this.host + ":" + this.port + ";databaseName=" + this.database;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.c = DriverManager.getConnection(url, userName, passName);
			connected = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			connected = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			connected = false;
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			connected = false;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			connected = false;
		}

		return c;
	}

	public void disconnect() {
		String url;
		String userName = this.user;
		String passName = this.pass;
		url = "jdbc:sqlserver://" + this.host + ":" + this.port + ";databaseName=" + this.database;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			this.c = DriverManager.getConnection(url, userName, passName);
			this.c.close();
			connected = false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			connected = true;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			connected = true;
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
			connected = true;
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
			connected = true;
		}

	}

	public void disconnect(Connection conn) {
		try {
			if (conn != null)
				conn.close();
			conn = null;
			connected = false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			connected = true;
		}

	}

	public boolean isConnected() {
		return this.connected;
	}

}
