package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ModeloLibro;
import vista.VistaLibro;
import vista.VistaLibroActualizar;
import vista.VistaLibroNuevo;
import vista.VistaPrincipal;

public class ControladorLibro implements ActionListener {

    VistaPrincipal vista = new VistaPrincipal();
    VistaLibro panel = new VistaLibro();
    ModeloLibro modelo = new ModeloLibro();

    public ControladorLibro(VistaPrincipal vista, VistaLibro panel, ModeloLibro modelo) {
        this.vista = vista;
        this.panel = panel;
        this.modelo = modelo;
        validacionCampos();
        panel.btnNuevoLibro.addActionListener(this);
        panel.btnActualizarLibro.addActionListener(this);
        panel.btnBuscarNombre.addActionListener(this);
        panel.btnBuscarFiltro.addActionListener(this);
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
                /*
                if (e.isControlDown() || e.getKeyCode() == KeyEvent.VK_V) {
                    String cadena;
                    char caracter_;
                    if (!panel.campoRangoI.getText().equals("")) {
                        cadena = panel.campoRangoI.getText();
                        for (int i = 0; i < cadena.length(); i++) {
                            caracter_ = cadena.charAt(i);
                            if (Character.isDigit(caracter_)) {
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Ingrese solo numeros!");
                                panel.campoRangoI.setText("");
                                break;
                            }
                        }
                    }
                    if (!panel.campoRangoF.getText().equals("")) {
                        cadena = panel.campoRangoF.getText();
                        for (int i = 0; i < cadena.length(); i++) {
                            caracter_ = cadena.charAt(i);
                            if (Character.isDigit(caracter_)) {
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Ingrese solo numeros!");
                                panel.campoRangoF.setText("");
                                break;
                            }
                        }
                    }
                }*/
            }
        };
        panel.campoRangoI.addKeyListener(eventoTecla);
        panel.campoRangoF.addKeyListener(eventoTecla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == panel.btnNuevoLibro) {
                VistaLibroNuevo vista_nuevo = new VistaLibroNuevo();
                ControladorLibroNuevo controlador_nuevo = new ControladorLibroNuevo(vista_nuevo, modelo);
                vista_nuevo.setVisible(true);
            } else if (e.getSource() == panel.btnActualizarLibro) {
                VistaLibroActualizar vista_actualizar = new VistaLibroActualizar();
                ControladorLibroActualizar controlador_actualizar = new ControladorLibroActualizar(vista_actualizar, panel, modelo);
                vista_actualizar.setVisible(true);
            } else if (e.getSource() == panel.btnBuscarNombre) {
                if (!panel.campoNombre.getText().equals("")) {
                    Integer numero_fila;
                    numero_fila = modelo.buscarTitulo(panel.campoNombre.getText());
                    if (numero_fila == null) {
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        JOptionPane.showMessageDialog(null, "¡Libro no encontrado!");
                    } else {
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        String[] vector = new String[2];
                        vector[0] = modelo.getTitulo(numero_fila);
                        vector[1] = modelo.getISBN(numero_fila);
                        panel.diseño.addRow(vector);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Complete el campo nombre!");
                }
            } else if (e.getSource() == panel.btnBuscarFiltro) {
                if (!panel.campoAutor.getText().equals("") && !panel.campoRangoI.getText().equals("") && !panel.campoRangoF.getText().equals("")) {
                    String numero_filas;
                    int inicio = Integer.parseInt(panel.campoRangoI.getText());
                    int fin = Integer.parseInt(panel.campoRangoF.getText());
                    numero_filas = modelo.buscarAutorYRango(panel.campoAutor.getText(), inicio, fin);
                    if (numero_filas.equals("")) {
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        JOptionPane.showMessageDialog(null, "¡Libro no encontrado!");
                    } else {
                        String posicion = "";
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        for (int i = 0; i < numero_filas.length(); i++) {
                            if (numero_filas.charAt(i) == '-') {
                                String[] vector = new String[2];
                                vector[0] = modelo.getTitulo(Integer.parseInt(posicion));
                                vector[1] = modelo.getISBN(Integer.parseInt(posicion));
                                panel.diseño.addRow(vector);
                                posicion = "";
                            } else {
                                posicion += numero_filas.charAt(i);
                            }
                        }
                    }
                } else if (!panel.campoAutor.getText().equals("") && (panel.campoRangoI.getText().equals("") || panel.campoRangoF.getText().equals(""))) {
                    String numero_filas;
                    numero_filas = modelo.buscarAutor(panel.campoAutor.getText());
                    if (numero_filas.equals("")) {
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        JOptionPane.showMessageDialog(null, "¡Libro no encontrado!");
                    } else {
                        String posicion = "";
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        for (int i = 0; i < numero_filas.length(); i++) {
                            if (numero_filas.charAt(i) == '-') {
                                String[] vector = new String[2];
                                vector[0] = modelo.getTitulo(Integer.parseInt(posicion));
                                vector[1] = modelo.getISBN(Integer.parseInt(posicion));
                                panel.diseño.addRow(vector);
                                posicion = "";
                            } else {
                                posicion += numero_filas.charAt(i);
                            }
                        }
                    }
                } else if (panel.campoAutor.getText().equals("") && (!panel.campoRangoI.getText().equals("") && !panel.campoRangoF.getText().equals(""))) {
                    String numero_filas;
                    int inicio = Integer.parseInt(panel.campoRangoI.getText());
                    int fin = Integer.parseInt(panel.campoRangoF.getText());
                    numero_filas = modelo.buscarRango(inicio, fin);
                    if (numero_filas.equals("")) {
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        JOptionPane.showMessageDialog(null, "¡Libro no encontrado!");
                    } else {
                        String posicion = "";
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        for (int i = 0; i < numero_filas.length(); i++) {
                            if (numero_filas.charAt(i) == '-') {
                                String[] vector = new String[2];
                                vector[0] = modelo.getTitulo(Integer.parseInt(posicion));
                                vector[1] = modelo.getISBN(Integer.parseInt(posicion));
                                panel.diseño.addRow(vector);
                                posicion = "";
                            } else {
                                posicion += numero_filas.charAt(i);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Complete el campo autor o \nlos dos campos de rango!");
                }
            }
        } catch (NumberFormatException ae) {
            JOptionPane.showMessageDialog(null, "¡Error, debio ingresar numeros donde se le solicito!");
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        panel.campoNombre.setText("");
        panel.campoAutor.setText("");
        panel.campoRangoI.setText("");
        panel.campoRangoF.setText("");
        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
            panel.diseño.removeRow(i);
        }
    }
}
