package classesPrincipais;

public class CoisaBonus {
	public static void main(String[] args) {
		descanso();
	    System.out.println("-----");
	    disciplina();
	    System.out.println("-----");
	    atividadesComplementares();
		
	}
	public static void descanso() {
	       Descanso descanso = new Descanso();
	       descanso.definirEmoji(":(");
	       System.out.println(descanso.getStatusGeral());
	       descanso.defineHorasDescanso(30);
	       descanso.defineNumeroSemanas(1);
	       System.out.println(descanso.getStatusGeral());
	       descanso.defineHorasDescanso(26);
	       descanso.defineNumeroSemanas(2);
	       System.out.println(descanso.getStatusGeral());
	       descanso.defineHorasDescanso(26);
	       descanso.defineNumeroSemanas(1);
	       
	       descanso.definirEmoji(":)");
	       System.out.println(descanso.getStatusGeral());
	       descanso.defineHorasDescanso(26);
	       descanso.defineNumeroSemanas(1);
	       System.out.println(descanso.getStatusGeral());
	   }
	
	private static void disciplina() {
		   int quantidadeNotas = 6;
		   int[] pesos = new int [6];
		   for(int i = 0; i < 6; i++) {
			   pesos[i] = i+1;
		   }
		   
	       Disciplina prog2 = new Disciplina("PROGRAMACAO 2",pesos);
	       prog2.cadastraHoras(4);
	       prog2.cadastraNota(1, 5.0);
	       prog2.cadastraNota(2, 6.0);
	       prog2.cadastraNota(3, 7.0);
	       
	       System.out.println(prog2.aprovado());
	       
	       prog2.cadastraNota(4, 10.0);
	       prog2.cadastraNota(5, 8.0);
	       prog2.cadastraNota(6, 5.0);
	       
	       System.out.println(prog2.aprovado());
	       
	       System.out.println(prog2.toString());
	   }
	private static void atividadesComplementares() {
	       AtividadesComplementares minhasAtividades = new AtividadesComplementares();
	       int horasEstagio1 = 600;
	       int mesesEstagio1 = 8;
	       int horasEstagio2 = 600;
	       int mesesEstagio2 = 4;
	       
	       minhasAtividades.adicionarEstagio(600,4); //5 Creditos
	       
	       
	      
	       String[] atividades = minhasAtividades.pegaAtividades();
	       for (int i = 0; i < atividades.length; i++) {
	           System.out.println(minhasAtividades.pegaAtividades()[i]);
	       }
	       System.out.println(minhasAtividades.contaCreditos());
	       minhasAtividades.adicionarEstagio(600,8); // 10 Creditos
           System.out.println("");

	       
	       
	       for (int i = 0; i < atividades.length; i++) {
	           System.out.println(minhasAtividades.pegaAtividades()[i]);
	       }
	       
	       System.out.println(minhasAtividades.contaCreditos());
	       
	       
	      
	       
	       
	 
	   }

}