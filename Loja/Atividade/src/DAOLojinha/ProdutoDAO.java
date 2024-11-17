package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ModelLojinha.ModelarProduto;
import ModelLojinha.ModelarCategoria;
import ModelLojinha.ModelarEstoque;

public class ProdutoDAO {
private Connection connection;
	
	public ProdutoDAO() {
		this.connection = new ConnectionFactory().getConnection(); 
	}
	
	public void adicionarEstoque( ModelarProduto Produto) throws SQLException {
		try {
			String tbProduto = "insert into tbProduto (nomeProduto, precoProduto , quantidadeProduto) values (?,?,?) ";
			PreparedStatement stmt = connection.prepareStatement (tbProduto);
			
			stmt.setString(1, Produto.getNomeProduto());
			stmt.setDouble(2, Produto.getValorProduto());;
			stmt.setInt(3, Produto.getQuantidadeProduto());

			stmt.execute();
			stmt.close();
			
			System.out.println(Produto.getNomeProduto() + " Cadastrado com exito");
			
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); 
			
		}
		finally {
			connection.close();
		}
	}
}

