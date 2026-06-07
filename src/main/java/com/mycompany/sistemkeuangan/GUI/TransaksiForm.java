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

        if (row >= 0) {

            int id = Integer.parseInt(jTable2.getValueAt(row, 0).toString());
            String jenis = jTable2.getValueAt(row, 3).toString();

            // contoh ambil input baru (bisa dari dialog / form edit)
            String tanggalBaru = JOptionPane.showInputDialog(this, "Tanggal baru:");
            String jumlahStr = JOptionPane.showInputDialog(this, "Jumlah baru:");
            double jumlahBaru = Double.parseDouble(jumlahStr);

            Connection conn = null;

            try {
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistemkeuangan", "root", "");

                conn.setAutoCommit(false); // 🔥 TRANSACTION

                // 🔵 UPDATE TRANSAKSI
                String sql1 = "UPDATE transaksi SET tanggal=?, jumlah=? WHERE id_transaksi=?";
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, tanggalBaru);
                ps1.setDouble(2, jumlahBaru);
                ps1.setInt(3, id);
                ps1.executeUpdate();

                // 🔵 UPDATE DETAIL SESUAI JENIS
                switch (jenis) {

                    case "Pendapatan":
                        String sumber = JOptionPane.showInputDialog(this, "Sumber baru:");
                        String sql2 = "UPDATE pendapatan SET sumber=? WHERE id_transaksi=?";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setString(1, sumber);
                        ps2.setInt(2, id);
                        ps2.executeUpdate();
                        break;

                    case "Pengeluaran":
                        String kebutuhan = JOptionPane.showInputDialog(this, "Kebutuhan baru:");
                        String sql3 = "UPDATE pengeluaran SET kebutuhan=? WHERE id_transaksi=?";
                        PreparedStatement ps3 = conn.prepareStatement(sql3);
                        ps3.setString(1, kebutuhan);
                        ps3.setInt(2, id);
                        ps3.executeUpdate();
                        break;

                    case "Hutang":
                        String pemberi = JOptionPane.showInputDialog(this, "Pemberi pinjaman:");
                        String tempo = JOptionPane.showInputDialog(this, "Jatuh tempo:");
                        String sql4 = "UPDATE hutang SET pemberipinjaman=?, jatuhtempo=? WHERE id_transaksi=?";
                        PreparedStatement ps4 = conn.prepareStatement(sql4);
                        ps4.setString(1, pemberi);
                        ps4.setString(2, tempo);
                        ps4.setInt(3, id);
                        ps4.executeUpdate();
                        break;

                    case "Tabungan":
                        String tujuan = JOptionPane.showInputDialog(this, "Tujuan baru:");
                        String sql5 = "UPDATE tabungan SET tujuan=? WHERE id_transaksi=?";
                        PreparedStatement ps5 = conn.prepareStatement(sql5);
                        ps5.setString(1, tujuan);
                        ps5.setInt(2, id);
                        ps5.executeUpdate();
                        break;
                }

                conn.commit(); // 🔥 SIMPAN

                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                loadTransaksiTable();

            } catch (Exception e) {
                try {
                    if (conn != null) conn.rollback(); // 🔥 rollback
                } catch (SQLException ex) {}

                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
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

        if (row >= 0) {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistemkeuangan", "root", "")) {

                int id = Integer.parseInt(jTable2.getValueAt(row, 0).toString());

                String sql = "DELETE FROM transaksi WHERE idtransaksi=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
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

        if (row >= 0) {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistemkeuangan", "root", "")) {

                int id = Integer.parseInt(jTable2.getValueAt(row, 0).toString());
                String jenis = jTable2.getValueAt(row, 3).toString();
                double jumlah = Double.parseDouble(jTable2.getValueAt(row, 2).toString());

                String pesan = "";

                switch (jenis) {

                    case "Pendapatan":
                        String sql1 = "SELECT sumber FROM pendapatan WHERE idtransaksi=?";
                        PreparedStatement ps1 = conn.prepareStatement(sql1);
                        ps1.setInt(1, id);
                        ResultSet rs1 = ps1.executeQuery();

                        if (rs1.next()) {
                            String sumber = rs1.getString("sumber");
                            pesan = "Pendapatan dari " + sumber + " sebesar " + jumlah;
                        }
                        break;

                    case "Pengeluaran":
                        String sql2 = "SELECT kebutuhan FROM pengeluaran WHERE idtransaksi=?";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setInt(1, id);
                        ResultSet rs2 = ps2.executeQuery();

                        if (rs2.next()) {
                            String kebutuhan = rs2.getString("kebutuhan");
                            pesan = "Pengeluaran untuk " + kebutuhan + " sebesar " + jumlah;
                        }
                        break;

                    case "Hutang":
                        String sql3 = "SELECT pemberipinjaman, jatuhtempo FROM hutang WHERE idtransaksi=?";
                        PreparedStatement ps3 = conn.prepareStatement(sql3);
                        ps3.setInt(1, id);
                        ResultSet rs3 = ps3.executeQuery();

                        if (rs3.next()) {
                            String pemberi = rs3.getString("pemberipinjaman");
                            String tempo = rs3.getString("jatuhtempo");
                            pesan = "Hutang dari " + pemberi + " jatuh tempo " + tempo + " sebesar " + jumlah;
                        }
                        break;

                    case "Tabungan":
                        String sql4 = "SELECT tujuan FROM tabungan WHERE idtransaksi=?";
                        PreparedStatement ps4 = conn.prepareStatement(sql4);
                        ps4.setInt(1, id);
                        ResultSet rs4 = ps4.executeQuery();

                        if (rs4.next()) {
                            String tujuan = rs4.getString("tujuan");
                            pesan = "Menabung untuk " + tujuan + " sebesar " + jumlah;
                        }
                        break;
                }

                JOptionPane.showMessageDialog(this, pesan);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
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

            String sql = "SELECT * FROM transaksi WHERE iduser=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getIduser());

            ResultSet rs = ps.executeQuery();

            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("idtransaksi"),
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
