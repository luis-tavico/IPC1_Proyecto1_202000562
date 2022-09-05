package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloLibro;
import vista.VistaDesbloqueo;
import vista.VistaLibro;
import vista.VistaPrincipal;

public class ControladorDesbloqueo implements ActionListener {

    private VistaDesbloqueo vista;
    private ModeloLibro modelo = new ModeloLibro();
    private String clave = "ipc1";

    public ControladorDesbloqueo(VistaDesbloqueo vista) {
        this.vista = vista;
        vista.btnAceptar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAceptar) {
            if (vista.campoClave.getText().equals(clave)) {
                vista.dispose();
                VistaPrincipal vista = new VistaPrincipal();
                ControladorPrincipal controlador = new ControladorPrincipal(vista, modelo);
                vista.setVisible(true);
            } else if (vista.campoClave.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Complete el campo vacio!");
            } else if (!vista.campoClave.getText().equals(clave)) {
                JOptionPane.showMessageDialog(null, "¡Palabra clave incorrecta!");
                limpiarCampos();
            }
        } else if (e.getSource() == vista.btnCancelar) {
            System.exit(0);
        }
    }

    private void limpiarCampos() {
        vista.campoClave.setText("");
    }

}






























