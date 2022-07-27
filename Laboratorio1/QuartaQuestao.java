/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Gabriel Yuri Ramalho Ferreira - 121210381
 */


import java.util.Scanner;

public  class QuartaQuestao {

    public static void verificarFuncao(int[] valores){
        
        if (valores[0] < valores[1] && valores[1] < valores[2] && valores[2] < valores[3]){
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        }

        else if(valores[0] > valores[1] && valores[1] > valores[2] && valores[2] > valores[3]){
                System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");

            }

        else{
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");

        }
        

    }

    public static void main(String[] args) {
        int [] valores = new int[4];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++){
            valores[i] = sc.nextInt();

        }

        verificarFuncao(valores);


    }
}