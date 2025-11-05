package entidades;

public class Pix implements MetodoPagamento {

	@Override
	public void processarPagamento(double valor) {

		System.out.println("Pagamento com pix de R$ " + valor + " foi aceito.");
	}

}
