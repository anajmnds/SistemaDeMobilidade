package teste;
import entidades.Motorista;
import entidades.Passageiro;
import entidades.Veiculo;

import entidades.MetodoPagamento;
import entidades.CartaoCredito;
import entidades.Corrida;
import entidades.Pix;
import entidades.Dinheiro;
import entidades.Categoria;
import entidades.CategoriaComum;

import servicos.ServicoCorrida;

import excecoes.EstadoInvalidoDaCorridaException;
import excecoes.NenhumMotoristaDisponivelException;
import excecoes.PagamentoRecusadoException;
import excecoes.SaldoInsuficienteException;


public class Main {

	public static void main(String[] args) {
	 
		ServicoCorrida servico = new ServicoCorrida();
		
		System.out.println("Sistema iniciado.");
		
		Veiculo veiculo1 = new Veiculo ("PBX-0426", "Volkswagen T-Cross", "Branco", 2020);
		
		Motorista motorista1 = new Motorista(
				"Arthur Laranja",
				"123.456.789-10",
				"arthur@gmail.com",
				"1234-6789",
				"senhaArthur",
				"987654321",
				"Online",
				veiculo1 );
		
		Passageiro passageiro1 = new Passageiro(
				"Ana Jullia Lopes",
				"987.654.321-00",
				"ana@gmail.com",
				"5555-6666",
				"senha123");
		
		servico.cadastrarMotorista(motorista1);
		servico.cadastrarPassageiro(passageiro1);
				
		System.out.println("Motorista Arthur e passageira Ana cadastrados!");
	
		Corrida corrida1 = null;
		
		System.out.println("\n---- Simulação 1: Solicitando uma corrida ----");
		
		Categoria categoriaDaCorrida = new CategoriaComum();
		MetodoPagamento pagamentoDaCorrida = new CartaoCredito();
		
				try {
					System.out.println("Passageira Ana está tentando pedir uma corrida...");
					
					corrida1 = servico.solicitarCorrida(
							passageiro1,
							"Asa Sul",
							"Asa Norte",
							categoriaDaCorrida,
							pagamentoDaCorrida,
							10.0);
					
					System.out.println("Corrida solicitada.");
					System.out.println("Motorista: " + corrida1.getMotorista().getNome());
					System.out.println("Valor: R$ " + corrida1.getValorEstimado());
					System.out.println("Status da Corrida: " + corrida1.getStatus());
					System.out.println("Status do Motorista: " + motorista1.getStatus());
					
				} catch (NenhumMotoristaDisponivelException erro) {
					
					System.out.println("Falha: " + erro.getMessage());
				}
				
				
		System.out.println("\n---- Simulação 2: Finalizando a Viagem ----");
		
		if(corrida1 != null) {
			
			corrida1.setStatus("Em Andamento");
			System.out.println("Motorista iniciou a viagem. Status: " + corrida1.getStatus());
			
			try {
				
				System.out.println("Finalizando a viagem");
				servico.finalizarViagem(corrida1);
				
				System.out.println("Viagem finalizada.");
				System.out.println("Status da corrida: " + corrida1.getStatus());
				System.out.println("Status do motorista: " + motorista1.getStatus());	
				
			} catch (PagamentoRecusadoException | SaldoInsuficienteException erro) {
				System.out.println("Falha no Pagamento: " + erro.getMessage() );
				
			} catch (EstadoInvalidoDaCorridaException erro) {
				System.out.println("Falha de Estado: " + erro.getMessage());
			}
			
		} else {
			
			System.out.println("Simulação 2 nao pode rodar porque a corrida1 não foi criada.");
		}
		
		
		
		
	}	
}
