
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

        System.out.println("\n Moda 1: "+AmostraUm.moda());
        
        System.out.println("\n Media 1: "+AmostraUm.media());

        System.out.println("\n Mediana 1: "+ AmostraUm.mediana());
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("\n Moda 2: "+AmostraDois.moda());
        
        System.out.println("\n Media 2: "+AmostraDois.media());

        System.out.println("\n Mediana 2: "+ AmostraDois.mediana());
                      
                                           
        }
    
    
}
