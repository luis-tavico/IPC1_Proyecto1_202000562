package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaPrincipal extends javax.swing.JFrame {
    
    private JPanel panel;
    public JPanel panelContenido;
    public JButton btnLibro;
    public JButton btnPrestamo;
    Font fuente = new Font("Segoe UI", 0, 14);
    
    public VistaPrincipal() {
        setSize(543, 500);
        setLocationRelativeTo(null);
        setTitle("BIBLIOTECA SYSTEM");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        agregarPanel();
        agregarBotonLibro();
        agregarBotonPrestamo();
        agregarPanelContenido();
    }
    
    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }
    
    private void agregarPanelContenido() {
        panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0, 25, 527, 437);
        panelContenido.setBackground(Color.white);
        panel.add(panelContenido);
    }
    
    private void agregarBotonLibro() {
        btnLibro = new JButton();
        btnLibro.setBounds(0, 0, 100, 25);
        btnLibro.setText("Libro");
        btnLibro.setFont(fuente);
        btnLibro.setBackground(Color.WHITE);
        btnLibro.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        btnLibro.setFocusPainted(false);
        panel.add(btnLibro);
    }
    
    private void agregarBotonPrestamo() {
        btnPrestamo = new JButton();
        btnPrestamo.setBounds(100, 0, 100, 25);
        btnPrestamo.setText("Prestamo");
        btnPrestamo.setFont(fuente);
        btnPrestamo.setBackground(Color.WHITE);
        btnPrestamo.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
        btnPrestamo.setFocusPainted(false);
        panel.add(btnPrestamo);
    }
}
