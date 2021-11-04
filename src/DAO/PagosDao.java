
package DAO;

import Conexion.Conexion;
import Conexion.ConexionPagos;
import VO.UsuariosVo;
import VO.PagosVo2;
import com.sun.jdi.connect.spi.Connection;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PagosDao {
    ConexionPagos cn = new ConexionPagos();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public PagosVo2 login(String usuario,String clave){
        String sql = "Select * FROM Alumnos";
        PagosVo2 us = new PagosVo2 ();
     try {
            con = cn.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2, clave);
                    
        }catch (Exception e){
            
        } 
    
        return null;
    
    
    }
//       ArrayList<PagosVo> list = new ArrayList<PagosVo>();
//     public ArrayList<PagosVo> Listar_Pagos(){
//     public List ListtarPagos(){
//        List<PagosVo2> ListtarPagos = new ArrayList();
//      
//        String sql = "Select * FROM Alumnos";
//        try {
//            con = cn.getConexion();
//            con.PrepareStatement(sql);
//            
//                    
//        }catch (Exception e){
//            
//        }
//        
//        return null;
//     
//        
//    }
    
}
