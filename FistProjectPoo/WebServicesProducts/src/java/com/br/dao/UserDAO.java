package com.br.dao;

import com.br.database.ccon;
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
        
        Boolean retorno = false;
        try
        {
            PreparedStatement stmt = ccon.getPreparedStatement(sql);
            stmt.setString(1,users.getLogin_User());
            stmt.setString(2,users.getPass_User());
            stmt.setString(3,users.getPerfil_User());
            stmt.setString(4,users.getEmail_User());
            
            stmt.execute();
            
            if(stmt.executeUpdate()>0){
                return true;
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Database not connected" + ex);
            return false;
        }
        return retorno;
    }
    
    public boolean Alter(Users users)
    {
      
        
        String sql = "UPDATE INTO tb_user (login_User = ?,"
                + "pass_User = ?,perfil_User = ?,"
                + "email_User = ?) WHERE id_user = ?" ;
        try
        {
            PreparedStatement stmt = ccon.getPreparedStatement(sql);
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
        String sql = "SELECT * FROM tb_user";
        
        List<Users> rtn = new ArrayList<>();
        try
        {
            PreparedStatement stmt = ccon.getPreparedStatement(sql);
            ResultSet result = stmt.executeQuery();
            
            
            while(result.next())
            {
                Users users = new Users();
                users.setId_User(result.getInt("id_user"));
                users.setLogin_User(result.getString("login_User"));
                users.setPass_User(result.getString("pass_User"));
                users.setPerfil_User(result.getString("perfil_User"));
                users.setEmail_User(result.getString("email_User"));
                
                
                rtn.add(users);
            }
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Don't Possible list in Database" + ex);
            
        }
        return rtn;
    }
    
    public Users listLogin(Users user)
    {
        String sql = "Select * FROM tb_user WHERE login_User = ?";
        
        Users retorno = new Users();
        try
        {
            PreparedStatement stmt = ccon.getPreparedStatement(sql);
            stmt.setString(1, user.getLogin_User());
            
            ResultSet result = stmt.executeQuery();
            if(result.next())
            {
                
                retorno.setId_User(result.getInt("id_user"));
                retorno.setLogin_User(result.getString("login_User"));
                retorno.setPass_User(result.getString("pass_User"));
                retorno.setPerfil_User(result.getString("perfil_User"));
                retorno.setEmail_User(result.getString("email_User"));
                
                
                return retorno;
            }
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Don't Possible list in Database" + ex);
            
        }
        return retorno;
    }
}
