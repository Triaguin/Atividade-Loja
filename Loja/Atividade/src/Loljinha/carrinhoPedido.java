package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import DAOLojinha.PedidoDAO;
import DAOLojinha.ProdutoDAO;
import ModelLojinha.ModelarPedido;
import ModelLojinha.ModelarProduto;
public class carrinhoPedido extends JFrame {
	private JComboBox cbProduto;
	private int qtProdutos = 0;
	private JLabel lbqtProdutos;
	private JTextField txqtProdutos;
	private JButton btAdicionarProduto;
	private JButton btfinalizarPedido;
	
	ModelarPedido pedido = new ModelarPedido();
	PedidoDAO salvarPedido = new PedidoDAO();
	
	public carrinhoPedido() throws SQLException {
		this.setTitle("Carrinho");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    setLayout(null); // Importante
	    
	    List<ModelarProduto> produtos = new ProdutoDAO().getLista();
			String[] ListaProdutos = new String[produtos.size()]; 
			
			for (int i = 0; i < produtos.size(); i++) { 
				ListaProdutos[i] = produtos.get(i).getNomeProduto();
			}
	    
	    cbProduto = new JComboBox(ListaProdutos);
	    cbProduto.setBounds(300, 50, 300, 30);
	    add(cbProduto); //Aqui aonde vai ficar o carrinho
	    
	    txqtProdutos = new JTextField();
	    txqtProdutos.setBounds(500, 15, 100, 30);
	    add(txqtProdutos);
	    
	    lbqtProdutos = new JLabel();
	    lbqtProdutos.setText("Quantidade de produtos");
	    lbqtProdutos.setBounds(300, 160, 300, 30);
	    add(lbqtProdutos);
	    
	    
	    btAdicionarProduto = new JButton();
	    btAdicionarProduto.setText("Adicionar pedido");
	    btAdicionarProduto.setBounds(350, 450, 150, 30);
	    add(btAdicionarProduto);
	    
	    btfinalizarPedido = new JButton();
	    btfinalizarPedido.setText("FInalizar Pedido");
	    btfinalizarPedido.setBounds(350, 500, 150, 30);
	    add(btfinalizarPedido);
	    
	    btAdicionarProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
	}

}