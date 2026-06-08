package com.mycompany.sistemkeuangan.GUI;

import com.mycompany.sistemkeuangan.model.Hutang;
import com.mycompany.sistemkeuangan.model.User;
import com.mycompany.sistemkeuangan.model.KoneksiDB;
import com.mycompany.sistemkeuangan.model.Pendapatan;
import com.mycompany.sistemkeuangan.model.Pengeluaran;
import com.mycompany.sistemkeuangan.model.Tabungan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TransaksiForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(TransaksiForm.class.getName());

    private User user;

    public TransaksiForm(User user) {
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        jLabel1.setText("Nama    : " + user.getNama());
        jLabel2.setText("User ID : " + user.getIduser());
        loadTransaksiTable();
    }

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
            int id        = Integer.parseInt(jTable2.getValueAt(row, 0).toString());
            String jenis  = jTable2.getValueAt(row, 3).toString();

            try (Connection conn = KoneksiDB.getConnection()) {
                if (conn == null) { JOptionPane.showMessageDialog(this, "Koneksi gagal!"); return; }

                switch (jenis) {

                    case "Pendapatan": {
                        String sql = "SELECT t.idtransaksi, t.tanggal, t.jumlah, t.prioritas, t.tenggat, t.status, p.sumber "
                                   + "FROM transaksi t JOIN pendapatan p ON t.idtransaksi=p.idtransaksi "
                                   + "WHERE t.idtransaksi=?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, id);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            Pendapatan p = new Pendapatan(
                                rs.getString("tanggal"),
                                rs.getDouble("jumlah"),
                                rs.getString("prioritas"),
                                rs.getString("tenggat"),
                                rs.getString("sumber")
                            );
                            p.setidtransaksi(rs.getInt("idtransaksi"));
                            p.setStatus(rs.getString("status"));
                            new PendapatanForm(user, p).setVisible(true);
                        }
                        break;
                    }

                    case "Pengeluaran": {
                        String sql = "SELECT t.idtransaksi, t.tanggal, t.jumlah, t.prioritas, t.tenggat, t.status, pe.kebutuhan "
                                   + "FROM transaksi t JOIN pengeluaran pe ON t.idtransaksi=pe.idtransaksi "
                                   + "WHERE t.idtransaksi=?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, id);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            Pengeluaran p = new Pengeluaran(
                                rs.getString("tanggal"),
                                rs.getDouble("jumlah"),
                                rs.getString("prioritas"),
                                rs.getString("tenggat"),
                                rs.getString("kebutuhan")
                            );
                            p.setIdPengeluaran(rs.getInt("idtransaksi"));
                            p.setStatus(rs.getString("status"));
                            new PengeluaranForm(user, p).setVisible(true);
                        }
                        break;
                    }

                    case "Hutang": {
                        String sql = "SELECT t.idtransaksi, t.tanggal, t.jumlah, t.prioritas, t.tenggat, t.status, "
                                   + "h.pemberipinjaman, h.jatuhtempo "
                                   + "FROM transaksi t JOIN hutang h ON t.idtransaksi=h.idtransaksi "
                                   + "WHERE t.idtransaksi=?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, id);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            Hutang h = new Hutang(
                                rs.getString("tanggal"),
                                rs.getDouble("jumlah"),
                                rs.getString("prioritas"),
                                rs.getString("tenggat"),
                                rs.getString("pemberipinjaman"),
                                rs.getString("jatuhtempo")
                            );
                            h.setidtransaksi(rs.getInt("idtransaksi"));
                            h.setStatus(rs.getString("status"));
                            new HutangForm(user, h).setVisible(true);
                        }
                        break;
                    }

                    case "Tabungan": {
                        String sql = "SELECT t.idtransaksi, t.tanggal, t.jumlah, t.prioritas, t.tenggat, t.status, tb.tujuan "
                                   + "FROM transaksi t JOIN tabungan tb ON t.idtransaksi=tb.idtransaksi "
                                   + "WHERE t.idtransaksi=?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, id);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            Tabungan tb = new Tabungan(
                                rs.getString("tanggal"),
                                rs.getDouble("jumlah"),
                                rs.getString("prioritas"),
                                rs.getString("tenggat"),
                                rs.getString("tujuan")
                            );
                            tb.setIdTabungan(rs.getInt("idtransaksi"));
                            tb.setStatus(rs.getString("status"));
                            new TabunganForm(user, tb).setVisible(true);
                        }
                        break;
                    }

                    default:
                        JOptionPane.showMessageDialog(this, "Jenis transaksi tidak dikenali.");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Pilih transaksi dulu!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     String[] options = {"Pendapatan", "Pengeluaran", "Hutang", "Tabungan"};
        int choice = JOptionPane.showOptionDialog(
            this, "Pilih jenis transaksi:", "Tambah Transaksi",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]
        );

        switch (choice) {
            case 0 -> new PendapatanForm(user).setVisible(true);
            case 1 -> new PengeluaranForm(user).setVisible(true);
            case 2 -> new HutangForm(user).setVisible(true);
            case 3 -> new TabunganForm(user).setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = jTable2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        int id = Integer.parseInt(jTable2.getValueAt(row, 0).toString());

        try (Connection conn = KoneksiDB.getConnection()) {
            if (conn == null) { JOptionPane.showMessageDialog(this, "Koneksi gagal!"); return; }

            // hapus detail dulu (FK), lalu transaksi
            String jenis = jTable2.getValueAt(row, 3).toString();
            switch (jenis) {
                case "Pendapatan" -> { PreparedStatement p = conn.prepareStatement("DELETE FROM pendapatan WHERE idtransaksi=?"); p.setInt(1,id); p.executeUpdate(); }
                case "Pengeluaran" -> { PreparedStatement p = conn.prepareStatement("DELETE FROM pengeluaran WHERE idtransaksi=?"); p.setInt(1,id); p.executeUpdate(); }
                case "Hutang" -> { PreparedStatement p = conn.prepareStatement("DELETE FROM hutang WHERE idtransaksi=?"); p.setInt(1,id); p.executeUpdate(); }
                case "Tabungan" -> { PreparedStatement p = conn.prepareStatement("DELETE FROM tabungan WHERE idtransaksi=?"); p.setInt(1,id); p.executeUpdate(); }
            }

            PreparedStatement ps = conn.prepareStatement("DELETE FROM transaksi WHERE idtransaksi=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            loadTransaksiTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal hapus: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        loadTransaksiTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       int row = jTable2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        int id = Integer.parseInt(jTable2.getValueAt(row, 0).toString());
        String jenis = jTable2.getValueAt(row, 3).toString();
        double jumlah = Double.parseDouble(jTable2.getValueAt(row, 2).toString());
        String pesan = "";

        try (Connection conn = KoneksiDB.getConnection()) {
            if (conn == null) { JOptionPane.showMessageDialog(this, "Koneksi gagal!"); return; }

            switch (jenis) {
                case "Pendapatan": {
                    PreparedStatement ps = conn.prepareStatement("SELECT sumber FROM pendapatan WHERE idtransaksi=?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) pesan = "Pendapatan dari " + rs.getString("sumber") + " sebesar Rp " + jumlah;
                    break;
                }
                case "Pengeluaran": {
                    PreparedStatement ps = conn.prepareStatement("SELECT kebutuhan FROM pengeluaran WHERE idtransaksi=?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) pesan = "Pengeluaran untuk " + rs.getString("kebutuhan") + " sebesar Rp " + jumlah;
                    break;
                }
                case "Hutang": {
                    PreparedStatement ps = conn.prepareStatement("SELECT pemberipinjaman, jatuhtempo FROM hutang WHERE idtransaksi=?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) pesan = "Hutang dari " + rs.getString("pemberipinjaman") + " jatuh tempo " + rs.getString("jatuhtempo") + " sebesar Rp " + jumlah;
                    break;
                }
                case "Tabungan": {
                    PreparedStatement ps = conn.prepareStatement("SELECT tujuan FROM tabungan WHERE idtransaksi=?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) pesan = "Menabung untuk " + rs.getString("tujuan") + " sebesar Rp " + jumlah;
                    break;
                }
                default: pesan = "Jenis transaksi: " + jenis + " sebesar Rp " + jumlah;
            }
            JOptionPane.showMessageDialog(this, pesan.isEmpty() ? "Data tidak ditemukan." : pesan);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void loadTransaksiTable() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        try (Connection conn = KoneksiDB.getConnection()) {
            if (conn == null) { JOptionPane.showMessageDialog(this, "Koneksi gagal!"); return; }

            String sql = "SELECT idtransaksi, tanggal, jumlah, jenis, prioritas, tenggat, status FROM transaksi WHERE iduser=? ORDER BY idtransaksi DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getIduser());
            ResultSet rs = ps.executeQuery();

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
