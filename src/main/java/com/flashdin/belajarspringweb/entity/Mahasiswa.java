/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.entity;

/**
 *
 * @author Fajar
 */
public class Mahasiswa {

    protected int id;
    private String nama;
    private String alamat;
    private int no_telepon;
    private int sks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(int no_telepon) {
        this.no_telepon = no_telepon;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
