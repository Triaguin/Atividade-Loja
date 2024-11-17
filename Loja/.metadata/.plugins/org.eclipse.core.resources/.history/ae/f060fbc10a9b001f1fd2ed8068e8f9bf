package DAO;

//conecxao com o banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bdteste" ,"root",""); //url de conecxao, bd , usuario e senha ; jdbc = java database connection
		}
		
		catch(SQLException e) { //Caso de algum erro acontecer
			throw new RuntimeException();
		}
	}
}
