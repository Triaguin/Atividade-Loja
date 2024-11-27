package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import ModelLojinha.ModelarCarrinho;
import ModelLojinha.ModelarPedido;
import DAOLojinha.CarrinhhoDAO;
import DAOLojinha.PedidoDAO;

public class CadastrarPedido extends JFrame {
	private JButton btnovoPedido;
	private JButton btverPedido;
	
	CarrinhhoDAO salvarCarrinho = new CarrinhhoDAO();	
	ModelarPedido pedido = new ModelarPedido();
	ModelarCarrinho carrinho = new ModelarCarrinho();
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
    			
    			
    			pedido.setValorPedido(null);
    			pedido.setStatusPedido("Em andamento");
    			
    			
    			try {
					new PedidoDAO().adcionarPedido(pedido);
					pedido.setIdPedido(new PedidoDAO().getIdMaisRecente());
					carrinho.setIdCarrinho(new CarrinhhoDAO().getIdMaisRecente());
					salvarCarrinho.adicionarCarrinho(carrinho, pedido);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    		}
	    });
	    
	    
	    
//	    btverPedido.addActionListener((ActionListener) new ActionListener() {
//	    	public void actionPerformed(ActionEvent e) {
//    			
//    		}
//	    });
}
	
}