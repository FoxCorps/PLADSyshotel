/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagemdao;


import conexao.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import listagemdto.adminDTO;


public class adminDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;  
  
    ArrayList<adminDTO> lista = new ArrayList<>();
    
    public ArrayList<adminDTO> ListarAdmin(){
        String sql = "SELECT * FROM tb_admin";
        
        try {
           conn = new ConexaoBD().conectar();
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           
            while (rs.next()) {
                adminDTO objlistagemdto = new adminDTO();
                objlistagemdto.setId(rs.getInt("id_admin"));
                objlistagemdto.setUser(rs.getString("user"));
                objlistagemdto.setSenha(rs.getString("senha"));
                
                lista.add(objlistagemdto);
            }
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Funcionario DAO ListarAdmin: "+erro);
        }
        return lista;
    }
    public ArrayList<adminDTO> PesquisarAdmin(String user){
        adminDTO objlistagemdto = new adminDTO();
        String sql = "SELECT * FROM tb_admin where user LIKE ?";
       
        
        try {
           conn = new ConexaoBD().conectar();
           pstm = conn.prepareStatement(sql);
           pstm.setString(1,"%"+user+"%");
           rs = pstm.executeQuery();
           
           
            while (rs.next()) {
                
                objlistagemdto.setId(rs.getInt("id_admin"));
                objlistagemdto.setUser(rs.getString("user"));
                objlistagemdto.setSenha(rs.getString("senha"));
                
                lista.add(objlistagemdto);
            }
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Funcionario DAO ListarAdmin: "+erro);
        }
        return lista;
    }
     public void alterarAdmin(String id, String user, String senha){
        String sql = "UPDATE tb_admin SET user = ?, senha = ? WHERE id_admin = ?";
        
        try {
           conn = new ConexaoBD().conectar();
           pstm = conn.prepareStatement(sql);
           pstm.setString(1,user);
           pstm.setString(2,senha);
           pstm.setString(3,id);
           
           pstm.executeUpdate();
           
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Funcionario DAO ListarAdmin: "+erro);
        }
        
    }
     
          public void deletarAdmin(String id){
        String sql = "DELETE FROM tb_admin WHERE id_admin = ?";
        
        try {
           conn = new ConexaoBD().conectar();
           pstm = conn.prepareStatement(sql);
           pstm.setString(1,id);
       
           
           pstm.executeUpdate();
           
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Funcionario DAO ListarAdmin: "+erro);
        }
        
    }
}
