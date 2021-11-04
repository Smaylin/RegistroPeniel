/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
    
//    com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'sql3429613.Cliente' doesn't exist
/**
 *
 * @author ANDRES
 */
public class control_cliente extends Persona2 {
private Sentencias_sql sql; 

  
    public control_cliente(String documento,  String nombres, String apellidos ) {
        super(documento, nombres, apellidos );
        sql = new Sentencias_sql();
    }   
    
        
   
    public boolean ingresar_cliente()
    {               
        
            String datos[] = {documento,nombres,apellidos};           
            return sql.insertar(datos, "insert into cliente(Documento, Nombres, Apellidos) values(?,?,?)");
                      
                
    }
    
  
    
    
    public Object[][] consulta_clientes(){
        String[] columnas={"Documento","Descripcion","Nombres","Apellidos","Direccion","Nombre_ciudad","Telefono"};
        Object[][] datos = sql.GetTabla(columnas, "cliente", "select Documento,Descripcion,Nombres,Apellidos,Direccion,Nombre_ciudad,Telefono from cliente,ciudad,tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad;");
        return datos;
    }
     
    
    
}