/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_estatistica;

/**
 *
 * @author Anderson Luis
 */
public class Java_Estatistica {

	public static void main(String[] args) {		          

        MoMeMd AmostraUm = new MoMeMd();
        MoMeMd AmostraDois = new MoMeMd();

        double array[] = {22,25,25,27,27,28,29,29,30,27};
        double array2[] = {22,25,27,28,28,28,27,25,26,24};

        AmostraUm.setArray(array);       
        AmostraDois.setArray(array2);

        System.out.println("\n Moda 1: "+AmostraUm.getModa());
        
        System.out.println("\n Media Aritmética 1: "+AmostraUm.getMediaAritmetica());

        System.out.println("\n mediana 1: "+ AmostraUm.getMediana());
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("\n Moda 2: "+AmostraDois.getModa());
        
        System.out.println("\n Media Aritmética 2: "+AmostraDois.getMediaAritmetica());

        System.out.println("\n mediana 2: "+ AmostraDois.getMediana());
                      
                                           
        }
    
    
}
