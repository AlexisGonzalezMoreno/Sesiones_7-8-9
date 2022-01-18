package com.example.Ejercicio4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private double price;
    private String batery;
    private int numUsb;
    private boolean hdmi;

    //contstructor

    public Laptop() {


    }
    public Laptop(Long id, String marca, double price, String batery, int numUsb, boolean hdmi) {
        this.id = id;
        this.marca = marca;
        this.price = price;
        this.batery = batery;
        this.numUsb = numUsb;
        this.hdmi = hdmi;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBatery() {
        return batery;
    }

    public void setBatery(String batery) {
        this.batery = batery;
    }

    public int getNumUsb() {
        return numUsb;
    }

    public void setNumUsb(int numUsb) {
        this.numUsb = numUsb;
    }

    public boolean isHdmi() {
        return hdmi;
    }

    public void setHdmi(boolean hdmi) {
        this.hdmi = hdmi;
    }

    //tostring

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", price=" + price +
                ", batery='" + batery + '\'' +
                ", numUsb=" + numUsb +
                ", hdmi=" + hdmi +
                '}';
    }
}
