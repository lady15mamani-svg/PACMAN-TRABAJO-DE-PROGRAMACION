public class EnemigoPerseguidor {

    private int fila;
    private int columna;
    private int danio;
    private boolean activo;

    public EnemigoPerseguidor(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.danio = 1;
        this.activo = true;
    }

    public void mover(Jugador jugador, Tablero tablero) {

        if (!activo) {
            return;
        }

        int nuevaFila = fila;
        int nuevaColumna = columna;

        if (jugador.getFila() < fila) {
            nuevaFila--;
        } else if (jugador.getFila() > fila) {
            nuevaFila++;
        }

        if (tablero.movimientoValido(nuevaFila, columna)) {
            fila = nuevaFila;
            return;
        }

        nuevaFila = fila;

        if (jugador.getColumna() < columna) {
            nuevaColumna--;
        } else if (jugador.getColumna() > columna) {
            nuevaColumna++;
        }

        if (tablero.movimientoValido(fila, nuevaColumna)) {
            columna = nuevaColumna;
        }
    }

    public void atacar(Jugador jugador) {
        jugador.recibirDanio(danio);
    }

    public boolean verificarColision(Jugador jugador) {
        return fila == jugador.getFila() &&
                columna == jugador.getColumna();
    }

    public void mostrarEstado() {
        System.out.println("Perseguidor -> (" + fila + "," + columna + ")");
    }


    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getDanio() {
        return danio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}