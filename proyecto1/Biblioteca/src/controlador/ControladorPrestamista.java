package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ModeloPrestamo;
import vista.VistaPrestamista;

public class ControladorPrestamista implements ActionListener {

    VistaPrestamista vista = new VistaPrestamista();
    ModeloPrestamo modelo = new ModeloPrestamo();

    public ControladorPrestamista(VistaPrestamista vista, ModeloPrestamo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        validacionCampos();
        vista.btnGuardar.addActionListener(this);
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
        vista.campoCui.addKeyListener(eventoTecla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (vista.campoCui.getText().equals("") || vista.campoNombre.getText().equals("") || vista.campoApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Complete los campos vacios!");
            } else {
                if (modelo.getValorFila() < 20) {
                    if (modelo.buscarCUI(vista.campoCui.getText()) == null) {
                        int posicion = modelo.getValorFila();
                        modelo.setCUI(posicion, vista.campoCui.getText());
                        modelo.setNombre(posicion, vista.campoNombre.getText());
                        modelo.setApellido(posicion, vista.campoApellido.getText());
                        modelo.setValorFila();
                        JOptionPane.showMessageDialog(null, "¡Prestamista agregado exitosamente!");
                        limpiarControles();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error, El CUI ingresado ya existe!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Almacenamiento lleno!");
                    limpiarControles();
                }
            }
        }
    }

    private void limpiarControles() {
        vista.campoCui.setText("");
        vista.campoNombre.setText("");
        vista.campoApellido.setText("");
    }

}
