package Loljinha;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

import DAOLojinha.CategoriaDAO;
import ModelLojinha.ModelarCategoria;

public class Menu extends JFrame {

	public Menu() { // Criando o menu

		try {

			// Cria as coisas basicas da Aplicacao
			this.setTitle("Aplicacao");
			this.setSize(960, 540);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setExtendedState(MAXIMIZED_BOTH); // Maxima a janela

			// Cria a Barra de Menu
			JMenuBar barra = new JMenuBar();
			setJMenuBar(barra);

			// Cria o menu Arquivo
			JMenu arquivo = new JMenu("Arquivo");
			barra.add(arquivo);

			// Cria a opcao de novo arquivo
			JMenuItem novo = new JMenuItem("Novo");
			// Cria uma nova Janela
			novo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Menu();
				}
			});

			arquivo.add(novo);

			// Cria o item Salvar
			JMenuItem salvar = new JMenuItem("Salvar");
			// Cria um arquivo
			salvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Insirir aqui a funcao criar arquivo
				}
			});

			arquivo.add(salvar);

			// Cria o item Salvar Como
			JMenuItem salvarComo = new JMenuItem("Salvar Como");

			arquivo.add(salvarComo);

			// Cria o Item Carregar
			JMenuItem carregar = new JMenuItem("Carregar");
			carregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});

			arquivo.add(carregar);

			// Cria o item Sair
			JMenuItem sair = new JMenuItem("Sair");
			sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					System.exit(0);
				}
			});
			arquivo.add(sair);

			// Cria o menu cadastrar
			JMenu cadastrar = new JMenu("Cadastrar");
			barra.add(cadastrar);

			// Cria o item categoria
			JMenuItem categoria = new JMenuItem("Categoria");
			categoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					CadastrarCategoria categoria = new CadastrarCategoria();
					categoria.setVisible(true);
				}
			});

			cadastrar.add(categoria);

			// Cria o item Produto
			JMenuItem produto = new JMenuItem("Produto");
			produto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					CadastrarProduto produto;
					try {
						produto = new CadastrarProduto();
					} catch (SQLException e) {
						throw new RuntimeException();
					}
					produto.setVisible(true);
				}
			});
			cadastrar.add(produto);

			// Cria o item cliente
			JMenuItem cliente = new JMenuItem("Cliente");
			cliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					CadastrarCliente cliente = new CadastrarCliente();
					cliente.setVisible(true);
				}
			});

			cadastrar.add(cliente);

			// Cria o item pedidos
			JMenuItem pedido = new JMenuItem("Pedido");
			pedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					CadastrarPedido pedido = new CadastrarPedido();
					pedido.setVisible(true);
				}
			});

			cadastrar.add(pedido);
			
			JMenuItem telefone = new JMenuItem("Telefone");
			telefone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					CadastrarTelefone novoTelefone = new CadastrarTelefone();
					novoTelefone.setVisible(true);
				}
				});
			
			cadastrar.add(telefone);

			// Cria o menu Consultar
			JMenu consultar = new JMenu("Consultar");
			barra.add(consultar);

			// Cria o item categoria
			JMenuItem consultarCategoria = new JMenuItem("Categoria");
			consultarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					ConsultarCategoria consultarCategoria;
					try {
						consultarCategoria = new ConsultarCategoria();
					} catch (SQLException e) {
						throw new RuntimeException();
					}
					consultarCategoria.setVisible(true);
				}
			});

			consultar.add(consultarCategoria);

			// Cria o item Produto
			JMenuItem consultarProduto = new JMenuItem("Produto");
			consultarProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					ConsultarProduto consultarProduto;
					try {
						consultarProduto = new ConsultarProduto();
					} catch (SQLException e) {
						throw new RuntimeException();
					}
					consultarProduto.setVisible(true);
				}
			});
			consultar.add(consultarProduto);

			// Cria o item cliente
			JMenuItem consultarCliente = new JMenuItem("Cliente");
			consultarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					ConsultarCliente consultarCliente;
					try {
						consultarCliente = new ConsultarCliente();
					} catch (SQLException e) {
						throw new RuntimeException();
					}
					 consultarCliente.setVisible(true);
				}
			});
			consultar.add(consultarCliente);

			// Cria o item pedidos
			JMenuItem consultarPedido = new JMenuItem("Pedido");
			consultarPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					// ConsultarPedido consultarPedido = new ConsultarPedido();
					// consultarPedido.setVisible(true);
				}
			});
			consultar.add(consultarPedido);

			// Cria o menu Alterar
			JMenu alterar = new JMenu("Alterar");
			barra.add(alterar);

			// Cria o item categoria
			JMenuItem alterarCategoria = new JMenuItem("Categoria");
			alterarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					
					AlterarCategoria alterarCategoria = new AlterarCategoria();
					alterarCategoria.setVisible(true);
				}
			});

			alterar.add(alterarCategoria);

			// Cria o item Produto
			JMenuItem alterarProduto = new JMenuItem("Produto");
			alterarProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
//					AlterarProduto alterarProduto;
//					try {
//						 alterarProduto = new AlterarProduto();
//					} catch (SQLException e) {
//						throw new RuntimeException();
//					}
//					alterarProduto.setVisible(true);
				}
			});
			alterar.add(alterarProduto);

			// Cria o item cliente
			JMenuItem alterarCliente = new JMenuItem("Cliente");
			alterarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					// AlterarCliente alterarCliente = new AlterarCliente();
					// alterarCliente.setVisible(true);
				}
			});
			alterar.add(alterarCliente);

			// Cria o item pedidos
			JMenuItem alterarPedido = new JMenuItem("Pedido");
			alterarPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					// AlterarPedido alterarPedido = new AlterarPedido();
					// alterarPedido.setVisible(true);
				}
			});
			alterar.add(alterarPedido);

			// Cria o menu Excluir
			JMenu excluir = new JMenu("Excluir");
			barra.add(excluir);

			// Cria o item categoria
			JMenuItem excluirCategoria = new JMenuItem("Categoria");
			excluirCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					ExcluirCategoria excluirCategoria = new ExcluirCategoria();
					excluirCategoria.setVisible(true);
				}
			});

			excluir.add(excluirCategoria);

			// Cria o item Produto
			JMenuItem excluirProduto = new JMenuItem("Produto");
			excluirProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
//					ExcluirProduto excluirProduto;
//					try {
//						 excluirProduto = new ExcluirProduto();
//					} catch (SQLException e) {
//						throw new RuntimeException();
//					}
//					excluirProduto.setVisible(true);
				}
			});
			excluir.add(excluirProduto);

			// Cria o item cliente
			JMenuItem excluirCliente = new JMenuItem("Cliente");
			excluirCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					// ExcluirCliente excluirCliente = new ExcluirCliente();
					// excluirCliente.setVisible(true);
				}
			});
			excluir.add(excluirCliente);

			// Cria o item pedidos
			JMenuItem excluirPedido = new JMenuItem("Pedido");
			excluirPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					// ExcluirPedido excluirPedido = new ExcluirPedido();
					// excluirPedido.setVisible(true);
				}
			});
			excluir.add(excluirPedido);

			
			
			// Cria o menu ajuda
			JMenu ajuda = new JMenu("Ajuda");
			barra.add(ajuda);

			// Cria o item Sobre
			JMenuItem sobre = new JMenuItem("Sobre");
			sobre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					TelaSobre sobre = new TelaSobre();
					sobre.setVisible(true);
				}
			});

			ajuda.add(sobre);

			this.setVisible(true);

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}