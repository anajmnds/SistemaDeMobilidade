package entidades;

public class CategoriaComum implements Categoria {

	@Override
	public double calcularPreco(double distanciaKm) {

		return 5.00 + (1.00 * distanciaKm);
	}

}
