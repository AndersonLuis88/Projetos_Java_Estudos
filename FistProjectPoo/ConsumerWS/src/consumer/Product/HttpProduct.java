package consumer.Product;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpProduct {
    private final String USER_AGENT = "Mozilla/5.0";
    
    public void sendGET(String url) throws MalformedURLException, IOException{
        
        
        URL obj = new URL(url);
        
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        
        conn.setRequestMethod("GET");
        
        conn.setRequestProperty("User-Agent", USER_AGENT);
        
        int codeResponse = conn.getResponseCode();
        System.out.println("\n Enviando um método 'GET' requisitado para a URL: " + url);
        
        System.out.println("\n Código respondido: " + codeResponse);
        BufferedReader in = new BufferedReader (new InputStreamReader(conn.getInputStream()));
        
        String inputLine;
        StringBuffer answer = new StringBuffer();
        
        while((inputLine = in.readLine()) != null){
            answer.append(inputLine);
        }
        in.close();
        System.out.println(answer.toString());
    }
    
    public void sendPost() throws MalformedURLException, IOException{
        String url = "";
        
        URL obj = new URL(url);
        
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        
        conn.setRequestMethod("POST");
        
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.addRequestProperty("Accept-Language", "en-US,en;q=0.5");
        
        String urlParametros = "sn=C0268416DRJM&cn-&locale-&caller-&num-12345";
        
        conn.setDoOutput(true);
        DataOutputStream wc = new DataOutputStream(conn.getOutputStream());
        wc.writeBytes(urlParametros);
        wc.flush();
        wc.close();
        
        int codeResponse = conn.getResponseCode();
        System.out.println("\n Enviando 'Post' requerido para a url: " + url);
        System.out.println("Post parametros: " + urlParametros);
        System.out.println("Resposta do código: " + codeResponse);
        
        BufferedReader in = new BufferedReader (new InputStreamReader(conn.getInputStream()));
        
        String inputLine;
        StringBuffer answer = new StringBuffer();
        
        while((inputLine = in.readLine()) != null){
            answer.append(inputLine);
        }
        in.close();
        System.out.println(answer.toString());
    }
}
