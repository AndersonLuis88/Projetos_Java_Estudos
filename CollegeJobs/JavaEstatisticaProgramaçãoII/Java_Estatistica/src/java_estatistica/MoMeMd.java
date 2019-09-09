
package java_estatistica;
import java.util.Arrays;

import java.util.HashMap;


/**
 *
 * @author Anderson Luis
 */
public class MoMeMd {            
    
    private double array[];
	 
    public double media() {

          double tt = 0;

          for (int cc = 0; cc < array.length; cc++)

                tt += array[cc];

          return tt / array.length;

    }
   

    public double media(double array[]) {

          double tt = 0;

          for (int cc = 0; cc < array.length; cc++)

                tt += array[cc];

          return tt / array.length;

    }
  
    public void ordenar() {

          Arrays.sort(array);

    }



    public void imprimeArray() {

          System.out.print("\nElementos do Array: ");

          for (int cc = 0; cc < array.length; cc++)

                System.out.print(array[cc] + " ");

    }

    public double mediana() {

          this.ordenar();

          int tipo = array.length % 2;

          if (tipo == 1) {

                return array[((array.length + 1) / 2) - 1];

          } else {

                int m = array.length / 2;

                return (array[m - 1] + array[m]) / 2;

          }

    }



    public double moda() {



          HashMap map = new HashMap();

          Integer i;

          Double moda = 0.0;

          Integer atual, maior = 0;

          for (int cc = 0; cc < array.length; cc++) {

                i = (Integer) map.get(new Double(array[cc]));



                if (i == null) {

                      map.put(new Double(array[cc]), new Integer(1));

                } else {

                      map.put(new Double(array[cc]), new Integer(i.intValue() + 1));

                      atual = i.intValue() + 1;

                      if (atual > maior) {

                           maior = atual;

                           moda = new Double(array[cc]);



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
      
      
      
      

