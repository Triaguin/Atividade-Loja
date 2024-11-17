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
	
	public void adicionarEstoque(ModelarEstoque Estoque , ModelarProduto Produto, ModelarCategoria Categoria) throws SQLException {
		try {
			String tbEstoque = "insert into tbEstoqueProduto (nomeEstoqueProduto , idCategroia) values (?,?) ";
			String tbProduto = "insert into tbProduto (nomeProduto, precoProduto , idEstoqueProduto) valuues (?,?,?) ";
			PreparedStatement stmtE = connection.prepareStatement (tbEstoque);
			
			stmtE.setString(1, Estoque.getNomeEstoqueProduto());
			stmtE.setInt(2, Categoria.getIdCategoria());
			stmtE.execute();
			
			
			
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); 
			
		}
		
		
		
		public List<ModelarEstoque> getLista() throws SQLException {
			try {
				List<ModelarEstoque> Estoque = new ArrayList <ModelarEstoque>();
				String sql = "SELECT idEstoqueProduto FROM tbEstoqueProduto";
				PreparedStatement stmtE = connection.prepareStatement(sql);
				ResultSet rs = stmtE.executeQuery();
				
				while(rs.next()) {
					ModelarCategoria categoria = new ModelarCategoria();
					categoria.setIdCategoria(rs.getInt(1));
				}
				
			}
			
			catch(SQLException e) {
				System.out.println("Erro: " + e); 
				
			}
			finally {
				connection.close();
			}
		}
	}
}
