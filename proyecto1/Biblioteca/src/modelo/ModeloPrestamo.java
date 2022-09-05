package modelo;

public class ModeloPrestamo {

    String[][] prestamista = new String[20][5];
    private int num_fila = 0;

    public ModeloPrestamo() {
        definirAlmacenamiento();
    }

    public String getCUI(Integer numero_fila) {
        String CUI;
        CUI = prestamista[numero_fila][0];
        return CUI;
    }

    public String getNombre(Integer numero_fila) {
        String nombre;
        nombre = prestamista[numero_fila][1];
        return nombre;
    }

    public String getApellido(Integer numero_fila) {
        String apellido;
        apellido = prestamista[numero_fila][2];
        return apellido;
    }

    public String getISBN(Integer numero_fila) {
        String ISBN;
        ISBN = prestamista[numero_fila][3];
        return ISBN;
    }

    public String getHistorial(Integer numero_fila) {
        String historial;
        historial = prestamista[numero_fila][4];
        return historial;
    }

    public void setCUI(Integer numero_fila, String CUI) {
        prestamista[numero_fila][0] = CUI;
    }

    public void setNombre(Integer numero_fila, String nombre) {
        prestamista[numero_fila][1] = nombre;
    }

    public void setApellido(Integer numero_fila, String apellido) {
        prestamista[numero_fila][2] = apellido;
    }

    public void setISBN(Integer numero_fila, String ISBN) {
        prestamista[numero_fila][3] = ISBN;
    }

    public void setHistorial(Integer numero_fila, String historial) {
        prestamista[numero_fila][4] += historial;
    }

    public int getValorFila() {
        return num_fila;
    }

    public void setValorFila() {
        num_fila++;
    }

    public void definirAlmacenamiento() {
        for (int i = 0; i < prestamista.length; i++) {
            for (int j = 0; j < prestamista[0].length; j++) {
                prestamista[i][j] = "";
            }
        }
    }

    public Integer buscarCUI(String CUI) {
        Integer numero_fila = null;
        for (int i = 0; i < prestamista.length; i++) {
            if (prestamista[i][0].equalsIgnoreCase(CUI)) {
                numero_fila = i;
            }
        }
        return numero_fila;
    }

}
