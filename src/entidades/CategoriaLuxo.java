package entidades;

public class CategoriaLuxo implements Categoria {

	@Override
	public double calcularPreco(double distanciaKm) {

		return 9.00 + (2.20 * distanciaKm);
	}

}
