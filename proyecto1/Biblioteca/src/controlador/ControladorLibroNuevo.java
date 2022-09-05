package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ModeloLibro;
import vista.VistaLibroNuevo;

public class ControladorLibroNuevo implements ActionListener {

    private VistaLibroNuevo vista;
    private ModeloLibro modelo;

    public ControladorLibroNuevo(VistaLibroNuevo vista, ModeloLibro modelo) {
        this.vista = vista;
        this.modelo = modelo;
        validacionCampos();
        validacionCampoISBN();
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
        if (e.getSource() == vista.btnGuardar) {
            if (vista.campoISBN.getText().equals("") || vista.campoTitulo.getText().equals("") || vista.campoAutor.getText().equals("") || vista.campoTemas.getText().equals("") || vista.campoEdicion.getText().equals("") || vista.campoAño.getText().equals("") || vista.campoCopiasT.getText().equals("") || vista.campoFila.getText().equals("") || vista.campoEstanteriaN.getText().equals("") || vista.areaDescripcion.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Complete los campos vacios!");
            } else {
                if (modelo.getValorFila() < 20) {
                    if (modelo.buscarISBN(vista.campoISBN.getText()) == null) {
                        int posicion = modelo.getValorFila();
                        modelo.setISBN(posicion, vista.campoISBN.getText());
                        modelo.setTitulo(posicion, vista.campoTitulo.getText());
                        modelo.setAutor(posicion, vista.campoAutor.getText());
                        modelo.setTema(posicion, vista.campoTemas.getText());
                        modelo.setEdicion(posicion, vista.campoEdicion.getText());
                        modelo.setAño(posicion, vista.campoAño.getText());
                        modelo.setCopiasTotal(posicion, vista.campoCopiasT.getText());
                        modelo.setCopiasDisponibles(posicion, vista.campoCopiasT.getText());
                        modelo.setEstanteriaNumero(posicion, vista.campoEstanteriaN.getText());
                        modelo.setFila(posicion, vista.campoFila.getText());
                        modelo.setDescripcion(posicion, vista.areaDescripcion.getText());
                        modelo.setPrestados(posicion, "0");
                        modelo.setValorFila();
                        JOptionPane.showMessageDialog(null, "¡Libro agregado exitosamente!");
                        limpiarControles();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error, El ISBN ingresado ya existe!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Almacenamiento lleno!");
                    limpiarControles();
                }
            }
        }
    }

    private void limpiarControles() {
        vista.campoISBN.setText("");
        vista.campoTitulo.setText("");
        vista.campoAutor.setText("");
        vista.campoTemas.setText("");
        vista.campoEdicion.setText("");
        vista.campoAño.setText("");
        vista.campoCopiasT.setText("");
        vista.campoEstanteriaN.setText("");
        vista.campoFila.setText("");
        vista.areaDescripcion.setText("");
    }
}
