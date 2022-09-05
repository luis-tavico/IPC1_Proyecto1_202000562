package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import vista.VistaLibro;
import vista.VistaPrestamo;
import vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener {

    VistaPrincipal vista = new VistaPrincipal();
    VistaLibro panel_libro = new VistaLibro();
    VistaPrestamo panel_prestamo = new VistaPrestamo();
    ModeloLibro modelo_libro = new ModeloLibro();
    ModeloPrestamo modelo_prestamo = new ModeloPrestamo();
    ControladorLibro controlador_libro = new ControladorLibro(vista, panel_libro, modelo_libro);
    ControladorPrestamo controlador_prestamo = new ControladorPrestamo(vista, panel_prestamo, modelo_prestamo, modelo_libro);

    public ControladorPrincipal(VistaPrincipal vista, ModeloLibro modelo) {
        this.vista = vista;
        this.modelo_libro = modelo_libro;
        vista.btnLibro.addActionListener(this);
        vista.btnPrestamo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLibro) {
            //VistaLibro panel_libro = new VistaLibro();
            vista.panelContenido.removeAll();
            vista.panelContenido.add(panel_libro);
            vista.panelContenido.revalidate();
            vista.panelContenido.repaint();
            limpiarCamposLibro();
        } else if (e.getSource() == vista.btnPrestamo) {
            //VistaPrestamo panel_prestamo = new VistaPrestamo();
            vista.panelContenido.removeAll();
            vista.panelContenido.add(panel_prestamo);
            vista.panelContenido.revalidate();
            vista.panelContenido.repaint();
            limpiarCamposPrestamo();
            //ControladorLibro controlador = new ControladorLibro(vista, vista_libro);

        }
    }

    private void limpiarCamposLibro() {
        panel_libro.campoNombre.setText("");
        panel_libro.campoAutor.setText("");
        panel_libro.campoRangoI.setText("");
        panel_libro.campoRangoF.setText("");
        for (int i = panel_libro.diseño.getRowCount() - 1; i >= 0; i--) {
            panel_libro.diseño.removeRow(i);
        }
    }

    private void limpiarCamposPrestamo() {
        panel_prestamo.campoCui.setText("");
        panel_prestamo.campoNombre.setText("");
        panel_prestamo.campoApellido.setText("");
        for (int i = panel_prestamo.diseño.getRowCount() - 1; i >= 0; i--) {
            panel_prestamo.diseño.removeRow(i);
        }
    }

}
