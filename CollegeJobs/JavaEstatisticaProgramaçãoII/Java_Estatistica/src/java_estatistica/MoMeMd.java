
package java_estatistica;
import java.util.Arrays;

import java.util.HashMap;


/**
 *
 * @author Anderson Luis
 */
public class MoMeMd {            
    
    private double array[];

	 

    // Coeficiente de Variação de Pearson

    
    public double getMediaAritmetica() {

          double total = 0;

          for (int counter = 0; counter < array.length; counter++)

                total += array[counter];

          return total / array.length;

    }
   

    public double getMediaAritmetica(double array[]) {

          double total = 0;

          for (int counter = 0; counter < array.length; counter++)

                total += array[counter];

          return total / array.length;

    }
  
    public void ordenar() {

          Arrays.sort(array);

    }



    public void imprimeArray() {

          System.out.print("\nElementos do Array: ");

          for (int count = 0; count < array.length; count++)

                System.out.print(array[count] + " ");

    }

    public double getMediana() {

          this.ordenar();

          int tipo = array.length % 2;

          if (tipo == 1) {

                return array[((array.length + 1) / 2) - 1];

          } else {

                int m = array.length / 2;

                return (array[m - 1] + array[m]) / 2;

          }

    }



    public double getModa() {



          HashMap map = new HashMap();

          Integer i;

          Double moda = 0.0;

          Integer numAtual, numMaior = 0;

          for (int count = 0; count < array.length; count++) {

                i = (Integer) map.get(new Double(array[count]));



                if (i == null) {

                      map.put(new Double(array[count]), new Integer(1));

                } else {

                      map.put(new Double(array[count]), new Integer(i.intValue() + 1));

                      numAtual = i.intValue() + 1;

                      if (numAtual > numMaior) {

                           numMaior = numAtual;

                           moda = new Double(array[count]);



                      }



                }

          }         

          return moda;

    }

    public double[] getArray() {

          return array;

    }



    public void setArray(double[] array) {

          this.array = array;

    }
    
    
}
      
      
      
      

