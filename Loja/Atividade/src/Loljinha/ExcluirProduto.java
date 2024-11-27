package Loljinha;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

import DAOLojinha.ProdutoDAO;
import ModelLojinha.ModelarProduto;

public class ExcluirProduto extends JFrame {
	ModelarProduto produto = new ModelarProduto();
	ProdutoDAO ExcluirProduto = new ProdutoDAO();
	
	private JLabel lbProduto;
	private JTextField txProduto;
	private JButton btExcluirProduto;
	
	public ExcluirProduto() throws SQLException {

		this.setTitle("Excluir Produto");
		this.setSize(900, 600);
		this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// Nome
		lbProduto = new JLabel();
		lbProduto.setText("Nome: ");
		lbProduto.setBounds(300, 150, 300, 15);
		add(lbProduto);

		txProduto = new JTextField();
		txProduto.setBounds(300, 165, 300, 35);
		add(txProduto);
		
		btExcluirProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				try {
					int idproduto = Integer.parseInt(txProduto.getText());
					produto.setIdProduto(idproduto);
					ExcluirProduto.excluirProduto(produto);
					JOptionPane.showMessageDialog(null, "Produto Excluida com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo deu errado");
				}
				
				
			}
		});
		
		
	}
}
