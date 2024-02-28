/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_kasir_nabila;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RPL-PC
 */
public class Form_Satuan extends javax.swing.JFrame {
    Connection con;
    DefaultTableModel tm;
    String filename=null;
    
     private void connect(){
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_kasir_nabila", "root", "");
        } catch(Exception e) {
            System.out.print("ERROR KONEKSI KE DATABASE:\n" + e);
        }
}
     
     private void refreshTable(){
        tm = new DefaultTableModel(
            null,
            new Object[] {"Id Satuan","Nama Satuan"}
        );
        tblsat.setModel(tm);
        tm.getDataVector().removeAllElements();
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM tbl_satuan");
            ResultSet r = s.executeQuery();
            while(r.next()) {
                Object[] data = {
                 r.getString(1),
                 r.getString(2)
                };
                tm.addRow(data);
            }
        } catch(Exception e) {
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
}
     
     private void id_otomatis(){
          try{
             PreparedStatement s = con.prepareStatement("SELECT*FROM tbl_satuan ORDER BY id_satuan DESC");
             ResultSet r = s.executeQuery();
             if(r.next())
             {
                 String No = r.getString("id_satuan");
                 String otomatis = "" +(Integer.parseInt(No)+1);
                 txtid.setText(otomatis);
             } else {
                txtid.setText("1");   
             }
             r.close();
             s.close();
          }catch(Exception e){
            System.out.println("autonumber error");  
          }
      }


    /**
     * Creates new form Satuan
     */
    public Form_Satuan() {
        initComponents();
        connect();
        refreshTable();
        id_otomatis();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-accessories-58.png"))); // NOI18N
        jLabel1.setText("Satuan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Nama Satuan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        txtid.setBackground(new java.awt.Color(204, 204, 204));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 49, -1));
        jPanel2.add(txtnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 160, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-32.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 153, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 153, 204));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Edit.png"))); // NOI18N
        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 153, 204));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        tblsat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Satuan"
            }
        ));
        tblsat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblsat);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 1020, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                try {
                    // Mengecek apakah barang dengan kode atau nama yang sama sudah ada dalam database
    String query = "SELECT * FROM tbl_satuan WHERE id_satuan = ? OR nama_satuan = ?";
    PreparedStatement psCheck = con.prepareStatement(query);
    psCheck.setString(1, txtid.getText());
    psCheck.setString(2, txtnm.getText());
    ResultSet rs = psCheck.executeQuery();
    
    if (rs.next()) {
        // Jika barang sudah ada dalam database, tampilkan pesan kesalahan
        JOptionPane.showMessageDialog(this, "Barang dengan kode atau nama yang sama sudah ada dalam database.");
    } else {
        // Jika barang belum ada dalam database, lakukan operasi INSERT
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_satuan VALUES (?,?)");
            ps.setString(1, txtid.getText());
            ps.setString(2, txtnm.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Telah Tersimpan");
            refreshTable();
            txtnm.setText("");
            txtid.setText("");
    }
        } catch(Exception e) {
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        id_otomatis();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_satuan SET nama_satuan=? WHERE id_satuan=?");
            ps.setString(1, txtnm.getText());
            ps.setString(2, txtid.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Telah Terupdate");
            refreshTable();
            txtnm.setText("");
            txtid.setText("");
        } catch(Exception e) {
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"Anda Yakin Ingin Menghapus Data Ini='"+txtid.getText()+"'",".:: Konfirmasi ::.", JOptionPane.YES_NO_OPTION);
            if (ok==0){
                try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_satuan WHERE id_satuan=?");
            ps.setString(1, txtid.getText());
            ps.executeUpdate();
            refreshTable();
            txtid.setText("");
            txtnm.setText("");
        } catch(Exception e) {
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblsatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsatMouseClicked
        // TODO add your handling code here:
        int i = tblsat.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id_satuan = (String) tm.getValueAt (i, 0);
        txtid.setText(id_satuan);
        String nama_satuan = (String) tm.getValueAt (i, 1);
        txtnm.setText(nama_satuan);
    }//GEN-LAST:event_tblsatMouseClicked

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
            java.util.logging.Logger.getLogger(Form_Satuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Satuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Satuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Satuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Satuan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblsat;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnm;
    // End of variables declaration//GEN-END:variables
}
