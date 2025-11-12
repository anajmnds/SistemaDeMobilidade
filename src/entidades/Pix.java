package entidades;
import excecoes.SaldoInsuficienteException;
import excecoes.PagamentoRecusadoException;

public class Pix implements MetodoPagamento {

	@Override
	public void processarPagamento(double valor) throws PagamentoRecusadoException, SaldoInsuficienteException{

		System.out.println("Pagamento com pix de R$ " + valor + " foi aceito.");
	}

}
