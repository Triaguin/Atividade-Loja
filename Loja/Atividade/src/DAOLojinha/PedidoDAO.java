package DAOLojinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			String tbPedido = "insert into tbPedido (valorPedido,statusPedido) values (?,?)";
			PreparedStatement stmt = connection.prepareStatement (tbPedido);
			
			stmt.setDouble(1, pedido.getValorPedido());
			stmt.setString(2, pedido.getStatusPedido());
		}
		
		catch(SQLException e) {
			System.out.println("Erro: " + e); 
			
		}
		finally {
			connection.close();
		}
			}
	
}
