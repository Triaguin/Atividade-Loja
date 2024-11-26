package DAOLojinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

import javax.swing.*;
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
			String tbCarrinho = "UPDATE tbPedido SET statusPedido = ? WHERE idPedido = ?";
			
			PreparedStatement stmt = connection.prepareStatement(tbCarrinho);
			
			stmt.setString(1, pedido.getStatusPedido());
			stmt.setInt(2, pedido.getIdPedido());
			
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
	
}
