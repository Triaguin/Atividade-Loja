package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelLojinha.ModelarTelefone;
import ModelLojinha.ModelarCategoria;
import ModelLojinha.ModelarCliente;

public class ListaTelefoneDAO {
private Connection connection;
	
	public ListaTelefoneDAO() {
		this.connection = new ConnectionFactory().getConnection(); // Cada vez que criar uma instancia, ira conectar com o banco de dados
	}
	
	public void adicionarListaTelefone (ModelarCliente Cliente, ModelarTelefone Telefone) throws SQLException {
		try {
			String sqlCli = "SELECT * FROM tbCliente WHERE cpfCliente = ?";
			String sqlTel = "SELECT * FROM tbTelefone WHERE numTelefone = ?";
			String sql = "INSERT INTO tbListaTelefone (numPrincipal, idTelefone, idCliente) VALUES (?,?,?)";
			
			PreparedStatement stmtCli = connection.prepareStatement(sqlCli);
			PreparedStatement stmtTel = connection.prepareStatement(sqlTel);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rsCli = stmtCli.executeQuery(Cliente.getCpfCliente());
			ResultSet rsTel = stmtTel.executeQuery(Telefone.getTelefone());
			
			Cliente.setIdCliente(rsCli.getInt(1));
			Telefone.setIdTelefone(rsTel.getInt(1));
			
			stmt.setString(1, Telefone.getTelefone());
			stmt.setInt(2, Telefone.getIdTelefone());
			stmt.setInt(3, Cliente.getIdCliente());
			
			stmt.execute();
			stmtCli.close();
			stmtTel.close();
			
			
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			
		}
		
		finally {
			connection.close();
		}
	}
}
