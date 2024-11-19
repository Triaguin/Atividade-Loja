package ModelLojinha;

import java.util.Calendar;

public class ModelarCliente {
	
	private int idCliente;
	private String nomeCliente;
	private Calendar datanasc;
	private String cpfCliente;
	private int sexoCliente;
	private String logradouroCliente;
	private int numLogradouroCliente;
	private String bairroCliente;
	private String cidadeCliente;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Calendar getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Calendar datanascCliente) {
		this.datanasc = datanascCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public int getSexoCliente() {
		return sexoCliente;
	}
	public void setSexoCliente(int sexoCliente) {
		this.sexoCliente = sexoCliente;
	}
	public String getLogradouroCliente() {
		return logradouroCliente;
	}
	public void setLogradouroCliente(String logradouroCliente) {
		this.logradouroCliente = logradouroCliente;
	}
	public int getNumLogradouroCliente() {
		return numLogradouroCliente;
	}
	public void setNumLogradouroCliente(int numLogradouroCliente) {
		this.numLogradouroCliente = numLogradouroCliente;
	}
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	
	
}