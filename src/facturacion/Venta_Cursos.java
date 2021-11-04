/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import Login.Admin;
import static Login.Admin.ComboUsuario;

import Registro.RegistroDatos;
import static Registro.RegistroDatos.jPrivilegio;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.pdf.PdfPTable;
//import java.awt.Image;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Desktop;
import java.io.IOException;
//import facturacion.Control_Usuarios;


import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Venta_Cursos extends javax.swing.JInternalFrame {

  
            
            

   
 
    control_existencias con;
    Control_Usuarios co;
    private Object [][] datostabla;
    public Venta_Cursos(control_existencias con) {
         
        initComponents();
         buttonGroup1.add(jRadioButton1);
         jRadioButton1.setText("Vendido con libro");
          
         buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Vendido sin libro");
        
        fecha_fact.setEnabled(false);
//        num_factura.setEnabled(false);
        cliente_factura.setEnabled(false);
        apell_cli.setEnabled(false);
        articulo_venta.setEnabled(false);
        stock_art.setEnabled(false);
        preciu_unid.setEnabled(false);
//        cant_art.setEnabled(false);
        iva_art.setEnabled(false);
//        desc_art.setEnabled(false);
        Total_art.setEnabled(false);
        combo_articulos.setEnabled(false);
        Reg_articulo.setEnabled(false);
        imprimir_bt.setEnabled(false);
        total_factura.setEnabled(false);
        vend_fact.setEnabled(false);
   
        txtNivel.setEnabled(false);
          jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        comboHorario.setEnabled(false); 
        txtComentario.setEnabled(false);
        
        this.con = con;
        
        cliente_factura.setText( con.ingresa_nombre_Cliente() );
        
        apell_cli.setText(con.ingresa_apellidos_Cliente());
        
        num_factura.setText("");  
        
        
//        txtNivel.setText(con.ingresaNivel());
        vend_fact.setText((String) ComboUsuario.getSelectedItem());

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy ");  
        Date date = new Date();  
        System.out.println(formatter.format(date));  
         fecha_fact.setText(formatter.format(date));
        
//        Date hoy = new Date();
//        fecha_fact.setText( hoy.getDate()+"/"+(hoy.getMonth()+1) +"/"+(hoy.getYear()+1900) );
        
        Object[] idarticulo = con.combox("articulo","id_articulo");
        combo_articulos.removeAllItems();
        for(int i=0;i<idarticulo.length;i++)
        {
        combo_articulos.addItem(idarticulo[i]);
        }
        Object[] formapago = con.combox("forma_de_pago","id_formapago");
        combo_formapago.removeAllItems();
        for(int i=0;i<formapago.length;i++)
        {
        combo_formapago.addItem(formapago[i]);
        }
       
    }





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cliente_factura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        num_factura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        vend_fact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fecha_fact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_articulos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        articulo_venta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        preciu_unid = new javax.swing.JTextField();
        stock_art = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Total_art = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Reg_articulo = new javax.swing.JButton();
        apell_cli = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        reg_factura = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        combo_formapago = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        iva_art = new javax.swing.JTextField();
        total_factura = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        imprimir_bt = new javax.swing.JButton();
        Nivel = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        comboHorario = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Generar factura");

        jLabel1.setText("Nombre cliente");

        cliente_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_facturaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese el Num factura");

        jLabel3.setText("Vendedor");

        vend_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vend_factActionPerformed(evt);
            }
        });

        jLabel4.setText("Forma pago");

        jLabel5.setText("Fecha");

        jLabel6.setText("Id_articulo");

        combo_articulos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_articulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_articulosActionPerformed(evt);
            }
        });

        jLabel7.setText("Articulo");

        jLabel8.setText("Precio_unidad");

        jLabel9.setText("stock");

        jLabel10.setText("Ingrese cantidad a abonar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Reg_articulo.setText("Registrar detalle");
        Reg_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_articuloActionPerformed(evt);
            }
        });

        apell_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apell_cliActionPerformed(evt);
            }
        });

        jLabel11.setText("Apellido cliente");

        reg_factura.setText("registrar factura");
        reg_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_facturaActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        combo_formapago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("IVA");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Total factura");

        imprimir_bt.setText("Registrar total");
        imprimir_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimir_btActionPerformed(evt);
            }
        });

        Nivel.setText("Nivel");

        jRadioButton1.setText("Venta con libro");

        jRadioButton2.setText("Venta sin libro");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        comboHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione seccion", "8:00 am - 10:00 am", "10:00 am a 12:00 pm", "2:00 pm - 4:00pm", "4:00 pm - 6:00 pm", "6:00 pm - 8:00 pm", "SAB.9:00 am - 12:00 pm", "SAB.2:00 pm - 5:00 pm" }));

        jLabel16.setText("Seccion");

        jLabel12.setText("Agregar un comentario");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane2.setViewportView(txtComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cliente_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(apell_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(119, 119, 119))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_articulos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(articulo_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(preciu_unid, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(vend_fact, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fecha_fact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                            .addComponent(combo_formapago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(reg_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(stock_art, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Total_art, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1))
                                .addGap(40, 40, 40))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(Reg_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(31, 31, 31)
                        .addComponent(iva_art, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(total_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imprimir_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(combo_formapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fecha_fact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(cliente_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(reg_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(apell_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vend_fact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nivel)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_articulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(articulo_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(stock_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(preciu_unid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(Total_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Reg_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iva_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imprimir_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reg_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_facturaActionPerformed
    con.registrar_factura(num_factura.getText(), cliente_factura.getText(),vend_fact.getText(),fecha_fact.getText(),combo_formapago.getSelectedItem().toString(),cliente_factura.getText());
//        cant_art.setEnabled(true);
//        iva_art.setEnabled(true);
//        desc_art.setEnabled(true);
//        Total_art.setEnabled(true);
        combo_articulos.setEnabled(true);
        Reg_articulo.setEnabled(true);
        total_factura.setEnabled(false);
        imprimir_bt.setEnabled(true);
        reg_factura.setEnabled(false);
        combo_formapago.setEnabled(false);
        vend_fact.setEnabled(false);
        txtNivel.setEnabled(true);
          jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        comboHorario.setEnabled(true); 
        txtComentario.setEnabled(true);
       
    }//GEN-LAST:event_reg_facturaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_articulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_articulosActionPerformed
     if(combo_articulos.getSelectedItem()!=null )
     {  
            Object[][] datos = con.datos_articulo(combo_articulos.getSelectedItem().toString());
            articulo_venta.setText(datos[0][0].toString());
            preciu_unid.setText(datos[0][1].toString());
            stock_art.setText(datos[0][2].toString());
//            cant_art.setText("0");
            Total_art.setText("0");
//            desc_art.setText("0");
        }        
    }//GEN-LAST:event_combo_articulosActionPerformed
    
    private void Reg_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_articuloActionPerformed
        int c = Integer.parseInt(stock_art.getText());
//        int b = Integer.parseInt(cant_art.getText());
                
//        if(!cant_art.getText().equals("0") )
//        {
//            if (c > b)
//            {            
            
            if( con.registrar_Curso(num_factura.getText(),cliente_factura.getText(),vend_fact.getText(), combo_articulos.getSelectedItem().toString(),Total_art.getText(),txtNivel.getText().toString()))
            {
                JOptionPane.showMessageDialog(this, "El articulo se registro con exito");
//                cant_art.setText("0");
                Total_art.setText("0");                
//                desc_art.setText("");
                txtNivel.setText("");
            }
            else
            {
//                JOptionPane.showMessageDialog(this, "Error al registrar el articulo");
            }
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(this, "El stock del articulo no soporta la venta por favor actualize en stock");
//            }
////        }
//            else
//            {
//            JOptionPane.showMessageDialog(this, "La cantidad no es valida");
//            }
        
        String[] columnas = { "Cliente","Vendedor", "Numero_factura","Codigo articulo","Descripcion","Nivel","Cantidad","Total"};
        datostabla = con.datos_detallefactura(num_factura.getText());
        DefaultTableModel datosta = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datosta);
        
        Double a = con.total_factura(num_factura.getText());
        
        total_factura.setText(a.toString());
        IVA iva = new IVA(Double.parseDouble(total_factura.getText()));
        iva_art.setText(iva.calcular_iva().toString());
        
    }//GEN-LAST:event_Reg_articuloActionPerformed

    private void imprimir_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimir_btActionPerformed
    if(!total_factura.getText().equals("0") )
        {
            
            
            if( con.update_factura(num_factura.getText(),total_factura.getText(),iva_art.getText()))
            {
                JOptionPane.showMessageDialog(this, "Se registro la venta");
                
//                
                iva_art.setText("0");  
//                cant_art.setEnabled(false);
                iva_art.setEnabled(false);
//                desc_art.setEnabled(false);
                Total_art.setEnabled(false);
                combo_articulos.setEnabled(false);
                Reg_articulo.setEnabled(false);
                imprimir_bt.setEnabled(false);
                total_factura.setEnabled(false);
                txtNivel.setEnabled(false);
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error al registrar la venta");
            }
            }
            
            else
            {
            JOptionPane.showMessageDialog(this, "El total no es valido");
            }
     pdf();
     total_factura.setText("0");
    }//GEN-LAST:event_imprimir_btActionPerformed

    private void apell_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apell_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apell_cliActionPerformed

    private void vend_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vend_factActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vend_factActionPerformed

    private void cliente_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cliente_facturaActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void pdf(){
        try {
            
            FileOutputStream archivo;
            File file = new File("C:/pdf/venta.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.newPage();
            doc.add(new Chunk("")); 
            Image img = Image.getInstance("C:/img/logo.jpeg");
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.GREEN);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha:" + new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnaEncabezado = new float[]{20f,30f,70f,40f};
            Encabezado.setWidths(columnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            Encabezado.addCell(img);
            control_existencias con = new control_existencias();
            con.datos_detallefactura(title);

            String ruc = num_factura.getText();
            String nom = "Academia de idiomas Peniel " ;
            String ws = "829-728-8864";
            String tel = "829-256-0101";
            String dir = "Marginal Las Americas KM.10, Plaza ICOM,3er Nivel";
            
     
            Encabezado.addCell("");
//            Encabezado.addCell("Institucion: " +nom+ "\n\nwhatsapp:  " +ws+ "\n\nTelefono: " +tel+"\n\nDireccion:  " +dir  );;
            Encabezado.addCell(nom+ "\n\nwhatsapp:  " +ws+ "\n\nTelefono: " +tel+"\n\nDireccion:  " +dir );
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos de Venta:" + "\n\n");
            doc.add(cli);
            
             
            PdfPTable tablecli = new PdfPTable(3);
            tablecli.setWidthPercentage(100);
            tablecli.getDefaultCell().setBorder(0);
            float[] columnacli = new float[]{40f,50f,35f};
            tablecli.setWidths(columnacli);
            tablecli.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell (new Phrase ("#Factura",negrita));
            PdfPCell cl2 = new PdfPCell (new Phrase ("Nombre",negrita));
            PdfPCell cl3 = new PdfPCell (new Phrase ("Vendedor",negrita));
//            PdfPCell cl4 = new PdfPCell (new Phrase ("Direccion",negrita));
            cl1.setBorder(0);
            cl2.setBorder(0);
            cl3.setBorder(0);
//            cl4.setBorder(0);
//            cl1.setBackgroundColor(BaseColor.DARK_GRAY);
//            cl2.setBackgroundColor(BaseColor.DARK_GRAY);
//            cl3.setBackgroundColor(BaseColor.DARK_GRAY);
//            cl4.setBackgroundColor(BaseColor.DARK_GRAY);
            tablecli.addCell(cl1);
            tablecli.addCell(cl2);
            tablecli.addCell(cl3);
//            tablecli.addCell(cl4);
            tablecli.addCell(num_factura.getText());
            tablecli.addCell(cliente_factura.getText());
            tablecli.addCell(vend_fact.getText());
//            tablecli.addCell(apell_cli.getText());
            doc.add(tablecli);
   
            
            
            //TABLE PRODUCTOS//
            PdfPTable tablapro = new PdfPTable(6);
            tablapro.setWidthPercentage(100);
            tablapro.getDefaultCell().setBorder(0);
            float[] columnapro = new float[]{40f,60f,40f,40f,40f,40f};
            tablapro.setWidths(columnapro);
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell (new Phrase ("Cliente",negrita));
            PdfPCell pro2 = new PdfPCell (new Phrase ("Sección",negrita));
//            PdfPCell pro3 = new PdfPCell (new Phrase ("Codigo",negrita));
            PdfPCell pro4 = new PdfPCell (new Phrase ("Descripcion",negrita));
            PdfPCell pro5 = new PdfPCell (new Phrase ("Nivel",negrita));
            PdfPCell pro6 = new PdfPCell (new Phrase ("Cantidad",negrita));
            PdfPCell pro7 = new PdfPCell (new Phrase ("Precio U.",negrita));
//            PdfPCell pro7 = new PdfPCell (new Phrase ("Precio Total",negrita));
            pro1.setBorder(0);
            pro2.setBorder(0);
//            pro3.setBorder(0);
            pro4.setBorder(0);
            pro5.setBorder(0);
            pro6.setBorder(0);
            pro7.setBorder(0);
            pro1.setBackgroundColor(BaseColor.DARK_GRAY);
            pro2.setBackgroundColor(BaseColor.DARK_GRAY);
//            pro3.setBackgroundColor(BaseColor.DARK_GRAY);
            pro4.setBackgroundColor(BaseColor.DARK_GRAY);
            pro5.setBackgroundColor(BaseColor.DARK_GRAY);
            pro6.setBackgroundColor(BaseColor.DARK_GRAY);
            pro7.setBackgroundColor(BaseColor.DARK_GRAY);
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
//            tablapro.addCell(pro3);
            tablapro.addCell(pro4);
            tablapro.addCell(pro5);
            tablapro.addCell(pro6);
            tablapro.addCell(pro7);
            for (int i = 0; i < jTable1.getRowCount(); i++){
                
            String Cliente =  jTable1.getValueAt(i, 0).toString(); 
//            String Vendedor =  jTable1.getValueAt(i, 2).toString();
            String Vendedor = (String) comboHorario.getSelectedItem();

            String Num_Factura =  jTable1.getValueAt(i, 4).toString(); 
//            String Cod_Articulo =  jTable1.getValueAt(i, 3).toString(); 
            String Descripcion = jTable1.getValueAt(i, 5).toString();
            String Nivel = jTable1.getValueAt(i, 6).toString();
            String cantidad = jTable1.getValueAt(i, 7).toString(); 
             
//            String total = total_factura.getText();
//            String total = jTable1.getValueAt(i, 4).toString();
            tablapro.addCell(Cliente);
            tablapro.addCell(Vendedor);
            tablapro.addCell(Num_Factura);
//            tablapro.addCell(Cod_Articulo);
            tablapro.addCell(Descripcion);
            tablapro.addCell(Nivel);
            tablapro.addCell(cantidad);
            
//            tablapro.addCell(total);

        }
       doc.add(tablapro);
       Paragraph info = new Paragraph();
       info.add(Chunk.NEWLINE);
       info.add("Total a pagar " + total_factura.getText());
       info.setAlignment(Element.ALIGN_RIGHT);
       doc.add(info);
       
       Paragraph comentario = new Paragraph();
       comentario.add(Chunk.NEWLINE);
//       comentario.add("Comentario\n \n");
       comentario.add(txtComentario.getText());
       info.setAlignment(Element.ALIGN_RIGHT);
       doc.add(comentario);
       
         Paragraph lirbo = new Paragraph();
       lirbo.add(Chunk.NEWLINE);
//       lirbo.add("libro\n \n");
//       lirbo.add(jRadioButton1.getText());
       info.setAlignment(Element.ALIGN_RIGHT);
       
       if(jRadioButton1.isSelected())
        {
            System.out.print(jRadioButton1.getText() );
//        System.out.print( "Seleccionó opción 1");
        lirbo.add(jRadioButton1.getText());
        }else if (jRadioButton2.isSelected()){
//            System.out.print("Seleccionó opción 2");
            lirbo.add(jRadioButton2.getText());
        }
       doc.add(lirbo);
       
       
       
       
        Paragraph firma = new Paragraph();
       firma.add(Chunk.NEWLINE);
       firma.add("Firma\n \n");
       firma.add("-------------------------------");
       info.setAlignment(Element.ALIGN_RIGHT);
       doc.add(firma);
      
       
       
       
       Paragraph mensaje = new Paragraph();
       mensaje.add(Chunk.NEWLINE);
       mensaje.add("Welcome\n");
       mensaje.add("Bienvenue");
       info.setAlignment(Element.ALIGN_RIGHT);
       doc.add(mensaje);
            doc.close();
            archivo.close();
          Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            JOptionPane.showInternalMessageDialog(null, "conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            System.out.println(e);
        }
}
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nivel;
    private javax.swing.JButton Reg_articulo;
    private javax.swing.JTextField Total_art;
    private javax.swing.JTextField apell_cli;
    private javax.swing.JTextField articulo_venta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cliente_factura;
    private javax.swing.JComboBox<String> comboHorario;
    private javax.swing.JComboBox combo_articulos;
    private javax.swing.JComboBox combo_formapago;
    private javax.swing.JTextField fecha_fact;
    private javax.swing.JButton imprimir_bt;
    private javax.swing.JTextField iva_art;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField num_factura;
    private javax.swing.JTextField preciu_unid;
    private javax.swing.JButton reg_factura;
    private javax.swing.JTextField stock_art;
    private javax.swing.JTextField total_factura;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField vend_fact;
    // End of variables declaration//GEN-END:variables
}
