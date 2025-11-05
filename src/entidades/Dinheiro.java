package entidades;

public class Dinheiro implements MetodoPagamento {

	@Override
	public void processarPagamento(double valor) {

		System.out.println("Pagamento em dinheiro de R$ " + valor + " foi aceito.");
	}

}
