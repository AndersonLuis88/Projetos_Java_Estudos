package com.br.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ccon {

    private static String bb = "jdbc:mysql://localhost:3306/mydb";
    /**
     * O atributo driver representa a classe do driver JDBC que será usada na
     * conexão. Quando se utiliza outros bancos usa-se a classe apropriada a
     * cada banco.
     */
   private static final String driver = "com.mysql.jdbc.Driver";
    /**
     * Os atributos user e pass representam usuario e senha do
     * SGBD a ser usado na conexão
     */
   private static final String user = "root";
   private static final String pass = "374360";
   
   /**
    * O atributo con representa um objeto que
    * contém a conexão com o banco de dados em si
    */
   private static Connection con = null;
   
   /**
    * Metodo que retorna uma conexão com o banco de dados
    * @return objeto java.sql.Connection
    */
   public static Connection getCon(){
       if(con == null){
           try{
               //define a classe do driver a ser usado
               //class.forName(driver);
               //criação da conexão com o BD
                       con = DriverManager.getConnection(
                        bb, user, pass); 
           } catch (SQLException ex){
                           System.out.println("Error Connection: "+
                                   ex.getMessage());
                           }
       }
           return con;
   }
   /**
    * Método que recebe um comando SQL para ser executado
    * @param sql
    * @return um objeto java.sql.PreparedStatement
    */
       public static PreparedStatement getPreparedStatement(String sql){
           //teste se a conexão já foi criada
           if(con == null){
               //cria a conexão
               con = getCon();
               
           }
           try{
               //retorna um objeto java.sql.PreparedStatement
               return con.prepareStatement(sql);
           }catch (SQLException e){
               System.out.println("Error of Sql: "+
                       e.getMessage());
           }
           return null;
       }
   
}
