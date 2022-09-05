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
import vista.VistaPrestamo;
import vista.VistaPrestamoNuevo;

public class ControladorPrestamoNuevo implements ActionListener {

    VistaPrestamoNuevo vista = new VistaPrestamoNuevo();
    ModeloPrestamo modelo_prestamo = new ModeloPrestamo();
    ModeloLibro modelo_libro = new ModeloLibro();

    public ControladorPrestamoNuevo(VistaPrestamoNuevo vista, ModeloPrestamo modelo_prestamo, ModeloLibro modelo_libro) {
        this.vista = vista;
        this.modelo_prestamo = modelo_prestamo;
        this.modelo_libro = modelo_libro;
        validacionCUI();
        validacionCampoISBN();
        vista.btnPrestar.addActionListener(this);
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
        if (e.getSource() == vista.btnPrestar) {
            if (vista.campoCui.getText().equals("") || vista.campoISBN.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Complete los campos vacios!");
            } else {
                Integer numfila_libro;
                Integer numfila_prestamo;
                numfila_libro = modelo_libro.buscarISBN(vista.campoISBN.getText());
                numfila_prestamo = modelo_prestamo.buscarCUI(vista.campoCui.getText());
                if (numfila_libro == null) {
                    JOptionPane.showMessageDialog(null, "¡Error, El ISBN ingresado no existe!");
                } else {
                    if (numfila_prestamo == null) {
                        JOptionPane.showMessageDialog(null, "¡Error, El CUI ingresado no existe!");
                    } else {
                        if (modelo_prestamo.getISBN(numfila_prestamo).equals("")) {
                            int copias_disponibles = Integer.parseInt(modelo_libro.getCopiasDisponibles(numfila_libro));
                            if (copias_disponibles > 0) {
                                String isbn = vista.campoISBN.getText();
                                String titulo = modelo_libro.getTitulo(numfila_libro);
                                int prestados = Integer.parseInt(modelo_libro.getPrestados(numfila_libro));
                                prestados++;
                                modelo_libro.setPrestados(numfila_libro, String.valueOf(prestados));
                                copias_disponibles--;
                                modelo_libro.setCopiasDisponibles(numfila_libro, String.valueOf(copias_disponibles));
                                modelo_prestamo.setISBN(numfila_prestamo, isbn);
                                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                                Calendar calendar = Calendar.getInstance();
                                Date dateObj = calendar.getTime();
                                String formattedDate = dtf.format(dateObj);
                                modelo_prestamo.setHistorial(numfila_prestamo, isbn + "*" + titulo + "*" + formattedDate + "*");
                                JOptionPane.showMessageDialog(null, "¡Prestamo realizado exitosamente!");
                                limpiarCampos();
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No hay libros disponibles!");
                                limpiarCampos();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error, Tiene un libro pendiente de devolver!");
                        }
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
