package servicos;

import java.util.ArrayList;
import java.util.List;
import entidades.Motorista;
import entidades.Passageiro;
import entidades.Corrida;
import entidades.MetodoPagamento;
import entidades.Categoria;
import excecoes.NenhumMotoristaDisponivelException;
import excecoes.PagamentoRecusadoException;
import excecoes.SaldoInsuficienteException;
import excecoes.EstadoInvalidoDaCorridaException;

public class ServicoCorrida {
	
	private List<Motorista> motoristas;
	private List<Passageiro> passageiros;
	private List<Corrida> corridas;
	
	public ServicoCorrida () {
		
		this.motoristas = new ArrayList<>();
		this.passageiros = new ArrayList<>();
		this.corridas = new ArrayList<>();
	}
	
	public void cadastrarMotorista(Motorista motorista) {
		this.motoristas.add(motorista);
		
	}
	
	public void cadastrarPassageiro (Passageiro passageiro) {
		this.passageiros.add(passageiro);
	}
	
	public Corrida solicitarCorrida(Passageiro passageiro, String localPartida, String localDestino, Categoria categoria, MetodoPagamento metodoPagamento, double distanciaKm )
			throws NenhumMotoristaDisponivelException {
		
		Motorista motoristaLivre = this.encontrarMotoristaDisponivel();
		
		if(motoristaLivre == null) {
			throw new NenhumMotoristaDisponivelException ("Não tem motorista disponível agora, tente mais tarde.");
		}
		
		Corrida novaCorrida = new Corrida(passageiro, localPartida, localDestino, categoria, metodoPagamento, distanciaKm);
		
		novaCorrida.setMotorista(motoristaLivre);
		novaCorrida.setStatus("Aceita");
		motoristaLivre.setStatus("Online");
		this.corridas.add(novaCorrida);
		
		return novaCorrida;
		
	}
	
	private Motorista encontrarMotoristaDisponivel() {
		
		for (Motorista motorista : this.motoristas) {
			if(motorista.getStatus().equals("Online")) {
				return motorista;
			}
		}
		return null;
	}
	
	
	public void iniciarCorrida(Corrida corrida) throws EstadoInvalidoDaCorridaException {
        if (!corrida.getStatus().equals("Aceita")) {
            throw new EstadoInvalidoDaCorridaException("A corrida só pode ser iniciada se for aceita.");
        }

        corrida.setStatus("Em Andamento");
        System.out.println("Corrida iniciada.");
    }

    public void finalizarViagem(Corrida corrida)
            throws PagamentoRecusadoException, SaldoInsuficienteException, EstadoInvalidoDaCorridaException {

        if (!corrida.getStatus().equals("Em Andamento")) {
            throw new EstadoInvalidoDaCorridaException(
                    "Só é possível finalizar uma corrida que está em andamento.");
        }

        MetodoPagamento metodo = corrida.getMetodoPagamento();
        double valor = corrida.getValorEstimado();

        metodo.processarPagamento(valor);

        corrida.setStatus("Finalizada");
        Motorista motorista = corrida.getMotorista();
        motorista.setStatus("Online");

        System.out.println("Corrida finalizada. Pagamento de R$ " + valor + " efetuado.");
    }

    public void cancelarCorrida(Corrida corrida) throws EstadoInvalidoDaCorridaException {

        if (corrida.getStatus().equals("Em Andamento") || corrida.getStatus().equals("Finalizada")) {
            throw new EstadoInvalidoDaCorridaException(
                    "Não é possível cancelar uma corrida que já está em andamento ou finalizada.");
        }

        corrida.setStatus("Cancelada");

        if (corrida.getMotorista() != null) {
            corrida.getMotorista().setStatus("Online");
        }

        System.out.println("Corrida cancelada.");
    }
}