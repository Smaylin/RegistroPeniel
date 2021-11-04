
package facturacion;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Login.Admin;
public class Sentenciasql_Usuarios {
    
    public String datos_usuarios(String usuario, String sentenciasql ){
        Admin ad= new Admin();
        String US = ad.TFNombre;
        String Co = ad.TFContraseña;
        
          String TFNombre = US;
        String TFContraseña  = Co;
        String url = " SELECT username,contraseña,privilegio " + "FROM usuarios WHERE  username = '"+TFNombre+"'";

        try {
            Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(url);
            ResultSet Query = ps.executeQuery();

            if (Query.next()){
                //SI EXISTE EL USUARIO
                String BDNombre= Query.getString("username");
                String BDContraseña= Query.getString("contraseña");
                String priv = Query.getString("privilegio");

                if(TFContraseña.equals(BDContraseña) & TFNombre.equals(BDNombre)){
                    JOptionPane.showInternalMessageDialog(null, "Bienvenido" + " " + BDNombre);
                }else{
                    JOptionPane.showInternalMessageDialog(null, "La contraseña no es correcta", "Conexion", JOptionPane.ERROR_MESSAGE);

                }

            }else{
                JOptionPane.showInternalMessageDialog(null, "El usuario no existe en la base de datos ", "Conexion", JOptionPane.ERROR_MESSAGE);

            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        
     }
        return TFNombre;
     }
    
    
}
