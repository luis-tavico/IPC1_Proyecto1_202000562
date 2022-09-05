package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaLibroDevolver extends javax.swing.JDialog {

    private JPanel panel;
    public JTextField campoISBN;
    public JTextField campoCui;
    private JLabel etiquetaCui;
    private JLabel etiquetaISBN;
    public JButton btnDevolver;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 10);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaLibroDevolver() {
        setSize(285, 185);
        setLocationRelativeTo(null);
        setTitle("DEVOLVER LIBRO");
        setResizable(false);
        iniciarComponentes();
        this.setModal(true);
    }

    private void iniciarComponentes() {
        agregarPanel();
        agregarCampoCui();
        agregarCampoISBN();
        agregarEtiquetas();
        agregarBotonDevolver();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    private void agregarCampoISBN() {
        campoISBN = new JTextField();
        campoISBN.setBounds(50, 20, 200, 25);
        campoISBN.setFont(fuente);
        campoISBN.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoISBN);
    }

    private void agregarCampoCui() {
        campoCui = new JTextField();
        campoCui.setBounds(50, 60, 200, 25);
        campoCui.setFont(fuente);
        campoCui.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoCui);
    }

    private void agregarEtiquetas() {
        etiquetaISBN = new JLabel();
        etiquetaISBN.setBounds(20, 20, 30, 20);
        etiquetaISBN.setText("ISBN:");
        etiquetaISBN.setFont(fuenteEtiqueta);
        etiquetaISBN.setForeground(colorEtiquetas);
        panel.add(etiquetaISBN);
        //////////////////////////////////////////////
        etiquetaCui = new JLabel();
        etiquetaCui.setBounds(20, 60, 30, 20);
        etiquetaCui.setText("CUI:");
        etiquetaCui.setFont(fuenteEtiqueta);
        etiquetaCui.setForeground(colorEtiquetas);
        panel.add(etiquetaCui);
    }

    private void agregarBotonDevolver() {
        btnDevolver = new JButton();
        btnDevolver.setBounds(155, 100, 90, 25);
        btnDevolver.setText("Devolver");
        btnDevolver.setFont(fuente);
        btnDevolver.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        btnDevolver.setForeground(new Color(255, 255, 255));
        btnDevolver.setBackground(new Color(229, 62, 62));
        btnDevolver.setFocusPainted(false);
        panel.add(btnDevolver);
    }

}
