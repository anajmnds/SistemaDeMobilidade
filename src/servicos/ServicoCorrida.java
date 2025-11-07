package servicos;

import java.util.ArrayList;
import java.util.List;
import entidades.Motorista;
import entidades.Passageiro;
import entidades.Corrida;
import entidades.MetodoPagamento;
import entidades.Categoria;
import excecoes.NenhumMotoristaDisponivelException;


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
	
	public void cadrastarPassageiro (Passageiro passageiro) {
		this.passageiros.add(passageiro);
	}
	
	public Corrida solicitarCorrida(Passageiro passageiro, String localPartida, String localDestino, Categoria categoria, MetodoPagamento metodoPagamento, double distanciaKm ) throws NenhumMotoristaDisponivelException {
		
		Motorista motoristaLivre = this.encontrarMotoristaDisponivel();
		
		if(motoristaLivre == null) {
			throw new NenhumMotoristaDisponivelException ("Não tem motorista disponível agora, tente mais tarde.");
		}
		Corrida novaCorrida = new Corrida(passageiro, localPartida, localDestino, categoria, metodoPagamento, distanciaKm);
		
		novaCorrida.setMotorista(motoristaLivre);
		motoristaLivre.setStatus("Em corrida");
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
}
