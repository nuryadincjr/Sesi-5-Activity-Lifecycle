package com.nuryadincjr.activitylifecycle.pojo;

public class Hiros {

    private String id;
    private String nama;

    public Hiros() {
    }

    public Hiros(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
