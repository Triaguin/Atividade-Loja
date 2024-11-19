package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DAOLojinha.PedidoDAO;
import ModelLojinha.ModelarPedido;
public class carrinhoPedido extends JFrame {
	private JComboBox cbcarrinho;
	private JLabel lbvalorPedido;
	private JTextField txvalorPedido;
	private JButton btfinalizarPedido;
	
	ModelarPedido pedido = new ModelarPedido();
	PedidoDAO salvarPedido = new PedidoDAO();
	
	public carrinhoPedido() {
		this.setTitle("Carrinho");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    setLayout(null); // Importante
	    
	    
//	    cbcarrinho = new JComboBox();
//	    cbcarrinho.setBounds(300, 100, 300, 35);
//	    add(cbcarrinho); //Aqui aonde vai ficar o carrinho
	    
	    lbvalorPedido = new JLabel();
		lbvalorPedido.setText("Valor Pedido");
		lbvalorPedido.setBounds(300, 100, 300, 15);
		add(lbvalorPedido);

		txvalorPedido = new JTextField();
		txvalorPedido.setBounds(300, 115, 300, 35);
		add(txvalorPedido);

	    
	    btfinalizarPedido = new JButton();
	    btfinalizarPedido.setBounds(350, 500, 200, 35);
	    btfinalizarPedido.setText("Finzalizar pedido");
	    add(btfinalizarPedido);
	    
	    btfinalizarPedido.addActionListener((ActionListener) new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
  			Double valorPedido = Double.parseDouble(txvalorPedido.getText());
  			pedido.setStatusPedido("Em andamento"); 		
  			try {
				salvarPedido.adcionarPedido(pedido);
				JOptionPane.showMessageDialog(null, "Pedido finalizado");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    });
	}

}