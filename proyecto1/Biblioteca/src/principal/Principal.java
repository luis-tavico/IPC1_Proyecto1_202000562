package principal;

import controlador.ControladorDesbloqueo;
import vista.VistaDesbloqueo;

public class Principal {

    public static void main(String[] args) {
        VistaDesbloqueo vista = new VistaDesbloqueo();
        ControladorDesbloqueo controlador = new ControladorDesbloqueo(vista);
        vista.setVisible(true);
    }
}
