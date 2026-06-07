package com.mycompany.sistemkeuangan.model;

public class Pendapatan extends Transaksi {

    private int idPendapatan;
    private String sumber;
    private String currentStatus;


    public Pendapatan(String tanggal, double jumlah, String prioritas,
                  String tenggat, String sumber) {
    super(tanggal, jumlah, prioritas, tenggat);
    this.sumber = sumber;
    this.currentStatus = "Pending";
    }


    public String getSumber() {
        return sumber;
    }
    
    public void setSumber(String sumber) {
        this.sumber = sumber;
    }
    
    public int getIdPendapatan() {
    return idPendapatan;
    }

    public void setIdPendapatan(int idPendapatan) {
    this.idPendapatan = idPendapatan;
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