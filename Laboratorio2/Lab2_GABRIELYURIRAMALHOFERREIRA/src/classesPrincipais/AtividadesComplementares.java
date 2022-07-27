package classesPrincipais;


/**
 * Classe responsável pelas atividades complementares, como: Estagios, projetos ,cursos e
 * a quantidade de creditos obtidas nessas atividades.
 * 
 *  @author Gabriel Yuri Ramalho Ferreira.
 */

public class AtividadesComplementares {
	/**
	 * Atributo responsável por armazenar a quantidade de horas 
	 * de cada estagio.
	 */
	private int horasEstagios;
	
	/**
	 * Atributo responsável por armazenar o tempo em meses
	 * que o aluno passou em um projeto.
	 */
	private int mesesProjetos;
	
	/**
	 * Atributo responsável por armazenar o tempo
	 * em horas de todos os cursos feitos, sendo 
	 * esse valo cumulativo.
	 */
	private double horasCursos;
	
	/**
	 * Atributo responsável por armazenar a quantidade
	 * de meses decorridos em um certo estágio.
	 * 
	 */
	private int mesesEstagios;
	
	/**
	 * Atributo responsável por acumular a quantidade
	 * de créditos dos estagios.
	 */
	private int creditosEstagios; 
	
	/**
	 * Atributo responsável por acumular a quantidade
	 * de créditos dos projetos.
	 */
	private int creditosProjetos; 
	
	/**
	 * Atributo responsável por acumular a quantidade
	 * de créditos dos cursos.
	 */
	private int creditosCursos;
	
	/**
	 * Atibruto que vai armazenar a soma dos creditos de todas 
	 * as atividades.
	 */
	private int creditosEstagiosTotal;
	
	
	
	/**
	 * Armazenar o total de creditos de acumulados em todas
	 * as atividades.
	 */
	private int creditosTotais;
	
	/**
	 * Vetor de String, onde cada posição correspondente
	 * a um estagio cadastrado, no formato: "Estagio + meses + horas".
	 * 
	 */
	private String[] estagios = new String[9];
	
	/**
	 * Vetor de String, onde cada posiçãoo correspondente
	 * a um projeto cadastrado, no formateo: "Projeto + meses + horas".
	 */
	private String[] projetos = new String[16];
	
	
	
	/**
	 * Atributo respons�vel por contabilizar o total
	 * de atividades cadastradas.
	 */
	private int contaAtividades;
	
	/**
	 * Vetor responsável por armazenar todas as informações adquiridas
	 * pelo objeto.
	 */
	private String[] resumoAtividades = new String[29];
	
	/**
	 * 	M�todo que atribui um valor ao atributo horasEstagios
	 *  e adiciona um estagio dentro do vetor estagios[].
	 */
	public void adicionarEstagio(int horas) {
		this.horasEstagios += horas;
		this.mesesEstagios = 4;
		
		for(int i = 0; i < 9; i++) {
			if (estagios[i] == null) {
				estagios[i] = "Estagio" + (i+1) + " " +"Meses: " + this.mesesEstagios
				+", Horas: " + horas;
				contaAtividades++;
				break;
			}
		}
		
	}
	
	/**
	 * Método para adicionar um estagio com uma quantidade de horas e meses.
	 * 
	 * @param horas horas do estagio em formato inteiro.
	 * @param mesesEstagios meses do estagio em formato inteiro.
	 */
	public void adicionarEstagio(int horas, int mesesEstagios) {
		this.horasEstagios += horas;
		this.mesesEstagios += mesesEstagios;
		this.creditosEstagios = (this.horasEstagios / 300) * 5;
		
		for(int i = 0; i < 9; i++) {
			if (estagios[i] == null) {
				estagios[i] = "Estagio" + (i+1) + " " +"Meses: " + this.mesesEstagios
				+", Horas: " + horas;
				contaAtividades++;
				break;
			}
		}
		
		
	}
	
	/**
	 * 	Método que atribui um valor ao atributo mesesProjetos
	 *  e adiciona um projeto dentro do vetor projetos[].
	 *  
	 *  @param meses valor de meses dedicado ao projeto.
	 */
	public void adicionarProjeto(int meses) {
		this.mesesProjetos += meses; 
		
		for(int i = 0; i < 16; i++) {
			if (projetos[i] == null) {
				projetos[i] = "Projeto" + (i+1) + " " + meses;
				contaAtividades++;
				break;
			}
		}	
		
	}
	
	/**
	 * Atribui um valor em horas ao atributo horasCursos.
	 * 
	 * @param horas valor de horas passadas em cursos.
	 */
	public void adicionarCurso(double horas) {
		this.horasCursos += horas;	
		
	}
	
	/**
	 * Responsável por contabilizar os creditos de cada atividade e depois
	 * gerar o total de creditos adquiridos.
	 * 
	 * @return Um inteiro que é a quantidade de creditos totais.
	 */
	public int contaCreditos() {
		
		if(this.horasEstagios / 300 < this.mesesEstagios / 4) {
			this.creditosEstagios = (this.creditosEstagios / 300) * 5;
			
		}
		else {
			this.creditosEstagios = (this.mesesEstagios / 4) * 5;
			
		}
		
		
		this.creditosProjetos = (this.mesesProjetos / 3) * 2;
		this.creditosCursos = ((int)this.horasCursos / 30);
		this.creditosTotais = this.creditosEstagios + this.creditosProjetos + this.creditosCursos;
		
		
		return creditosTotais;
	}
	
	/**
	 * Pega informações relevantes das atividades complementares e coloca
	 * no vetor resumoAtividades e depois realiza uma copia para o vetor
	 * resumoAtividades2 para evitar valores nulos.
	 * 
	 * @return um vetor de String contendo o tempo e creditos
	 * de cada atividade.
	 */
	public String[] pegaAtividades() {
		
		
		contaCreditos();
		 
		 int contaAtividades = 0;
		for(int i = 0; i < 9; i++) {
			if(estagios[i] != null) {
				resumoAtividades[i] = estagios[i];
				contaAtividades++;
				
			}
			
		}
		
		for(int i = 0; i < 16; i++) {
			if(projetos[i] != null) {
				resumoAtividades[contaAtividades] = projetos[i];
				contaAtividades++;
				
			}
			
					
		}
		
		
		resumoAtividades[contaAtividades] = "Cursos " + this.horasCursos;
		resumoAtividades[contaAtividades + 1] = "Creditos_Estagio " + this.creditosEstagios;
		resumoAtividades[contaAtividades + 2] = "Creditos_Projeto " + this.creditosProjetos;
		resumoAtividades[contaAtividades + 3] = "Creditos_Cursos " + this.creditosCursos;
		
		String[] resumoAtividades2 = new String[contaAtividades + 4];
		
		for(int i = 0; i < resumoAtividades2.length; i++) {
			if(resumoAtividades[i] != null) {
				resumoAtividades2[i] = resumoAtividades[i];	
			}
			
		}
		
		
		return resumoAtividades2;
	}
		
	}