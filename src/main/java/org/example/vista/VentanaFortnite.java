package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaFortnite extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblArma;
    private JLabel lblBaile;
    private JLabel lblUbicacion;
    private JLabel lblUrl;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtArma;
    private JTextField txtBaile;
    private JTextField txtUbicacion;
    private JTextField txtUrl;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblFortnite;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1; //formulario para capturar fornites
    private JPanel panel2; //Tabla para mostrar los fortnites
    private JPanel panel3; //Mostrar imagen seleccionada del fortnite
    private JPanel panel4; //Eliminacion y actualizacion de campos
    private JLabel imagenFortnite;
    private JLabel lblDelete;
    private JButton btnDelete;
    private JTextArea txaActualizar;
    private JButton btnActualizar;
    private JTextField txtActualizar;
    public VentanaFortnite(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(183, 153, 255));
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblArma = new JLabel("Arma:");
        lblBaile = new JLabel("Baile:");
        lblUbicacion = new JLabel("Ubicacion:");
        lblUrl = new JLabel("URL:");
        txtId = new JTextField(2);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(10);
        txtArma = new JTextField(10);
        txtBaile = new JTextField(6);
        txtUbicacion = new JTextField(7);
        txtUrl = new JTextField(23);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblArma);
        panel1.add(txtArma);
        panel1.add(lblBaile);
        panel1.add(txtBaile);
        panel1.add(lblUbicacion);
        panel1.add(txtUbicacion);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);



        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(172, 188, 255));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblFortnite = new JTable();
        scrollPane = new JScrollPane(tblFortnite);
        panel2.add(scrollPane);

        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(174, 226, 255));
        imagenFortnite = new JLabel("...");
        panel3.add(imagenFortnite);


        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(230, 255, 253));
        lblDelete = new JLabel("Seleccione la fila que desee borrar y oprima el boton");
        btnDelete = new JButton("Delete");
        txaActualizar = new JTextArea("Actualizar:"+ "\n1.Escriba el nuevo valor." +
                "\n 2.Seleccione la casilla que desea sustituir" + " \n 3.Oprima el boton actualizar");
        txaActualizar.setBackground(null);
        txtActualizar = new JTextField(14);
        btnActualizar = new JButton("Actualizar");
        panel4.add(lblDelete);
        panel4.add(btnDelete);
        panel4.add(txaActualizar);
        panel4.add(txtActualizar);
        panel4.add(btnActualizar);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblArma() {
        return lblArma;
    }

    public void setLblArma(JLabel lblArma) {
        this.lblArma = lblArma;
    }

    public JLabel getLblBaile() {
        return lblBaile;
    }

    public void setLblBaile(JLabel lblBaile) {
        this.lblBaile = lblBaile;
    }

    public JLabel getLblUbicacion() {
        return lblUbicacion;
    }

    public void setLblUbicacion(JLabel lblUbicacion) {
        this.lblUbicacion = lblUbicacion;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtArma() {
        return txtArma;
    }

    public void setTxtArma(JTextField txtArma) {
        this.txtArma = txtArma;
    }

    public JTextField getTxtBaile() {
        return txtBaile;
    }

    public void setTxtBaile(JTextField txtBaile) {
        this.txtBaile = txtBaile;
    }

    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }

    public void setTxtUbicacion(JTextField txtUbicacion) {
        this.txtUbicacion = txtUbicacion;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblFortnite() {
        return tblFortnite;
    }

    public void setTblFortnite(JTable tblFortnite) {
        this.tblFortnite = tblFortnite;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenFortnite() {
        return imagenFortnite;
    }

    public void setImagenFortnite(JLabel imagenFortnite) {
        this.imagenFortnite = imagenFortnite;
    }

    public JLabel getLblDelete() {
        return lblDelete;
    }

    public void setLblDelete(JLabel lblDelete) {
        this.lblDelete = lblDelete;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JTextArea getTxaActualizar() {
        return txaActualizar;
    }

    public void setTxaActualizar(JTextArea txaActualizar) {
        this.txaActualizar = txaActualizar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTextField getTxtActualizar() {
        return txtActualizar;
    }

    public void setTxtActualizar(JTextField txtActualizar) {
        this.txtActualizar = txtActualizar;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtArma.setText("");
        txtBaile.setText("");
        txtUbicacion.setText("");
        txtUrl.setText("");
        txtActualizar.setText("");

    }
}