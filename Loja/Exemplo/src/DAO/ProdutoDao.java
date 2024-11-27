package DAO;
//Rotina de insercao
//Objeto de acesso a dados

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Produto; //Importando o objeto produto que esta em outro pacote

public class ProdutoDao {

		private Connection connection;
		
		public ProdutoDao() {
			this.connection = new ConnectionFactory().getConnection(); // Cada vez que criar uma instancia, ira conectar com o banco de dados
		}
		
		public void adicionarProduto(Produto produto) throws SQLException {
			try {
				String sql = "insert into tbProduto (nomeProduto , valorProduto) values (?,?)";
				
				PreparedStatement stmt = connection.prepareStatement (sql); //preparando parar executar o codigo
				
				stmt.setString(1, produto.getNomeProduto()); //Inserindo os valores no lugar do ?
				stmt.setDouble(2, produto.getValorProduto());
				
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
		
		public List<Produto> getLista() throws SQLException { //Select basicamente
			
			try {
				
				List<Produto> produtos = new ArrayList<Produto>(); //cria a lista de produtos
				
				String sql = "SELECT * FROM tbProduto";
				
				PreparedStatement stmt = connection.prepareStatement (sql); //preparando parar executar o codigo
				
				ResultSet rs = stmt.executeQuery(); //Guarda os produtos do select
				
				while(rs.next()) { //Coloca cada um dos produtos num objeto produto
					
					Produto produto = new Produto(); //Cria um novo produto
					
					// Adiciona as informacoes do produto
					produto.setIdProduto(rs.getInt(1));
					produto.setNomeProduto(rs.getString(2));
					produto.setValorProduto(rs.getDouble(3));
					
					produtos.add(produto); //adiciona o produto na lista
				}
				
				rs.close();
				stmt.close();
				
				return produtos;
			}
			catch (SQLException e) {
				
				System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			}
			finally {
				
				connection.close();
			}
			return null;
		}
		
		public void alterar(Produto produto) throws SQLException { // Muda os valores do produto no banco para os do produto que ta no parametro
			
			String sql = "UPDATE tbProduto SET nomeProduto = ? , valorProduto = ? WHERE idProduto = ?";
			
			try {
				
				PreparedStatement stmt = connection.prepareStatement (sql); //preparando parar executar o codigo
				
				stmt.setString(1, produto.getNomeProduto()); //Inserindo os valores no lugar do ?
				stmt.setDouble(2, produto.getValorProduto());
				stmt.setInt(3, produto.getIdProduto());
				
				stmt.execute();
				stmt.close();
				
				System.out.println("Operacao concluida com exito!");
				
			}
			catch (SQLException e) {
				
				System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			}
			finally {
				
				connection.close();
			}
		}
		
		public void excluir(Produto produto) throws SQLException {
			
			String sql = "DELETE FROM tbProduto WHERE idProduto = ?";
			
			try {
				
				PreparedStatement stmt = connection.prepareStatement (sql); //preparando parar executar o codigo
				
				stmt.setInt(1, produto.getIdProduto()); //Inserindo os valores no lugar do ?
				
				stmt.execute();
				stmt.close();
				
				System.out.println("Operacao concluida com exito!");
			}
			catch (SQLException e) {
				
				System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			}
			finally {
				
				connection.close();
			}
		}
}
