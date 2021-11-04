
package Idiomas;


import Conexion.ConexionBD;
import Conexion.ConexionConsultas;

import PermisosAdmin.PerAdmin;
import facturacion.Interfaz_principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class English extends javax.swing.JFrame {

    ConexionBD mysql = new ConexionBD(); 
    Connection conect= mysql.conectar();
    public English() {
        setIconImage(new ImageIcon(getClass().getResource("/img/logoPeniel2.png")).getImage());
        this.setResizable(false);
        initComponents();
        mostrarDatos();
       
    }

  
    public void mostrarDatos(){
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("ID");
        tcliente.addColumn("Nombre");
        tcliente.addColumn("Apellido");
        tcliente.addColumn("Telefono");
        tcliente.addColumn("Horario");
        table.setModel(tcliente);
        txtID.getText();
//        Object selectedItem = ComboBoxBuscar.getSelectedItem();
//        String item = (String) ComboBoxBuscar.getSelectedItem();
//        
        String [] datos = new String[5];

        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Alumnos where Curso = 'ingles' or 'Ingles' or 'English' or 'english'");

            
            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(7);
                datos[4] = resultado.getString(10);
                tcliente.addRow(datos);
            }

            table.setModel(tcliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
    }
    
    public ResultSet SeleccionarDatos(String nombre){
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("ID");
        tcliente.addColumn("Nombre");
        tcliente.addColumn("Direccion");
        table.setModel(tcliente);
        txtID.getText();
//        Object selectedItem = ComboBoxBuscar.getSelectedItem();
        
        String combo ;
//        combo = ComboBoxBuscar.getItemAt(ComboBoxBuscar.getSelectedIndex()).getCodigo();

        String [] datos = new String[3];
        ConexionBD mysql = new ConexionBD(); 
           mysql.conectar();
           Connection cn=mysql.conectar();
        try {

            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM clientes");
            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                tcliente.addRow(datos);
            }
            table.setModel(tcliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
        return null;
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btActualizar = new javax.swing.JButton();
        btNombre = new javax.swing.JButton();
        btID = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("English");

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

        btActualizar.setText("Actualizar");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        btNombre.setText("Buscar por Nombre");
        btNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNombreActionPerformed(evt);
            }
        });

        btID.setText("Buscar por ID");
        btID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIDActionPerformed(evt);
            }
        });

        btVolver.setText("Volver");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel1.setText("Estudiantes de English ");

        jLabel2.setText("Ingrese el Nombre o ID");

        jLabel3.setText("del estudiante que desea buscar");

        jDesktopPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel1)))
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 1, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(28, 28, 28))))))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btActualizar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btID)
                        .addGap(29, 29, 29)
                        .addComponent(btActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVolver)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        // TODO add your handling code here:
          this.dispose();
        PerAdmin volver = new PerAdmin();
        volver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btVolverActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNombreActionPerformed
        // TODO add your handling code here:
              String nombre =this.txtID.getText().toString();
//        String nombre = (String) this.ComboBoxBuscar.getSelectedItem().toString();
        ConexionConsultas cn = new ConexionConsultas();
        ResultSet rs = cn.SeleccionarUsuario(nombre);
        DefaultTableModel dfmbuscar = new DefaultTableModel();
        this.table.setModel(dfmbuscar);
        dfmbuscar.setColumnIdentifiers(new Object [] {"ID","NOMBRE","Apellido","Telefono","Horario"});
        try {
            while(rs.next()){
                dfmbuscar.addRow(new Object[]{rs.getInt("id"),rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Telefono"),rs.getString("Horario")});
            }
        } catch (Exception e) {
              System.out.print(e);
        }
    }//GEN-LAST:event_btNombreActionPerformed

    private void btIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIDActionPerformed
        // TODO add your handling code here:
       String nombre =this.txtID.getText().toString();
//        String nombre = (String) this.ComboBoxBuscar.getSelectedItem().toString();
        ConexionConsultas cn = new ConexionConsultas();
        ResultSet rs = cn.SeleccionarId(nombre);
        DefaultTableModel dfmbuscar = new DefaultTableModel();
        this.table.setModel(dfmbuscar);
        dfmbuscar.setColumnIdentifiers(new Object [] {"ID","NOMBRE","Apellido","Telefono","Horario"});
        try {
            while(rs.next()){
                dfmbuscar.addRow(new Object[]{rs.getInt("id"),rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Telefono"),rs.getString("Horario")});
            }
        } catch (Exception e) {
              System.out.print(e);
        }
    }//GEN-LAST:event_btIDActionPerformed

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
            java.util.logging.Logger.getLogger(English.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(English.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(English.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(English.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new English().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btID;
    private javax.swing.JButton btNombre;
    private javax.swing.JButton btVolver;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
