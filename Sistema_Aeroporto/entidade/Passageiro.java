package entidade;

/*Início da classe Passageiro*/
public class Passageiro {
	/*Declaração dos atributos*/
	public String nome;
	public int idade;
	public String cpf;
	public String email;
	public int passagem;
	/*Fim da declaração dos atributos*/
	
	/*Método para recuperação dos dados inseridos no objeto em questão*/	
	public Passageiro(String nome, int idade, String cpf, String email, int passagem) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.passagem = passagem;
	}
	/*Fim do método para recuperação dos dados inseridos no objeto em questão*/
	
	/*Método para recuperação dos dados inseridos no objeto em questão*/	
	public Passageiro(String nome, String cpf, int passagem) {
		this.nome = nome;
		this.cpf = cpf;
		this.passagem = passagem;
		
	}
	/*Fim do método para recuperação dos dados inseridos no objeto em questão*/

	/*Inicio dos getters e setters dessa classe*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassagem() {
		return passagem;
	}
	public void setPassagem(int passagem) {
		this.passagem = passagem;
	}
	/*Inicio dos getters e setters dessa classe*/	
}
/*Fim da classe Passageiro*/
