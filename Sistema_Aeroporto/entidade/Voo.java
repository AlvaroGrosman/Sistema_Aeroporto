package entidade;

/*Importação de pacotes das utilidades do Java para a classe Voo*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*Fim da importação de pacotes das utilidades do Java para a classe Voo*/

/*Início da classe Voo*/
public class Voo {
	/*Declaração dos atributos*/
	public int numeroVoo;
	public String origem;
	public String destino;
	public String horarioPartida;
	public String horarioChegada;
	public int capacidadeMaxima;
	public int reservasConfirmadas;
	/*Fim da declaração dos atributos*/

	/*Método para recuperação dos dados inseridos no objeto em questão*/	
	public Voo(int numeroVoo, String origem, String destino, String horarioPartida, String horarioChegada, int capacidadeMaxima) {
		this.numeroVoo = numeroVoo;
		this.origem = origem;
		this.destino = destino;
		this.horarioPartida = horarioPartida;
		this.horarioChegada = horarioChegada;
		this.capacidadeMaxima = capacidadeMaxima;
		this.reservasConfirmadas = reservasConfirmadas;
	}
	/*Fim do método para recuperação dos dados inseridos no objeto em questão*/

	/*Inicio dos getters dessa classe*/
	public int getReservasConfirmadas() {
		return reservasConfirmadas;
	}
	public int getNumeroVoo() {
		return numeroVoo;
	}
	public String getOrigem() {
		return origem;
	}
	public String getDestino() {
		return destino;
	}
	public String getHorarioPartida() {
		return horarioPartida;
	}
	public String getHorarioChegada() {
		return horarioChegada;
	}
	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	/*Fim dos getters dessa classe*/
	
	/*Inicio do método Confirmar Reserva, que irá (após realizado o check in) adicionar 1 unidade ao atributo "Reservas Confirmadas" dessa classe*/
	public void confirmarReserva (){
		this.reservasConfirmadas += 1;
		
	}
	/*Fim do método Confirmar Reserva*/
}
/*Fim da classe Voo*/
