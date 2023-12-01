package controladores;

/*Importação de pacotes das utilidades do Java para a classe controladora SistemaAeroporto*/
import 	java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import entidade.Passageiro;
import entidade.Voo;

/*Fim da importação de pacotes das utilidades do Java para a classe controladora SistemaAeroporto*/

/*Início da classe construtora SistemaAeroporto*/
public class SistemaAeroporto {
	
	Scanner scanner = new Scanner(System.in);
	/*Declarando variáveis e iniciando pilhas, filas e listas*/
	 public ArrayList<Voo> listaVoos;
	 public Stack<Passageiro> passageirosCheckIn;
	 public Queue<Passageiro> passageirosReservaPendente = new LinkedList<>();
	 public Voo novoVoo;
	
	 
	
	public SistemaAeroporto() {
	     this.listaVoos = new ArrayList<>();
	     this.passageirosCheckIn = new Stack<>();
	     this.passageirosReservaPendente = new LinkedList<>();
	 }
	/* Fim da declaração de variáveis e inicio de pilhas, filas e listas */
	
	/* Início do método Adicionar Voo, que irá adicionar os dados inseridos no programa main.java a lista de Voos cadastrados pelo Administrador */
	 public void adicionarVoo(Voo voo) {
	     listaVoos.add(voo);
	 }
	/* Fim do método Adicionar Voo */

	/* Início do método Exibir Informações do Voo, que irá recuperar os dados atuais de cada Voo cadastrado pelo Administrador */
	 public void exibirInformacoesVoos() {
	     for (Voo voo : listaVoos) {
		 System.out.println();
	         System.out.println("Número do Voo: " + voo.getNumeroVoo());
	         System.out.println("Origem: " + voo.getOrigem());
	         System.out.println("Destino: " + voo.getDestino());
	         System.out.println("Horário de Partida: " + voo.getHorarioPartida());
	         System.out.println("Horário de Chegada: " + voo.getHorarioChegada());
	         System.out.println("Capacidade Máxima: " + voo.getCapacidadeMaxima());
	         System.out.println("Reservas Confirmadas: " + voo.getReservasConfirmadas());
	     }
	 }
	 /* Fim do método Exibir Informações do Voo */
	
	/* Início do método Realizar Check In, que irá pegar os dados do passageiro e do voo para realizar o check in, depois irá remover os dados da pilha de Check In's, e irá adicionar 1 unidade ao atributo "Reservas Confirmadas" na classe Voo */
	 public void realizarCheckIn(Voo voo, Passageiro novoPassageiro) {
		 System.out.println();
	         System.out.println("Check-in realizado para o voo " + voo.getNumeroVoo() + " - Passageiro: " + novoPassageiro.getNome());
		 passageirosCheckIn.pop();
	         voo.confirmarReserva();
	 }
	 /* Fim do método Realizar Check In */

	/* Início do método Cadastrar Voo, que irá adicionar os dados inseridos no programa main.java a lista de Voos cadastrados */
	 public void cadastrarVoo(int numeroVoo, String origem, String destino, String horarioPartida, String horarioChegada, int capacidadeMaxima) {
	     novoVoo = new Voo(numeroVoo, origem, destino, horarioPartida, horarioChegada, capacidadeMaxima);
	     listaVoos.add(novoVoo);
	     System.out.println("Voo cadastrado com sucesso.");
	 }
	/* Fim do método Cadastrar Voo */
	
	/* Início do método Realizar Reserva, que irá adicionar os dados inseridos no programa main.java a fila de Reservas Pendentes */
	 public void realizarReserva(Voo vooSelecionado, Passageiro novoPassageiro) {
		 passageirosReservaPendente.add(novoPassageiro);
	 }
	/* Fim do método Realizar Reserva*/

	/* Início do método Processar Reservas, que irá tirar a reserva da fila de reservas pendentes e adicionar a pilha de Check In's */
	public void processarReservas() {
		
		for (Passageiro passageiro : passageirosReservaPendente) {
			 System.out.println("Número do Voo: " + passageiro.getPassagem());
	         	 System.out.println("Nome do passageiro: " + passageiro.getNome());
	         
	     }
		System.out.println("\nDeseja processar a primeira reserva? (y/n)");
		String resposta = scanner.nextLine();
		
		if (resposta.equals ("y")) {
			
			passageirosCheckIn.push(passageirosReservaPendente.remove());

		} else {
			System.out.println("\nRetornando ao menu anterior...");
		}
		
	 }
	/*Fim do método Processar Reservas*/
			
	}
	/*Fim da classe controladora SistemaAeroporto*/

	


	
