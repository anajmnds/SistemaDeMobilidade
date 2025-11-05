package entidades;

public class CartaoCredito implements MetodoPagamento {
	@Override
	public void processarPagamento(double valor) {
		
		System.out.println("Pagamento com cartão de R$ " + valor + " foi aceito");
	}

}
