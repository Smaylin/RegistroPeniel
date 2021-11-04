/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idiomas;

import Conexion.ConexionBD;
import Conexion.ConexionConsultas;
import PermisosAdmin.PerAdmin;
import PermisosUser.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smail
 */
public class CursosExtra2 extends javax.swing.JFrame {

   ConexionBD mysql = new ConexionBD(); 
    Connection conect= mysql.conectar();
    
    public CursosExtra2() {
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
        txtCurso.getText();
//        Object selectedItem = ComboBoxBuscar.getSelectedItem();
//        String item = (String) ComboBoxBuscar.getSelectedItem();
//        
        String [] datos = new String[5];

        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Alumnos ");

            
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
    
    
    
    public void mostrarCursos(){
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("ID");
        tcliente.addColumn("Nombre");
        tcliente.addColumn("Apellido");
        tcliente.addColumn("Telefono");
        tcliente.addColumn("Horario");
        table.setModel(tcliente);
        txtID.getText();
        txtCurso.getText();
//        Object selectedItem = ComboBoxBuscar.getSelectedItem();
//        String item = (String) ComboBoxBuscar.getSelectedItem();
//        
        String [] datos = new String[5];

        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Alumnos where Curso = '"+txtCurso+"'");

            
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btNombre = new javax.swing.JButton();
        btID = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btActualizar = new javax.swing.JButton();
        txtCurso = new javax.swing.JTextField();
        btVolver = new javax.swing.JButton();
        btCursos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cursos");

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

        jLabel2.setText("Ingrese el Nombre o ID");

        jLabel3.setText("del estudiante que desea buscar");

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

        jLabel4.setText("Ingrese el curso del estudiante:");

        btActualizar.setText("Actualizar");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        txtCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCursoActionPerformed(evt);
            }
        });

        btVolver.setText("Volver");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        btCursos.setText("Buscar curso");
        btCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCursosActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btCursos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(btActualizar))
                                    .addComponent(btNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel2)))
                                .addContainerGap())))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btCursos))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCursos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btNombre)
                        .addGap(18, 18, 18)
                        .addComponent(btID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btActualizar)
                        .addGap(46, 46, 46)
                        .addComponent(btVolver))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        // TODO add your handling code here:
          this.dispose();
        User Usuario = new User();
        Usuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btVolverActionPerformed

    private void txtCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCursoActionPerformed

    private void btCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCursosActionPerformed
        // TODO add your handling code here:
           String curso =this.txtCurso.getText().toString();
        //        String nombre = (String) this.ComboBoxBuscar.getSelectedItem().toString();
        ConexionConsultas cn = new ConexionConsultas();
        ResultSet rs = cn.SeleccionarUsuarioCurso(curso);
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
    }//GEN-LAST:event_btCursosActionPerformed

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
            java.util.logging.Logger.getLogger(CursosExtra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursosExtra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursosExtra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursosExtra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursosExtra2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btCursos;
    private javax.swing.JButton btID;
    private javax.swing.JButton btNombre;
    private javax.swing.JButton btVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
