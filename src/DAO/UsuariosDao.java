
package DAO;

import Conexion.Conectar;
import Tablas.Tables;
import VO.UsuariosVo;
import java.awt.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuariosDao {
    
    
    
    
    
    public ArrayList<UsuariosVo> Listar_Usuario(){
//        Tables color = new Tables();
//        tabla.setDefaultRenderer(tabla.getCoumnClass(0),color);
        ArrayList<UsuariosVo> list = new ArrayList<UsuariosVo>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuarios;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                UsuariosVo vo = new UsuariosVo();
                vo.setId_articulo(rs.getInt(1));
                vo.setDescripcion(rs.getString(2));
                vo.setPrecio_venta(rs.getString(3));
                vo.setPrecio_costo(rs.getString(4));
//                vo.setCurso(rs.getString(9));
//                vo.setHorario(rs.getString(10));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }

    
//       public List ListstarPagos(){
//        
//        List<PagosVo>listaPagos = new ArrayList();
////        List<PagosVo> list = new ArrayList<PagosVo>();
//        return null;
//     
//        
//    }
    

/*Metodo agregar*/
    public void Agregar_Usuario(UsuariosVo vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO usuarios (username,contraseña,privilegio,) VALUES(NULL,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getDescripcion());
            ps.setString(2, vo.getPrecio_venta());
//            ps.setString(3, vo.getPrecio_costo());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


/*Metodo Modificar*/
    public void Modificar_Usuario(UsuariosVo vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE usuarios SET username = ?, contraseña = ?, privilegio = ? WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getDescripcion());
            ps.setString(2, vo.getPrecio_venta());
            ps.setString(3, vo.getPrecio_costo());
            ps.setInt(4, vo.getId_articulo());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


/*Metodo Eliminar*/
    public void Eliminar_Usuario(UsuariosVo vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM usuarios WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getId_articulo());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
    
   
}
