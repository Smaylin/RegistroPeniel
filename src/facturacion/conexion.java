/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;
import java.sql.*;

/**
 *
 * @author ANDRES
 */
public class conexion {

   
//   "jdbc:mysql://localhost/facturacion"
//   com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'sql3429613.Cliente' doesn't exist
   private final String url = "jdbc:mysql://sql550.main-hosting.eu:3306/u279581364_webpeniel?autoReconnect=true&useUnicode=yes";
    PreparedStatement psPrepararSentencia;
    Connection con = null;
   

    
    public conexion() {
     try{  
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = DriverManager.getConnection(url,"u279581364_peniel","S8092730489s");
         if (con!=null){
            System.out.println("Conexión a base de datos facturacion. listo");
         }
      }
         catch(SQLException e)
         {
         System.out.println(e);
         }
         catch(ClassNotFoundException e)
         {
          System.out.println(e);
         }
    }
     /**
     *
     * @return
     */
    public Connection conectado(){
      return con;
}

    public void desconectar(){
      con = null;
      System.out.println("conexion terminada");

    } 

    
}
