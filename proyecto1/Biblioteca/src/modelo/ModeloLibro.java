package modelo;

public class ModeloLibro {

    String[][] libro = new String[20][12];
    private int num_fila = 0;

    public ModeloLibro() {
        definirAlmacenamiento();
    }

    public String getISBN(Integer numero_fila) {
        String ISBN;
        ISBN = libro[numero_fila][0];
        return ISBN;
    }

    public String getTitulo(Integer numero_fila) {
        String titulo;
        titulo = libro[numero_fila][1];
        return titulo;
    }

    public String getAutor(Integer numero_fila) {
        String autor;
        autor = libro[numero_fila][2];
        return autor;
    }

    public String getTema(Integer numero_fila) {
        String tema;
        tema = libro[numero_fila][3];
        return tema;
    }

    public String getEdicion(Integer numero_fila) {
        String titulo;
        titulo = libro[numero_fila][4];
        return titulo;
    }

    public String getAño(Integer numero_fila) {
        String año;
        año = libro[numero_fila][5];
        return año;
    }

    public String getCopiasTotal(Integer numero_fila) {
        String copiasTotal;
        copiasTotal = libro[numero_fila][6];
        return copiasTotal;
    }

    public String getCopiasDisponibles(Integer numero_fila) {
        String copiasDisponibles;
        copiasDisponibles = libro[numero_fila][7];
        return copiasDisponibles;
    }

    public String getPrestados(Integer numero_fila) {
        String prestados;
        prestados = libro[numero_fila][8];
        return prestados;
    }

    public String getEstanteriaNumero(Integer numero_fila) {
        String estanteriaNumero;
        estanteriaNumero = libro[numero_fila][9];
        return estanteriaNumero;
    }

    public String getFila(Integer numero_fila) {
        String fila;
        fila = libro[numero_fila][10];
        return fila;
    }

    public String getDescripcion(Integer numero_fila) {
        String descripcion;
        descripcion = libro[numero_fila][11];
        return descripcion;
    }

    public void setISBN(Integer numero_fila, String ISBN) {
        libro[numero_fila][0] = ISBN;
    }

    public void setTitulo(Integer numero_fila, String titulo) {
        libro[numero_fila][1] = titulo;
    }

    public void setAutor(Integer numero_fila, String autor) {
        libro[numero_fila][2] = autor;
    }

    public void setTema(Integer numero_fila, String tema) {
        libro[numero_fila][3] = tema;
    }

    public void setEdicion(Integer numero_fila, String titulo) {
        libro[numero_fila][4] = titulo;
    }

    public void setAño(Integer numero_fila, String año) {
        libro[numero_fila][5] = año;
    }

    public void setCopiasTotal(Integer numero_fila, String copiasTotal) {
        libro[numero_fila][6] = copiasTotal;
    }

    public void setCopiasDisponibles(Integer numero_fila, String copiasDisponibles) {
        libro[numero_fila][7] = copiasDisponibles;
    }

    public void setPrestados(Integer numero_fila, String prestados) {
        libro[numero_fila][8] = prestados;
    }

    public void setEstanteriaNumero(Integer numero_fila, String estanteriaNumero) {
        libro[numero_fila][9] = estanteriaNumero;
    }

    public void setFila(Integer numero_fila, String fila) {
        libro[numero_fila][10] = fila;
    }

    public void setDescripcion(Integer numero_fila, String descripcion) {
        libro[numero_fila][11] = descripcion;
    }

    public int getValorFila() {
        return num_fila;
    }

    public void setValorFila() {
        num_fila++;
    }

    ///////////////////////////
    public void definirAlmacenamiento() {
        for (int i = 0; i < libro.length; i++) {
            for (int j = 0; j < libro[0].length; j++) {
                libro[i][j] = "";
            }
        }
    }

    public Integer buscarISBN(String ISBN) {
        Integer numero_fila = null;
        for (int i = 0; i < libro.length; i++) {
            if (libro[i][0].equalsIgnoreCase(ISBN)) {
                numero_fila = i;
            }
        }
        return numero_fila;
    }

    public Integer buscarTitulo(String titulo) {
        Integer numero_fila = null;
        for (int i = 0; i < libro.length; i++) {
            if (libro[i][1].equalsIgnoreCase(titulo)) {
                numero_fila = i;
            }
        }
        return numero_fila;
    }

    public String buscarAutor(String autor) {
        String numero_filas = "";
        for (int i = 0; i < libro.length; i++) {
            if (libro[i][2].equalsIgnoreCase(autor)) {
                numero_filas += i + "-";
            }
        }
        return numero_filas;
    }

    public String buscarRango(int inicio, int fin) {
        String numero_filas = "";
        for (int i = 0; i < libro.length; i++) {
            if (!libro[i][5].equals("")) {
                if (Integer.parseInt(libro[i][5]) >= inicio && Integer.parseInt(libro[i][5]) <= fin) {
                    numero_filas += i + "-";
                }
            }
        }
        return numero_filas;
    }

    public String buscarAutorYRango(String autor, int inicio, int fin) {
        String numero_filas = "";
        for (int i = 0; i < libro.length; i++) {
            if (!libro[i][5].equals("")) {
                if (libro[i][2].equalsIgnoreCase(autor) && (Integer.parseInt(libro[i][5]) >= inicio && Integer.parseInt(libro[i][5]) <= fin)) {
                    numero_filas += i + "-";
                }
            }
        }
        return numero_filas;
    }

}
