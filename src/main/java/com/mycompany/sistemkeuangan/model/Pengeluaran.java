package com.mycompany.sistemkeuangan.model;

public class Pengeluaran extends Transaksi {

    private String kebutuhan;
    private String currentStatus;

    public Pengeluaran(String tanggal, double jumlah,
                       String prioritas, String tenggat,
                       String kebutuhan) {

        super(tanggal, jumlah, prioritas, tenggat);
        this.kebutuhan = kebutuhan;
    }

    public String getKebutuhan() {
        return kebutuhan;
    }
    
    public void setKebutuhan(String kebutuhan) {
        this.kebutuhan = kebutuhan;
    }

    @Override
    public void proses() {
        System.out.println("Memproses pengeluaran...");
    }

    @Override
    public String info() {
        return "Pengeluaran untuk " + kebutuhan +
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