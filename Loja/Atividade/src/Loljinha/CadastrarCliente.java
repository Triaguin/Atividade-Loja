package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import DAOLojinha.CategoriaDAO;
import DAOLojinha.ClienteDAO;
import DAOLojinha.TelefoneDAO;
import ModelLojinha.ModelarCliente;
import ModelLojinha.ModelarTelefone;

public class CadastrarCliente extends JFrame {

	private JLabel lbNomeCliente;
	private JTextField txNomeCliente;

	private JLabel lbDataNascCliente;
	private JTextField txDiaNascCliente;
	private JTextField txMesNascCliente;
	private JTextField txAnoNascCliente;

	private JLabel lbCpfCliente;
	private JTextField txCpfCliente;

	private JLabel lbSexoCliente;
	private ButtonGroup btgSexoCliente; // Grupo para os RadioButtons
	private JRadioButton rdHomem; // RadioButtons
	private JRadioButton rdMulher;
	private JRadioButton rdOutro;

	private JLabel lbEnderecoCliente;
	private JLabel lbLogrCliente;
	private JTextField txLogrCliente;
	private JLabel lbNumLogrCliente;
	private JTextField txNumLogrCliente;
	private JLabel lbBairroCliente;
	private JTextField txBairroCliente;
	private JLabel lbCidadeCliente;
	private JTextField txCidadeCliente;

	private JButton btTelefoneCliente;
	private JButton btCadastrarCliente;

	ModelarCliente cliente = new ModelarCliente();
	ClienteDAO salvarCliente = new ClienteDAO();
	ModelarTelefone telefone = new ModelarTelefone();
	TelefoneDAO salvarTelefone = new TelefoneDAO();
	
