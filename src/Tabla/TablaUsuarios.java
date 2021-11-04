
package Tabla;

import DAO.UsuariosDao;
import Tablas.Tables;
import VO.UsuariosVo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class TablaUsuarios{
    UsuariosDao dao = null;
    
  
    
   

    public void visualizar_PagosMensuales(JTable tabla){
        
               tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Contraseña");
        dt.addColumn("Privilegio");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");
     
        
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
        
      
        
        

        dao = new UsuariosDao();
        UsuariosVo vo = new UsuariosVo();
        ArrayList<UsuariosVo> list = dao.Listar_Usuario();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getId_articulo();
                fila[1] = vo.getDescripcion();
                fila[2] = vo.getPrecio_venta();
                fila[3] = vo.getPrecio_costo();
                fila[4] = btn_modificar;
                fila[5] = btn_eliminar;
           
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
        }
    }
    
}
