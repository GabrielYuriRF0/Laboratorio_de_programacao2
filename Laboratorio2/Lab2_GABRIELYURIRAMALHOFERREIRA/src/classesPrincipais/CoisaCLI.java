package classesPrincipais;
import java.util.Scanner;

public class CoisaCLI {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int escolha;
	
		exibirMenu();
		escolha = sc.nextInt();
		
		switch (escolha) {
		case 1:{
			descanso();
			break;
		}
		case 2:{
			registroOnline();
			break;
			
		}
		case 3:{
			disciplina();
			break;
			
		}
		case 4:{
			atividadesComplementares();
			break;
			
			
		}
		default:
			System.out.println("Voc� digitou uma op��o inv�lida!");
			break;
		}
			
		
		
		
		
	}
	
	private static void exibirMenu() {
		System.out.println("O que voc� deseja alterar?\nDigite"
				+ " uma op��o entre 1 e 4:\n");
		
		System.out.println("1 - Rotina de Descanso");
		System.out.println("2 - Registro de Tempo Online");
		System.out.println("3 - Disciplina");
		System.out.println("4 - Registro de Atividades Complementares");
		System.out.print("Insira a sua escolha: ");
		
		
		
	}
	 public static void descanso() {
		   Descanso descanso = new Descanso();
		   Scanner sc = new Scanner(System.in);
		   String acaoEscolhida = new String();
		   String[] acaoEscolhidaSplit = new String[2];
		   int parametro;
		   String continuidade = "sim";
		   
		   System.out.println("Digite uma a��o a ser executada, no formato: "
		   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
		   
		   acaoEscolhida = sc.nextLine();
		   acaoEscolhidaSplit = acaoEscolhida.split(" ");
		   parametro = Integer.parseInt(acaoEscolhidaSplit[1]);
		   
		   while(true) {
			   
			   
			   if(acaoEscolhidaSplit[0].equals("status")) {
				   System.out.println(descanso.getStatusGeral()); 
				   
				   
			   }	
			   else if(acaoEscolhidaSplit[0].equals("horasdescanso")) {
				   descanso.defineHorasDescanso(parametro);
				   
			   }
			   else if(acaoEscolhidaSplit[0].equals("semanasdescanso")) {
				   descanso.defineNumeroSemanas(parametro);
			   }
			   System.out.println("Deseja continuar? Digite <sim> ou <n�o> ");
			   continuidade = sc.nextLine();
			   
			   if(continuidade.equals("n�o")) {
				   break;
			   }
			   
			   System.out.println("Digite uma a��o a ser executada, no formato: "
				   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   acaoEscolhida = sc.nextLine();
			   acaoEscolhidaSplit = acaoEscolhida.split(" ");
			   parametro = Integer.parseInt(acaoEscolhidaSplit[1]);
			   
		   }
		   System.out.println("Programa encerrado!");
		   
		   
		   
	   }
	 
	 private static void registroOnline() {
		   Scanner sc = new Scanner(System.in);
		   RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
		   String acaoEscolhida = new String();
		   String[] acaoEscolhidaSplit = new String[2];
		   int parametro;
		   String continuidade = "sim";
		   
		   System.out.println("Digite uma a��o a ser executada, no formato: "
			   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   
		   acaoEscolhida = sc.nextLine();
		   acaoEscolhidaSplit = acaoEscolhida.split(" ");
		   parametro = Integer.parseInt(acaoEscolhidaSplit[1]);
		   
		   while(true) {
			   if(acaoEscolhidaSplit[0].equals("adicionatempo")) {
				   tempoLP2.adicionaTempoOnline(parametro);
			   }
			   else if(acaoEscolhidaSplit[0].equals("atingiumeta")) {
				   System.out.println(tempoLP2.atingiuMetaTempoOnline());
			   }
			   else if(acaoEscolhidaSplit[0].equals("exibir")) {
				   System.out.println(tempoLP2.toString());
			   }
			   
			   System.out.println("Deseja continuar? Digite <sim> ou <n�o> ");
			   continuidade = sc.nextLine();
			   
			   if(continuidade.equals("n�o")) {
				   break;
			   }
			   
			   System.out.println("Digite uma a��o a ser executada, no formato: "
				   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   
			   acaoEscolhida = sc.nextLine();
			   acaoEscolhidaSplit = acaoEscolhida.split(" ");
			   parametro = Integer.parseInt(acaoEscolhidaSplit[1]);
			   
		   }
		   System.out.println("Programa encerrado!");
			   
			   
		   
	       
	   }
	 private static void disciplina() {
		   Scanner sc = new Scanner(System.in);
		   Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
		   String acaoEscolhida = new String();
		   String[] acaoEscolhidaSplit = new String[3];
		   int parametro1;
		   double parametro2;
		   String continuidade = "sim";
		   
		   System.out.println("Digite uma a��o a ser executada, no formato: "
			   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   
		   acaoEscolhida = sc.nextLine();
		   acaoEscolhidaSplit = acaoEscolhida.split(" ");
		   parametro1 = Integer.parseInt(acaoEscolhidaSplit[1]);
		   parametro2 = Double.parseDouble(acaoEscolhidaSplit[2]);
		   
		   while(true) {
			   if(acaoEscolhidaSplit[0].equals("cadastrahoras")) {
				   prog2.cadastraHoras(parametro1);
			   }
			   else if(acaoEscolhidaSplit[0].equals("cadastranota")) {
				   prog2.cadastraNota(parametro1,parametro2);
				      
			   }
			   else if(acaoEscolhidaSplit[0].equals("statusdisciplina")) {
				   System.out.println(prog2.aprovado());
			   }
			   else if(acaoEscolhidaSplit[0].equals("exibir")) {
				   System.out.println(prog2.toString());
			   }
			   
			   System.out.println("Deseja continuar? Digite <sim> ou <n�o> ");
			   continuidade = sc.nextLine();
			   
			   if(continuidade.equals("n�o")) {
				   break;
			   }
			   
			   System.out.println("Digite uma a��o a ser executada, no formato: "
				   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   
			   acaoEscolhida = sc.nextLine();
			   acaoEscolhidaSplit = acaoEscolhida.split(" ");
			   parametro1 = Integer.parseInt(acaoEscolhidaSplit[1]);
			   parametro2 = Double.parseDouble(acaoEscolhidaSplit[2]);
			   
		   }
		   System.out.println("Programa encerrado!");
		   
		   
	   }
	 private static void atividadesComplementares() {
	       Scanner sc = new Scanner(System.in);
	       AtividadesComplementares minhasAtividades = new AtividadesComplementares();
	       
	       String acaoEscolhida = new String();
		   String[] acaoEscolhidaSplit = new String[3];
		   double parametro1;
		   double parametro2;
		   String continuidade = "sim";
		   
		   System.out.println("Digite uma a��o a ser executada, no formato: "
			   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   
		   acaoEscolhida = sc.nextLine();
		   acaoEscolhidaSplit = acaoEscolhida.split(" ");
		   parametro1 = Double.parseDouble(acaoEscolhidaSplit[1]);
		   parametro2 = Double.parseDouble(acaoEscolhidaSplit[2]);
		   String[] atividades = minhasAtividades.pegaAtividades();
	       
		   
		   while(true) {
			   if(acaoEscolhidaSplit[0].equals("adicionarestagio")) {
				   minhasAtividades.adicionarEstagio((int)parametro1);
			   }
			   else if(acaoEscolhidaSplit[0].equals("adicionarestagio+")) {
				   minhasAtividades.adicionarEstagio((int)parametro1, (int)parametro2);
			   }
			   else if(acaoEscolhidaSplit[0].equals("adicionarprojeto")){
				   minhasAtividades.adicionarProjeto((int)parametro1);
			   }
			   else if(acaoEscolhidaSplit[0].equals("adicionarcurso")) {
				   minhasAtividades.adicionarCurso(parametro1);
			   }
			   else if(acaoEscolhidaSplit[0].equals("contarcreditos")) {
				   minhasAtividades.contaCreditos();
			   }
			   else if(acaoEscolhidaSplit[0].equals("exibir")){
				   minhasAtividades.pegaAtividades();
				   
				   for (int i = 0; i < atividades.length; i++) {
			           System.out.println(minhasAtividades.pegaAtividades()[i]);
			       }
			       System.out.println(minhasAtividades.contaCreditos());
				     
				   
			   }
			   System.out.println("Deseja continuar? Digite <sim> ou <n�o> ");
			   continuidade = sc.nextLine();
			   
			   if(continuidade.equals("n�o")) {
				   break;
			   }
			   
			   System.out.println("Digite uma a��o a ser executada, no formato: "
				   		+ "nomedom�todo  par�metro(s), caso n�o tenha par�metro, insira 0");
			   
			   acaoEscolhida = sc.nextLine();
			   acaoEscolhidaSplit = acaoEscolhida.split(" ");
			   parametro1 = Double.parseDouble(acaoEscolhidaSplit[1]);
			   parametro2 = Double.parseDouble(acaoEscolhidaSplit[2]);
			   
		   }
		   System.out.println("Programa encerrado!");
	       
	   }
	
}


