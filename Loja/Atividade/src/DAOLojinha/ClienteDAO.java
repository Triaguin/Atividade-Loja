package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ModelLojinha.ModelarCliente;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection(); 
	}
	
	public void adicionarCategoria(ModelarCliente Cliente) throws SQLException {
		try {
			
			String tbCliente = "insert into tbCliente (nomeCliente,datanascCliente,cpfCliente,sexoCliente,logradouroCliente,numlogradouroCliente,bairroCliente,cidadeCliente) values (?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = connection.prepareStatement (tbCliente); 
			
			java.sql.Date datasql = new java.sql.Date(Cliente.getDatanasc().getTime().getTime());
			datasql.setMonth((datasql.getMonth() - 1) % 12);
			
			System.out.println("Nome: " + Cliente.getNomeCliente() + " Dia " + datasql.getDate() + " Mes " + datasql.getMonth() + " Ano " + datasql.getYear() + " CPF: " + Cliente.getCpfCliente() + " Sexo: " + Cliente.getSexoCliente() + " Logr: " + Cliente.getLogradouroCliente() + " N: " + Cliente.getNumLogradouroCliente() + " Bairro: " + Cliente.getBairroCliente() + " Cidade: " + Cliente.getCidadeCliente());
			
			stmt.setString(1, Cliente.getNomeCliente());
			stmt.setDate(2, datasql);
			stmt.setString(3, Cliente.getCpfCliente());
			stmt.setInt(4, Cliente.getSexoCliente());
			stmt.setString(5, Cliente.getLogradouroCliente());
			stmt.setInt(6, Cliente.getNumLogradouroCliente());
			stmt.setString(7, Cliente.getBairroCliente());
			stmt.setString(8, Cliente.getCidadeCliente());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Operacao concluida com exito! Cliente" + Cliente.getNomeCliente() + " Cadastrado");
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); 
			
		}
		
		finally {
			connection.close();
		}
	}
}
