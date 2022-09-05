package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaLibroActualizar extends javax.swing.JDialog {

    private JPanel panel;
    public JTextField campoISBN;
    public JButton btnBuscar;
    public JButton btnActualizar;
    private JLabel etiquetaISBN;
    private JLabel etiquetaAutor;
    private JLabel etiquetaTitulo;
    private JLabel etiquetaAño;
    private JLabel etiquetaEdicion;
    private JLabel etiquetaTemas;
    private JLabel etiquetaCopiasA;
    private JLabel etiquetaCopiasD;
    private JLabel etiquetaNEstanteria;
    private JLabel etiquetaFEstanteria;
    private JLabel etiquetaDescripcion;
    public JTextField campoAutor;
    public JTextField campoTitulo;
    public JTextField campoAño;
    public JTextField campoEdicion;
    public JTextField campoTemas;
    public JTextField campoCopiasT;
    public JTextField campoCopiasD;
    public JTextField campoEstanteriaN;
    public JTextField campoFila;
    public JTextField campoPrestados;
    public JTextArea areaDescripcion;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 10);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaLibroActualizar() {
        setSize(460, 460);
        setLocationRelativeTo(null);
        setTitle("ACTUALIZAR LIBRO");
        setResizable(false);
        iniciarComponentes();
        this.setModal(true);
    }

    private void iniciarComponentes() {
        agregarPanel();
        agregarCampoISBN();
        agregarBotonBuscar();
        agregarBotonActualizar();
        agregarEtiquetas();
        agregarCampoTitulo();
        agregarCampoAutor();
        agregarCampoTemas();
        agregarCampoEdicion();
        agregarCampoAño();
        agregarCampoCopiasT();
        agregarCampoCopiasD();
        agregarCampoEstanteriaN();
        agregarCampoFila();
        agregarCampoPrestados();
        agregarAreaDescripcion();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    private void agregarCampoISBN() {
        campoISBN = new JTextField();
        campoISBN.setBounds(20, 35, 200, 25);
        campoISBN.setFont(fuente);
        campoISBN.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoISBN);
    }

    private void agregarBotonBuscar() {
        btnBuscar = new JButton();
        btnBuscar.setBounds(240, 35, 80, 25);
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(fuente);
        btnBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnBuscar.setForeground(new Color(255, 255, 255));
        btnBuscar.setBackground(new Color(247, 183, 14));
        btnBuscar.setFocusPainted(false);
        panel.add(btnBuscar);
    }

    private void agregarBotonActualizar() {
        btnActualizar = new JButton();
        btnActualizar.setBounds(330, 35, 95, 25);
        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(fuente);
        btnActualizar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnActualizar.setForeground(new Color(255, 255, 255));
        btnActualizar.setBackground(new Color(58, 173, 48));
        btnActualizar.setFocusPainted(false);
        panel.add(btnActualizar);
    }

    private void agregarCampoTitulo() {
        campoTitulo = new JTextField();
        campoTitulo.setBounds(20, 95, 195, 25);
        campoTitulo.setFont(fuente);
        campoTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoTitulo);
    }

    private void agregarCampoAutor() {
        campoAutor = new JTextField();
        campoAutor.setBounds(235, 95, 180, 25);
        campoAutor.setFont(fuente);
        campoAutor.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoAutor);
    }

    private void agregarCampoTemas() {
        campoTemas = new JTextField();
        campoTemas.setBounds(20, 155, 175, 25);
        campoTemas.setFont(fuente);
        campoTemas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoTemas);
    }

    private void agregarCampoEdicion() {
        campoEdicion = new JTextField();
        campoEdicion.setBounds(215, 155, 90, 25);
        campoEdicion.setFont(fuente);
        campoEdicion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoEdicion);
    }

    private void agregarCampoAño() {
        campoAño = new JTextField();
        campoAño.setBounds(325, 155, 90, 25);
        campoAño.setFont(fuente);
        campoAño.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoAño);
    }

    private void agregarCampoCopiasT() {
        campoCopiasT = new JTextField();
        campoCopiasT.setBounds(20, 215, 90, 25);
        campoCopiasT.setFont(fuente);
        campoCopiasT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoCopiasT);
    }

    private void agregarCampoCopiasD() {
        campoCopiasD = new JTextField();
        campoCopiasD.setBounds(122, 215, 90, 25);
        campoCopiasD.setFont(fuente);
        campoCopiasD.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        campoCopiasD.setEditable(false);
        panel.add(campoCopiasD);
    }

    private void agregarCampoEstanteriaN() {
        campoEstanteriaN = new JTextField();
        campoEstanteriaN.setBounds(224, 215, 90, 25);
        campoEstanteriaN.setFont(fuente);
        campoEstanteriaN.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoEstanteriaN);
    }

    private void agregarCampoFila() {
        campoFila = new JTextField();
        campoFila.setBounds(326, 215, 90, 25);
        campoFila.setFont(fuente);
        campoFila.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoFila);
    }

    private void agregarCampoPrestados() {
        campoPrestados = new JTextField();
        campoPrestados.setBounds(326, 245, 90, 25);
        campoPrestados.setFont(fuente);
        campoPrestados.setVisible(false);
        panel.add(campoPrestados);
    }

    private void agregarAreaDescripcion() {
        areaDescripcion = new JTextArea();
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setWrapStyleWord(true);
        //areaDescripcion.setBounds(20, 280, 405, 125);
        areaDescripcion.setFont(fuente);
        areaDescripcion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, colorCajas));
        panel.add(areaDescripcion);
        ////////////////////////////////////
        JScrollPane scroll = new JScrollPane(areaDescripcion, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 280, 405, 125);
        panel.add(scroll);
    }

    private void agregarEtiquetas() {
        //////////////////////////////////////////////
        etiquetaISBN = new JLabel();
        etiquetaISBN.setBounds(20, 15, 35, 20);
        etiquetaISBN.setText("ISBN:");
        etiquetaISBN.setFont(fuenteEtiqueta);
        etiquetaISBN.setForeground(colorEtiquetas);
        panel.add(etiquetaISBN);
        //////////////////////////////////////////////
        etiquetaTitulo = new JLabel();
        etiquetaTitulo.setBounds(20, 75, 55, 20);
        etiquetaTitulo.setText("TITULO:");
        etiquetaTitulo.setFont(fuenteEtiqueta);
        etiquetaTitulo.setForeground(colorEtiquetas);
        panel.add(etiquetaTitulo);
        //////////////////////////////////////////////
        etiquetaAutor = new JLabel();
        etiquetaAutor.setBounds(235, 75, 55, 20);
        etiquetaAutor.setText("AUTOR:");
        etiquetaAutor.setFont(fuenteEtiqueta);
        etiquetaAutor.setForeground(colorEtiquetas);
        panel.add(etiquetaAutor);
        //////////////////////////////////////////////
        etiquetaTemas = new JLabel();
        etiquetaTemas.setBounds(20, 135, 55, 20);
        etiquetaTemas.setText("TEMA:");
        etiquetaTemas.setFont(fuenteEtiqueta);
        etiquetaTemas.setForeground(colorEtiquetas);
        panel.add(etiquetaTemas);
        //////////////////////////////////////////////
        etiquetaEdicion = new JLabel();
        etiquetaEdicion.setBounds(215, 135, 55, 20);
        etiquetaEdicion.setText("EDICION:");
        etiquetaEdicion.setFont(fuenteEtiqueta);
        etiquetaEdicion.setForeground(colorEtiquetas);
        panel.add(etiquetaEdicion);
        //////////////////////////////////////////////
        etiquetaAño = new JLabel();
        etiquetaAño.setBounds(325, 135, 35, 20);
        etiquetaAño.setText("AÑO:");
        etiquetaAño.setFont(fuenteEtiqueta);
        etiquetaAño.setForeground(colorEtiquetas);
        panel.add(etiquetaAño);
        //////////////////////////////////////////////
        etiquetaCopiasA = new JLabel();
        etiquetaCopiasA.setBounds(20, 195, 85, 20);
        etiquetaCopiasA.setText("TOTAL COPIAS:");
        etiquetaCopiasA.setFont(fuenteEtiqueta);
        etiquetaCopiasA.setForeground(colorEtiquetas);
        panel.add(etiquetaCopiasA);
        //////////////////////////////////////////////
        etiquetaCopiasD = new JLabel();
        etiquetaCopiasD.setBounds(122, 195, 85, 20);
        etiquetaCopiasD.setText("DISP. COPIAS:");
        etiquetaCopiasD.setFont(fuenteEtiqueta);
        etiquetaCopiasD.setForeground(colorEtiquetas);
        panel.add(etiquetaCopiasD);
        //////////////////////////////////////////////
        etiquetaNEstanteria = new JLabel();
        etiquetaNEstanteria.setBounds(224, 195, 95, 20);
        etiquetaNEstanteria.setText("No. ESTANTERIA:");
        etiquetaNEstanteria.setFont(fuenteEtiqueta);
        etiquetaNEstanteria.setForeground(colorEtiquetas);
        panel.add(etiquetaNEstanteria);
        //////////////////////////////////////////////
        etiquetaFEstanteria = new JLabel();
        etiquetaFEstanteria.setBounds(326, 195, 55, 20);
        etiquetaFEstanteria.setText("No. FILA:");
        etiquetaFEstanteria.setFont(fuenteEtiqueta);
        etiquetaFEstanteria.setForeground(colorEtiquetas);
        panel.add(etiquetaFEstanteria);
        //////////////////////////////////////////////
        etiquetaDescripcion = new JLabel();
        etiquetaDescripcion.setBounds(20, 260, 75, 20);
        etiquetaDescripcion.setText("DESCRIPCION:");
        etiquetaDescripcion.setFont(fuenteEtiqueta);
        etiquetaDescripcion.setForeground(colorEtiquetas);
        panel.add(etiquetaDescripcion);
    }

}
