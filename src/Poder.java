public class Poder {

    private String tipo;
    private int duracion;
    private int fila;
    private int columna;
    private boolean recogido;

    public Poder(String tipo, int duracion, int fila, int columna) {

        this.tipo = tipo;
        this.duracion = duracion;
        this.fila = fila;
        this.columna = columna;
        this.recogido = false;
    }

    public void activar(Jugador jugador) {

        switch (tipo) {

            case "Velocidad":
                jugador.setVelocidad(jugador.getVelocidad() + 1);
                jugador.setPoderActivo(true);
                System.out.println("¡Velocidad aumentada!");
                break;

            case "Congelar":
                jugador.setPoderActivo(true);
                System.out.println("¡Los enemigos se congelarán por unos turnos!");
                break;

            case "Vida":
                jugador.setVida(jugador.getVida() + 1);
                System.out.println("¡Has recuperado una vida!");
                break;
        }
    }

    public String descripcion() {
        switch (tipo) {
            case "Velocidad":
                return "Aumenta la velocidad del jugador.";
            case "Congelar":
                return "Congela a los enemigos por unos turnos.";
            case "Vida":
                return "Recupera una vida.";
            default:
                return "Poder desconocido.";
        }
    }

    public void recoger() {
        recogido = true;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean estaRecogido() {
        return recogido;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}