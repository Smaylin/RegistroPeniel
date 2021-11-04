
package Tablas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class ColorCelda extends JTable {
    
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,int Column){
    
        Component componente = super.prepareRenderer(renderer,rowIndex, Column);
        if (getValueAt (rowIndex,Column).getClass().equals(Integer.class)){
            int valor = Integer.parseInt(this.getValueAt(rowIndex,Column).toString());
            
            if(valor <5){
                componente.setBackground(Color.red);
                componente.setForeground(Color.red);
            }
        }else{
            componente.setBackground(Color.white);
//            componente.setBackground(Color.black);
        }
        return componente;
    }
    
}
