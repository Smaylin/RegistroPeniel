/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imprimir;

import Conexion.Conexion;
import Conexion.ConexionBD;
import Conexion.ConexionConsultas;
import static Login.Admin.ComboUsuario;
import Settings.Configuracion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smail
 */
public class ImprimirEstudiantes extends javax.swing.JFrame {

    /**
     * Creates new form ImprimirEstudiantes
     */
    private Object [][] datostabla;
    public ImprimirEstudiantes() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/logoPeniel2.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mostrarDatos();
        SacarUsuarios();
        
    }
    
    
    
public void SacarUsuarios(){
    PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.obtenerConexion();
        try {
            String sql = "SELECT Horario FROM Alumnos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ComboHorario.addItem("Seleccione Horario: ");
            
            while(rs.next()){
                ComboHorario.addItem(rs.getString("Horario"));
        }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
          
}
    
    ConexionBD mysql = new ConexionBD(); 
    Connection conect= mysql.conectar();
    public void mostrarDatos(){
     String TFNombre = (String) ComboHorario.getSelectedItem();
//        Tables color = new Tables();
//        table.setDefaultRenderer(table.getColumnClass(0),color);
        DefaultTableModel tcliente = new DefaultTableModel();
        tcliente.addColumn("Nombre");
        tcliente.addColumn("Apellido");
        tcliente.addColumn("Telefono");
        tcliente.addColumn("Curso");
        tcliente.addColumn("Seccion");
        tcliente.addColumn("Semana1");
        tcliente.addColumn("Semana2");
        tcliente.addColumn("Semana3");
        tcliente.addColumn("Semana4");
        
        jTable1.setModel(tcliente);

//        
        String [] datos = new String[9];

        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Alumnos");
//            ResultSet resultado = leer.executeQuery("select * from Alumnos where Horario = '"+TFNombre+"' ");
//            System.out.print(result);
            
//
//            if(result == "englis"){
//            
//            }
            while(resultado.next()){
                datos[0] = resultado.getString(2);
                datos[1] = resultado.getString(3);
                datos[2] = resultado.getString(7);
                datos[3] = resultado.getString(9);
                datos[4] = resultado.getString(10);
                datos[5] = resultado.getString(11);
                datos[6] = resultado.getString(12);
                datos[7] = resultado.getString(13);
                datos[8] = resultado.getString(14);

                tcliente.addRow(datos);
                
                
            }

            jTable1.setModel(tcliente);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
//        table.setDefaultRenderer(table.getColumnClass(0),color);
    }
//    public void prueba(){
//          String[] columnas = { "Cliente","Vendedor", "Numero_factura","Codigo articulo","Descripcion","Nivel","Cantidad","Total"};
////          String TFNombre = (String) ComboUsuario.getSelectedItem();
//        datostabla = conect.SeleccionarTodo(Comboseccion.getSelectedItem());
//        DefaultTableModel datosta = new DefaultTableModel(datostabla,columnas);
//        jTable1.setModel(datosta)
//    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ComboHorario = new javax.swing.JComboBox<>();
        btImprimir = new javax.swing.JButton();
        btVolver = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btActualizar = new javax.swing.JButton();
        calendar1 = new com.toedter.calendar.JDateChooser();
        calendar2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Imprimir");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        btVolver.setText("Volver");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ingrese el curso:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione un horario:");

        btActualizar.setText("Motrar todo");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        calendar1.setDateFormatString("MM/dd/yyyy ");

        calendar2.setDateFormatString("MM/dd/yyyy ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Seleccione una fecha");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Desde");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Hasta");

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(ComboHorario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtnombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(calendar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(calendar2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btVolver)
                                    .addComponent(jLabel4)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboHorario, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(70, 70, 70))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btImprimir)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(btBuscar)
                                            .addGap(69, 69, 69))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(35, 35, 35))))
                                .addComponent(calendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(83, 83, 83))))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btBuscar)
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btImprimir)
                            .addComponent(btActualizar))
                        .addGap(56, 56, 56)
                        .addComponent(btVolver))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        // TODO add your handling code here:
         this.dispose();
        Configuracion volver = new Configuracion();
        volver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btVolverActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
      
         pdf();
    }//GEN-LAST:event_btImprimirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
     String TFNombre = (String) ComboHorario.getSelectedItem();
     String curso = txtnombre.getText();
      String fecha1 =((JTextField)calendar1.getDateEditor().getUiComponent()).getText();
       String fecha2 =((JTextField)calendar2.getDateEditor().getUiComponent()).getText();
       System.out.print(calendar1);
       System.out.print(calendar2);
