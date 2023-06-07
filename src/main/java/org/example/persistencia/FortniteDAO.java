package org.example.persistencia;

import org.example.modelo.Fortnite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FortniteDAO implements InterfazDAO {
    public FortniteDAO() {
    }

    //Metodo invocado en el modelo en el metodo AgregarFortnite
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO fortnite(nombre,arma,baile,ubicacion,url) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Fortnite) obj).getNombre());
        pstm.setString(2, ((Fortnite) obj).getArma());
        pstm.setString(3, ((Fortnite) obj).getBaile());
        pstm.setString(4, ((Fortnite) obj).getUbicacion());
        pstm.setString(5, ((Fortnite) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE fortnite SET nombre = ?,arma = ?,baile = ?,ubicacion = ?,url = ? WHERE id = ? ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Fortnite) obj).getNombre());
        pstm.setString(2, ((Fortnite) obj).getArma());
        pstm.setString(3, ((Fortnite) obj).getBaile());
        pstm.setString(4, ((Fortnite) obj).getUbicacion());
        pstm.setString(5, ((Fortnite) obj).getUrl());
        pstm.setInt(6, ((Fortnite) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    //Metodo invocado en el modelo en el metodo actualizarUnElemento
    public boolean updateUnElemento(Object obj, int id, int columna) throws SQLException {
        int rowCount = 0;
        String sqlDelete;
        PreparedStatement pstm= null;
        switch (columna){
            case 0:
                System.out.println("No se puede actualizar un id");
                break;
            case 1:
                sqlDelete = "UPDATE fortnite SET nombre = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 2:
                sqlDelete = "UPDATE fortnite SET arma = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 3:
                sqlDelete = "UPDATE fortnite SET baile = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setDouble(1, (Double)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 4:
                sqlDelete = "UPDATE fortnite SET ubicacion = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 5:
                sqlDelete = "UPDATE fortnite SET url = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
        }
        return rowCount > 0;
    }

    //Metodo invocado en el modelo en el metodo borrarFortnite
    @Override
    public boolean delete(int id) throws SQLException {
        String sqlDelete = "DELETE FROM fortnite WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, id);
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM fortnite";
        ArrayList<Fortnite> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Fortnite(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6)));
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM fortnite WHERE id = ?";
        Fortnite fortnite = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("fortniteDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            fortnite = new Fortnite(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6));

            return fortnite;
        }
        return null;
    }

}