package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelLojinha.ModelarTelefone;
import ModelLojinha.ModelarCliente;

public class TelefoneDAO {

private Connection connection;
	
	public TelefoneDAO() {
		this.connection = new ConnectionFactory().getConnection(); // Cada vez que criar uma instancia, ira conectar com o banco de dados
	}
	
	public void adicionarTelefone(ModelarTelefone Telefone , ModelarCliente Cliente) throws SQLException {
		
		try {
			
			String tbTelefone = "insert into tbTelefone (numTelefone , idCliente) values(?,?)";
			
			PreparedStatement stmt = connection.prepareStatement (tbTelefone);
			
			stmt.setString(1, Telefone.getTelefone());
			stmt.setInt(2, Cliente.getIdCliente());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Operacao concluida com exito!");
			
			
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			
		}
		
		finally {
			connection.close();
		}
		
	}
	
}
