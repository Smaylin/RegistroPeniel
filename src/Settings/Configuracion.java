
package Settings;

import static Conexion.Conexion.obtenerConexion;
import Conexion.ConexionBD;
import Conexion.ConexionConsultas;
import Imprimir.ImprimirEstudiantes;
import PermisosAdmin.PerAdmin;
import Visual.CrudUsuarios;
import Visual.Visual;
import Visual.visual2;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class Configuracion extends javax.swing.JFrame {
    ConexionBD mysql = new ConexionBD(); 
    Connection conect= mysql.conectar();    
  
    public Configuracion() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/logoPeniel2.png")).getImage());
        this.setResizable(false);
        mostrarDatos();
        this.setLocationRelativeTo(null);
         
    }

    
    public static String convertTostring(Date Date)
        {
            DateFormat df;
            String fech = null;
//            df = new SimpleDateFormat("yyyy/MM/d");
            df = new SimpleDateFormat("dd/MM/yyyy");
            fech = df.format(Date);
            return fech;
        }
    
      public ResultSet SeleccionarUsuario(String nombre){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = obtenerConexion();
            pst = cn.prepareStatement("SELECT * FROM clientes WHERE nombre=?");
            pst.setString(1,nombre);
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
    }
      
      
      //Este metodo convierte la fecha del JDateChooser a String para guardarlo en la base de datos
//    public String obtener_fecha() {
//        String fecha = "";
//        try {
////            fecha = txtfecha.getCalendar().get(Calendar.YEAR) + "/" + (txtfecha.getCalendar().get(Calendar.MONTH) + 1) + "/" + txtfecha.getCalendar().get(Calendar.DAY_OF_MONTH);
//            fecha = Calendario.getCalendar().get(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH) + "/" + (Calendario.getCalendar().get(Calendar.MONTH) + 1) + "/" + Calendario.getCalendar().get(Calendar.YEAR);
//            System.out.println(fecha + "Fecha 1");
//        } catch (Exception ex) {
//            System.out.println("Error al obtener fecha " + ex.getMessage());
//        }
//        return fecha;
//    }
//
//    //Este metodo es similar al anterior, pero lo usamos para cualquier JDateChooser
//    public String obtener_fecha2(JDateChooser Calendario) {
//        String fecha = null;
//        try {
////            fecha = txtfecha.getCalendar().get(Calendar.YEAR) + "/" + (txtfecha.getCalendar().get(Calendar.MONTH) + 1) + "/" + txtfecha.getCalendar().get(Calendar.DAY_OF_MONTH);
//            fecha = Calendario.getCalendar().get (Calendar.DATE ) + "/" + (Calendario.getCalendar().get(Calendar.MONTH) + 1) + "/" + Calendario.getCalendar().get(Calendar.YEAR);
//            System.out.println(fecha + "Fecha 2");
//        } catch (Exception ex) {
//            System.out.println("Error al obtener fecha " + ex.getMessage());
//        }
//        return fecha;
//    }
      
      
      
      
      
      
      
      public ResultSet Seleccionarfecha(String fecha, String fecha2){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
//        if(){
//        }
        try {
            cn = obtenerConexion();
            pst = cn.prepareStatement("SELECT * FROM clientes WHERE nombre=?");
            pst.setString(1,fecha);
            rs= pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
              System.out.print(e);
        }
        return rs;
        
    }
      
      
      
    
  public void mostrarTotal(){

        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Total de todas las ventas");

        table.setModel(tcliente);
  
        String [] datos = new String[1];

        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("select  sum(total) from detalle_factura ;");

            
            while(resultado.next()){
                datos[0] = resultado.getString(1);
          
                
                tcliente.addRow(datos);
            }
       

            table.setModel(tcliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
    }
  
  
  
  public void mostrarDatos(){
//      String fecha,fecha2;
//      fecha = convertTostring(Calendario.getDate());
//      fecha2 = convertTostring(Calendario2.getDate());
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Cod_facura");
        tcliente.addColumn("Cliente");
        tcliente.addColumn("Vendedor");
        tcliente.addColumn("Fecha_facuras");
        tcliente.addColumn("total");
//        tcliente.addColumn("Tel_Contanto");
//        tcliente.addColumn("Curso");
//        tcliente.addColumn("Horario");
//    "select total from detalle_factura where Fecha_facturacion between '"+fecha+"'   and '"+fecha2+"' ;"
        table.setModel(tcliente);
//        txtID.getText();
//        Object selectedItem = ComboBoxBuscar.getSelectedItem();
//        String item = (String) ComboBoxBuscar.getSelectedItem();
//        
        String [] datos = new String[8];

        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("select * from detalle_factura");

            
            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(7);
                datos[4] = resultado.getString(8);
//                datos[5] = resultado.getString(8);
//                datos[6] = resultado.getString(9);
//                datos[7] = resultado.getString(10);
                
                
                tcliente.addRow(datos);
            }
       

            table.setModel(tcliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
    }
  
  
  
  
  
  
  
  
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Calendario2 = new com.toedter.calendar.JDateChooser();
        Calendario = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        btVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btimprimir = new javax.swing.JButton();
        btCrud = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btVendedores = new javax.swing.JButton();
        btCrud3 = new javax.swing.JButton();
        btTotal = new javax.swing.JButton();
        btTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuracion");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        Calendario2.setDateFormatString("MM/dd/yyyy ");

        Calendario.setDateFormatString("MM/dd/yyyy ");

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel1.setText("Filtrar facturas");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Desde:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Hasta:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btVolver.setText("Volver");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(114, 190, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        btimprimir.setBackground(new java.awt.Color(114, 190, 240));
        btimprimir.setForeground(new java.awt.Color(0, 0, 0));
        btimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2849806-copy-interface-multimedia-print-printer_107972.png"))); // NOI18N
        btimprimir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimir cursos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btimprimir.setContentAreaFilled(false);
        btimprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btimprimir.setOpaque(true);
        btimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btimprimirActionPerformed(evt);
            }
        });

        btCrud.setBackground(new java.awt.Color(114, 190, 240));
        btCrud.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        btCrud.setForeground(new java.awt.Color(0, 0, 0));
        btCrud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/school_students_icon_144607.png"))); // NOI18N
        btCrud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar estudiantes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btCrud.setContentAreaFilled(false);
        btCrud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCrud.setOpaque(true);
        btCrud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrudActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1.png"))); // NOI18N

        btVendedores.setBackground(new java.awt.Color(114, 190, 240));
        btVendedores.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        btVendedores.setForeground(new java.awt.Color(0, 0, 0));
        btVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarios.png"))); // NOI18N
        btVendedores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar usuarios\n\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btVendedores.setContentAreaFilled(false);
        btVendedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVendedores.setOpaque(true);
        btVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendedoresActionPerformed(evt);
            }
        });

        btCrud3.setBackground(new java.awt.Color(114, 190, 240));
        btCrud3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        btCrud3.setForeground(new java.awt.Color(0, 0, 0));
        btCrud3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/products_items_icon_142979.png"))); // NOI18N
        btCrud3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar productos\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btCrud3.setContentAreaFilled(false);
        btCrud3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCrud3.setOpaque(true);
        btCrud3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrud3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCrud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btVendedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCrud3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btimprimir)
                .addGap(18, 18, 18)
                .addComponent(btCrud, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCrud3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        btTotal.setText("Mostrar todo el total");
        btTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTotalActionPerformed(evt);
            }
        });

        btTodo.setText("Mostar todo");
        btTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodoActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Calendario2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Calendario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btTodo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btVolver)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(btTotal)
                                .addGap(18, 18, 18)
                                .addComponent(btTodo)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(Calendario2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel3))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel2))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(73, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calendario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btTotal)
                            .addComponent(btTodo))
                        .addGap(36, 36, 36)
                        .addComponent(btVolver))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
