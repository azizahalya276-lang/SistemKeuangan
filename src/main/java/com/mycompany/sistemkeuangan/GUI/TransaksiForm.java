package com.mycompany.sistemkeuangan.GUI;
import javax.swing.JOptionPane;
import com.mycompany.sistemkeuangan.model.Pendapatan;
import com.mycompany.sistemkeuangan.model.Pengeluaran;
import com.mycompany.sistemkeuangan.model.Hutang;
import com.mycompany.sistemkeuangan.model.Tabungan;
import com.mycompany.sistemkeuangan.model.Transaksi;
import com.mycompany.sistemkeuangan.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class TransaksiForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(TransaksiForm.class.getName());

    private User user; // menyimpan user aktif

    // Konstruktor menerima User dari Login
    public TransaksiForm(User user) {
    this.user = user;
    initComponents();
    setLocationRelativeTo(null);

    jLabel1.setText("Nama : " + user.getNama());
    jLabel2.setText("User ID : " + user.getIduser());

    System.out.println("Masuk ke TransaksiForm untuk user: " + user.getNama());

    loadTransaksiTable();
    }

    // Konstruktor default (supaya bisa dipanggil dari main)
    public TransaksiForm() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tanggal", "Jumlah Uang", "Jenis", "Prioritas", "Tenggat Waktu", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jButton3.setText("Edit");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Tambah Transaksi");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setText("Hapus");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton6.setText("Refresh");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("TRANSAKSI KEUANGAN");

        jLabel1.setText("nama    : ");

        jLabel2.setText("user  ID : ");

        jButton7.setText("Proses");
        jButton7.addActionListener(this::jButton7ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton3)
                .addGap(44, 44, 44)
                .addComponent(jButton5)
                .addGap(45, 45, 45)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable2.getSelectedRow();
        if(row >= 0) {
            String jenis = jTable2.getValueAt(row, 2).toString();
            switch (jenis) {
                case "Pendapatan" -> {
                    Pendapatan pendapatan = (Pendapatan) user.getDaftarTransaksi().get(row);
                    new PendapatanForm(user, pendapatan).setVisible(true);
                }

                case "Pengeluaran" -> {
                    Pengeluaran pengeluaran = (Pengeluaran) user.getDaftarTransaksi().get(row);
                    new PengeluaranForm(user, pengeluaran).setVisible(true);
                }

                case "Hutang" -> {
                    Hutang hutang = (Hutang) user.getDaftarTransaksi().get(row);
                    new HutangForm(user, hutang).setVisible(true);
                }

                case "Tabungan" -> {
                    Tabungan tabungan = (Tabungan) user.getDaftarTransaksi().get(row);
                    new TabunganForm(user, tabungan).setVisible(true);
                }
                default -> JOptionPane.showMessageDialog(this, "Jenis transaksi tidak dikenali!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih transaksi dulu!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String[] options = {"Pendapatan", "Pengeluaran", "Tagihan", "Hutang", "Tabungan"};
        int choice = javax.swing.JOptionPane.showOptionDialog(
            this,
            "Pilih jenis transaksi:",
            "Tambah Transaksi",
            javax.swing.JOptionPane.DEFAULT_OPTION,
            javax.swing.JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );

        switch(choice) {
           case 0 -> {
               PendapatanForm pf = new PendapatanForm(user);
               pf.setVisible(true);
            }
            case 1 -> new PengeluaranForm(user).setVisible(true);
            case 3 -> new HutangForm(user).setVisible(true);
            case 4 -> new TabunganForm(user).setVisible(true);
            default -> {
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = jTable2.getSelectedRow();
        if(row >= 0) {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistemkeuangan", "root", "")) {

                String id = jTable2.getValueAt(row, 0).toString();
                String jenis = jTable2.getValueAt(row, 3).toString();

                String sql = switch (jenis) {
                    case "Pendapatan" -> "DELETE FROM pendapatan WHERE id_pendapatan=?";
                    case "Pengeluaran" -> "DELETE FROM pengeluaran WHERE id_pengeluaran=?";
                    case "Hutang" -> "DELETE FROM hutang WHERE id_hutang=?";
                    case "Tabungan" -> "DELETE FROM tabungan WHERE id_tabungan=?";
                    default -> null;
                };

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(id));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data dihapus!");
                loadTransaksiTable();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal hapus: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        loadTransaksiTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int row = jTable2.getSelectedRow();
        if(row >= 0) {

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistemkeuangan", "root", "")) {

                String id = jTable2.getValueAt(row, 0).toString();
                String jenis = jTable2.getValueAt(row, 3).toString();

                String sql = switch (jenis) {
                    case "Pendapatan" -> "UPDATE pendapatan SET status=? WHERE id_pendapatan=?";
                    case "Hutang" -> "UPDATE hutang SET status=? WHERE id_hutang=?";
                    default -> null;
                };

                if (sql == null) {
                    JOptionPane.showMessageDialog(this, "Jenis ini tidak bisa diproses!");
                    return;
                }

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "Selesai");
                ps.setInt(2, Integer.parseInt(id));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Transaksi diproses!");
                loadTransaksiTable();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal proses: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Pilih transaksi dulu!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void loadTransaksiTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah");
        model.addColumn("Jenis");
        model.addColumn("Prioritas");
        model.addColumn("Tenggat");
        model.addColumn("Status");

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistemkeuangan", "root", "")) {

                String sql =
                    "SELECT idpendapatan, tanggal, jumlah, 'Pendapatan' AS jenis, prioritas, tenggat, status FROM pendapatan " +
                    "UNION ALL " +
                    "SELECT idpengeluaran, tanggal, jumlah, 'Pengeluaran', prioritas, tenggat, status FROM pengeluaran " +
                    "UNION ALL " +
                    "SELECT idhutang, tanggal, jumlah, 'Hutang', prioritas, tenggat, status FROM hutang " +
                    "UNION ALL " +
                    "SELECT idtabungan, tanggal, jumlah, 'Tabungan', prioritas, tenggat, status status FROM tabungan";

                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                model.setRowCount(0);

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("tanggal"),
                        rs.getDouble("jumlah"),
                        rs.getString("jenis"),
                        rs.getString("prioritas"),
                        rs.getString("tenggat"),
                        rs.getString("status")
                    });
                }

                jTable2.setModel(model);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal load transaksi: " + e.getMessage());
        }
    }
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TransaksiForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}   
