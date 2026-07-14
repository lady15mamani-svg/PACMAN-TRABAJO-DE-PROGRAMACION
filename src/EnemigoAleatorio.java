import java.util.Random;

public class EnemigoAleatorio {

    private int fila;
    private int columna;
    private int danio;
    private boolean activo;

    private Random random;

    public EnemigoAleatorio(int fila, int columna) {

        this.fila = fila;
        this.columna = columna;
        this.danio = 1;
        this.activo = true;

        random = new Random();

    }

    public void mover(Tablero tablero) {

        if (!activo) {
            return;
        }

        int nuevaFila = fila;
        int nuevaColumna = columna;

        int direccion = random.nextInt(4);

        switch (direccion) {
            case 0:
                nuevaFila--;
                break;
            case 1:
                nuevaFila++;
                break;
            case 2:
                nuevaColumna--;
                break;
            case 3:
                nuevaColumna++;
                break;
        }

        if (tablero.movimientoValido(nuevaFila, nuevaColumna)) {
            fila = nuevaFila;
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
        System.out.println("Aleatorio -> (" + fila + "," + columna + ")");
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