//        String nombre = (String) this.ComboBoxBuscar.getSelectedItem().toString();
        ConexionConsultas cn = new ConexionConsultas();
        ResultSet rs = cn.SeleccionarHorario(TFNombre,curso,fecha1,fecha2);
        DefaultTableModel dfmbuscar = new DefaultTableModel();
        this.jTable1.setModel(dfmbuscar);
        dfmbuscar.setColumnIdentifiers(new Object [] {"ID","Nombre","Telefono","Curso","Horario","Semana1","Semana2","Semana3","Semana4"});
        try {
            while(rs.next()){
                dfmbuscar.addRow(new Object[]{rs.getInt("id"),rs.getString("Nombre"),rs.getString("Telefono"),rs.getString("Curso"),rs.getString("Horario"),rs.getString("Semana1"),rs.getString("Semana2"),rs.getString("Semana3"),rs.getString("Semana4")});
            }
        } catch (Exception e) {
              System.out.print(e);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_btActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(ImprimirEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImprimirEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImprimirEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImprimirEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImprimirEstudiantes().setVisible(true);
            }
        });
    }

    public ImprimirEstudiantes(Object[][] datostabla, JComboBox<String> ComboHorario, JButton btActualizar, JButton btImprimir, JButton btVolver, JButton jButton1, JDesktopPane jDesktopPane1, JLabel jLabel1, JLabel jLabel2, JScrollPane jScrollPane1, JTable jTable1, JTextField txtnombre) throws HeadlessException {
        this.datostabla = datostabla;
        this.ComboHorario = ComboHorario;
        this.btActualizar = btActualizar;
        this.btImprimir = btImprimir;
        this.btVolver = btVolver;
        this.btBuscar = jButton1;
        this.jDesktopPane1 = jDesktopPane1;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jScrollPane1 = jScrollPane1;
        this.jTable1 = jTable1;
        this.txtnombre = txtnombre;
    }
  
    
    
    
    
    private void pdf(){
        try {
            
            FileOutputStream archivo;
            File file = new File("C:/pdf/Curso.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.newPage();
            doc.add(new Chunk("")); 
            Image img = Image.getInstance("C:/img/logoPeniel2.png");
            
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
            
            String nom = "Control del aula" ;
            String idioma = "Idioma:_____________"
                    +       "Desde:_____________ \nHasta:_____________\n"
                    + "Profesor:___________\n\n"   ;
            String hora = "Hora:_______________";
            
            
          
            
     
            Encabezado.addCell("");
//            Encabezado.addCell("Institucion: " +nom+ "\n\nwhatsapp:  " +ws+ "\n\nTelefono: " +tel+"\n\nDireccion:  " +dir  );;
            Encabezado.addCell(nom);
            Encabezado.addCell(idioma);
//            Encabezado.addCell(hora);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            

            
            
            //TABLE PRODUCTOS//
            PdfPTable tablapro = new PdfPTable(9);
            tablapro.setWidthPercentage(100);
            tablapro.getDefaultCell().setBorderWidthBottom(0);
            float[] columnapro = new float[]{40f,60f,60,60f,0f,40f,40f,40f,40f};
            tablapro.setWidths(columnapro);
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell (new Phrase ("Nombre",negrita));
            PdfPCell pro2 = new PdfPCell (new Phrase ("Apellido",negrita));
            PdfPCell pro3 = new PdfPCell (new Phrase ("Telefono",negrita));
            PdfPCell pro4 = new PdfPCell (new Phrase ("Curso",negrita));
            PdfPCell pro5 = new PdfPCell (new Phrase ("Seccion",negrita));
            PdfPCell pro6 = new PdfPCell (new Phrase ("Semana1",negrita));
            PdfPCell pro7 = new PdfPCell (new Phrase ("Semana2",negrita));
            PdfPCell pro8 = new PdfPCell (new Phrase ("Semana3",negrita));
            PdfPCell pro9 = new PdfPCell (new Phrase ("Semana4",negrita));
            
            pro1.setBorder(1);
            pro2.setBorder(1);
            pro3.setBorder(1);
            pro4.setBorder(1);
            pro5.setBorder(1);
            pro6.setBorder(1);
            pro7.setBorder(1);
            pro8.setBorder(1);
            pro9.setBorder(1);
            pro1.setBackgroundColor(BaseColor.DARK_GRAY);
            pro2.setBackgroundColor(BaseColor.DARK_GRAY);
            pro3.setBackgroundColor(BaseColor.DARK_GRAY);
            pro4.setBackgroundColor(BaseColor.DARK_GRAY);
            pro5.setBackgroundColor(BaseColor.DARK_GRAY);
            pro6.setBackgroundColor(BaseColor.DARK_GRAY);
            pro7.setBackgroundColor(BaseColor.DARK_GRAY);
            pro8.setBackgroundColor(BaseColor.DARK_GRAY);
            
            pro9.setBackgroundColor(BaseColor.DARK_GRAY);
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
            tablapro.addCell(pro3);
            tablapro.addCell(pro4);
            tablapro.addCell(pro5);
            tablapro.addCell(pro6);
            tablapro.addCell(pro7);
            tablapro.addCell(pro8);
            tablapro.addCell(pro9);
            for (int i = 0; i < jTable1.getRowCount(); i++){
             
                
            String Cliente =  jTable1.getValueAt(i, 0).toString(); 
            String Vendedor =  jTable1.getValueAt(i, 1).toString(); 
            String Num_Factura =  jTable1.getValueAt(i, 2).toString(); 
            String Cod_Articulo =  jTable1.getValueAt(i, 3).toString(); 
            String Descripcion = jTable1.getValueAt(i, 4).toString();
            String Nivel = jTable1.getValueAt(i, 5).toString();
            String cantidad = jTable1.getValueAt(i, 6).toString(); 
            String total = jTable1.getValueAt(i, 7).toString(); 
            String semana = jTable1.getValueAt(i, 8).toString(); 
             
//            String total = total_factura.getText();
//            String total = jTable1.getValueAt(i, 4).toString();
            tablapro.addCell(Cliente);
            tablapro.addCell(Vendedor);
            tablapro.addCell(Num_Factura);
            tablapro.addCell(Cod_Articulo);
            tablapro.addCell(Descripcion);
            tablapro.addCell(Nivel);
            tablapro.addCell(total);
            tablapro.addCell(cantidad);
            tablapro.addCell(semana);
            
//            tablapro.addCell(total);

        }
       doc.add(tablapro );
       
       
       
       Paragraph info = new Paragraph();
       info.add(Chunk.NEWLINE);
//       info.add("Total a pagar " + total_factura.getText());
       info.setAlignment(Element.ALIGN_RIGHT);
       doc.add(info);
       
          Paragraph texto = new Paragraph();
       texto.add(Chunk.NEWLINE);
       texto.add("Sección terminada y pagada\n \n");
       
//        Paragraph firma = new Paragraph();
//       firma.add(Chunk.NEWLINE);
//       firma.add("-------------------------------  \n \n");
//       firma.add("Dirección(a) \n \n");
       
        Paragraph direccion = new Paragraph();
       direccion.add(Chunk.NEWLINE);
       direccion.add("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n-------------------------------         -------------------------------  ");
       direccion.add("                                                                          Firma del profesor (a)                 Dirección(a)");
       
       info.setAlignment(Element.ALIGN_RIGHT);
//       doc.add(firma);
      
       doc.add(direccion);
        doc.add(texto);

       Paragraph mensaje = new Paragraph();
//       mensaje.add(Chunk.NEWLINE);
//       mensaje.add("Welcome\n");
//       mensaje.add("Bienvenue");
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
    private javax.swing.JComboBox<String> ComboHorario;
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btVolver;
    private com.toedter.calendar.JDateChooser calendar1;
    private com.toedter.calendar.JDateChooser calendar2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
