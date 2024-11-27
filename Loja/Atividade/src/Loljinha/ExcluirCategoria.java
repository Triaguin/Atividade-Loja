package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

import ModelLojinha.ModelarCategoria;
import DAOLojinha.CategoriaDAO;

public class ExcluirCategoria extends JFrame {

	private JLabel lbCategoria;
	private JTextField txCategoria;
	private JButton btExcluirCategoria;

	ModelarCategoria categoria = new ModelarCategoria();
	CategoriaDAO excluirCategoria = new CategoriaDAO();
	
	public ExcluirCategoria() {

		setTitle("Excluir Categoria");
		setSize(900, 600);
	    this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		lbCategoria = new JLabel();
		lbCategoria.setText("Categoria: ");
		lbCategoria.setBounds(415, 220, 70, 15);
		add(lbCategoria);

		txCategoria = new JTextField();
		txCategoria.setBounds(350, 260, 200, 35);
		add(txCategoria);

		btExcluirCategoria = new JButton();
		btExcluirCategoria.setText("Excluir");
		btExcluirCategoria.setBounds(400, 325, 100, 35);

		btExcluirCategoria.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				try {
					int idcategoria = Integer.parseInt(txCategoria.getText());
					categoria.setIdCategoria(idcategoria);
					excluirCategoria.excluirCategoria(categoria);
					JOptionPane.showMessageDialog(null, "Categoria Excluida com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo deu errado");
				}
				
				
			}
		});

		add(btExcluirCategoria);
	}

	public boolean cadastrarCategoria(String categoria) {
		return true;
	}
}