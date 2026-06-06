package com.mycompany.sistemkeuangan.model;

public class Hutang extends Transaksi {

    private String pemberiPinjaman;
    private String jatuhTempo;
    private String currentStatus;

    public Hutang(String tanggal, double jumlah,
                  String prioritas, String tenggat,
                  String pemberiPinjaman, String jatuhTempo) {

        super(tanggal, jumlah, prioritas, tenggat);

        this.pemberiPinjaman = pemberiPinjaman;
        this.jatuhTempo = jatuhTempo;
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

    @Override
    public void proses() {
        System.out.println("Memproses hutang..");
    }

    @Override
    public String info() {
        return "Hutang kepada " + pemberiPinjaman +
               " sebesar " + jumlah +
               " jatuh tempo : " + jatuhTempo;
    }

    @Override
    public String status() {
           return currentStatus;
    }

    public void setStatus(String newStatus) {
        this.currentStatus = newStatus;
    }
}