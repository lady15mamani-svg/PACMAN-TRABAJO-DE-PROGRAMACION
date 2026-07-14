public class Muro {

    private int fila;
    private int columna;

    public Muro(int fila, int columna) {

        this.fila = fila;
        this.columna = columna;

    }

    public int[] getPosicion() {

        return new int[]{fila, columna};

    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

}