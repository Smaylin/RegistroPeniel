/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermisosUser;

import Conexion.ConexionBD;
import Idiomas.CursosExtra;
import Idiomas.CursosExtra2;
import Idiomas.English;
import Idiomas.English2;
import Idiomas.Español;
import Idiomas.Español2;
import PermisosAdmin.MiRendererNum;
import facturacion.Interfaz_principal;
import facturacion.Interfaz_principal2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smail
 */
public class User extends javax.swing.JFrame {

  ConexionBD mysql = new ConexionBD(); 
    Connection conect= mysql.conectar();
    public User() {
        initComponents();
        this.TablaPagos.setDefaultRenderer(Object.class, new MiRendererNum()); // Esto es lo que envia la tabla seleccionada hacia el MiRender Para darle el color a las celdas 
       setIconImage(new ImageIcon(getClass().getResource("/img/logoPeniel2.png")).getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        mostrarDatos();
        mostrarDatosEpañol();
        MetodoPago();
    }
    //Esta tabla muestra tododos los estudiantes que tengan los pagos menor al precio del curso
    public void mostrarDatos(){
     

        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Factura");
        tcliente.addColumn("Estudiante");
        tcliente.addColumn("Vendedor");

        tcliente.addColumn("Nivel");
        tcliente.addColumn("Fecha_factura");
        tcliente.addColumn("Total");
        table.setModel(tcliente);
     
        String [] datos = new String[7];

        try {
            Statement leer = conect.createStatement();
//            ResultSet resultado = leer.executeQuery("SELECT * FROM detalle_factura");
            ResultSet resultado = leer.executeQuery("Select \n" +
                                                    "-- b.precio_venta,\n" +
                                                    "a.*\n" +
                                                    " from detalle_factura a \n" +
                                                    "INNER JOIN articulo b ON a.cod_articulo = b.id_articulo where descripcion = 'English' and total < b.precio_venta;");

            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(5);
                datos[4] = resultado.getString(7);
                datos[5] = resultado.getString(8);


                tcliente.addRow(datos);
                
                
            }

            table.setModel(tcliente);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
//        table.setDefaultRenderer(table.getColumnClass(0),color);
    }
    //Esta tabla muestra tododos los estudiantes que tengan los pagos menor al precio del curso
    public void mostrarDatosEpañol(){
     
//        Tables color = new Tables();
//        table.setDefaultRenderer(table.getColumnClass(0),color);
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Factura");
        tcliente.addColumn("Estudiante");
        tcliente.addColumn("Vendedor");
        tcliente.addColumn("Nivel");
        tcliente.addColumn("Fecha_factura");
        tcliente.addColumn("Total");
        jTable1.setModel(tcliente);

        String [] datos = new String[7];

        try {
            Statement leer = conect.createStatement();
//            ResultSet resultado = leer.executeQuery("SELECT * FROM detalle_factura");
            ResultSet resultado = leer.executeQuery("Select \n" +
                                                    "-- b.precio_venta,\n" +
                                                    "a.*\n" +
                                                    " from detalle_factura a \n" +
                                                    "INNER JOIN articulo b ON a.cod_articulo = b.id_articulo where descripcion = 'Español' and total < b.precio_venta;");

            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(5);
                datos[4] = resultado.getString(7);
                datos[5] = resultado.getString(8);
//                datos[3] = resultado.getString(7);

                tcliente.addRow(datos);
                
                
            }

            jTable1.setModel(tcliente);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
//        table.setDefaultRenderer(table.getColumnClass(0),color);
    }
    
    
    
    
     //Esta tabla muestra tododos los estudiantes que tengan los pagos menor al precio del curso
    public void mostrarDatos(int opBuscar, String valor){
     

        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Factura");
        tcliente.addColumn("Estudiantes");
        tcliente.addColumn("Vendedor");
        tcliente.addColumn("Nivel");
        tcliente.addColumn("Fecha_factura");
        tcliente.addColumn("Total");
        table.setModel(tcliente);
     
        String [] datos = new String[7];

        try {
            Statement leer = conect.createStatement();
//            ResultSet resultado = leer.executeQuery("SELECT * FROM detalle_factura");
            ResultSet resultado = leer.executeQuery("Select \n" +
                                                    "-- b.precio_venta,\n" +
                                                    "a.*\n" +
                                                    " from detalle_factura a \n" +
                                                    "INNER JOIN articulo b ON a.cod_articulo = b.id_articulo where descripcion = 'English' and total < b.precio_venta;");

            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(5);
                datos[4] = resultado.getString(7);
                datos[5] = resultado.getString(8);


                tcliente.addRow(datos);
                
                
            }

            table.setModel(tcliente);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }

//        table.setDefaultRenderer(table.getColumnClass(0),color);
    }
    
