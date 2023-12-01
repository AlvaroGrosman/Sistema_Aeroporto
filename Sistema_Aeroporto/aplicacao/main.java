package aplicacao;

/*Importação de pacotes das utilidades do Java para o programa main.java*/
import java.util.Scanner;
import controladores.SistemaAeroporto;
import entidade.Passageiro;
import entidade.Voo;
/*Fim da importação de pacotes das utilidades do Java para o programa main.java*/

/*Início do programa main.java*/
public class main {

/*Início do menu inicial, que irá direcionar o usuário para as funções de acordo com a opção que for selecionada*/
 public static void main (String[] args) {
     SistemaAeroporto sistema = new SistemaAeroporto();
     Scanner scanner = new Scanner(System.in);
/* Declaração da variável "opção" que será usada no menu */
     int opcaoUsuario;
/* Fim da declaração da variável "opção" que será usada no menu */

	
     do {
	 System.out.println();
         System.out.println("#### Menu Principal ####");
         System.out.println("1 - Entrar como Administrador");
         System.out.println("2 - Entrar como Passageiro");
         System.out.println("0 - Sair do Sistema");
	 System.out.println("########################");
         System.out.print("Escolha a opção desejada: ");
         opcaoUsuario = scanner.nextInt();

         switch (opcaoUsuario) {
             case 1:
                 menuAdministrador(sistema, scanner);
                 break;
             case 2:
                 menuPassageiro(sistema, scanner);
                 break;
             case 0:
                 System.out.println("Saindo do sistema...");
                 break;
             default:
                 System.out.println("Opção inválida. Tente novamente.");
         }
     } while (opcaoUsuario != 0);

     scanner.close();
	/*Fim do menu inicial*/
 }
/*Início do menu de administrador, que irá direcionar o administrador para as funções de acordo com a opção que for selecionada*/
 private static void menuAdministrador(SistemaAeroporto sistema, Scanner scanner) {
     int opcao;

     do {
	 System.out.println();
         System.out.println("\n### Menu Administrador ###");
         System.out.println("1 - Cadastrar Voo");
         System.out.println("2 - Processar Reservas");
         System.out.println("3 - Exibir Voos Disponíveis");
         System.out.println("4 - Sair do usuário");
	 System.out.print("########################");
         System.out.println("Escolha a opção desejada: ");
         opcao = scanner.nextInt();

         switch (opcao) {
             case 1:
                 // Capturar informações do novo voo
            	 
                 System.out.print("\nNúmero do Voo: ");
                 int numeroVoo = scanner.nextInt();
                 System.out.print("Origem: ");
                 String origem = scanner.next();
                 System.out.print("Destino: ");
                 String destino = scanner.next();
                 System.out.print("Horário de Partida: ");
                 String horarioPartida = scanner.next();
                 System.out.print("Horário de Chegada: ");
                 String horarioChegada = scanner.next();
                 System.out.print("Capacidade Máxima: ");
                 int capacidadeMaxima = scanner.nextInt();

                 sistema.cadastrarVoo(numeroVoo, origem, destino, horarioPartida, horarioChegada, capacidadeMaxima);
                 break;
             case 2:
                 sistema.processarReservas();
                 break;
             case 3:
                 sistema.exibirInformacoesVoos();
                 break;
             case 4:
                 System.out.println("\nSaindo do Menu Administrador...");
                 break;
             default:
                 System.out.println("\nOpção inválida. Tente novamente.");
         }
     } while (opcao != 4);
 }
/*Fim do menu de administrador*/

/*Início do menu de passageiro, que irá direcionar o passageiro para as funções de acordo com a opção que for selecionada*/
 private static void menuPassageiro(SistemaAeroporto sistema, Scanner scanner) {
     int opcao;

     do {
	 System.out.println();
         System.out.println("\n### Menu Passageiro ###");
         System.out.println("1 - Exibir Voos Disponíveis");
         System.out.println("2 - Realizar Reserva");
         System.out.println("3 - Realizar Check-in");
         System.out.println("4 - Sair do usuário");
	 System.out.println("########################");
         System.out.print("Escolha a opção desejada: ");
         opcao = scanner.nextInt();

         switch (opcao) {
             case 1:
                 sistema.exibirInformacoesVoos();
                 break;
             case 2:
                 realizarReserva(sistema, scanner);
                 break;
             case 3:
                 realizarCheckIn(sistema, scanner);
                 break;
             case 4:
                 System.out.println("\nSaindo do Menu Passageiro...");
                 break;
             default:
                 System.out.println("\nOpção inválida. Tente novamente.");
         }
     } while (opcao != 4);
 }
/*Fim do menu de passageiro*/

/*Início do metodo Realizar Reserva, que irá verificar a existência do voo, coletar os dados do passageiro e do respectivo voo, e criar uma reserva contendo os dados combinados*/
 private static void realizarReserva(SistemaAeroporto sistema, Scanner scanner) {
     System.out.println("\n### Realizar Reserva ###");
     System.out.print("Digite o número do voo desejado: ");
     int numeroVoo = scanner.nextInt();
    /* Verificação da existência do Voo na lista de voos*/
     Voo vooSelecionado = null;
     for (Voo voo : sistema.listaVoos) {
         if (voo.getNumeroVoo() == numeroVoo) {
             vooSelecionado = voo;
             break;
         }
     }
    /* Fim da verificação da existência do Voo na lista de voos*/
	
	/*Coleta de dados do passageiro*/
     if (vooSelecionado != null) {
         System.out.print("\nNome do Passageiro: ");
         String nome = scanner.next();
         System.out.print("Idade do Passageiro: ");
         int idade = scanner.nextInt();
         System.out.print("CPF do Passageiro: ");
         String cpf = scanner.next();
         System.out.print("E-mail do Passageiro: ");
         String email = scanner.next();
         System.out.print("Digite novamente o numero do voo: ");
         int passagem = scanner.nextInt();
	/*Fim da coleta de dados do passageiro*/

         Passageiro novoPassageiro = new Passageiro(nome, idade, cpf, email, passagem); //Usando os dados coletados para criação de um objeto da classe Passageiro
         sistema.realizarReserva(vooSelecionado, novoPassageiro); //Direcionamendo dos objetos Passageiro e Voo para o método Realizar Reserva na classe SistemaAeroporto
     } else {
         System.out.println("\nVoo não encontrado.");
     }
 }
/*Fim do metodo Realizar Reserva*/

/*Inicio do método Realizar Check In, que irá verificar a existência do voo, coletar informações do passageiro, e direcionar para o método Realizar Check In*/
 private static void realizarCheckIn(SistemaAeroporto sistema, Scanner scanner) {
	 
     System.out.println("\n### Realizar Check-in ###");
     System.out.print("Digite o número do voo desejado: ");
     int numeroVoo = scanner.nextInt();
	 
/* Verificação da existência do Voo na lista de voos*/
	 
     Voo vooSelecionado = null;
     for (Voo voo : sistema.listaVoos) {
         if (voo.getNumeroVoo() == numeroVoo) {
             vooSelecionado = voo;
             break;
         }
     }
/* Fim da verificação da existência do Voo na lista de voos*/
	 
/*Coleta de dados do passageiro*/
     if (vooSelecionado != null) {

    	 System.out.print("\nNome do Passageiro: ");
         String nome = scanner.next();
         System.out.print("CPF do Passageiro: ");
         String cpf = scanner.next();
         System.out.print("Digite novamente o numero do voo: ");
         int passagem = scanner.nextInt();
/*Fim da coleta de dados do passageiro*/

         Passageiro novoPassageiro = new Passageiro(nome, cpf, passagem);//Usando os dados coletados para criação de um objeto da classe Passageiro
 	 sistema.realizarCheckIn(vooSelecionado, novoPassageiro);//Direcionamendo dos objetos Passageiro e Voo para o método Realizar Check In na classe SistemaAeroporto

         } else {
             System.out.println("\nPassageiros não encontrado nas reservas pendentes para este voo.");
         }    
 }
/*Fim do método Realizar Check In*/
}
/*Fim do programa main.java*/
