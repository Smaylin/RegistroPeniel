/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Login.Admin.*;
/**
 *
 * @author ANDRES
 */
public class control_existencias 
{
     private Sentencias_sql sen;
     private String Documento;
     private  String numero_factura="";
     private String docclientejTextField1 = "";

    public String getDocclientejTextField1() {
        return docclientejTextField1;
    }

    public void setDocclientejTextField1(String docclientejTextField1) {
        this.docclientejTextField1 = docclientejTextField1;
    }
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getId_cliente() {
        return Documento;
    }

    public void setId_cliente(String id_cliente) {
        this.Documento = Documento;
    }
     private String No_documento;

    public String getId_proveedor() {
        return No_documento;
    }

    public void setId_proveedor(String id_proveedor) {
        this.No_documento = No_documento;
    }

    public String getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(String id_articulo) {
        this.id_articulo = id_articulo;
    }
     private String id_articulo;
     
     public control_existencias()
     {
         sen = new Sentencias_sql();
     }
     
     public boolean existe_cliente( String cod)
     {
         
        this.Documento = cod;
        return sen.existencias(cod, " from cliente where Documento='"+cod+"';");
      
    }
     public boolean existe_proveedor( String id_prov)
     {
        this.No_documento = id_prov;
        return sen.existencias(id_prov, " from proveedor where No_documento='"+id_prov+"';");
     
     }
     public boolean existe_articulo( String idart)
     {
        this.id_articulo = idart;
        return sen.existencias(idart, " from articulo where id_articulo='"+idart+"';");

}
     
     
     
   
     
     public String ingresa_nombre_Cliente()
     { 
       String result;
       result = sen.datos_string("nombres", "select nombres from cliente where Documento='"+this.Documento+"';");
       return result;
    }
     public String ingresa_apellidos_Cliente()
     { 
       String resultado;
       resultado = sen.datos_string("apellidos", "select apellidos from cliente where Documento='"+this.Documento+"';");
       return resultado;
    }
     
     
//         public String ingresaNivel()
//     { 
//       String resultado;
//       resultado = sen.datos_string("nivel", "select nivel from detalle_factura where cod_factura='"+this.Documento+"';");
//       return resultado;
//    }
     
     public String GenerarNumeroFactura()
     {
        String codigo = "FACT-";
        for(int i=1; i<=6;i++){
           int num = (int)((Math.random()*(5))+6);
           codigo = codigo  +  num;
        }
        numero_factura = codigo;
        return codigo;
    }
     
       public String GenerarID(String codigo)
     {
        String cod = codigo +"-";
        for(int i=1; i<=6;i++){
           int num = (int)((Math.random()*(5))+1);
           cod = cod  +  num;
        }
        docclientejTextField1 = cod;
        return cod;
    }
       
       
//       public String GenerarID()
//     {
//        String cod = "peniel";
//        for(int i=1; i<=6;i++){
//           int num = (int)((Math.random()*(5))+6);
//           cod = cod  +  num;
//        }
//        docclientejTextField1 = cod;
//        return cod;
//    }
     
     public void registrar_factura(String Nnm_factura, String cliente,String Nombre_empleado, String fecha_facturacion, String cod_formapago,String cliente_factura)
     {
        String[] datos = {Nnm_factura, Documento, Nombre_empleado,cliente,fecha_facturacion,cod_formapago,cliente_factura};
        sen.insertar(datos, "insert into factura(Nnm_factura,cliente,cod_cliente,Nombre_empleado,fecha_facturacion, cod_formapago) values(?,?,?,?,?,?);");
    }
     //////////////////////////////////////////////FACTURA////////////////////////////////////////////////////
      public boolean update_factura(String factura, String total, String iva)
      {
          String campos[] = {total, iva,factura};           
          return sen.insertar(campos, "update factura set total_factura=?, IVA=? where Nnm_factura=?;");
      
      }
      
      public boolean update_stock(String stock, String id_articulo)
      {
          String campos[] = {stock,id_articulo};           
          return sen.insertar(campos, "update articulo set stock=stock+? where id_articulo=?;");
      
      }
     
     
     public Object[] combox(String tabla, String campo)
     {
        return sen.poblar_combox(tabla, campo, "select "+campo+" from "+tabla+";");
     }
     
