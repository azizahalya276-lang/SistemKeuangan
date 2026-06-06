package com.mycompany.sistemkeuangan.model;

public class Tabungan extends Transaksi {

    private String tujuan;
    private String currentStatus;

    public Tabungan(String tanggal, double jumlah,
                    String prioritas, String tenggat,
                    String tujuan) {

        super(tanggal, jumlah, prioritas, tenggat);

        this.tujuan = tujuan;
    }

    public String getTujuan() {
        return tujuan;
    }
    
     public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    @Override
    public void proses() {
        System.out.println("Memproses tabungan...");
    }

    @Override
    public String info() {
        return "Tabungan untuk " + tujuan +
               " sebesar " + jumlah;
    }

    @Override
    public String status() {
        return currentStatus;
    }

    public void setStatus(String newStatus) {
        this.currentStatus = newStatus;
    }
}