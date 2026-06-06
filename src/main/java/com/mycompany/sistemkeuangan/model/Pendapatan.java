package com.mycompany.sistemkeuangan.model;

public class Pendapatan extends Transaksi {

    private String sumber;
    private String currentStatus;

    public Pendapatan(String tanggal, double jumlah, String prioritas,
                      String tenggat, String sumber) {

        super(tanggal, jumlah, prioritas, tenggat);
        this.sumber = sumber;
    }

    public String getSumber() {
        return sumber;
    }
    
    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    @Override
    public void proses() {
        System.out.println("Memproses pendapatan...");   
    }

    @Override
    public String info() {
        return "Pendapatan dari " + sumber + " sebesar " + jumlah;
    }

    @Override
    public String status() {
        return currentStatus;
    }
    
    public void setStatus(String newStatus) {
        this.currentStatus = newStatus;
    }
}