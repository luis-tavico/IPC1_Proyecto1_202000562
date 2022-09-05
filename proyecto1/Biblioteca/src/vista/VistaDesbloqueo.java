package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaDesbloqueo extends javax.swing.JFrame {

    private JPanel panel;
    public JTextField campoClave;
    private JLabel etiqueta;
    public JButton btnAceptar;
    public JButton btnCancelar;
    Font fuenteEtiqueta = new Font("Segoe UI", 0, 12);
    Font fuente = new Font("Segoe UI", 0, 14);
    Color colorEtiquetas = new Color(85, 85, 85);
    Color colorCajas = new Color(52, 168, 205);

    public VistaDesbloqueo() {
        setSize(272, 175);
        setLocationRelativeTo(null);
        setTitle("DESBLOQUEAR");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        agregarPanel();
        agregarEtiquetas();
        agregarCampoClave();
        agregarBotonAceptar();
        agregarBotonCancelar();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    private void agregarCampoClave() {
        campoClave = new JTextField();
        campoClave.setBounds(20, 45, 215, 25);
        campoClave.setFont(fuente);
        campoClave.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorCajas));
        panel.add(campoClave);
    }

    private void agregarBotonAceptar() {
        btnAceptar = new JButton();
        btnAceptar.setBounds(20, 85, 95, 25);
        btnAceptar.setText("Aceptar");
        btnAceptar.setFont(fuente);
        btnAceptar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        btnAceptar.setForeground(new Color(255, 255, 255));
        btnAceptar.setBackground(new Color(60, 90, 153));
        btnAceptar.setFocusPainted(false);
        panel.add(btnAceptar);
    }

    private void agregarBotonCancelar() {
        btnCancelar = new JButton();
        btnCancelar.setBounds(138, 85, 95, 25);
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(fuente);
        btnCancelar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setBackground(new Color(229, 62, 62));
        btnCancelar.setFocusPainted(false);
        panel.add(btnCancelar);
    }

    private void agregarEtiquetas() {
        etiqueta = new JLabel();
        etiqueta.setBounds(20, 20, 200, 20);
        etiqueta.setText("Porfavor ingrese la palabra clave:");
        etiqueta.setFont(fuenteEtiqueta);
        etiqueta.setForeground(colorEtiquetas);
        panel.add(etiqueta);
    }

}
