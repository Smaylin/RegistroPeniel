/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conectar;
import VO.Articulos;
import VO.ProductoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author smail
 */
public class PrecioArticulos {
    
    
     public ArrayList<Articulos> Listar_Articulo(){
        ArrayList<Articulos> list = new ArrayList<Articulos>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM articulo;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Articulos vo = new Articulos();
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


/*Metodo agregar*/
    public void Agregar_Articulo(Articulos vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO articulo (id_articulo,descipcion,precio_venta,precio_costo) VALUES(NULL,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getDescripcion());
            ps.setString(2, vo.getPrecio_venta());
            ps.setString(3, vo.getPrecio_costo());
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
    public void Modificar_Articulo(Articulos vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE articulo SET descripcion = ?, precio_venta = ?, precio_costo = ? WHERE id_articulo = ?;";
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
    public void Eliminar_articulo(Articulos vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM articulo WHERE id_articulo = ?;";
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
