public class Jugador {

    private String nombre;
    private int fila;
    private int columna;
    private int vida;
    private int puntaje;
    private int velocidad;
    private boolean poderActivo;

    public Jugador(String nombre) {
        this.nombre = nombre;

        this.fila = 1;
        this.columna = 1;

        this.vida = 3;
        this.puntaje = 0;
        this.velocidad = 1;
        this.poderActivo = false;
    }

    public void mover(String direccion, Tablero tablero) {
        int nuevaFila = fila;
        int nuevaColumna = columna;

        switch (direccion) {
            case "W":
                nuevaFila -= velocidad;
                break;
            case "S":
                nuevaFila += velocidad;
                break;
            case "A":
                nuevaColumna -= velocidad;
                break;
            case "D":
                nuevaColumna += velocidad;
                break;
            default:
                System.out.println("Movimiento inválido.");
                return;
        }

        if (tablero.movimientoValido(nuevaFila, nuevaColumna)) {
            fila = nuevaFila;
            columna = nuevaColumna;
        } else {
            System.out.println("Hay un muro. No puedes pasar.");

        }
    }

    public void recogerPunto(Punto punto) {
        if (!punto.estaRecogido()) {
            puntaje += punto.getValor();
            punto.recoger();
        }
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void usarPoder(Poder poder) {

        if (!poder.estaRecogido()) {
            poder.activar(this);
            poder.recoger();
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void mostrarEstado() {
        System.out.println();
        System.out.println("=========== JUGADOR ===========");
        System.out.println("Nombre     : " + nombre);
        System.out.println("Vida       : " + vida);
        System.out.println("Puntaje    : " + puntaje);
        System.out.println("Velocidad  : " + velocidad);
        System.out.println("Poder      : " + (poderActivo ? "Activo" : "Ninguno"));
        System.out.println("Posición   : (" + fila + ", " + columna + ")");
        System.out.println("===============================");
        System.out.println();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getVida() {
        return vida;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isPoderActivo() {
        return poderActivo;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setPoderActivo(boolean poderActivo) {
        this.poderActivo = poderActivo;
    }

}