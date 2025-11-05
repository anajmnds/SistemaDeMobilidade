package entidades;

public class Motorista extends Usuario {
	
	private String cnh;
	private String status;
	private Veiculo veiculo; 
	
	public Motorista (String nome, String cpf, String email, String telefone, String senha,  String cnh, String status, Veiculo veiculo) {
		super ( nome, cpf, email, telefone, senha);
		
		this.cnh = cnh;
		this.status = status;
		this.veiculo = veiculo;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