//        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy ");  
//        Date date = new Date();  
//        System.out.println(formatter.format(date));  
//         fecha1.setText(formatter.format(date));
        
        
        String fecha1 =((JTextField)Calendario.getDateEditor().getUiComponent()).getText();
        String fecha2 = ((JTextField)Calendario2.getDateEditor().getUiComponent()).getText();
//        String fecha2 = obtener_fecha2(Calendario2);
        ConexionConsultas cn = new ConexionConsultas();
        ResultSet rs = cn.Seleccionarfecha(fecha1, fecha2);
        DefaultTableModel dfmbuscar = new DefaultTableModel();
        this.table.setModel(dfmbuscar);
        dfmbuscar.setColumnIdentifiers(new Object [] {"Cod_Factura","Cliente","Vendedor","Fecha_facturacion","Total"});
        try {
            while(rs.next()){
                dfmbuscar.addRow(new Object[]{rs.getString("cod_factura"),rs.getString("cliente"),rs.getString("Vendedor"),rs.getString("Fecha_facturacion"),rs.getString("total")});
            }
        } catch (Exception e) {
              System.out.print(e);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        PerAdmin volver = new PerAdmin();
        volver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btVolverActionPerformed

    private void btimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btimprimirActionPerformed

        ImprimirEstudiantes estudiantes = new ImprimirEstudiantes();
        estudiantes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btimprimirActionPerformed

    private void btCrudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrudActionPerformed
        Visual visual = new Visual();
        visual.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btCrudActionPerformed

    private void btTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTotalActionPerformed
        // TODO add your handling code here:
      mostrarTotal();
    }//GEN-LAST:event_btTotalActionPerformed

    private void btTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodoActionPerformed
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_btTodoActionPerformed

    private void btVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendedoresActionPerformed
        // TODO add your handling code here:
        
        CrudUsuarios Vendedores = new CrudUsuarios();
        Vendedores.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btVendedoresActionPerformed

    private void btCrud3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrud3ActionPerformed
        // TODO add your handling code here:
        visual2 productos = new visual2();
        productos.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btCrud3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendario;
    private com.toedter.calendar.JDateChooser Calendario2;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCrud;
    private javax.swing.JButton btCrud3;
    private javax.swing.JButton btTodo;
    private javax.swing.JButton btTotal;
    private javax.swing.JButton btVendedores;
    private javax.swing.JButton btVolver;
    private javax.swing.JButton btimprimir;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
