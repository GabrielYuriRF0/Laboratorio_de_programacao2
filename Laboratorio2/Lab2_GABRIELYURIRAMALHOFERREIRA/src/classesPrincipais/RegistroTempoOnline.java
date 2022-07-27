package classesPrincipais;
/**
* Classe responsável por armazenar o tempo gasto em uma disciplina
* e analisar se a carga horária do estudante é satisfatória para
* uma disciplina em questão.
*
* @author Gabriel Yuri Ramalho Ferreira
*/
public class RegistroTempoOnline {
	/**
	* Vai armazenar o nome da disciplina e esse nome pode ser 
	* simples ou composto.
	*/
	private String nomeDisciplina = new String();
	
	/**
	 * Tempo em horas recomendado para estudar uma certa disciplina.
	 */
	private int tempoOnlineEsperado = 0;
	
	/**
	 * Tempo em horas que o aluno dedicou a uma disciplina.
	 */
	private int tempoDedicado = 0;
	
	
	/**
	 * Construtor que vai receber vai receber apenas o nome da disciplina
	 * e vai setar com padrão o tempo online de 120 horas para a conclusão
	 * da disciplina em quest�o.
	 * 
	 * @param Nome da disciplina que pode ser composto
	 * ou não.
	 */
	public RegistroTempoOnline (String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
		
	}
	
	/**
	 * Construtor que vai criar um objeto contendo nome e tempo online esperado
	 * onde o tempo é fonnecido em horas.
	 * 
	 * @param Nome da disciplna em formato de String.
	 * 
	 * @param tempo online para a sua realização da disciplina 
	 * que é dado em horas.
	 */
	public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	* Adiciona no atributo tempoDedicado um valor em horas que
	* corresponde ao tempo dedicado a essa disciplina de maneira online.
	* 
	* @param tempo tempo online dedicado a uma disciplina.
	*/
	public void adicionaTempoOnline(int tempo) {
		this.tempoDedicado += tempo;
		
	}
	
	/**
	* Verifica se a carga hor�ria dedicada a uma disciplina � maior ou igual
	* a carga hor�ria esperada.
	* 
	* @return Retorna true se a aluno conseguir cumprir a carga hor�ria esperada,
	* caso contr�rio retorna false.
	*/
	public boolean atingiuMetaTempoOnline() {	
		return this.tempoDedicado >= this.tempoOnlineEsperado;
		
	}
	
	/**
	* Método que vai acessar o nome de uma disciplina, a carga horária realizada
	* e a carga horária esperada.
	* 
	* @return Retorna uma String contendo o nomeDisciplina concatenado
	* com o tempoDedicado e tempoOnlineEsperado.
	*/
	
	public String toString(){
		return this.nomeDisciplina + " " +  this.tempoDedicado + "/" 
		+ this.tempoOnlineEsperado;
		
	}
}