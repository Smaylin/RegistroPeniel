
package Conexion;

import PermisosAdmin.PerAdmin;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConexionConsultas {

   
    String tipo;

    public ResultSet SeleccionarDocumento(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public class Conexion{
        
    }
    
    public Connection Conectar(){
        Connection cn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://sql550.main-hosting.eu:3306/u279581364_webpeniel","u279581364_peniel","S8092730489s");
                    
        } catch (Exception e) {
        }
        return cn;
    }
  
    
    
    public ResultSet SeleccionarUsuario(String nombre){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT * FROM Alumnos WHERE Nombre=?");
            pst.setString(1,nombre);

            
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
    }
     
    public ResultSet SeleccionarUsuarioCurso(String curso){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT * FROM Alumnos WHERE Curso=?");
            pst.setString(1,curso);

            
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
    }
    
    public ResultSet Seleccionarfecha(String fecha1, String fecha2){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        System.out.println(fecha1);
//        if(){
//        }
        try {
            cn = Conectar();
            pst = cn.prepareStatement ("CALL buscar(?, ?)");
            pst.setString(1,fecha1);
            pst.setString(2,fecha2);
            System.out.println(fecha1);
            System.out.println(fecha2);
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
              System.out.println(fecha1);
        }
        return rs;
        
    }
    
        public ResultSet SeleccionarId(String nombre){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT * FROM Alumnos WHERE id=?");
            pst.setString(1,nombre);
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
    }
        
         public ResultSet SeleccionarHorario(String nombre, String curso,String fecha1, String fecha2){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT * FROM Alumnos WHERE Horario =? AND Curso = ? AND `estado` BETWEEN ? AND ?");
            pst.setString(1,nombre);
            pst.setString(2,curso);
            pst.setString(3,fecha1);
            pst.setString(4,fecha2);
            
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
    }
    
        
        
         public ResultSet SeleccionarTodo(String session){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT * FROM Alumnos");
//            pst.setString(1,nombre);
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
         }
//        public ResultSet SeleccionarTotal (){
//        Connection cn;
//        PreparedStatement pst;
//        ResultSet rs = null;
////        if(){
////        }
//        try {
//            cn = Conectar();
//            pst = cn.prepareStatement("select  sum(total) from detalle_factura ;");
////            pst.setString(1,nombre);
//            rs= pst.executeQuery();
//        } catch (Exception e) {
//            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
//              System.out.print(e);
//        }
//        return rs;
//
//    }
        
        
        
        
        
        public static  ArrayList<String> llenarCombo(){
        Connection cn;
        PreparedStatement pst = null;
        ResultSet rs = null ;
        ArrayList<String> lista = new  ArrayList<String>();
        String g = "SELECT * FROM usuarios ";
            try { 
//            pst = cn.prepareStatement("SELECE * FROM usuarios ");
                rs = pst.executeQuery(g);
            } catch (Exception e) {
                System.out.print("No correcto");
            }
            try {
                while (rs.next())
                    lista.add(rs.getString("username"));
            } catch (Exception e) {
            }
            
            
         return lista;
        }
        
}
