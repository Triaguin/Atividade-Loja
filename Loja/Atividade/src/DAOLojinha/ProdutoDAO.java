package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ModelLojinha.ModelarProduto;
import ModelLojinha.ModelarCategoria;

public class ProdutoDAO {
private Connection connection;
	
	public ProdutoDAO() {
		this.connection = new ConnectionFactory().getConnection(); 
	}
	
	public void adicionarEstoque( ModelarProduto Produto , 	ModelarCategoria Categoria) throws SQLException {
		try {
			String tbProduto = "insert into tbProduto (nomeProduto, precoProduto , quantidadeProduto, idCategoria) values (?,?,?,?) ";
			PreparedStatement stmt = connection.prepareStatement (tbProduto);
			
			stmt.setString(1, Produto.getNomeProduto());
			stmt.setDouble(2, Produto.getValorProduto());;
			stmt.setInt(3, Produto.getQuantidadeProduto());
			stmt.setInt(4, Categoria.getIdCategoria());
			
 
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
	
	public List<ModelarProduto> getLista() throws SQLException { // Select basicamente

		try {

			List<ModelarProduto> produtos = new ArrayList<ModelarProduto>(); // cria a lista de produtos

			String sql = "SELECT * FROM tbProduto";

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			ResultSet rs = stmt.executeQuery(); // Guarda os produtos do select

			while (rs.next()) { // Coloca cada uma dos produtos num objeto modelarproduto

				ModelarProduto produto = new ModelarProduto(); // Cria um novo modelarproduto

				// Adiciona as informacoes da produtos
				produto.setIdProduto(rs.getInt(1));
				produto.setNomeProduto(rs.getString(2));
				produto.setValorProduto(rs.getDouble(3));
				produto.setQuantidadeProduto(rs.getInt(4));
				produto.setIdCategoria(rs.getInt(5));

				produtos.add(produto); // adiciona o produto na lista
			}

			rs.close();
			stmt.close();

			return produtos; // retorna os produtos
		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
		return null;
	}
	
	public void alterarProduto(ModelarProduto produto) throws SQLException { 


			String sql = "UPDATE tbProduto SET nomeProduto = ? SET valorProduto = ? SET qtProduto = ? SET idCategoria ?  WHERE idProduto = ?";
			
			try {
			
			PreparedStatement stmt = connection.prepareStatement(sql); 
			
			stmt.setString(1, produto.getNomeProduto());
			stmt.setDouble(2, produto.getValorProduto());
			stmt.setInt(3, produto.getQuantidadeProduto());
			stmt.setInt(4, produto.getIdCategoria());
			stmt.setInt(5, produto.getIdProduto());
			
			
			stmt.execute();
			stmt.close();
			
			} catch (SQLException e) {
			
			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			} finally {
			
			connection.close();
			}
			}
		
	public void qtProduto(ModelarProduto produto, int qtProduto) throws SQLException { //Essa funcao serve para atualizar o estoque quando um pedido e feito


		String sql = "UPDATE SET qtProduto = ?  WHERE idProduto = ?";
		
		try {
		
		PreparedStatement stmt = connection.prepareStatement(sql); 
		
		stmt.setInt(1, produto.getQuantidadeProduto());
		stmt.setInt(2, produto.getIdProduto());
		
		
		
		stmt.execute();
		stmt.close();
		
		} catch (SQLException e) {
		
		System.out.println("Erro: " + e); 
		} finally {
		
		connection.close();
		}
		}
	
	
	public void excluirProduto(ModelarProduto produto)throws SQLException {
		try {
			String sql = "DELETE * FROM tbProduto WHERE idProduto = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, produto.getIdProduto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			System.out.println("Erro: " + e); 
		} finally {

			connection.close();
		}
	}
}
