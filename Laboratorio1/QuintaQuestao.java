/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Gabriel Yuri Ramalho Ferreira - 121210381
 */

import java.util.Scanner;

public  class QuintaQuestao {

    public static double somar(double n1, double n2){
        double soma = n1 + n2;
        return soma;

    }

    public static double subtrair(double n1, double n2){
        double subtracao = n1 - n2;
        return subtracao;

    }

    public static double multiplicar(double n1, double n2){
        double produto = n1 * n2;
        return produto;
    }

    public static void dividir(double n1, double n2){
        double divisao = n1 / n2;

        if(n2 == 0){
            System.out.println("ERRO");
            
        }
        else{
            System.out.println("RESULTADO: "+ divisao);
            
        }
        

    }

    public static void main(String[] args) {
        char operacao;
        double n1,n2;
        Scanner sc = new Scanner(System.in);

        operacao = sc.next().charAt(0);

        if (operacao != '+' && operacao != '-' && operacao != '*' && operacao != '/' ){
            System.out.println("ENTRADA INVALIDA");
        }
        else{
            n1 = sc.nextDouble();
        n2 = sc.nextDouble();


        switch (operacao) {
            case '+':
                System.out.println("RESULTADO: "+somar(n1, n2));
                break;

            case '-':
            System.out.println("RESULTADO: "+subtrair(n1, n2));
                break;

            case '*':
            System.out.println("RESULTADO: "+multiplicar(n1, n2));
                break;
            
            case '/':
                dividir(n1,n2);
                break;
        }

        }
        
        
    }
}