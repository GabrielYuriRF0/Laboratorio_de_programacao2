/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Gabriel Yuri Ramalho Ferreira - 121210381
 */

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
public class SetimaQuestao {
    public static void main(String[] args){
        String linhaNomes = new String();
        ArrayList <String> nomes = new ArrayList<>();
        String[] splitar = {};
        Scanner sc = new Scanner(System.in);

        do{
            linhaNomes = sc.nextLine();
            boolean tem5Letras = true;
             
            if(linhaNomes.equals("wally") == true){
                break;    

            }
            else{
                splitar = linhaNomes.split(" ");
                
                
                for (int i = 0; i < splitar.length; i++){
                    
                    nomes.add(splitar[i]);
                }   


                for(int i2 = nomes.size() - 1; i2 >= 0; i2--){
                     
                    if (nomes.get(i2).length() == 5){
                        System.out.println(nomes.get(i2));
                        tem5Letras = true;
                        break;
                    }

                    else{
                        tem5Letras = false;
                        }         
                    
                }  
            }
            if (tem5Letras == false){
                System.out.println("?");
            }
            nomes.clear();    
        }while(true);
        
    }

    
}
