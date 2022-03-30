/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import  java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author 3° Ano Info
 */
public class ConexaoBD {
     public static String driver = "com.mysql.jdbc.Driver";
    public static String server = "localhost";
    public static String bd = "db_checkin";
    public static String username = "root";
    public static String senha = "";
    Connection conexao;

   public Connection conectar() throws SQLException{
      
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://"+server+"/"+bd+"?user="+username+"&password="+senha);
            this.conexao = con;
            
           // JOptionPane.showMessageDialog(null,"Conectado");
        } catch (Exception ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
      return conexao;
   }
   public ResultSet consultar(String query) throws SQLException{
        Statement ps = this.conexao.createStatement();
        ResultSet rs = ps.executeQuery(query);
        return rs;
   }   
}
        

