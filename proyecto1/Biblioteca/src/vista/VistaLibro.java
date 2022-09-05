package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class VistaLibro extends javax.swing.JPanel {

    public JTextField campoNombre;
    public JButton btnBuscarNombre;
    public JButton btnBuscarFiltro;
    public JButton btnNuevoLibro;
    public JButton btnActualizarLibro;
    private JLabel etiquetaNombre;
    private JLabel etiquetaDe;
    private JLabel etiquetaA;
    private JLabel etiquetaAutor;
    public JTextField campoRangoI;
    public JTextField campoRangoF;
    public JTextField campoAutor;
    public DefaultTableModel diseño;
    public JTable tabla;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 10);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaLibro() {
        this.setLayout(null);
        this.setBounds(0, 0, 527, 437);
        this.setBackground(Color.white);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        agregarCampoNombre();
        agregarBotonBuscarNombre();
        agregarCampoAutor();
        agregarCampoRangoI();
        agregarCampoRangoF();
        agregarBotonBuscarFiltro();
        agregarEtiquetas();
        agregarTabla();
        agregarBotonNuevoLibro();
        agregarBotonActualizarLibro();
    }

    private void agregarBotonNuevoLibro() {
        btnNuevoLibro = new JButton();
        btnNuevoLibro.setBounds(230, 385, 125, 25);
        btnNuevoLibro.setText("Nuevo Libro");
        btnNuevoLibro.setFont(fuente);
        btnNuevoLibro.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnNuevoLibro.setForeground(new Color(255, 255, 255));
        btnNuevoLibro.setBackground(new Color(60, 90, 153));
        btnNuevoLibro.setFocusPainted(false);
        this.add(btnNuevoLibro);
    }

    private void agregarBotonActualizarLibro() {
        btnActualizarLibro = new JButton();
        btnActualizarLibro.setBounds(380, 385, 125, 25);
        btnActualizarLibro.setText("Actualizar Libro");
        btnActualizarLibro.setFont(fuente);
        btnActualizarLibro.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnActualizarLibro.setForeground(new Color(255, 255, 255));
        btnActualizarLibro.setBackground(new Color(58, 173, 48));
        btnActualizarLibro.setFocusPainted(false);
        this.add(btnActualizarLibro);
    }

    private void agregarCampoNombre() {
        campoNombre = new JTextField();
        campoNombre.setBounds(67, 20, 344, 25);
        campoNombre.setFont(fuente);
        campoNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoNombre);
    }

    private void agregarBotonBuscarNombre() {
        btnBuscarNombre = new JButton();
        btnBuscarNombre.setBounds(425, 20, 80, 25);
        btnBuscarNombre.setText("Buscar");
        btnBuscarNombre.setFont(fuente);
        btnBuscarNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnBuscarNombre.setForeground(new Color(255, 255, 255));
        btnBuscarNombre.setBackground(new Color(247, 183, 14));
        btnBuscarNombre.setFocusPainted(false);
        this.add(btnBuscarNombre);
    }

    private void agregarCampoRangoI() {
        campoRangoI = new JTextField();
        campoRangoI.setBounds(270, 65, 60, 25);
        campoRangoI.setFont(fuente);
        campoRangoI.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoRangoI);
    }

    private void agregarCampoRangoF() {
        campoRangoF = new JTextField();
        campoRangoF.setBounds(350, 65, 60, 25);
        campoRangoF.setFont(fuente);
        campoRangoF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoRangoF);
    }

    private void agregarCampoAutor() {
        campoAutor = new JTextField();
        campoAutor.setBounds(67, 65, 140, 25);
        campoAutor.setFont(fuente);
        campoAutor.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoAutor);
    }

    private void agregarBotonBuscarFiltro() {
        btnBuscarFiltro = new JButton();
        btnBuscarFiltro.setBounds(425, 65, 80, 25);
        btnBuscarFiltro.setText("Buscar");
        btnBuscarFiltro.setFont(fuente);
        btnBuscarFiltro.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnBuscarFiltro.setForeground(new Color(255, 255, 255));
        btnBuscarFiltro.setBackground(new Color(247, 183, 14));
        btnBuscarFiltro.setFocusPainted(false);
        this.add(btnBuscarFiltro);
    }

    private void agregarTabla() {
        diseño = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        diseño.addColumn("Titulo");
        diseño.addColumn("ISBN");
        tabla = new JTable(diseño);
        tabla.getTableHeader().setOpaque(false);
        tabla.setBounds(20, 118, 486, 242);
        tabla.getTableHeader().setFont(fuente);
        tabla.getTableHeader().setBackground(new Color(60, 90, 153));
        tabla.getTableHeader().setForeground(Color.white);
        tabla.setFont(fuente);
        tabla.setRowHeight(20);
        tabla.setCellSelectionEnabled(true);
        this.add(tabla);
        JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20, 118, 486, 242);
        scroll.getViewport().setBackground(Color.white);
        this.add(scroll);
    }

    private void agregarEtiquetas() {
        //////////////////////////////////////////////
        etiquetaNombre = new JLabel();
        etiquetaNombre.setBounds(20, 20, 60, 20);
        etiquetaNombre.setText("TITULO:");
        etiquetaNombre.setFont(fuenteEtiqueta);
        etiquetaNombre.setForeground(colorEtiquetas);
        this.add(etiquetaNombre);
        //////////////////////////////////////////////
        etiquetaDe = new JLabel();
        etiquetaDe.setBounds(247, 65, 40, 20);
        etiquetaDe.setText("DE:");
        etiquetaDe.setFont(fuenteEtiqueta);
        etiquetaDe.setForeground(colorEtiquetas);
        this.add(etiquetaDe);
        //////////////////////////////////////////////
        etiquetaA = new JLabel();
        etiquetaA.setBounds(337, 65, 40, 20);
        etiquetaA.setText("A:");
        etiquetaA.setFont(fuenteEtiqueta);
        etiquetaA.setForeground(colorEtiquetas);
        this.add(etiquetaA);
        //////////////////////////////////////////////
        etiquetaAutor = new JLabel();
        etiquetaAutor.setBounds(20, 65, 50, 20);
        etiquetaAutor.setText("AUTOR:");
        etiquetaAutor.setFont(fuenteEtiqueta);
        etiquetaAutor.setForeground(colorEtiquetas);
        this.add(etiquetaAutor);
    }

}
