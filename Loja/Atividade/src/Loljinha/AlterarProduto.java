package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

import DAOLojinha.CategoriaDAO;
import ModelLojinha.ModelarCategoria;
import ModelLojinha.ModelarProduto;

public class AlterarProduto extends JFrame {
	
	private JLabel lbidProduto;
	private JLabel lbnomeProduto;
	private JLabel lbprecoProduto;
	private JLabel lbqtProduto;
	private JLabel lbidCategoria;
	private JTextField txidProduto;
	private JTextField txnomeProduto;
	private JTextField txprecoProduto;
	private JTextField txqtProduto;
	private JTextField txidCategoria;
	private JButton btalterarProduto;
	
	public AlterarProduto() {
		setTitle("Alterar Produto");
		setSize(900, 600);
	    this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		lbidProduto = new JLabel();
		lbidProduto.setText("idProduto: ");
		lbidProduto.setBounds(350, 105, 70, 15);
		add(lbidProduto);
		
		txidProduto = new JTextField();
		txidProduto.setBounds(420, 100, 200, 30);
		add(txidProduto);
		
		lbnomeProduto = new JLabel();
		lbnomeProduto.setText("Nome Produto: ");
		lbnomeProduto.setBounds(350, 155, 70, 15);
		add(lbnomeProduto);
		
		txnomeProduto = new JTextField();
		txnomeProduto.setBounds(420, 150, 200, 30);
		add(txnomeProduto);
		
		lbprecoProduto = new JLabel();
		lbprecoProduto.setText(" preco Produto: ");
		lbprecoProduto.setBounds(350, 205, 70, 15);
		add(lbprecoProduto);
		
		txprecoProduto = new JTextField();
		txprecoProduto.setBounds(420, 200, 200, 30);
		add(txprecoProduto);
		
		lbqtProduto = new JLabel();
		lbqtProduto.setText("qt Produto: ");
		lbqtProduto.setBounds(350, 250, 200, 30);
		add(lbqtProduto);;
		
		txqtProduto = new JTextField();
		txqtProduto.setBounds(420, 255, 200, 30);
		add(txqtProduto);
		
		lbidCategoria = new JLabel();
		lbidCategoria.setText("id Categoria ");
		lbidCategoria.setBounds(350, 305, 200, 30);
		add(lbidCategoria);
		
		txidCategoria = new JTextField();
		txidCategoria.setBounds(420, 300, 200, 30);
		add(txidCategoria);
		
		
		
		btalterarProduto = new JButton();
		btalterarProduto.setText("Alterar");
		btalterarProduto.setBounds(420, 350, 100, 35);
		
		btalterarProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ModelarProduto Produto = new ModelarProduto();
				Produto.setIdProduto(Integer.parseInt(txidProduto.getText()));
				Produto.setNomeProduto(txnomeProduto.getText());
				Produto.setValorProduto(Double.parseDouble(txprecoProduto.getText()));
				Produto.setQuantidadeProduto(Integer.parseInt(txqtProduto.getText()));
				Produto.setIdCategoria(Integer.parseInt(txidCategoria.getText()));
				
			}
		});
		add(btalterarProduto);
	}
	
}
