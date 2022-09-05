package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaPrestamista extends javax.swing.JDialog {

    private JPanel panel;
    public JTextField campoCui;
    public JTextField campoNombre;
    public JTextField campoApellido;
    public JButton btnGuardar;
    private JLabel etiquetaCui;
    private JLabel etiquetaNombre;
    private JLabel etiquetaApellido;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 10);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaPrestamista() {
        setSize(315, 225);
        setLocationRelativeTo(null);
        setTitle("NUEVO PRESTAMISTA");
        setResizable(false);
        iniciarComponentes();
        this.setModal(true);
    }

    private void iniciarComponentes() {
        agregarPanel();
        agregarCampoCui();
        agregarCampoNombre();
        agregarCampoApellido();
        agregarBotonGuardar();
        agregarEtiquetas();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    private void agregarCampoCui() {
        campoCui = new JTextField();
        campoCui.setBounds(80, 20, 200, 25);
        campoCui.setFont(fuente);
        campoCui.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoCui);
    }

    private void agregarCampoNombre() {
        campoNombre = new JTextField();
        campoNombre.setBounds(80, 60, 200, 25);
        campoNombre.setFont(fuente);
        campoNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoNombre);
    }

    private void agregarCampoApellido() {
        campoApellido = new JTextField();
        campoApellido.setBounds(80, 100, 200, 25);
        campoApellido.setFont(fuente);
        campoApellido.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoApellido);
    }

    private void agregarBotonGuardar() {
        btnGuardar = new JButton();
        btnGuardar.setBounds(188, 140, 90, 25);
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(fuente);
        btnGuardar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnGuardar.setForeground(new Color(255, 255, 255));
        btnGuardar.setBackground(new Color(60, 90, 153));
        btnGuardar.setFocusPainted(false);
        panel.add(btnGuardar);
    }

    private void agregarEtiquetas() {
        //////////////////////////////////////////////
        etiquetaCui = new JLabel();
        etiquetaCui.setBounds(20, 20, 50, 20);
        etiquetaCui.setText("CUI:");
        etiquetaCui.setFont(fuenteEtiqueta);
        etiquetaCui.setForeground(colorEtiquetas);
        panel.add(etiquetaCui);
        //////////////////////////////////////////////
        etiquetaNombre = new JLabel();
        etiquetaNombre.setBounds(20, 60, 50, 20);
        etiquetaNombre.setText("NOMBRE:");
        etiquetaNombre.setFont(fuenteEtiqueta);
        etiquetaNombre.setForeground(colorEtiquetas);
        panel.add(etiquetaNombre);
        //////////////////////////////////////////////
        etiquetaApellido = new JLabel();
        etiquetaApellido.setBounds(20, 100, 55, 20);
        etiquetaApellido.setText("APELLIDO:");
        etiquetaApellido.setFont(fuenteEtiqueta);
        etiquetaApellido.setForeground(colorEtiquetas);
        panel.add(etiquetaApellido);
    }

}
