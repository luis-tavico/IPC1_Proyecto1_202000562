package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ModeloLibro;
import vista.VistaLibro;
import vista.VistaLibroActualizar;

public class ControladorLibroActualizar implements ActionListener {

    VistaLibroActualizar vista = new VistaLibroActualizar();
    VistaLibro panel = new VistaLibro();
    ModeloLibro modelo = new ModeloLibro();

    public ControladorLibroActualizar(VistaLibroActualizar vista, VistaLibro panel, ModeloLibro modelo) {
        this.vista = vista;
        this.panel = panel;
        this.modelo = modelo;
        validacionCampoCopiasTotales();
        validacionCampos();
        validacionCampoISBN();
        vista.btnBuscar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
    }

    private void validacionCampoCopiasTotales() {
        FocusListener evento = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //JOptionPane.showMessageDialog(null, "¡No puedes agregar!");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!vista.campoCopiasT.getText().equals("") && !vista.campoCopiasD.getText().equals("")) {
                    int copias_total = Integer.parseInt(vista.campoCopiasT.getText());
                    int copias_disp = Integer.parseInt(vista.campoCopiasD.getText());
                    int prestados = Integer.parseInt(vista.campoPrestados.getText());
                    int total = copias_disp + prestados;
                    if (copias_total >= prestados) {
                        int disponibles = copias_total - prestados;
                        vista.campoCopiasD.setText(String.valueOf(disponibles));
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Hay " + prestados + " libros prestados! El numero a \ningresar debe ser mayor o igual a " + prestados);
                        vista.campoCopiasT.setText("");
                        vista.campoCopiasT.setText(String.valueOf(total));
                    }
                } else {

                }
            }

        };
        vista.campoCopiasT.addFocusListener(evento);
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
        vista.campoAño.addKeyListener(eventoTecla);
        vista.campoCopiasT.addKeyListener(eventoTecla);
        vista.campoEstanteriaN.addKeyListener(eventoTecla);
        vista.campoFila.addKeyListener(eventoTecla);
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
        Integer numero_fila;
        if (e.getSource() == vista.btnBuscar) {
            if (!vista.campoISBN.getText().equals("")) {
                numero_fila = modelo.buscarISBN(vista.campoISBN.getText());
                if (numero_fila == null) {
                    JOptionPane.showMessageDialog(null, "¡Error, El ISBN ingresado no existe!");
                } else {
                    vista.campoTitulo.setText(modelo.getTitulo(numero_fila));
                    vista.campoAutor.setText(modelo.getAutor(numero_fila));
                    vista.campoTemas.setText(modelo.getTema(numero_fila));
                    vista.campoEdicion.setText(modelo.getEdicion(numero_fila));
                    vista.campoAño.setText(modelo.getAño(numero_fila));
                    vista.campoCopiasT.setText(modelo.getCopiasTotal(numero_fila));
                    vista.campoCopiasD.setText(modelo.getCopiasDisponibles(numero_fila));
                    vista.campoEstanteriaN.setText(modelo.getEstanteriaNumero(numero_fila));
                    vista.campoFila.setText(modelo.getFila(numero_fila));
                    vista.campoPrestados.setText(modelo.getPrestados(numero_fila));
                    vista.areaDescripcion.setText(modelo.getDescripcion(numero_fila));
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Complete el campo ISBN!");
            }
        } else if (e.getSource() == vista.btnActualizar) {
            if (vista.campoISBN.getText().equals("") || vista.campoTitulo.getText().equals("") || vista.campoAutor.getText().equals("") || vista.campoTemas.getText().equals("") || vista.campoEdicion.getText().equals("") || vista.campoAño.getText().equals("") || vista.campoCopiasT.getText().equals("") || vista.campoCopiasD.getText().equals("") || vista.campoFila.getText().equals("") || vista.campoEstanteriaN.getText().equals("") || vista.areaDescripcion.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Complete los campos vacios!");
            } else {
                numero_fila = modelo.buscarISBN(vista.campoISBN.getText());
                if (numero_fila == null) {
                    JOptionPane.showMessageDialog(null, "¡Error, El ISBN ingresado no existe!");
                } else {
                    int prestados = Integer.parseInt(modelo.getPrestados(numero_fila));
                    int copias_totales = Integer.parseInt(vista.campoCopiasT.getText());
                    if (copias_totales >= prestados) {
                        modelo.setTitulo(numero_fila, vista.campoTitulo.getText());
                        modelo.setAutor(numero_fila, vista.campoAutor.getText());
                        modelo.setTema(numero_fila, vista.campoTemas.getText());
                        modelo.setEdicion(numero_fila, vista.campoEdicion.getText());
                        modelo.setAño(numero_fila, vista.campoAño.getText());
                        modelo.setCopiasTotal(numero_fila, vista.campoCopiasT.getText());
                        modelo.setCopiasDisponibles(numero_fila, vista.campoCopiasD.getText());
                        modelo.setEstanteriaNumero(numero_fila, vista.campoEstanteriaN.getText());
                        modelo.setFila(numero_fila, vista.campoFila.getText());
                        modelo.setDescripcion(numero_fila, vista.areaDescripcion.getText());
                        JOptionPane.showMessageDialog(null, "¡Libro actualizado exitosamente!");
                        limpiarCampos();
                        for (int i = panel.diseño.getRowCount() - 1; i >= 0; i--) {
                            panel.diseño.removeRow(i);
                        }
                        panel.campoNombre.setText("");
                        panel.campoAutor.setText("");
                        panel.campoRangoI.setText("");
                        panel.campoRangoF.setText("");
                    } else {

                    }
                }
            }
        }

    }

    public void limpiarCampos() {
        vista.campoISBN.setText("");
        vista.campoTitulo.setText("");
        vista.campoAutor.setText("");
        vista.campoTemas.setText("");
        vista.campoEdicion.setText("");
        vista.campoAño.setText("");
        vista.campoCopiasT.setText("");
        vista.campoCopiasD.setText("");
        vista.campoEstanteriaN.setText("");
        vista.campoFila.setText("");
        vista.areaDescripcion.setText("");
    }

}
