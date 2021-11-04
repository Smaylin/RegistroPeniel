
package Tabla;

import DAO.PrecioArticulos;
import DAO.ProductoDAO;
import VO.Articulos;
import VO.ProductoVO;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Tabla_Articulo {
    
    PrecioArticulos dao = null;

    public void visualizar_PrecioArticulo(JTable tabla){
        
               tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        dt.addColumn("Codigo");
        dt.addColumn("Descripcion");
        dt.addColumn("Precio_venta");
        dt.addColumn("Precio_Costo");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");
        
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        dao = new PrecioArticulos();
        Articulos vo = new Articulos();
        ArrayList<Articulos> list = dao.Listar_Articulo();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[6];
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
