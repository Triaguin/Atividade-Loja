package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

public class AlterarProduto extends JFrame {
	
	private JLabel lbidProduto;
	private JLabel lbnomeProduto;
	private JLabel lbprecoProduto;
	private JLabel lbqtProduto;
	private JTextField txidProduto;
	private JTextField txnomeProduto;
	private JTextField txprecoProduto;
	private JTextField txqtProduto;
	
	public AlterarProduto() {
		setTitle("Alterar Categoria");
		setSize(900, 600);
	    this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
	}
	
}
