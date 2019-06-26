package consumerws;

import consumer.Product.HttpProduct;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsumerWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HttpProduct httpP = new HttpProduct();
        try {
            String url = "";
            httpP.sendGET(url);
        } catch (IOException ex) {
            Logger.getLogger(ConsumerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
