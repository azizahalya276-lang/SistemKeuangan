package com.mycompany.sistemkeuangan.model;

public class Tabungan extends Transaksi {
    
    private int idTabungan;
    private String tujuan;
    private String currentStatus;

    public Tabungan(String tanggal, double jumlah,
                    String prioritas, String tenggat,
                    String tujuan) {

        super(tanggal, jumlah, prioritas, tenggat);

        this.tujuan = tujuan;
        this.currentStatus = "Belum Terkumpul";
    }

    public String getTujuan() {
        return tujuan;
    }
    
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
     
    public int getIdTabungan() {
        return idTabungan;
    }

    public void setIdTabungan(int idTabungan) {
        this.idTabungan = idTabungan;
    }

    @Override
    public void proses() {
        System.out.println("Menabung Rp " + getJumlah() + " untuk " + tujuan);
    }

    @Override
    public String info() {
        return "Tabungan untuk " + tujuan +
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