     public Object[][] datos_articulo(String id_articulo)
     {
        String[] columnas={"descripcion","precio_venta","stock"};
        Object[][] resultado = sen.GetTabla(columnas, "articulo", "select descripcion, precio_venta, stock from articulo where id_articulo='"+id_articulo+"';");
        return resultado;
      }
     
     public Object[][] datos_cliente(String id_cliente)
     {
        String[] columnas={"Documento","Descripcion","Nombres","Apellidos","Direccion","Nombre_ciudad","Telefono"};
        Object[][] resultado = sen.GetTabla(columnas, "cliente", "select * from cliente, ciudad, tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad and documento='"+id_cliente+"';");
        return resultado;
      }
      public Object[][] datos_detallefactura(String numero_factura)  ////////////////////////////////////////DETALLE_FACTURA/////////////////////////////////////////////////////////////////////////////////////////dfs/////////////////
     {
        String[] columnas={"cliente","vendedor", "cod_factura","cod_articulo","descripcion","nivel","cantidad","total"};
        Object[][] resultado = sen.GetTabla(columnas, "detalle_factura where cod_factura='"+numero_factura+"';", "select * from detalle_factura,articulo where id_articulo = cod_articulo and cod_factura='"+numero_factura+"';");
        return resultado;
      }
      
      
       public Object[][] DatosAlumnos(String seccion)  ////////////////////////////////////////Seleccionado de la tabla alumnos/////////////////////////////////////////////////////////////////////////////////////////dfs/////////////////
     {
        String[] columnas={"cliente","vendedor", "cod_factura","cod_articulo","descripcion","nivel","cantidad","total"};
        Object[][] resultado = sen.GetTabla(columnas, "detalle_factura where cod_factura='"+numero_factura+"';", "select * from detalle_factura,articulo where id_articulo = cod_articulo and cod_factura='"+numero_factura+"';");
        return resultado;
      }
      
      public Object[][] consulta_factura(String id)
       {
        String[] columnas={"Nnm_factura","Nombres","Apellidos","Nombre_empleado","Fecha_facturacion","Descripcion_formapago","total_factura","IVA"};
        Object[][] resultado = sen.GetTabla(columnas, "cliente", "select * from cliente, factura, forma_de_pago where documento=cod_cliente and cod_formapago=id_formapago and documento='"+id+"';");
        return resultado;
       }
      
       public boolean devolucion(String cod_detallefactura, String cod_detallearticulo, String Motivo, String fecha_devolucion, String cantidad)
       {
        String[] columnas={cod_detallefactura,cod_detallearticulo,Motivo,fecha_devolucion,cantidad};
        return sen.insertar(columnas, "insert into devolucion(cod_detallefactura,cod_detallearticulo,Motivo,fecha_devolucion,cantidad) values(?,?,?,?,?)");
        
       }      
       
    
     
       
    
    public boolean registrar_producto(String Nnm_factura,String cliente_factura, String vend_fact, String id_articulo,String nivel,String cantidad, String fecha_fact,String total,String modoPago)
        {
        String[] datos = {Nnm_factura,cliente_factura,vend_fact,id_articulo,nivel,cantidad,fecha_fact,total,modoPago};
        
        String[] datosP = {cantidad, id_articulo};
        if(sen.insertar(datosP, "update articulo set stock=stock-? where id_articulo=?;"))
        {
            return sen.insertar(datos, "insert into detalle_factura(cod_factura,cliente,Vendedor,cod_articulo,nivel,cantidad,Fecha_facturacion,total,modoPago) values(?,?,?,?,?,?,?,?,?);");
        }
        else
        {
            return false;
        }
    }
        
        public Double total_factura(String numfact)
        {
        return sen.datos_totalfactura("total", "select round( sum( total ) , 2 ) as total from detalle_factura where cod_factura='"+numfact+"';");
    }
        
        
        
        
          public boolean registrar_Curso(String Nnm_factura,String cliente_factura, String vend_fact, String id_articulo, String total,String nivel)
        {
        String[] datos = {Nnm_factura,cliente_factura,vend_fact,id_articulo,total,nivel};
        
        String[] datosP = {total, Nnm_factura};
        if(sen.insertar(datosP, "update detalle_factura set total= total + ? where cod_factura=?;"))
        {
            return sen.insertar(datos, "insert into detalle_factura(cod_factura,cliente,Vendedor,cod_articulo,cantidad,total,nivel) values(?,?,?,?,?,?,?);");
        }
        else
        {
            return false;
        }
    }
        
       
        
  
        
}

