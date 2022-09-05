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

public class VistaPrestamo extends javax.swing.JPanel {

    public JTextField campoCui;
    public JTextField campoNombre;
    public JTextField campoApellido;
    public JButton btnBuscar;
    public JButton btnPrestarLibro;
    public JButton btnDevolverLibro;
    public JButton btnNuevoPrestamista;
    private JLabel etiquetaCui;
    private JLabel etiquetaNombre;
    private JLabel etiquetaApellido;
    public JTable tabla;
    public DefaultTableModel diseño;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 10);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaPrestamo() {
        this.setLayout(null);
        this.setBounds(0, 0, 527, 437);
        this.setBackground(Color.white);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        agregarCampoCui();
        agregarEtiquetas();
        agregarCampoNombre();
        agregarCampoApellido();
        agregarBotonBuscar();
        agregarTabla();
        agregarBotonNuevoPrestamista();
        agregarBotonPrestarLibro();
        agregarBotonDevolverLibro();
    }

    private void agregarCampoCui() {
        campoCui = new JTextField();
        campoCui.setBounds(48, 20, 350, 25);
        campoCui.setFont(fuente);
        campoCui.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoCui);
    }

    private void agregarCampoNombre() {
        campoNombre = new JTextField();
        campoNombre.setBounds(68, 65, 170, 25);
        campoNombre.setEditable(false);
        campoNombre.setFont(fuente);
        campoNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoNombre);
    }

    private void agregarCampoApellido() {
        campoApellido = new JTextField();
        campoApellido.setBounds(335, 65, 170, 25);
        campoApellido.setEditable(false);
        campoApellido.setFont(fuente);
        campoApellido.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        this.add(campoApellido);
    }

    private void agregarBotonBuscar() {
        btnBuscar = new JButton();
        btnBuscar.setBounds(415, 20, 90, 25);
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(fuente);
        btnBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnBuscar.setForeground(new Color(255, 255, 255));
        btnBuscar.setBackground(new Color(247, 183, 14));
        btnBuscar.setFocusPainted(false);
        this.add(btnBuscar);
    }

    private void agregarBotonNuevoPrestamista() {
        btnNuevoPrestamista = new JButton();
        btnNuevoPrestamista.setBounds(20, 385, 145, 25);
        btnNuevoPrestamista.setText("Nuevo Prestamista");
        btnNuevoPrestamista.setFont(fuente);
        btnNuevoPrestamista.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnNuevoPrestamista.setForeground(new Color(255, 255, 255));
        btnNuevoPrestamista.setBackground(new Color(60, 90, 153));
        btnNuevoPrestamista.setFocusPainted(false);
        this.add(btnNuevoPrestamista);
    }

    private void agregarBotonPrestarLibro() {
        btnPrestarLibro = new JButton();
        btnPrestarLibro.setBounds(230, 385, 125, 25);
        btnPrestarLibro.setText("Prestar Libro");
        btnPrestarLibro.setFont(fuente);
        btnPrestarLibro.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnPrestarLibro.setForeground(new Color(255, 255, 255));
        btnPrestarLibro.setBackground(new Color(58, 173, 48));
        btnPrestarLibro.setFocusPainted(false);
        this.add(btnPrestarLibro);
    }

    private void agregarBotonDevolverLibro() {
        btnDevolverLibro = new JButton();
        btnDevolverLibro.setBounds(380, 385, 125, 25);
        btnDevolverLibro.setText("Devolver Libro");
        btnDevolverLibro.setFont(fuente);
        btnDevolverLibro.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnDevolverLibro.setForeground(new Color(255, 255, 255));
        btnDevolverLibro.setBackground(new Color(229, 62, 62));
        btnDevolverLibro.setFocusPainted(false);
        this.add(btnDevolverLibro);
    }

    private void agregarEtiquetas() {
        //////////////////////////////////////////////
        etiquetaCui = new JLabel();
        etiquetaCui.setBounds(20, 20, 35, 20);
        etiquetaCui.setText("CUI:");
        etiquetaCui.setFont(fuenteEtiqueta);
        etiquetaCui.setForeground(colorEtiquetas);
        this.add(etiquetaCui);
        //////////////////////////////////////////////
        etiquetaNombre = new JLabel();
        etiquetaNombre.setBounds(20, 65, 55, 20);
        etiquetaNombre.setText("NOMBRE:");
        etiquetaNombre.setFont(fuenteEtiqueta);
        etiquetaNombre.setForeground(colorEtiquetas);
        this.add(etiquetaNombre);
        //////////////////////////////////////////////
        etiquetaApellido = new JLabel();
        etiquetaApellido.setBounds(283, 65, 64, 20);
        etiquetaApellido.setText("APELLIDO:");
        etiquetaApellido.setFont(fuenteEtiqueta);
        etiquetaApellido.setForeground(colorEtiquetas);
        this.add(etiquetaApellido);
    }

    private void agregarTabla() {
        diseño = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        diseño.addColumn("ISBN");
        diseño.addColumn("Titulo");
        diseño.addColumn("F. Prestado");
        diseño.addColumn("F. Devuelto");
        tabla = new JTable(diseño);
        tabla.getTableHeader().setOpaque(false);
        tabla.setBounds(20, 118, 486, 242);
        tabla.setFont(fuente);
        tabla.setRowHeight(20);
        tabla.setCellSelectionEnabled(true);
        tabla.getTableHeader().setFont(fuente);
        tabla.getTableHeader().setBackground(new Color(60, 90, 153));
        tabla.getTableHeader().setForeground(Color.white);
        this.add(tabla);
        JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20, 118, 486, 242);
        scroll.getViewport().setBackground(Color.white);
        this.add(scroll);
    }
}
