package DAOLojinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

import javax.swing.*;

import ModelLojinha.ModelarCategoria;
import ModelLojinha.ModelarPedido;

import ModelLojinha.ModelarPedido;

public class PedidoDAO {
private Connection connection;
	
	public PedidoDAO() {
		this.connection = new ConnectionFactory().getConnection(); 
	}
	
	public void adcionarPedido (ModelarPedido pedido) throws SQLException {
		try {
			String tbPedido = "insert into tbPedido (dataPedido,statusPedido) values (?,?)";
			PreparedStatement stmt = connection.prepareStatement (tbPedido);
			
			Date data = new Date();
			java.sql.Date datasql = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			
			stmt.setDate(1,datasql);
			stmt.setString(2, pedido.getStatusPedido());
			
			stmt.execute();
			stmt.close();

		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); 
			
		}
		finally {
			connection.close();
		}
			}
	
	public void statusPedido (ModelarPedido pedido) throws SQLException {
		try {
			String tbCarrinho = "UPDATE tbPedido SET statusPedido = ? SET valorPedido = ? WHERE idPedido = ?";
			
			PreparedStatement stmt = connection.prepareStatement(tbCarrinho);
			
			stmt.setString(1, pedido.getStatusPedido());
			stmt.setDouble(2, pedido.getValorPedido());
			stmt.setInt(3, pedido.getIdPedido());
			
			stmt.execute();
			stmt.close();
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); 
			
		}
		finally {
			connection.close();
		}
	}
	
	public int getIdMaisRecente() throws SQLException { // Select basicamente

		try {
			
			String sql = "SELECT MAX(idPedido) FROM tbPedido";

			PreparedStatement stmt = connection.prepareStatement(sql); // preparando parar executar o codigo

			ResultSet rs = stmt.executeQuery(); // Guarda a categoria do select

			rs.next();
			int id = rs.getInt(1);

			rs.close();
			stmt.close();

			return id; // retorna o id

		} catch (SQLException e) {

			System.out.println("Erro: " + e); // Caso algum erro ocorra no codigo, ele ira informar
			
			return 0;
		} finally {

			connection.close();
		}
	}
	
}
