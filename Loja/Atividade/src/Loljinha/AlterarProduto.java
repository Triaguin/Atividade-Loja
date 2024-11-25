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
	private JTextField txidProduto;
	private JTextField txnomeProduto;
	private JTextField txprecoProduto;
	private JTextField txqtProduto;
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
		lbnomeProduto.setText("Produto: ");
		lbnomeProduto.setBounds(350, 155, 70, 15);
		add(lbnomeProduto);
		
		txnomeProduto = new JTextField();
		txnomeProduto.setBounds(420, 150, 200, 30);
		add(txnomeProduto);
		
		lbprecoProduto = new JLabel();
		lbprecoProduto.setText("idProduto: ");
		lbprecoProduto.setBounds(350, 205, 70, 15);
		add(lbprecoProduto);
		
		txprecoProduto = new JTextField();
		txprecoProduto.setBounds(420, 200, 200, 30);
		add(txprecoProduto);
		
		lbqtProduto = new JLabel();
		lbqtProduto.setBounds(420, 255, 200, 30);
		add(lbqtProduto);;
		
		btalterarProduto = new JButton();
		btalterarProduto.setText("Alterar");
		btalterarProduto.setBounds(420, 300, 100, 35);
		
//		btalterarProduto.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				
//				try {
//					ModelarProduto Produto = new ModelarProduto();
//					Produto.setIdCategoria(Integer.parseInt(txidProduto.getText()));
//					Produto.setNomeProduto(txnomeProduto.getText());
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
		add(btalterarProduto);
	}
	
}
