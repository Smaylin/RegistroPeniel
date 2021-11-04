
package facturacion;

import javax.swing.JOptionPane;

public final class Interfaz_Clientes extends javax.swing.JInternalFrame {
    control_existencias con;

    public Interfaz_Clientes(control_existencias con) {
        initComponents();    
        this.con = con;
        
        System.out.print(num_factura);
         num_factura.setText(con.GenerarID(num_factura.getText()));  
//          con.GenerarID(num_factura.getText(),total_factura.getText(),iva_art.getText())
        limpiar();
        bloquear_cajas();
        
        
        Object[] tipo_doc = con.combox("tipo_de_documento","Descripcion");
//        combo_tipo.removeAllItems();
        for(int i=0;i<tipo_doc.length;i++){
//        combo_tipo.addItem(tipo_doc[i]);
        
    }
        
        Object[] ciu = con.combox("ciudad","Nombre_ciudad");
//        ciudad_combo.removeAllItems();
        for(int i=0;i<ciu.length;i++){
//        ciudad_combo.addItem(ciu[i]);
        
    }
         
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regclientejButton1 = new javax.swing.JButton();
        cancelclijButton2 = new javax.swing.JButton();
        salirclijButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nomclientejTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        apellclientejTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nuevojButton1 = new javax.swing.JButton();
        num_factura = new javax.swing.JTextField();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar clientes");

        regclientejButton1.setText("Registrar");
        regclientejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regclientejButton1ActionPerformed(evt);
            }
        });

        cancelclijButton2.setText("Cancelar");
        cancelclijButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelclijButton2ActionPerformed(evt);
            }
        });

        salirclijButton3.setText("Salir");
        salirclijButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirclijButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Documento");

        nomclientejTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomclientejTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombres");

        apellclientejTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellclientejTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellidos");

        nuevojButton1.setText(" Nuevo registro");
        nuevojButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevojButton1ActionPerformed(evt);
            }
        });

        num_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_facturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(regclientejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cancelclijButton2)
                        .addGap(33, 33, 33)
                        .addComponent(salirclijButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nuevojButton1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nomclientejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)))
                                    .addComponent(num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(apellclientejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomclientejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellclientejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelclijButton2)
                    .addComponent(salirclijButton3)
                    .addComponent(regclientejButton1)
                    .addComponent(nuevojButton1))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar()
    {
//       num_factura.setText("");
//       combo_tipo.setName("");
       nomclientejTextField2.setText("");
       apellclientejTextField3.setText("");
//       dirclientejTextField4.setText("");
//       telefonoclientjTextField1.setText("");
    }
    
    public void  bloquear_cajas()
    {
       num_factura.setEnabled(false);
//       combo_tipo.setEnabled(false);
       nomclientejTextField2.setEnabled(false);
       apellclientejTextField3.setEnabled(false);
//       dirclientejTextField4.setEnabled(false);       
//       ciudad_combo.setEnabled(false); 
       nuevojButton1.setEnabled(true);
       regclientejButton1.setEnabled(false);
       cancelclijButton2.setEnabled(false);
//       telefonoclientjTextField1.setEnabled(false);
       
    }
    public void  desbloquear()
    {
       num_factura.setEnabled(true);
//       combo_tipo.setEnabled(true);
       nomclientejTextField2.setEnabled(true);
       apellclientejTextField3.setEnabled(true);
//       dirclientejTextField4.setEnabled(true);       
//       ciudad_combo.setEnabled(true); 
//       telefonoclientjTextField1.setEnabled(true);
       nuevojButton1.setEnabled(false);
       regclientejButton1.setEnabled(true);
       cancelclijButton2.setEnabled(true);
       
    }
    
    private void regclientejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regclientejButton1ActionPerformed
       
        String doc,nom,ape,dir,ciu,tipo,tel; 
        
        doc = num_factura.getText();
//        tipo= combo_tipo.getSelectedItem().toString();
        nom = nomclientejTextField2.getText();
        ape = apellclientejTextField3.getText();
//        dir = dirclientejTextField4.getText();        
//        ciu = ciudad_combo.getSelectedItem().toString();
//        tel = telefonoclientjTextField1.getText();
        control_cliente contr = new control_cliente(doc, nom, ape );
        if(!doc.equals("") && !nom.equals("") && !ape.equals("") )
        {
        if(contr.ingresar_cliente())
        {
        JOptionPane.showMessageDialog(null,"El cliente se registro con exito ","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        limpiar();
        bloquear_cajas();
        }
        else
        {
        JOptionPane.showMessageDialog(this, "Error al registrar el cliente");
        }
        }
        else
        {
          JOptionPane.showMessageDialog(this, "Hay campos obligatorios");  
        }
        
       
               
    }//GEN-LAST:event_regclientejButton1ActionPerformed

    private void salirclijButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirclijButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirclijButton3ActionPerformed

    private void cancelclijButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelclijButton2ActionPerformed
    bloquear_cajas();  
    limpiar();
    }//GEN-LAST:event_cancelclijButton2ActionPerformed

    private void nuevojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevojButton1ActionPerformed
    desbloquear();
    num_factura.requestFocus();
    }//GEN-LAST:event_nuevojButton1ActionPerformed

    private void nomclientejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomclientejTextField2ActionPerformed
    nomclientejTextField2.transferFocus();
    }//GEN-LAST:event_nomclientejTextField2ActionPerformed

    private void apellclientejTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellclientejTextField3ActionPerformed
    apellclientejTextField3.transferFocus();
    }//GEN-LAST:event_apellclientejTextField3ActionPerformed

    private void num_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_facturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellclientejTextField3;
    private javax.swing.JButton cancelclijButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomclientejTextField2;
    private javax.swing.JButton nuevojButton1;
    private javax.swing.JTextField num_factura;
    private javax.swing.JButton regclientejButton1;
    private javax.swing.JButton salirclijButton3;
    // End of variables declaration//GEN-END:variables

}