package com.mycompany.sistemkeuangan.model;


import java.util.ArrayList;

public class User {
    private int iduser;      // User ID
    private String nama;        // Username
    private String password;    // Password

    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // Constructor
    public User(int iduser, String nama, String password) {
        this.iduser = iduser;
        this.nama = nama;
        this.password = password;
    }

    // Getter
    public int getIduser() { return iduser; }
    public String getNama() { return nama; }
    public String getPassword() { return password; }
    public ArrayList<Transaksi> getDaftarTransaksi() { return daftarTransaksi; }

    // Setter (opsional, kalau mau ubah data)
    public void setIduser(int iduser) { this.iduser = iduser; }
    public void setNama(String nama) { this.nama = nama; }
    public void setPassword(String password) { this.password = password; }

    // Tambah transaksi
    public void tambahTransaksi(Transaksi t) {
        daftarTransaksi.add(t);
    }

    // Edit transaksi
    public void editTransaksi(int index, Transaksi t) {
        if(index >= 0 && index < daftarTransaksi.size()) {
            daftarTransaksi.set(index, t);
        }
    }

    // Hapus transaksi
    public void hapusTransaksi(int index) {
        if(index >= 0 && index < daftarTransaksi.size()) {
            daftarTransaksi.remove(index);
        }
    }
}
