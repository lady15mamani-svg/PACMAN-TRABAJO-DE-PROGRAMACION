public class Punto {

    private int fila;
    private int columna;
    private int valor;
    private boolean recogido;

    public Punto(int fila, int columna, int valor) {

        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.recogido = false;

    }

    public int getValor() {
        return valor;
    }

    public boolean estaRecogido() {
        return recogido;
    }

    public void recoger() {
        recogido = true;
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

    public void setValor(int valor) {
        this.valor = valor;
    }
}