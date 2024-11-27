package DAOLojinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelLojinha.ModelarCarrinho;
import ModelLojinha.ModelarPedido;
import ModelLojinha.ModelarProduto;

public class CarrinhhoDAO {
	private Connection connection;

	public CarrinhhoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionarCarrinho(ModelarCarrinho carrinho, ModelarPedido pedido) throws SQLException {
		try {
			String tbCarrinho = "INSERT INTO tbCarrinho (quantidadeProduto, idPedido) VALUES (?,?)";
			PreparedStatement stmt = connection.prepareStatement(tbCarrinho);

			stmt.setInt(1, carrinho.getQtItens());
			stmt.setInt(2, pedido.getIdPedido());

			stmt.execute();
			stmt.close();
		} 

		catch (SQLException e) {
			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar

		}

		finally {
			connection.close();
		}

	}

	public void ItensCarrinho(ModelarCarrinho carrinho, ModelarProduto produto) throws SQLException {
		try {
			String tbItensCarrinho = "INSERT INTO tbItensCarrinho (idCarrinho, idProduto) VALUES (?, ?)";
			PreparedStatement stmt = connection.prepareStatement(tbItensCarrinho);

			stmt.setInt(1, carrinho.getIdCarrinho());
			stmt.setInt(2, produto.getIdProduto());

			stmt.execute();
			stmt.close();

		}

		catch (SQLException e) {
			System.out.println("Erro: " + e + " erro no itens carrinho"); // Caso algum erro ocorra no codigo, ele ira informar

		}

		finally {
			connection.close();
		}
	}
	
	public int getIdMaisRecente() throws SQLException { // Select basicamente

		try {
			
			String sql = "SELECT MAX(idCarrinho) FROM tbCarrinho";

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			ResultSet rs = stmt.executeQuery(); // Guarda a categoria do select

			rs.next();
			int id = rs.getInt(1);
			System.out.println(id);

			rs.close();
			stmt.close();

			return id; // retorna o id

		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
		} finally {

			connection.close();
		}
		return 0;
	}
}
