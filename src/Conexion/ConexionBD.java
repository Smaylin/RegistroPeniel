package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;

        
public class ConexionBD {
Connection conectar = null;
 String BD="sql3434599";  

public Connection conectar(){
   
  try{
      Class.forName("com.mysql.jdbc.Driver");
      conectar =  DriverManager.getConnection("jdbc:mysql://sql550.main-hosting.eu:3306/u279581364_webpeniel","u279581364_peniel","S8092730489s");
      
      
//      JOptionPane.showInternalMessageDialog(null, "conexion exitosa", "Conexion", JOptionPane.INFORMATION_MESSAGE);
      
  }catch(ClassNotFoundException | SQLException e ){
       JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
  }
    
    return conectar;
    
   
}
}