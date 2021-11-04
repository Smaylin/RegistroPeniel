package PermisosAdmin;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRendererNum extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

//        
//        String num = (String) table.getValueAt(row, 5  );
//        int numEntero = Integer.parseInt(num);
//        
//        
//        String num2= (String) table.getValueAt(row, 2 );
//        int numEntero2 = Integer.parseInt(num2);
////        float TestTreatmentID = Integer.parseInt((String) table.getValueAt(row, column));
        

    setEnabled(table == null || table.isEnabled());
        {if ("Sin pagar".equals((table.getValueAt(row,column)))) 
            setBackground(Color.RED);
        else
            setBackground(null);
        }
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);     
        return this;
    }






        
//        if (numEntero  >90  ) {
//            this.setBackground(Color.RED);
//            
//        }if(numEntero2 <1){
//            this.setBackground(Color.RED);
//        }  
//        
//        else {
//            this.setBackground(Color.GREEN);
//        }
//        
////        
////        else {
////            this.setBackground(Color.GREEN);
////        }
////        
//        
//        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
//    }

}

        