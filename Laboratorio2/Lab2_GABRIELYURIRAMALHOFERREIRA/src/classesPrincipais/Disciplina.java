package classesPrincipais;
import java.util.Arrays;
import java.util.ArrayList;


/**
* Classe responsável por informações referentes a uma disciplina
* como: nome, horas necessárias, notas. Também é responsável por calcular a
* média e definir se um aluno foi aprovado ou não
*
* @author Gabriel Yuri Ramalho Ferreira
*/
public class Disciplina {
	/**
	* Vai armazenar o nome da disciplina e esse nome pode ser 
	* simples ou composto.
	*/
	private String nomeDisciplina;
	
	
	
	/**
	 * Horas de estudos referentes a uma disciplina.
	 */
	private int horasCadastradas;
	
	/**
	 * Atributo responsável por receber a m�dia das notas. 
	 */
	private double media;
	
	
	/**
	 * Atributo responsável por armazenar todas as 
	 * notas cadastradas no sistema.
	 */
	private ArrayList<Double> notas = new ArrayList<>();
	
	/**
	 * Atributo responsável por armazenar todos os pesos
	 * das notas, para posteriomente ser realizado o
	 * cálculo da média ponderada.
	 */
	private ArrayList<Integer> pesosNotas = new ArrayList<>();
	
	
	/**
	 * Construtor para criar um objeto apenas passando 
	 * o nome da disciplina.
	 * 
	 * @param nomeDisciplina: é uma string, podendo
	 * ser composta ou não.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.pesosNotas.add(0);
		
	}
	 
	
	
	/**
	 * Construtor que criar um objeto utilizando nome, quantidade de notas e 
	 * um array de inteiros que vai conter o peso de cada nota. Essse Array
	 * vai ser copiado para um Arraylist.
	 * 
	 * @param nome da disciplina nome da disciplina
	 * @param pesosNotas array contendo os pesos de cada nota.
	 * 
	 */
	public Disciplina(String nomeDisciplina, int[] pesosNotas) {
		this.nomeDisciplina = nomeDisciplina;
		
		for(int i = 0; i < pesosNotas.length; i++) {
			this.pesosNotas.add(pesosNotas[i]);
			
		}
	}
	
	
	/**
	 * Método para atribuir valores ao atributo
	 * horasCadastradas, de maneira acumulativa.
	 */
	public void cadastraHoras(int horas) {
		this.horasCadastradas += horas;
	}
	
	/**
	 * Métodos para cadastrar um certo numero de  notas de uma disciplina
	 * onde cada posição do ArrayList corresponde a uma nota.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas.add(valorNota);
		
	}
	/**
	 * M�todo que vai calcular a média e exibir como saída um
	 * booleano indicando o status de aprovação do aluno.
	 * 
	 * @return um booleano que é true caso o aluno seja aprovado
	 * e false caso contrário.
	 */
	public boolean aprovado(){
		boolean statusAprovado = false;
		double soma = 0.0;
		int somaPesos = 0;
		
		
		//Calcular média normal:
		if(this.pesosNotas.get(0) == 0) {
			for(int j = 0; j < this.notas.size(); j++) {
				soma += this.notas.get(j);
				
			}
			
			
			this.media = soma / this.notas.size();
			
		}
		
		//Calcular a média ponderada:
		else {
			for(int i = 0; i < this.notas.size();i++) {
				soma += this.notas.get(i) * this.pesosNotas.get(i);
				somaPesos += this.pesosNotas.get(i);
				
			}
			this.media = soma / somaPesos;
			
			
		}
		if(this.media >= 7) {
			statusAprovado = true;
		}
		
		return statusAprovado;	
	}
	
	
	/**
	 * Método que vai concatenar informações referentes ao aluno em uma String.
	 * 
	 * @return Uma String contendo o nome da disciplina, horas cadastradas, media
	 * e notas.
	 */
	public String toString() {
		double[] notasVetor = new double[this.notas.size()];
		
		for(int i = 0; i < this.notas.size(); i++) {
			notasVetor[i] = this.notas.get(i);
		}
		return this.nomeDisciplina + " " + Integer.toString(this.horasCadastradas)+ " "
		+ Double.toString(this.media) + " " + Arrays.toString(notasVetor);
		
	}

	
	

	
	
}