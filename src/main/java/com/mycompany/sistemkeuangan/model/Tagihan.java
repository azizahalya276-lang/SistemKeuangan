package com.mycompany.sistemkeuangan.model;

public class Tagihan extends Transaksi {

    private String jenisTagihan;
    private String jatuhTempo;
    private String currentStatus;

    public Tagihan(String tanggal, double jumlah,
                   String prioritas, String tenggat,
                   String jenisTagihan, String jatuhTempo) {

        super(tanggal, jumlah, prioritas, tenggat);

        this.jenisTagihan = jenisTagihan;
        this.jatuhTempo = jatuhTempo;
    }

    public String getJenisTagihan() {
        return jenisTagihan;
    }

    public void setJenisTagihan(String jenisTagihan) {
        this.jenisTagihan = jenisTagihan;
    }

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    @Override
    public void proses() {
        System.out.println("Memproses tagihan...");
    }

    @Override
    public String info() {
        return "Tagihan " + jenisTagihan +
               " sebesar " + jumlah +
               " Jatuh tempo : " + jatuhTempo ;
    }

    @Override
    public String status() {
    return currentStatus;
    }

    public void setStatus(String newStatus) {
        this.currentStatus = newStatus;
    }
}