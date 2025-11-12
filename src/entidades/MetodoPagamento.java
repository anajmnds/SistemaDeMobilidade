package entidades;
import excecoes.PagamentoRecusadoException;
import excecoes.SaldoInsuficienteException;

public interface MetodoPagamento {

	
	public void processarPagamento (double valor) throws PagamentoRecusadoException, SaldoInsuficienteException;
}