     public void MetodoPago(){

//        Tables color = new Tables();
//        table.setDefaultRenderer(table.getColumnClass(0),color);
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Num_Fac");
        tcliente.addColumn("Estudiantes");
        tcliente.addColumn("Vendedor");
        tcliente.addColumn("Fecha_factura");
        tcliente.addColumn("Enero");
        tcliente.addColumn("Febrero");
        tcliente.addColumn("Marzo");
        tcliente.addColumn("Abril");
        tcliente.addColumn("Mayo");
        tcliente.addColumn("Junio");
        tcliente.addColumn("Julio");
        tcliente.addColumn("Agosto");
        tcliente.addColumn("Septiembre");
        tcliente.addColumn("Octubre");
        tcliente.addColumn("Noviembre");
        tcliente.addColumn("Diciembre");
//        tcliente.addColumn("Total");
        TablaPagos.setModel(tcliente);
        
//         tcliente.setDefaultRenderer(tcliente.getColumnClass(0),color);
        String [] datos = new String[16];
           String pago = "Pago Mensual";
        try {
            Statement leer = conect.createStatement();
//           ResultSet resultado = leer.executeQuery("SELECT * FROM detalle_factura");
            ResultSet resultado = leer.executeQuery("SELECT * FROM detalle_factura WHERE modoPago = '"+pago+"'");

            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(7);
                datos[4] = resultado.getString(10);
                datos[5] = resultado.getString(11);
                datos[6] = resultado.getString(12);
                datos[7] = resultado.getString(13);
                datos[8] = resultado.getString(14);
                datos[9] = resultado.getString(15);
                datos[10] = resultado.getString(16);
                datos[11] = resultado.getString(17);
                datos[12] = resultado.getString(18);
                datos[13] = resultado.getString(19);
                datos[14] = resultado.getString(20);
                datos[15] = resultado.getString(21);
//                datos[5] = resultado.getString(8);
//                datos[3] = resultado.getString(7);

                tcliente.addRow(datos);
                
            
            }

            TablaPagos.setModel(tcliente);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
//        table.setDefaultRenderer(table.getColumnClass(0),color);
    }

