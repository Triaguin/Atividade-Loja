package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class carrinhoPedido extends JFrame {
	private JComboBox cbcarrinho;
	private JButton btfinalizarPedido;
	
	public carrinhoPedido() {
		this.setTitle("Carrinho");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    setLayout(null); // Importante
	    
	    
	    cbcarrinho = new JComboBox();
	    cbcarrinho.setBounds(300, 100, 300, 35);
	    add(cbcarrinho); //Aqui aonde vai ficar o carrinho
	    
	    btfinalizarPedido = new JButton();
	    btfinalizarPedido.setBounds(350, 500, 200, 35);
	    btfinalizarPedido.setText("Finzalizar pedido");
	    add(btfinalizarPedido);
	}

}