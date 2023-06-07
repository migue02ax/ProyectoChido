package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Fortnite {
    private int id;
    private String nombre;
    private String arma;
    private String baile;
    private String ubicacion;
    private String url;

    public Fortnite() {
    }

    public Fortnite(int id, String nombre, String arma, String baile, String ubicacion, String url) {
        this.id = id;
        this.nombre = nombre;
        this.arma = arma;
        this.baile = baile;
        this.ubicacion = ubicacion;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getBaile() {
        return baile;
    }

    public void setBaile(String baile) {
        this.baile = baile;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Fortnite{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", arma='" + arma + '\'' +
                ", baile=" + baile +
                ", ubicacion='" + ubicacion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }
}