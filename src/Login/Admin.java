package Login;

import Conexion.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Registro.RegistroDatos;
import PermisosAdmin.*;
import PermisosUser.User;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class Admin extends javax.swing.JFrame {
    public String Usuario;
    public String TFNombre;
    public String TFContraseña;
//    FondoPanel fondo = new FondoPanel();
//String us= txtUser.getText();
    public Admin() {
           initComponents();  
           setIconImage(new ImageIcon(getClass().getResource("/img/logoPeniel2.png")).getImage());
           this.setLocationRelativeTo(null);
//           txtUser.setEnabled(false);
            SacarUsuarios();
                        
        
    }

public void SacarUsuarios(){
    PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.obtenerConexion();
        try {
            String sql = "SELECT * FROM usuarios";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ComboUsuario.addItem("Seleccione usuario: ");
            
            while(rs.next()){
                ComboUsuario.addItem(rs.getString("username"));
        }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
          
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        ComboUsuario = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesion");
        setResizable(false);

        jDesktopPane1.setBackground(java.awt.Color.lightGray);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Iniciar sesion");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(70, 0, 170, 30);

        jLabel2.setText("Usuario:");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(30, 70, 70, 16);

        jLabel3.setText("Contraseña:");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(30, 120, 80, 16);

        btEnviar.setBackground(new java.awt.Color(0, 255, 0));
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btEnviar);
        btEnviar.setBounds(40, 160, 72, 22);

        btLogin.setBackground(new java.awt.Color(255, 0, 0));
        btLogin.setForeground(new java.awt.Color(255, 255, 255));
        btLogin.setText("Registrar");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btLogin);
        btLogin.setBounds(170, 160, 90, 22);

        ComboUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboUsuarioActionPerformed(evt);
            }
        });
        jDesktopPane1.add(ComboUsuario);
        ComboUsuario.setBounds(110, 70, 150, 22);
        jDesktopPane1.add(jPasswordField1);
        jPasswordField1.setBounds(130, 120, 130, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        // TODO add your handling code here:
//      (String) ComboUsuario.getSelectedItem()
        String TFNombre = (String) ComboUsuario.getSelectedItem();
//        txtUser = setText(ComboUsuario);
        
        Usuario = TFNombre;
        String TFContraseña  = jPasswordField1.getText();
        //        SELECT username,contraseña,privilegio FROM usuarios WHERE username = 'admin' and activo = 1 ;
        String url = " SELECT username,contraseña,privilegio " + "FROM usuarios WHERE  username = '"+TFNombre+"'";
        
       
        

        try {
            Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(url);
            ResultSet Query = ps.executeQuery();

            if (Query.next()){
                //SI EXISTE EL USUARIO
                String BDNombre= Query.getString("username");
                String BDContraseña= Query.getString("contraseña");
                String priv = Query.getString("privilegio");

                if(TFContraseña.equals(BDContraseña) & TFNombre.equals(BDNombre)){
                    JOptionPane.showInternalMessageDialog(null, "Bienvenido" + " " + BDNombre);

                    //VAMOS A JFRAME Usuario
                    if(priv.equals("usuario")){
                       User Usuario = new User();
                        Usuario.setVisible(true);
                        this.setVisible(false);
                    }else if(priv.equals("admin")){
                       PerAdmin Admin = new PerAdmin();
                      Admin.setVisible(true);
                        this.setVisible(false);
                    }
                }else{
                    JOptionPane.showInternalMessageDialog(null, "La contraseña no es correcta", "Conexion", JOptionPane.ERROR_MESSAGE);

                }

            }else{
                JOptionPane.showInternalMessageDialog(null, "El usuario no existe en la base de datos ", "Conexion", JOptionPane.ERROR_MESSAGE);

            }

        } catch (Exception ex) {
            System.out.println(ex.toString());

        }

           
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        RegistroDatos registro = new RegistroDatos();
        registro.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btLoginActionPerformed

    private void ComboUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> ComboUsuario;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btLogin;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    private JTextField setText(JComboBox<String> ComboUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
// class FondoPanel extends JPanel
//    {
//        private Image imagen;
//        
//        @Override
//        public void paint(Graphics g)
//        {
//            imagen = new ImageIcon(getClass().getResource("/img/logo.jpeg")).getImage();
//            
//            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
//            
//            setOpaque(false);
//            
//            super.paint(g);
//        }
//    }
}
