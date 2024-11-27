package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import DAOLojinha.CarrinhhoDAO;
import DAOLojinha.PedidoDAO;
import DAOLojinha.ProdutoDAO;
import ModelLojinha.ModelarPedido;
import ModelLojinha.ModelarProduto;
public class carrinhoPedido extends JFrame {
	private JComboBox cbProduto;
	private JLabel lbqtProdutos;
	private JTextField txqtProdutos;
	private JButton btAdicionarProduto;
	private JButton btfinalizarPedido;
	private Double valorTotalVenda;
	
	ModelarPedido pedido = new ModelarPedido();
	ModelarProduto produto = new ModelarProduto();
	CarrinhhoDAO salvarCarrinho = new CarrinhhoDAO();
	PedidoDAO salvarPedido = new PedidoDAO();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	
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
	    txqtProdutos.setBounds(500, 150, 100, 30);
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
	    
	    btAdicionarProduto.addActionListener(new ActionListener() { // Esse serve para atribuir um produto a um carrinho, nao esta funcionando ainda

			public void actionPerformed(ActionEvent e) {
				
				int idProduto = (int) produtos.get(cbProduto.getSelectedIndex()).getIdProduto();
				produto.setIdProduto(idProduto);
				try {
					salvarCarrinho.adicionarCarrinho(produto, Integer.parseInt(txqtProdutos.getText()) , pedido);
					valorTotalVenda = valorTotalVenda + produtos.get(cbProduto.getSelectedIndex()).getValorProduto(); //Ele vai salvar o valor do produto na variavel
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	    
	    btfinalizarPedido.addActionListener(new ActionListener() { // Esse serve para atribuir um produto a um carrinho, nao esta funcionando ainda

			public void actionPerformed(ActionEvent e) {
				
				int qtProduto = Integer.parseInt(txqtProdutos.getText());
				pedido.setStatusPedido("Finalizado"); // Ele ira finalizar pedido
				pedido.setValorPedido(valorTotalVenda);
				
				try { // Ele atualiza o estoque do produto quando a compra for finalizada
					produtoDAO.qtProduto(produto, qtProduto);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}

}