package com.mycompany.sistemkeuangan.model;

public class Hutang extends Transaksi {
    
    private int idHutang;
    private String pemberiPinjaman;
    private String jatuhTempo;
    private String currentStatus;

    public Hutang(String tanggal, double jumlah,
                  String prioritas, String tenggat,
                  String pemberiPinjaman, String jatuhTempo) {

        super(tanggal, jumlah, prioritas, tenggat);

        this.pemberiPinjaman = pemberiPinjaman;
        this.jatuhTempo = jatuhTempo;
        this.currentStatus = "Belum Lunas";
    }

    public String getPemberiPinjaman() {
        return pemberiPinjaman;
    }

    public void setPemberiPinjaman(String pemberiPinjaman) {
        this.pemberiPinjaman = pemberiPinjaman;
    }

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }
    
    public int getIdHutang() {
        return idHutang;
    }

    public void setIdHutang(int idHutang) {
        this.idHutang = idHutang;
    }

    @Override
    public void proses() {
        System.out.println("Hutang dicatat sebesar Rp " + getJumlah());
        currentStatus = "Belum Lunas";
    }

    @Override
    public String info() {
        return "Hutang kepada " + pemberiPinjaman +
               " sebesar Rp " + getJumlah() +
               " | Jatuh tempo: " + jatuhTempo;
    }

    @Override
    public String status() {
        return currentStatus;
    }

    public void setStatus(String newStatus) {
        this.currentStatus = newStatus;
    }
}