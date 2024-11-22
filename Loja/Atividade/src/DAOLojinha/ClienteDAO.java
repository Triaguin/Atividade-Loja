package DAOLojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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

			System.out.println("Nome: " + Cliente.getNomeCliente() + " Dia " + datasql.getDate() + " Mes "
					+ datasql.getMonth() + " Ano " + datasql.getYear() + " CPF: " + Cliente.getCpfCliente() + " Sexo: "
					+ Cliente.getSexoCliente() + " Logr: " + Cliente.getLogradouroCliente() + " N: "
					+ Cliente.getNumLogradouroCliente() + " Bairro: " + Cliente.getBairroCliente() + " Cidade: "
					+ Cliente.getCidadeCliente());

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
				System.out.println(rs.getDate(3));
				System.out.println(dataNasc.DATE + "/" + dataNasc.MONTH + "/" + dataNasc.YEAR);

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
}
