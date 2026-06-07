package com.mycompany.sistemkeuangan.model;


public class Pengeluaran extends Transaksi {

    private int idPengeluaran;
    private String kebutuhan;
    private String currentStatus;

    public Pengeluaran(String tanggal, double jumlah,
                       String prioritas, String tenggat,
                       String kebutuhan) {

        super(tanggal, jumlah, prioritas, tenggat);
        this.kebutuhan = kebutuhan;
        this.currentStatus = "Pending";
    }

    public String getKebutuhan() {
        return kebutuhan;
    }

    public void setKebutuhan(String kebutuhan) {
        this.kebutuhan = kebutuhan;
    }

    public int getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(int idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
    }

    @Override
    public void proses() {
        System.out.println("Pengeluaran sebesar -" + getJumlah());
        currentStatus = "Selesai";
    }

    @Override
    public String info() {
        return "Pengeluaran untuk " + kebutuhan +
               " sebesar Rp " + getJumlah();
    }

    @Override
    public String status() {
        return currentStatus;
    }

    public void setStatus(String newStatus) {
        this.currentStatus = newStatus;
    }
}    