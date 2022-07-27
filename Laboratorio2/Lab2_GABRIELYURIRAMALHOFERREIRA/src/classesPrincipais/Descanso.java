package classesPrincipais;

/**
* Classe responsável por cuidar do tempo de descanso do aluno,
* levando em consideração a quantidade de horas de descanso e
* o número de semanas.
* 
* @author Gabriel Yuri Ramalho Ferreira
*/
public class Descanso {
	/**
	 * Atributo responsável pela quantidadde total em horas que o aluno descansou.
	 */
	private int horasDescanso;
	
	/**
	 * Atributo responsável pela quantidadde de semanas de estudo de um aluno.
	 */
	private int semanasDescanso; 
	
	
	/**
	 * Atributo que armazena o status de desncanso
	 * anterior do aluno.
	 */
	private String status = "cansado";
	
	/**
	 * Atributo que ira armazenar o status de descanso do aluno
	 * sendo concatenado posteriomente com um emoji.
	 */
	private String emojiStatus = "";
	
	/**
	* Retorna para o usuário a informação "descansado" ou "cansado"
	* De acordo com o descanso semanal do aluno.
	*
	* @return a representação do estado de descanso do aluno.
	*/
	public String getStatusGeral(){
		String statusAtual = "cansado";
		int descansoSemanal;
		
		if(this.horasDescanso == 0 || this.semanasDescanso == 0) {
			descansoSemanal = 0;
			
			
		}
		else {
			descansoSemanal = this.horasDescanso / this.semanasDescanso;
		}
		
		
		
		
		if (descansoSemanal >= 26) {
			statusAtual = "descansado";
			
		}
		
		
		if (this.status.equals(statusAtual) == false) {
			this.emojiStatus = "";
			
		}
		
		
		
		return statusAtual + this.emojiStatus;
	}
	
	/**
	* Define o atributo horasDescanso.
	* 
	* @param horas horas de descanso do aluno
	*/
	void defineHorasDescanso(int horas) {
		this.horasDescanso = horas;
	}
	
	/**
	 * Define o atributo semanasDescanso.
	 * 
	 * @param semanas semanas de descanso do aluno.
	*/
	void defineNumeroSemanas(int semanas) {
		this.semanasDescanso = semanas;
	}
	
	/**
	 * Define o atributo emojiStatus, que é uma string
	 * contendo um emoji usando caracteres do teclado.
	 * 
	 * @param valor String que vai conter um emoji representando o status 
	 * do aluno.
	 */
	void definirEmoji(String valor) {
		this.emojiStatus = " - " + valor;
		
	}

}
