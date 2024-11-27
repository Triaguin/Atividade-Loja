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
import ModelLojinha.ModelarPedido;
import ModelLojinha.ModelarProduto;

public class CarrinhhoDAO {
private Connection connection;
	
	public CarrinhhoDAO() {
		this.connection = new ConnectionFactory().getConnection(); 
	}
	
	public void adicionarCarrinho (ModelarProduto produto, int quantidadeProduto, ModelarPedido pedido) throws SQLException {
		try {
			String tbCarrinho = "INSERT INTO tbCarrinho (quantidadeProduto, idProduto, idPedido) VALUES (?, ?,?)";
			PreparedStatement stmt = connection.prepareStatement (tbCarrinho);
			
			stmt.setInt(1, quantidadeProduto);
			stmt.setInt(2, produto.getIdProduto());
			stmt.setInt(3, pedido.getContador());
			
			stmt.execute();
			stmt.close();
		}
		finally {
			connection.close();
		}
	
	}
}
