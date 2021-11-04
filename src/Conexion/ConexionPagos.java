
package Conexion;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConexionPagos {
    Connection con;
    public Connection getConexion(){
        try{
            String db ="jdbc:mysql://sql550.main-hosting.eu:3306/u279581364_webpeniel";
//            con = DriverManager.getConnection(db, "u279581364_peniel","S8092730489s");
            con = (Connection) DriverManager.getConnection(db,"u279581364_peniel","S8092730489s");
            return con;
            
        }catch (SQLException e){
            System.out.print(e);
        }
            return null;
        }

    public PreparedStatement prepareStatement(String select__from_Alumnos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
