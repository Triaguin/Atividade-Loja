package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelLojinha.ModelarCategoria;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO() {
		this.connection = new ConnectionFactory().getConnection(); // Cada vez que criar uma instancia, ira conectar com
																	// o banco de dados
	}

	public void adicionarCategoria(ModelarCategoria Categoria) throws SQLException {
		try {

			String tbCategoria = "insert into tbCategoria (nomeCategoria) values (?)";

			PreparedStatement stmt = connection.prepareStatement(tbCategoria); // preparando parar executar o codigo

			stmt.setString(1, Categoria.getNomeCategoria());

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

	public List<ModelarCategoria> getLista() throws SQLException { // Select basicamente

		try {

			List<ModelarCategoria> categorias = new ArrayList<ModelarCategoria>(); // cria a lista de categorias

			String sql = "SELECT * FROM tbCategoria";

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			ResultSet rs = stmt.executeQuery(); // Guarda as categorias do select

			while (rs.next()) { // Coloca cada uma das categorias num objeto modelarcategoria

				ModelarCategoria categoria = new ModelarCategoria(); // Cria um novo modelarcategoria

				// Adiciona as informacoes da categoria
				categoria.setIdCategoria(rs.getInt(1));
				categoria.setNomeCategoria(rs.getString(2));

				categorias.add(categoria); // adiciona a categoria na lista
			}

			rs.close();
			stmt.close();

			return categorias; // retorna as categorias

		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
		return null;
	}

	public void alterarCategoria(ModelarCategoria categoria) throws SQLException { // Muda os valores da categoria no banco para os da categoria
																// que ta no parametro

		String sql = "UPDATE tbCategoria SET nomeCategoria = ? WHERE idCategoria = ?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			stmt.setString(1, categoria.getNomeCategoria()); // Inserindo os valores no lugar do ?
			stmt.setInt(2, categoria.getIdCategoria());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
	}

	public ModelarCategoria getCategoria(int id) throws SQLException { // Select basicamente

		try {
			String sql = "SELECT * FROM tbCategoria WHERE idCategoria = ?";

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			stmt.setInt(1, id); // Adiciona o id no Codigo

			ResultSet rs = stmt.executeQuery(); // Guarda a categoria do select

			ModelarCategoria categoria = new ModelarCategoria(); // Cria um novo modelarcategoria

			// Adiciona as informacoes da categoria
			rs.next();
			categoria.setIdCategoria(id);
			categoria.setNomeCategoria(rs.getString(2));

			rs.close();
			stmt.close();

			return categoria; // retorna a categoria

		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
		return null;
	}
	
	public void excluirCategoria(ModelarCategoria categoria) throws SQLException {
		
		String sql = "DELETE FROM tbCategoria WHERE idCategoria = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, categoria.getIdCategoria());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
	}
}
