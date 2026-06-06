package com.mycompany.sistemkeuangan.model;

public abstract class Transaksi implements ProsesTransaksi {
    protected String tanggal;
    protected double jumlah;
    protected String prioritas;
    protected String tenggat;

    public Transaksi(String tanggal, double jumlah, String prioritas, String tenggat) {
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.prioritas = prioritas;
        this.tenggat = tenggat;
    }

    public String getTanggal() { return tanggal; }
    public double getJumlah() { return jumlah; }
    public String getPrioritas() { return prioritas; }
    public String getTenggat() { return tenggat; }
    
    public void setTanggal(String tanggal) {
    this.tanggal = tanggal;
}

public void setJumlah(double jumlah) {
    this.jumlah = jumlah;
}

public void setPrioritas(String prioritas) {
    this.prioritas = prioritas;
}

public void setTenggat(String tenggat) {
    this.tenggat = tenggat;
}

    public abstract String status();
}

