package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ModelLojinha.ModelarCategoria;
import ModelLojinha.ModelarCliente;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionarCategoria(ModelarCliente Cliente) throws SQLException {
		try {

			String tbCliente = "insert into tbCliente (nomeCliente,datanascCliente,cpfCliente,sexoCliente,logradouroCliente,numlogradouroCliente,bairroCliente,cidadeCliente) values (?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(tbCliente);

			java.sql.Date datasql = new java.sql.Date(Cliente.getDatanasc().getTime().getTime());
			datasql.setMonth((datasql.getMonth() - 1) % 12);

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

		catch (SQLException e) {
			System.out.println("Erro: " + e);

		}

		finally {
			connection.close();
		}
	}

	public List<ModelarCliente> getLista() throws SQLException { // Select basicamente

		try {

			List<ModelarCliente> clientes = new ArrayList<ModelarCliente>(); // cria a lista de clientes

			String sql = "SELECT * FROM tbCliente";

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			ResultSet rs = stmt.executeQuery(); // Guarda os clientes do select

			while (rs.next()) { // Coloca cada uma dos clientes num objeto modelarcliente

				ModelarCliente cliente = new ModelarCliente(); // Cria um novo modelarcliente
				
				Calendar dataNasc = Calendar.getInstance();
				dataNasc.setTime(rs.getDate(3));

				// Adiciona as informacoes da clientes
				cliente.setIdCliente(rs.getInt(1));
				cliente.setNomeCliente(rs.getString(2));
				cliente.setDatanasc(dataNasc);
				cliente.setCpfCliente(rs.getString(4));
				cliente.setSexoCliente(rs.getInt(5));
				cliente.setLogradouroCliente(rs.getString(6));
				cliente.setNumLogradouroCliente(rs.getInt(7));
				cliente.setBairroCliente(rs.getString(8));
				cliente.setCidadeCliente(rs.getString(9));

				clientes.add(cliente); // adiciona o cliente na lista
			}

			rs.close();
			stmt.close();

			return clientes; // retorna os clientes
		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
		return null;
	}
	
	public void alterarCliente (ModelarCliente cliente) throws SQLException {
		String sql = "UPDATE tbCliente SET nomeCliente = ? SET datanascCliente = ? SET cpfCliente = ? SET sexoCliente = ? SET logradouroCliente = ? SET numLogradouroCliente = ? SET bairroCliente = ? SET cidadeCliente = ? WHERE idCliente = ?";
		
		try {
			java.sql.Date datasql = new java.sql.Date(cliente.getDatanasc().getTime().getTime());
			datasql.setMonth((datasql.getMonth() - 1) % 12);
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setDate(2, datasql);
			stmt.setString(3, cliente.getCpfCliente());
			stmt.setInt(4, cliente.getSexoCliente());
			stmt.setString(5, cliente.getLogradouroCliente());
			stmt.setInt(6, cliente.getNumLogradouroCliente());
			stmt.setString(7, cliente.getBairroCliente());
			stmt.setString(8, cliente.getCidadeCliente());
			stmt.setInt(9, cliente.getIdCliente());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
	
		
	}
	
	public void excluirCliente(ModelarCliente cliente) throws SQLException {
		try {
			String sql = "DELETE * FROM tbCliente WHERE idCliente = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, cliente.getIdCliente());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
	}
	
	
}
