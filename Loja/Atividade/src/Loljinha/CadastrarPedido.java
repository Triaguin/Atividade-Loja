package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastrarPedido extends JFrame {
	private JButton btnovoPedido;
	private JButton btverPedido;
	
	public CadastrarPedido() {		
		this.setTitle("Cadastrar Categoria");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    setLayout(null); // Importante
	    
	    btnovoPedido = new JButton();
	    btnovoPedido.setText("Ver carrinho");
	    btnovoPedido.setBounds(300,20,250,80);
	    add(btnovoPedido);
	    
	    btnovoPedido.addActionListener((ActionListener) new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			carrinhoPedido carrinhoPedido = new carrinhoPedido();
    			carrinhoPedido.setVisible(true);
    		}
	    });
	    
	    btverPedido = new JButton();
	    btverPedido.setText("Ver compras");
	    btverPedido.setBounds(300,150,250,80);	    
	    add(btverPedido);
	}
	
}