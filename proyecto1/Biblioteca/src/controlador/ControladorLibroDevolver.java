package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import vista.VistaLibroDevolver;

public class ControladorLibroDevolver implements ActionListener {

    VistaLibroDevolver vista = new VistaLibroDevolver();
    ModeloPrestamo modelo_prestamo = new ModeloPrestamo();
    ModeloLibro modelo_libro = new ModeloLibro();

    public ControladorLibroDevolver(VistaLibroDevolver vista, ModeloPrestamo modelo_prestamo, ModeloLibro modelo_libro) {
        this.vista = vista;
        this.modelo_prestamo = modelo_prestamo;
        this.modelo_libro = modelo_libro;
        validacionCUI();
        validacionCampoISBN();
        vista.btnDevolver.addActionListener(this);
    }

    private void validacionCUI() {
        KeyListener eventoTecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (caracter == 13 || (caracter >= '0' && caracter <= '9') || caracter == 8 || caracter == '\n') {
                } else {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "¡Ingrese solo numeros!");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        vista.campoCui.addKeyListener(eventoTecla);
    }

    private void validacionCampoISBN() {
        KeyListener eventoTecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (Character.isLetter(caracter)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "¡No ingrese letras!");
                } else {

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        vista.campoISBN.addKeyListener(eventoTecla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnDevolver) {
            if (vista.campoCui.getText().equals("") || vista.campoISBN.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Complete los campos vacios!");
            } else {
                Integer numfila_prestamo;
                numfila_prestamo = modelo_prestamo.buscarCUI(vista.campoCui.getText());
                if (numfila_prestamo == null) {
                    JOptionPane.showMessageDialog(null, "¡Error, El CUI ingresado no existe!");
                } else {
                    String isbn = modelo_prestamo.getISBN(numfila_prestamo);
                    Integer numfila_libro = modelo_libro.buscarISBN(vista.campoISBN.getText());
                    if (isbn.equals(vista.campoISBN.getText())) {
                        modelo_prestamo.setISBN(numfila_prestamo, "");
                        int prestados = Integer.parseInt(modelo_libro.getPrestados(numfila_libro));
                        prestados--;
                        modelo_libro.setPrestados(numfila_libro, String.valueOf(prestados));
                        int copias_disponibles = Integer.parseInt(modelo_libro.getCopiasDisponibles(numfila_libro));
                        copias_disponibles++;
                        modelo_libro.setCopiasDisponibles(numfila_libro, String.valueOf(copias_disponibles));
                        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar calendar = Calendar.getInstance();
                        Date dateObj = calendar.getTime();
                        String formattedDate = dtf.format(dateObj);
                        modelo_prestamo.setHistorial(numfila_prestamo, formattedDate + "|");
                        JOptionPane.showMessageDialog(null, "¡Devolucion realizada exitosamente!");
                        limpiarCampos();
                    } else if (isbn.equals("")) {
                        JOptionPane.showMessageDialog(null, "¡Usuario absuelto de prestamos!");
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error, El ISBN no esta vinculado al usuario!");
                    }
                }
            }
        }
    }

    private void limpiarCampos() {
        vista.campoCui.setText("");
        vista.campoISBN.setText("");
    }

}