	public CadastrarCliente() {

		setTitle("Cadastrar Cliente");
		setSize(900, 800);
		this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// Nome
		lbNomeCliente = new JLabel();
		lbNomeCliente.setText("Nome: ");
		lbNomeCliente.setBounds(300, 100, 300, 15);
		add(lbNomeCliente);

		txNomeCliente = new JTextField();
		txNomeCliente.setBounds(300, 115, 300, 35);
		add(txNomeCliente);

		// Data Nascimento
		lbDataNascCliente = new JLabel();
		lbDataNascCliente.setText("Data de Nascimento: (DD MM AAAA)");
		lbDataNascCliente.setBounds(300, 165, 300, 15);
		add(lbDataNascCliente);

		txDiaNascCliente = new JTextField();
		txDiaNascCliente.setBounds(300, 180, 40, 35);
		add(txDiaNascCliente);

		txMesNascCliente = new JTextField();
		txMesNascCliente.setBounds(350, 180, 40, 35);
		add(txMesNascCliente);

		txAnoNascCliente = new JTextField();
		txAnoNascCliente.setBounds(400, 180, 60, 35);
		add(txAnoNascCliente);

		// Cpf
		lbCpfCliente = new JLabel();
		lbCpfCliente.setText("Cpf: ");
		lbCpfCliente.setBounds(300, 230, 300, 15);
		add(lbCpfCliente);

		txCpfCliente = new JTextField();
		txCpfCliente.setBounds(300, 245, 300, 35);
		add(txCpfCliente);

		// Sexo
		lbSexoCliente = new JLabel();
		lbSexoCliente.setText("Sexo: ");
		lbSexoCliente.setBounds(300, 295, 300, 15);
		add(lbSexoCliente);

		btgSexoCliente = new ButtonGroup(); // Cria o grupo dos RadiButtons

		rdHomem = new JRadioButton(); // RadioButton
		rdHomem.setText("Homem");
		rdHomem.setBounds(300, 320, 80, 15);
		add(rdHomem);
		btgSexoCliente.add(rdHomem);

		rdMulher = new JRadioButton(); // RadioButton
		rdMulher.setText("Mulher");
		rdMulher.setBounds(380, 320, 80, 15);
		add(rdMulher);
		btgSexoCliente.add(rdMulher);

		rdOutro = new JRadioButton(); // RadioButton
		rdOutro.setText("Outro");
		rdOutro.setBounds(460, 320, 80, 15);
		add(rdOutro);
		btgSexoCliente.add(rdOutro);

		// Endereco
		lbEnderecoCliente = new JLabel();
		lbEnderecoCliente.setText("Endereco: ");
		lbEnderecoCliente.setBounds(400, 350, 100, 15);
		add(lbEnderecoCliente);

		lbLogrCliente = new JLabel();
		lbLogrCliente.setText("Logradouro: ");
		lbLogrCliente.setBounds(300, 375, 300, 15);
		add(lbLogrCliente);

		txLogrCliente = new JTextField();
		txLogrCliente.setBounds(300, 390, 300, 35);
		add(txLogrCliente);

		lbNumLogrCliente = new JLabel();
		lbNumLogrCliente.setText("Numero do Logradouro: ");
		lbNumLogrCliente.setBounds(300, 440, 300, 15);
		add(lbNumLogrCliente);

		txNumLogrCliente = new JTextField();
		txNumLogrCliente.setBounds(300, 455, 300, 35);
		add(txNumLogrCliente);

		lbBairroCliente = new JLabel();
		lbBairroCliente.setText("Bairro: ");
		lbBairroCliente.setBounds(300, 505, 300, 15);
		add(lbBairroCliente);

		txBairroCliente = new JTextField();
		txBairroCliente.setBounds(300, 520, 300, 35);
		add(txBairroCliente);

		lbCidadeCliente = new JLabel();
		lbCidadeCliente.setText("Cidade: ");
		lbCidadeCliente.setBounds(300, 570, 300, 15);
		add(lbCidadeCliente);

		txCidadeCliente = new JTextField();
		txCidadeCliente.setBounds(300, 585, 300, 35);
		add(txCidadeCliente);
		
		//Botao AdcionarTelefone
		btTelefoneCliente = new JButton();
		btTelefoneCliente.setText("Adicionar um Telefone");
		btTelefoneCliente.setBounds(350, 635, 200 , 35);
		add(btTelefoneCliente);
		
		btTelefoneCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				CadastrarTelefone novoTelefone = new CadastrarTelefone();
				novoTelefone.setVisible(true);
			}
		});
		
		// Botao Cadastrar
		btCadastrarCliente = new JButton();
		btCadastrarCliente.setText("Cadastrar");
		btCadastrarCliente.setBounds(400, 690, 100, 35);

		btCadastrarCliente.addActionListener(new ActionListener() {
			
			//Atribuindo os valores
			public void actionPerformed(ActionEvent e) {

				try { // Tenta fazer o codigo (se der erro ele manda pro catch)

					String nome = txNomeCliente.getText(); //Le o nome
					cliente.setNomeCliente(nome);
					
					if (nome.equals("")) { //Se o nome nao foi colocado nao cadastra o cliente
						
						JOptionPane.showMessageDialog(null, "Insira um Nome");
						return;
						
					}else {
						cliente.setNomeCliente(nome); // Atribuindo valor
						System.out.println(cliente.getNomeCliente());
					}

					int diaNasc = Integer.parseInt(txDiaNascCliente.getText()); //Le o dia, mes e ano de nascimento
					int mesNasc = Integer.parseInt(txMesNascCliente.getText());
					int anoNasc = Integer.parseInt(txAnoNascCliente.getText());
					
					LocalDate datanasc = LocalDate.of(anoNasc, mesNasc , diaNasc); // Une o dia com o mes, o mes com o ano
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mmm/yyyy"); // Converte a data
					
					cliente.setDatanascCliente(datanasc.format(dtf)); 
					System.out.println(cliente.getDatanascCliente());

					String cpf = txCpfCliente.getText(); //Le o CPF
					
					
					if (cpf.equals("")) { //Se o CPF nao foi colocado nao cadastra o cliente
						
						JOptionPane.showMessageDialog(null, "Insira um CPF");
						return;
						
					}else {
						cliente.setCpfCliente(cpf);
						System.out.println(cliente.getCpfCliente());
					}

					String sexo;

					if (rdHomem.isSelected()) {  //Ve qual o sexo do cliente

						sexo = "Nasculino";
						
						cliente.setSexoCliente(sexo);
						System.out.println(cliente.getSexoCliente());

					} else if (rdMulher.isSelected()) {

						sexo = "Feminino";
						
						cliente.setSexoCliente(sexo);
						System.out.println(cliente.getSexoCliente());
						
					} else if (rdOutro.isSelected()) {
						sexo = "Outro";
						
						cliente.setSexoCliente(sexo);
						System.out.println(cliente.getSexoCliente());
						
					} else { // Se o sexo nao foi colocado nao cadastra o cliente
						
						JOptionPane.showMessageDialog(null, "Insira um Sexo");
						return;
					}

					String logradouro = txLogrCliente.getText(); // Le o logradouro, o numero do logradoro, o bairro e a cidade
					int numLogr = Integer.parseInt(txNumLogrCliente.getText());
					String bairro = txBairroCliente.getText();
					String cidade = txCidadeCliente.getText();
					
					if (logradouro.equals("")) { // Se o logradouro nao foi colocado nao cadastra o cliente

						JOptionPane.showMessageDialog(null, "Insira um Logradouro");
						return;

					}else {
						cliente.setLogradouroCliente(logradouro);
						System.out.println(cliente.getLogradouroCliente());
					}
					if (bairro.equals("")) { //Se o bairro nao foi colocado nao cadastra o cliente

						JOptionPane.showMessageDialog(null, "Insira um Bairro");
						return;

					}else {
						cliente.setNumLogradouroCliente(numLogr);
						System.out.println(cliente.getNumLogradouroCliente());
					}
					if (cidade.equals("")) { // Se a cidade nao foi colocado nao cadastra o cliente

						JOptionPane.showMessageDialog(null, "Insira um Cidade");
						return;

					}else {
						cliente.setNomeCliente(cidade);
						System.out.println(cliente.getCidadeCliente());
					}
					
					salvarCliente.adicionarCategoria(cliente);
					salvarTelefone.adicionarTelefone(telefone, cliente);
					
					JOptionPane.showMessageDialog(null,
							cadastrarCliente(nome, diaNasc, mesNasc, anoNasc, cpf, sexo, logradouro, numLogr, bairro,
									cidade) ? "Cliente " + nome + " Cadastrada Com Sucesso"
											: "Cliente " + nome + " Nao Cadastrada Com Sucesso"); // cadastra o cliente e mostra o resultado

				} catch (Exception execao) { // Se deu erro fala que deu erro (sem estoura o programa)
					JOptionPane.showMessageDialog(null, "Erro no Cadastro do Cliente");
				}
			}
		});

		add(btCadastrarCliente);
	}

	public boolean cadastrarCliente(String nome, int diaNasc, int mesNasc, int AnoNasc, String cpf, String sexo,
			String logradouro, int numLogr, String bairro, String cidade) {  // Supostamente cadastra o cliente mas nao faz nada ainda
		return true;
	}

}