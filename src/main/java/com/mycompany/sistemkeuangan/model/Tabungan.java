package com.mycompany.sistemkeuangan.model;

public class Tabungan extends Transaksi {
    
    private int idTabungan;
    private String tujuan;

    public Tabungan(String tanggal, double jumlah,
                    String prioritas, String tenggat,
                    String tujuan) {

        super(tanggal, jumlah, prioritas, tenggat);

        this.tujuan = tujuan;
        this.status = "Belum Terkumpul";
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
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }    
}