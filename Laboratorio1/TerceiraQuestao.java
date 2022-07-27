/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Gabriel Yuri Ramalho Ferreira - 121210381
 */

import java.util.Scanner;



public  class TerceiraQuestao {
    public  static float calcularMedia(float nota1, float nota2){
        float media = (nota1 + nota2) / 2;
        return media;
    }

    public static void main(String[] args) {

        float nota1, nota2;

        Scanner sc = new Scanner(System.in);
        nota1 = sc.nextFloat();
        nota2 = sc.nextFloat();

        if (calcularMedia(nota1, nota2) >= 7){
            System.out.println("pass: True!");
        }
        else{
            System.out.println("pass: False!");
        }







    }
}