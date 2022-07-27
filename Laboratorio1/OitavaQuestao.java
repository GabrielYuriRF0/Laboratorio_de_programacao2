/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Gabriel Yuri Ramalho Ferreira - 121210381
 */

import java.util.Scanner;
import java.util.ArrayList;


public class OitavaQuestao {
    public static void main(String[] args){
        String[] splitar;
        String dados = new String();
        ArrayList <Integer> notas = new ArrayList<>();

        int maiorNota, menorNota;
        int acimaMedia = 0, abaixoMedia = 0;
        int soma = 0, quantidade = 0;
        int media;
        
        int i = -1;

        Scanner sc = new Scanner(System.in);



        //Laço para ler as entradas e colocar em um ArrayList de inteiros:
        do{
            dados = sc.nextLine();
            if (dados.equals("-") == true){
                break;
            }
            else{
                i++;
                splitar = dados.split(" ");
                notas.add(Integer.parseInt(splitar[1]));
                soma += notas.get(i);
                

            }
        }while(true);

        maiorNota = 0;
        menorNota = 1000;
        quantidade = notas.size();

        //Laço para pegar maior, menor nota e notas acima e abaixo de 700:
        for (int i2 = 0; i2 < quantidade; i2++){
            if (notas.get(i2) > maiorNota){
                maiorNota = notas.get(i2);
            }

            if (notas.get(i2) < menorNota){
                menorNota = notas.get(i2);
            }

            if (notas.get(i2) >= 700){
                acimaMedia++;
            }
            
            else{
                abaixoMedia++;
            }

        }

        media = soma / quantidade;
        

        System.out.println("maior: "+maiorNota);
        System.out.println("menor: "+menorNota);
        System.out.println("media: "+media);
        System.out.println("acima: "+acimaMedia);
        System.out.println("abaixo: "+abaixoMedia);

    }
    
}
