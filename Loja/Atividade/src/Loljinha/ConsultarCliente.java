package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import ModelLojinha.ModelarCliente;
import DAOLojinha.ClienteDAO;

public class ConsultarCliente extends JFrame {

	private JScrollPane scrollTabela;
	private JTable tabelaCategoria;
	private String[] atributos;
	Object[][] dados;

	ModelarCliente categoria = new ModelarCliente();
	ClienteDAO salvarCategoria = new ClienteDAO();
	
	public ConsultarCliente() throws SQLException {

		setTitle("Consultar Cliente");
		setSize(900, 600);
	    this.setResizable(false);
		setLocationRelativeTo(null);

		atributos = new String[] {"Nome", "Data Nascimento", "CPF", "Sexo", "Logradouro", "Número de Logradouro", "Bairro", "Cidade"};
		dados = listaParaMatriz();
		tabelaCategoria = new JTable(dados, atributos);
		scrollTabela = new JScrollPane(tabelaCategoria);
		this.add(scrollTabela);
		
	}

	public Object[][] listaParaMatriz() throws SQLException {
		
		List<ModelarCliente> lista =  new ClienteDAO().getLista();
		
		Object[][] matriz = new Object[lista.size()][8];
		for (int i = 0; i < lista.size(); i++) {
			matriz[i][0] = lista.get(i).getNomeCliente();
			matriz[i][1] = lista.get(i).getDatanasc().DATE + "/" + lista.get(i).getDatanasc().MONTH + "/" + lista.get(i).getDatanasc().YEAR;
			System.out.println(lista.get(i).getDatanasc().DATE + "/" + lista.get(i).getDatanasc().MONTH + "/" + lista.get(i).getDatanasc().YEAR);
			matriz[i][2] = lista.get(i).getCpfCliente();
			matriz[i][3] = lista.get(i).getSexoCliente();
			matriz[i][4] = lista.get(i).getLogradouroCliente();
			matriz[i][5] = lista.get(i).getNumLogradouroCliente();
			matriz[i][6] = lista.get(i).getBairroCliente();
			matriz[i][7] = lista.get(i).getCidadeCliente();
		}
		
		return matriz;
	}
}