     ///POR ESTE METODO PODEMOS ACTUCALIZAR LA BASE DE DATOS MEDIANTE UN JTABLE SOLO CAMBIANDO EL VALOR DE LA SELDA Y DANDOLE AL BOTON
    public void actualizarPaga(){
        int fila = TablaPagos.getSelectedRow();
        String factura = (TablaPagos.getValueAt(fila, 0).toString());
        String enero = (String) TablaPagos.getValueAt(fila, 4);
        String febrero = (String) TablaPagos.getValueAt(fila, 5);
        String marzo = (String) TablaPagos.getValueAt(fila, 6);
        String abril = (String) TablaPagos.getValueAt(fila, 7);
        String mayo = (String) TablaPagos.getValueAt(fila, 8);
        String junio = (String) TablaPagos.getValueAt(fila, 9);
        String julio = (String) TablaPagos.getValueAt(fila, 10);
        String agosto = (String) TablaPagos.getValueAt(fila, 11);
        String septiembre = (String) TablaPagos.getValueAt(fila, 12);
        String octubre = (String) TablaPagos.getValueAt(fila, 13);
        String noviembre = (String) TablaPagos.getValueAt(fila, 14);
        String diciembre = (String) TablaPagos.getValueAt(fila, 15);

//        int numEntero = Integer.parseInt(total);
         
        try {
            PreparedStatement actu = conect.prepareStatement("UPDATE  detalle_factura set enero= '"+enero+"',febrero = '"+febrero+"',marzo = '"+marzo+"',abril = '"+abril+"',"
                    + "mayo = '"+mayo+"',junio = '"+junio+"',julio = '"+julio+"',agosto = '"+agosto+"',septiembre = '"+septiembre+"',octubre = '"+octubre+"',"
                            + "noviembre = '"+noviembre+"',diciembre = '"+diciembre+"' WHERE cod_factura = '"+factura+"' ");
//            PreparedStatement actu = conect.prepareStatement("UPDATE `detalle_factura` SET `total`= '"+total+"' WHERE cod_factura ='"+factura+"'");
            actu.executeUpdate();
            mostrarDatos(0,null);
            //SELECT * FROM `detalle_factura` WHERE `cod_factura` = 'FACT-1077787'
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,   "Recargue la pestaña");
        }
        
        
    }
    
        public void desactivarMetodoPago(){
        String factura = txtUpdateFactura.getText();
        String pago = "Pago";
        
        try {
//            PreparedStatement actu = conect.prepareStatement("UPDATE  detalle_factura set  '"+factura+"' WHERE cod_factura = '"+factura+"' ");
            PreparedStatement actu = conect.prepareStatement("UPDATE detalle_factura SET modoPago = '"+pago+"'  WHERE cod_factura = '"+factura+"'  ");
            actu.executeUpdate();
            mostrarDatos(0,null);
            JOptionPane.showMessageDialog(null,  "Factura actualizada");

            //SELECT * FROM `detalle_factura` WHERE `cod_factura` = 'FACT-1077787'
        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null,"Ingrese un numero de factura correcto");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btEnglish = new javax.swing.JButton();
        btEspanol = new javax.swing.JButton();
        btFactura = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btcusos = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btPago = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaPagos = new javax.swing.JTable();
        txtUpdateFactura = new javax.swing.JTextField();
        btUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        jPanel2.setBackground(new java.awt.Color(114, 190, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        btEnglish.setBackground(new java.awt.Color(114, 190, 240));
        btEnglish.setForeground(new java.awt.Color(0, 0, 0));
        btEnglish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/istockphoto-1013447762-612x612.png"))); // NOI18N
        btEnglish.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "English", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btEnglish.setContentAreaFilled(false);
        btEnglish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEnglish.setOpaque(true);
        btEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnglishActionPerformed(evt);
            }
        });

        btEspanol.setBackground(new java.awt.Color(114, 190, 240));
        btEspanol.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        btEspanol.setForeground(new java.awt.Color(0, 0, 0));
        btEspanol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bandera-de-republica-dominicana.png"))); // NOI18N
        btEspanol.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Español", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btEspanol.setContentAreaFilled(false);
        btEspanol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEspanol.setOpaque(true);
        btEspanol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEspanolActionPerformed(evt);
            }
        });

        btFactura.setBackground(new java.awt.Color(114, 190, 240));
        btFactura.setForeground(new java.awt.Color(0, 0, 0));
        btFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura.png"))); // NOI18N
        btFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btFactura.setContentAreaFilled(false);
        btFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFactura.setOpaque(true);
        btFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFacturaActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1.png"))); // NOI18N

        btcusos.setBackground(new java.awt.Color(114, 190, 240));
        btcusos.setForeground(new java.awt.Color(0, 0, 0));
        btcusos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/curso2.png"))); // NOI18N
        btcusos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        btcusos.setContentAreaFilled(false);
        btcusos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btcusos.setOpaque(true);
        btcusos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcusosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEnglish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEspanol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btcusos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEnglish)
                .addGap(18, 18, 18)
                .addComponent(btEspanol, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btcusos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFactura)
                .addGap(50, 50, 50))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Estudiantes English", jPanel5);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Estudiantes  Español", jPanel6);

        btPago.setText("Actuzalizar Pago");
        btPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagoActionPerformed(evt);
            }
        });

        TablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(TablaPagos);

        btUpdate.setText("Pago completo");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese la factura del estudiante");

        jLabel4.setText("a desactivar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUpdateFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btUpdate))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btPago, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btPago)
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUpdateFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Estudiantes de pagos mensuales", jPanel1);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel1.setText("Estudiantes a los cuales le faltan pagos");

        jDesktopPane1.setLayer(jTabbedPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnglishActionPerformed

        English2 ingles2 = new English2();
        ingles2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btEnglishActionPerformed

    private void btEspanolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEspanolActionPerformed
        Español2 espanol2 = new Español2();
        espanol2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btEspanolActionPerformed

    private void btFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFacturaActionPerformed
        // TODO add your handling code here:
        Interfaz_principal2 Cobro = new Interfaz_principal2();
        Cobro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btFacturaActionPerformed

    private void btPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagoActionPerformed
        // TODO add your handling code here:
        actualizarPaga();
    }//GEN-LAST:event_btPagoActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
        desactivarMetodoPago();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btcusosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcusosActionPerformed
        // TODO add your handling code here:
       CursosExtra2 cursos = new CursosExtra2();
        cursos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btcusosActionPerformed

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPagos;
    private javax.swing.JButton btEnglish;
    private javax.swing.JButton btEspanol;
    private javax.swing.JButton btFactura;
    private javax.swing.JButton btPago;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btcusos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtUpdateFactura;
    // End of variables declaration//GEN-END:variables
}
