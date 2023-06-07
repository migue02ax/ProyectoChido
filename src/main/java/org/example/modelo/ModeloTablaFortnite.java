package org.example.modelo;

import org.example.persistencia.FortniteDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaFortnite implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Fortnite> datos;
    private FortniteDAO mtdao;

    public ModeloTablaFortnite() {
        mtdao = new FortniteDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaFortnite(ArrayList<Fortnite> datos) {
        this.datos = datos;
        mtdao = new FortniteDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Arma";
            case 3:
                return "Baile";
            case 4:
                return "Ubicacion";
            case 5:
                return "Foto(URL)";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fortnite tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getArma();
            case 3:
                return tmp.getBaile();
            case 4:
                return tmp.getUbicacion();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setArma((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setBaile((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setUbicacion((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No se necesita modificar nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    //Metodo que se invoca en el controlador para boton cargar:
    public void cargarDatos(){
        try {
            ArrayList<Fortnite> tirar = mtdao.obtenerTodo();
            System.out.println(tirar);
            datos = mtdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }

    //Metodo que se invoca en el controlador para boton agregar:
    public boolean agregarFortnite(Fortnite fortnite){
        boolean resultado = false;
        try{
            if(mtdao.insertar(fortnite)){
                datos.add(fortnite);
                resultado = true;
            }else{
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Fortnite getFortniteAtIndex(int idx){
        return datos.get(idx);
    }

    //Metodo que se invoca en el controlador para boton delete:
    public boolean borrarFortnite(int id) {
        boolean resultado = false;
        try {
            if (mtdao. delete(id)) {
                resultado = true;
            }else{
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println("No se pudo");
        }
        return resultado;
    }

    //Metodo que se invoca en el controlador para boton Actualizar:
    public boolean actualizarUnElemento(Object o, int id, int columna){
        boolean resultado = false;
        try {
            if (mtdao.updateUnElemento(o,id,columna)) {
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println("No se pudo");
        }
        return resultado;
    }

}