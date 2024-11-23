package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

import ModelLojinha.ModelarCategoria;
import DAOLojinha.CategoriaDAO;

public class AlterarCategoria extends JFrame {

	private JLabel lbId;
	private JLabel lbNome;
	private JTextField txId;
	private JTextField txCategoria;
	private JButton btCadastrarCategoria;
	
	public AlterarCategoria() {

		setTitle("Alterar Categoria");
		setSize(900, 600);
	    this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		lbId = new JLabel();
		lbId.setText("Id: ");
		lbId.setBounds(350, 200, 70, 15);
		add(lbId);

		txId = new JTextField();
		txId.setBounds(350, 220, 200, 35);
		add(txId);
		
		lbNome = new JLabel();
		lbNome.setText("Nome: ");
		lbNome.setBounds(350, 260, 70, 15);
		add(lbNome);
		
		txCategoria = new JTextField();
		txCategoria.setBounds(350, 280, 200, 35);
		add(txCategoria);

		btCadastrarCategoria = new JButton();
		btCadastrarCategoria.setText("Cadastrar");
		btCadastrarCategoria.setBounds(400, 325, 100, 35);

		btCadastrarCategoria.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
					ModelarCategoria categoria = new ModelarCategoria();
					categoria.setIdCategoria(Integer.parseInt(txId.getText()));
					categoria.setNomeCategoria(txCategoria.getText());
					new CategoriaDAO().alterarCategoria(categoria);
					JOptionPane.showMessageDialog(null, true ? "Categoria: " + categoria.getNomeCategoria() + " Alterada Com Sucesso" : "Categoria " + categoria.getNomeCategoria() + " Nao Alterada Com Sucesso");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		add(btCadastrarCategoria);
	}

	public boolean cadastrarCategoria(String categoria) {
		return true;
	}
}