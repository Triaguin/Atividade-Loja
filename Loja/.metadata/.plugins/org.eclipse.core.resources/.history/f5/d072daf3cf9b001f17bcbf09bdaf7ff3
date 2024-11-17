package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ModelLojinha.ModelarCategoria;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO() {
		this.connection = new ConnectionFactory().getConnection(); // Cada vez que criar uma instancia, ira conectar com o banco de dados
	}
	
	public void adicionarCategoria(ModelarCategoria Categoria) throws SQLException {
		try {
			
			String tbCategoria = "insert into tbCategoria (nomeCategoria) values (?)";
			
			PreparedStatement stmt = connection.prepareStatement (tbCategoria); //preparando parar executar o codigo
			
			stmt.setString(1, Categoria.getNomeCategoria());
			
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
