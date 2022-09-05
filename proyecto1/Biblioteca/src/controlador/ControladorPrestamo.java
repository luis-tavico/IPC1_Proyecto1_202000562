package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import vista.VistaLibroDevolver;
import vista.VistaPrestamista;
import vista.VistaPrestamo;
import vista.VistaPrestamoNuevo;
import vista.VistaPrincipal;

public class ControladorPrestamo implements ActionListener {

    VistaPrincipal vista = new VistaPrincipal();
    VistaPrestamo panel = new VistaPrestamo();
    ModeloPrestamo modelo_prestamo = new ModeloPrestamo();
    ModeloLibro modelo_libro = new ModeloLibro();

    public ControladorPrestamo(VistaPrincipal vista, VistaPrestamo panel, ModeloPrestamo modelo_prestamo, ModeloLibro modelo_libro) {
        this.vista = vista;
        this.panel = panel;
        this.modelo_prestamo = modelo_prestamo;
        this.modelo_libro = modelo_libro;
        validacionCampos();
        panel.btnBuscar.addActionListener(this);
        panel.btnNuevoPrestamista.addActionListener(this);
        panel.btnPrestarLibro.addActionListener(this);
        panel.btnDevolverLibro.addActionListener(this);
    }

    private void validacionCampos() {
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
        panel.campoCui.addKeyListener(eventoTecla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.btnBuscar) {
            if (!panel.campoCui.getText().equals("")) {
                Integer numero_fila;
                numero_fila = modelo_prestamo.buscarCUI(panel.campoCui.getText());
                if (numero_fila == null) {
                    for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                        panel.diseño.removeRow(i);
                    }
                    panel.campoNombre.setText("");
                    panel.campoApellido.setText("");
                    JOptionPane.showMessageDialog(null, "¡Error, El CUI ingresado no existe!");
                } else {
                    for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                        panel.diseño.removeRow(i);
                    }
                    String historial = modelo_prestamo.getHistorial(numero_fila);
                    if (historial.equals("")) {
                        panel.campoNombre.setText(modelo_prestamo.getNombre(numero_fila));
                        panel.campoApellido.setText(modelo_prestamo.getApellido(numero_fila));
                        JOptionPane.showMessageDialog(null, "¡Historial vacio!");
                    } else {
                        String info = "";
                        String[] vector = new String[4];
                        //char entro = '*';
                        int j = 0;
                        for (int i = 0; i < historial.length(); i++) {
                            if (historial.charAt(i) == '*') {
                                vector[j] = info;
                                info = "";
                                j++;
                            } else if (historial.charAt(i) == '|') {
                                vector[j] = info;
                                info = "";
                                j = 0;
                                panel.diseño.addRow(vector);
                                vector = new String[4];
                                //entro = historial.charAt(i);
                            } else {
                                info += historial.charAt(i);
                            }
                        }
                        /*
                    String[] vector = new String[4];
                    vector[0] = modelo_prestamo.getISBN(numero_fila);
                    vector[1] = modelo_prestamo.getTitulo(numero_fila);
                    vector[2] = modelo_prestamo.getFechaPrestado(numero_fila);
                    vector[3] = modelo_prestamo.getFechaDevuelto(numero_fila);
                         */
                        panel.campoNombre.setText(modelo_prestamo.getNombre(numero_fila));
                        panel.campoApellido.setText(modelo_prestamo.getApellido(numero_fila));
                        if (vector[2] != null && vector[3] == null) {
                            panel.diseño.addRow(vector);
                        } else {
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Complete el campo CUI!");
            }
        } else if (e.getSource() == panel.btnNuevoPrestamista) {
            VistaPrestamista vista_prestamista = new VistaPrestamista();
            ControladorPrestamista controlador = new ControladorPrestamista(vista_prestamista, modelo_prestamo);
            vista_prestamista.setVisible(true);
        } else if (e.getSource() == panel.btnPrestarLibro) {
            VistaPrestamoNuevo vista_prestamo_nuevo = new VistaPrestamoNuevo();
            ControladorPrestamoNuevo controlador_prestamo_nuevo = new ControladorPrestamoNuevo(vista_prestamo_nuevo, modelo_prestamo, modelo_libro);
            vista_prestamo_nuevo.setVisible(true);
        } else if (e.getSource() == panel.btnDevolverLibro) {
            VistaLibroDevolver vista_devolver = new VistaLibroDevolver();
            ControladorLibroDevolver controlado_libro_devolver = new ControladorLibroDevolver(vista_devolver, modelo_prestamo, modelo_libro);
            vista_devolver.setVisible(true);
        }
    }

}
