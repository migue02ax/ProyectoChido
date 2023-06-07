package org.example;

import org.example.controlador.ControladorFortnite;
import org.example.vista.VentanaFortnite;


public class Main {
    public static void main(String[] args) {
        VentanaFortnite view = new VentanaFortnite("Fortnite");
        ControladorFortnite controller = new ControladorFortnite(view);
    }

}