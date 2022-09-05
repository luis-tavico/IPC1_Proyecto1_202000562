package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaPrestamoNuevo extends javax.swing.JDialog {

    private JPanel panel;
    public JTextField campoISBN;
    public JTextField campoCui;
    private JLabel etiquetaCui;
    private JLabel etiquetaISBN;
    public JButton btnPrestar;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 10);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaPrestamoNuevo() {
        setSize(285, 185);
        setLocationRelativeTo(null);
        setTitle("PRESTAR LIBRO");
        setResizable(false);
        iniciarComponentes();
        this.setModal(true);
    }

    private void iniciarComponentes() {
        agregarPanel();
        agregarCampoCui();
        agregarCampoISBN();
        agregarEtiquetas();
        agregarBotonPrestar();
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

    private void agregarBotonPrestar() {
        btnPrestar = new JButton();
        btnPrestar.setBounds(155, 100, 90, 25);
        btnPrestar.setText("Prestar");
        btnPrestar.setFont(fuente);
        btnPrestar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        btnPrestar.setForeground(new Color(255, 255, 255));
        btnPrestar.setBackground(new Color(58, 173, 48));
        btnPrestar.setFocusPainted(false);
        panel.add(btnPrestar);
    }
}
