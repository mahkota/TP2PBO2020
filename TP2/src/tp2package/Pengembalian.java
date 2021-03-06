/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2package;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fachm
 */
public class Pengembalian extends javax.swing.JFrame {

    /**
     * Creates new form Pengembalian
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pstchk = null;
    ResultSet rs = null;
    
    public Pengembalian() {
        initComponents();
        showTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldKdBk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPanePeminjaman = new javax.swing.JScrollPane();
        jTablePeminjaman = new javax.swing.JTable();
        jButtonPengembalian = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pengembalian");

        jLabel1.setText("Kode Buku");

        jLabel8.setText("1800570 - Fachri Veryawan Mahkota");

        jTablePeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Nama Buku", "Nama Peminjam", "Tanggal Pinjam", "Tanggal Pengembalian"
            }
        ));
        jScrollPanePeminjaman.setViewportView(jTablePeminjaman);

        jButtonPengembalian.setText("Pengembalian");
        jButtonPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPengembalianActionPerformed(evt);
            }
        });

        jButtonMenu.setText("Kembali ke Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(75, 75, 75)
                        .addComponent(jTextFieldKdBk, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldKdBk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPengembalian)
                    .addComponent(jButtonMenu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPanePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showTableData() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/pbo_tp2"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            String sql = "SELECT * FROM `peminjaman` ORDER BY `tanggal_pinjam` ASC";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTablePeminjaman.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void jButtonPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPengembalianActionPerformed
        // TODO add your handling code here:
        try {
            boolean kodeAda = false;

            String sql = "DELETE FROM `peminjaman` WHERE `kode_buku` = ?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/pbo_tp2"
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, jTextFieldKdBk.getText());

            pstchk = con.prepareStatement("SELECT * FROM `peminjaman`");
            ResultSet dup = pstchk.executeQuery();
            String kdBkCounter;

            while (dup.next()) {
                kdBkCounter = dup.getString("kode_buku");
                if(kdBkCounter.equals(jTextFieldKdBk.getText())) {
                    kodeAda = true;
                }
            }

            if (jTextFieldKdBk.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data gagal diperbaharui!"
                    + " Mohon lengkapi semua masukan.");
            }
            else {
                if (kodeAda == true) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil diperbaharui!");
                    showTableData();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data gagal diperbaharui!"
                        + " TIdak terdapat data dengan kode buku yang sama.");
                }
            }
        }
        catch(SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButtonPengembalianActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_jButtonMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPanePeminjaman;
    private javax.swing.JTable jTablePeminjaman;
    private javax.swing.JTextField jTextFieldKdBk;
    // End of variables declaration//GEN-END:variables
}
