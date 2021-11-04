
package Conexion;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Conexion {
    
    
    public static Connection obtenerConexion(){   
 Connection conectar = null;
 String BD="u279581364_Web";  

  try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      conectar = DriverManager.getConnection("jdbc:mysql://sql550.main-hosting.eu:3306/u279581364_webpeniel","u279581364_peniel","S8092730489s");
      
//      JOptionPane.showInternalMessageDialog(null, "conexion exitosa", "Conexion", JOptionPane.INFORMATION_MESSAGE);
      
  }catch(ClassNotFoundException | SQLException e ){
       JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
  }
    
    return conectar;
    
   
}
    
}
