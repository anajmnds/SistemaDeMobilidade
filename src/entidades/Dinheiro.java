package entidades;
import excecoes.SaldoInsuficienteException;

public class Dinheiro implements MetodoPagamento {

	@Override
	public void processarPagamento(double valor) throws SaldoInsuficienteException {

		int saldoDoUsuario = 50;
		
		if(valor > saldoDoUsuario) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		System.out.println("Pagamento em dinheiro de R$ " + valor + " foi aceito.");
	}

}
