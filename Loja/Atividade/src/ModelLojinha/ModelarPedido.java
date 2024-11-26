package ModelLojinha;

public class ModelarPedido {
	
	private int idPedido;
	private int contador ;
	private String dataPedido;
	private String statusPedido;
	private Double valorPedido;
	
	public Double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		contador = 1;
		this.contador = contador;
	}
	
	
}
