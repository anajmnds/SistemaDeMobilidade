package entidades;
import excecoes.PagamentoRecusadoException;

public class CartaoCredito implements MetodoPagamento {
	@Override
	public void processarPagamento(double valor) throws PagamentoRecusadoException {
		
		if (valor > 1000.0) {
			throw new PagamentoRecusadoException("Pagamento recusado pelo cartão (valor muito alto)");
		}
		
		System.out.println("Pagamento com cartão de R$ " + valor + " foi aceito");
	}

}
