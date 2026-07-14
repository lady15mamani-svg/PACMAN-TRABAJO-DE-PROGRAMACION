import java.util.Random;

public class ControlEnemigos {

    private EnemigoPerseguidor[] perseguidores;
    private EnemigoAleatorio[] aleatorios;
    private EnemigoFantasma[] fantasmas;

    private Random random;

    public ControlEnemigos() {
        random = new Random();

        perseguidores = new EnemigoPerseguidor[2];
        aleatorios = new EnemigoAleatorio[2];
        fantasmas = new EnemigoFantasma[1];
    }

    public void generarEnemigos(Tablero tablero) {

        for (int i = 0; i < perseguidores.length; i++) {
            int fila;
            int columna;

            do {
                fila = random.nextInt(tablero.getFilas() - 2) + 1;
                columna = random.nextInt(tablero.getColumnas() - 2) + 1;
            } while (!tablero.movimientoValido(fila, columna));

            perseguidores[i] = new EnemigoPerseguidor(fila, columna);
        }

        for (int i = 0; i < aleatorios.length; i++) {

            int fila;
            int columna;

            do {
                fila = random.nextInt(tablero.getFilas() - 2) + 1;
                columna = random.nextInt(tablero.getColumnas() - 2) + 1;
            } while (!tablero.movimientoValido(fila, columna));

            aleatorios[i] = new EnemigoAleatorio(fila, columna);
        }

        int fila;
        int columna;

        do {
            fila = random.nextInt(tablero.getFilas() - 2) + 1;
            columna = random.nextInt(tablero.getColumnas() - 2) + 1;
        } while (!tablero.movimientoValido(fila, columna));

        fantasmas[0] = new EnemigoFantasma(fila, columna);

    }

    public void moverEnemigos(Jugador jugador, Tablero tablero) {

        for (EnemigoPerseguidor enemigo : perseguidores) {
            enemigo.mover(jugador, tablero);
        }

        for (EnemigoAleatorio enemigo : aleatorios) {
            enemigo.mover(tablero);
        }

        for (EnemigoFantasma enemigo : fantasmas) {
            enemigo.mover(tablero);
        }
    }

    public void verificarColisiones(Jugador jugador) {

        for (EnemigoPerseguidor enemigo : perseguidores) {
            if (enemigo.verificarColision(jugador)) {
                enemigo.atacar(jugador);
            }
        }

        for (EnemigoAleatorio enemigo : aleatorios) {
            if (enemigo.verificarColision(jugador)) {
                enemigo.atacar(jugador);
            }
        }

        for (EnemigoFantasma enemigo : fantasmas) {
            if (enemigo.verificarColision(jugador)) {
                enemigo.atacar(jugador);
            }
        }
    }

    public EnemigoPerseguidor[] getPerseguidores() {
        return perseguidores;
    }

    public EnemigoAleatorio[] getAleatorios() {
        return aleatorios;
    }

    public EnemigoFantasma[] getFantasmas() {
        return fantasmas;
    }
}