package entidades;
import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario {
	
	private List<MetodoPagamento> metodosDePagamento;

	public Passageiro (String nome, String cpf, String email, String telefone, String senha) {
		
		super ( nome, cpf, email, telefone, senha);
		
		this.metodosDePagamento = new ArrayList<>();
	}
	
	public void adicionarMetodoDePagamento (MetodoPagamento metodo) {
		
		this.metodosDePagamento.add(metodo);
	}
	
}
