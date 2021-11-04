
package facturacion;


public class Control_Usuarios {
    
    private String usuario;
    private Sentencias_sql sen;
     private String Documento;
    
    //Constructor vacio
    public Control_Usuarios(){
    
}
    
   //Constructor con argumentos
       public Control_Usuarios(String nombre){
    
}       
       
       
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    public String datos_usuarios(){
      String result;
       result = sen.datos_string("nombres", "select nombres from cliente where Documento='"+this.Documento+"';");
       return result;
        
    
    }
    
}
