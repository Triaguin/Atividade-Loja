package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import ModelLojinha.ModelarPedido;
import DAOLojinha.PedidoDAO;

public class CadastrarPedido extends JFrame {
	private JButton btnovoPedido;
	private JButton btverPedido;
	public int contador = 0;
	
	ModelarPedido pedido = new ModelarPedido();
	public CadastrarPedido() {		
		this.setTitle("Cadastrar Categoria");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    setLayout(null); // Importante
	    
	    btnovoPedido = new JButton();
	    btnovoPedido.setText("Novo Pedido");
	    btnovoPedido.setBounds(300,20,250,80);
	    add(btnovoPedido);
	    
	    btnovoPedido.addActionListener((ActionListener) new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			carrinhoPedido carrinhoPedido;
				try {
					carrinhoPedido = new carrinhoPedido();
					carrinhoPedido.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			
//    			pedido.setStatusPedido(null);
//    			pedido.setStatusPedido("Em andamento");
//    			
//    			try {
//					new PedidoDAO().adcionarPedido(pedido);
//					contador++;
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
    			
    		}
	    });
	    
	    
	    
//	    btverPedido.addActionListener((ActionListener) new ActionListener() {
//	    	public void actionPerformed(ActionEvent e) {
//    			
//    		}
//	    });
}
	
}