package com.br.dao;

import com.br.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UserDAO {
    
    private Connection connection;
    //get e set conection
    public Connection getconnection()
    {
        return connection;
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    //Insert
    public boolean Insert(Users users)
    {
      
        
        String sql = "INSERT INTO tb_user (login_User,"
                + "pass_User,perfil_User,"
                + "email_User) VALUES (?,?,?)" ;
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,users.getLogin_User());
            stmt.setString(2,users.getPass_User());
            stmt.setString(3,users.getPerfil_User());
            stmt.setString(4,users.getEmail_User());
            
            stmt.execute();
            return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Database not connected" + ex);
            return false;
        }
        
    }
    
    public boolean Alter(Users users)
    {
      
        
        String sql = "UPDATE INTO tb_user (login_User = ?,"
                + "pass_User = ?,perfil_User = ?,"
                + "email_User = ?) WHERE id_user = ?" ;
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,users.getLogin_User());
            stmt.setString(2,users.getPass_User());
            stmt.setString(3,users.getPerfil_User());
            stmt.setString(4,users.getEmail_User());
            stmt.setInt(5,users.getId_User());
            
            
            stmt.execute();
            return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Don't Possible alter in Data Base" + ex);
            return false;
        }
        
    }
    
    //Select
    public List<Users> list()
    {
        String sql = "Select * FROM tb_user";
        
        List<Users> retorno = new ArrayList<>();
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            
            while(result.next())
            {
                Users user = new Users();
                user.setId_User(result.getInt("id_user"));
                user.setLogin_User(result.getString("login_User"));
                user.setPass_User(result.getString("pass_User"));
                user.setPerfil_User(result.getString("perfil_User"));
                user.setEmail_User(result.getString("email_User"));
                
                //add list
                retorno.add(user);
            }
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Don't Possible list in Database" + ex);
            
        }
        return retorno;
    }
}
