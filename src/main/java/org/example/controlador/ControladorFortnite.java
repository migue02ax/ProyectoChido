package org.example.controlador;

import org.example.modelo.ModeloTablaFortnite;
import org.example.modelo.Fortnite;
import org.example.vista.VentanaFortnite;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorFortnite extends MouseAdapter {
    private VentanaFortnite view;
    private ModeloTablaFortnite modelo;

    public ControladorFortnite(VentanaFortnite view) {
        this.view = view;
        modelo = new ModeloTablaFortnite();
        modelo.cargarDatos();
        this.view.getTblFortnite().setModel(modelo);
        this.view.getTblFortnite().updateUI();

        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblFortnite().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Evento del boton cargar:
        if(e.getSource() == this.view.getBtnCargar()){
            modelo.cargarDatos();
            this.view.getTblFortnite().setModel(modelo);
            this.view.getTblFortnite().updateUI();
        }

        //Eventos del boton agregar:
        if(e.getSource() == this.view.getBtnAgregar()){
            Fortnite fortnite = new Fortnite();
            fortnite.setId(0);
            fortnite.setNombre(this.view.getTxtNombre().getText());
            fortnite.setArma(this.view.getTxtArma().getText());
            fortnite.setBaile(this.view.getTxtBaile().getText());
            fortnite.setUbicacion(this.view.getTxtUbicacion().getText());
            fortnite.setUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarFortnite(fortnite)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblFortnite().updateUI();
            }else{
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de Datos." +
                        "Por favor revise su conexion", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }

        //Eventos sobre la tabla:
        if(e.getSource() == view.getTblFortnite()){
            System.out.println("Evento sobre tabla");
            int index = this.view.getTblFortnite().getSelectedRow();
            Fortnite tmp = modelo.getFortniteAtIndex(index);
            try{
                this.view.getImagenFortnite().setIcon(tmp.getImagen());
                this.view.getImagenFortnite().setText("");
            }catch(MalformedURLException mfue){
                System.out.println("Imagen no encontrada");
            }
        }

        //Evento del boton Delete:
        if(e.getSource() == view.getBtnDelete()){
            int index = this.view.getTblFortnite().getSelectedRow();
            int id = modelo.getFortniteAtIndex(index).getId();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Seguro que quieres borrar el elemento con indice: "
                    + id + "?", "Atencion", JOptionPane.YES_NO_OPTION);
            if(respuesta == 0){
                if(modelo.borrarFortnite(id)){
                    JOptionPane.showMessageDialog(view, "Se borro ese renglon");

                    modelo.cargarDatos();
                    this.view.getTblFortnite().setModel(modelo);
                    this.view.getTblFortnite().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No has cargado la tabla");
                }
            }
        }

        //Evento del boton Actualizar:
        if(e.getSource() == view.getBtnActualizar()){

            //Para actualizar cualquier casilla con dato de tipo String:
            try{
                Object o = this.view.getTxtActualizar().getText();
                int index = this.view.getTblFortnite().getSelectedRow();
                int id = modelo.getFortniteAtIndex(index).getId();
                int columna = this.view.getTblFortnite().getSelectedColumn();

                if(modelo.actualizarUnElemento(o, id, columna)){
                    JOptionPane.showMessageDialog(view, "Se actualizo ese elemento");
                    this.view.limpiar();
                    modelo.cargarDatos();
                    this.view.getTblFortnite().setModel(modelo);
                    this.view.getTblFortnite().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No has cargado la tabla");
                }
                //Para actualizar las casillas que poseen datos Double:
            }catch (ClassCastException cce){
                Object o = Double.parseDouble(this.view.getTxtActualizar().getText());
                int index = this.view.getTblFortnite().getSelectedRow();
                int id = modelo.getFortniteAtIndex(index).getId();
                int columna = this.view.getTblFortnite().getSelectedColumn();

                if(modelo.actualizarUnElemento(o, id, columna)){
                    JOptionPane.showMessageDialog(view, "Se actualizo ese elemento");
                    modelo.cargarDatos();
                    this.view.getTblFortnite().setModel(modelo);
                    this.view.getTblFortnite().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No se puede modificar el id");
                }

            }

        }
    }
}