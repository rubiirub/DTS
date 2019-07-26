package com.example.demoakhir.koneksi;

public class MyData {
    //ketik manual ini
    private String id,nama_teman, alamat_teman;

    //gunakan generate constructor
    public MyData() {
    }
    //gunakan generate constructor
    public MyData(String id, String nama_teman, String alamat_teman) {
        this.id = id;
        this.nama_teman = nama_teman;
        this.alamat_teman = alamat_teman;
    }

    //gunakan generate gettter dan setter
    public String getId() {
        return id;
    }

    //gunakan generate gettter dan setter
    public void setId(String id) {
        this.id = id;
    }

    //gunakan generate gettter dan setter
    public String getNama_teman() {
        return nama_teman;
    }

    //gunakan generate gettter dan setter
    public void setNama_teman(String nama_teman) {
        this.nama_teman = nama_teman;
    }

    //gunakan generate gettter dan setter
    public String getAlamat_teman() {
        return alamat_teman;
    }

    //gunakan generate gettter dan setter
    public void setAlamat_teman(String alamat_teman) {
        this.alamat_teman = alamat_teman;
    }
}
