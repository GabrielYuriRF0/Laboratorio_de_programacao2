/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Gabriel Yuri Ramalho Ferreira - 121210381
 */

import java.util.Scanner;

 public class SextaQuestao{
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] vetorValores = new int[1000];
        int soma = 0, quantidade = 0;
        float media;

        String linha = sc.nextLine();
        String[] valores = linha.split("\\s"); //

        //Laço para criar um vetor de inteiros
       for (int i = 0; i < valores.length;i++){
           vetorValores[i] = Integer.parseInt(valores[i]);
           soma += vetorValores[i];

       }

       quantidade = valores.length;
       media = soma / quantidade;

       //Laço para exibir os valores acima da média:
       for(int i2 = 0; i2 < quantidade; i2++){
           if (vetorValores[i2] > media){
               System.out.print(vetorValores[i2] + " ");
           }
       }

     }
 }