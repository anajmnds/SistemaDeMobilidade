package entidades;

public class Corrida {
	
	private String localPartida;
	private String localDestino;
	private double valorEstimado;
	private String status;
	
	private Motorista motorista;
	private Passageiro passageiro;
	private MetodoPagamento metodoPagamento;
	private Categoria categoria;
	
	public Corrida (Passageiro passageiro, String localPartida, String localDestino, Categoria categoria, MetodoPagamento metodoPagamento, double distanciaKm) {
		
		this.passageiro = passageiro;
		this.localPartida = localPartida;
		this.localDestino = localDestino;
		this.categoria = categoria;
		this.metodoPagamento = metodoPagamento;
		this.status = "Solicitada";
		this.motorista = null;
		this.valorEstimado = this.categoria.calcularPreco(distanciaKm);
		
	}

	public String getLocalPartida() {
		return localPartida;
	}

	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}

	public String getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}

	public double getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(double valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
