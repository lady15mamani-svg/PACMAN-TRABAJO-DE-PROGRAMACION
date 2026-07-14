import java.util.Scanner;

public class Juego {

    private Jugador jugador;
    private Tablero tablero;
    private ControlEnemigos controlEnemigos;

    private Scanner teclado;
    private boolean juegoTerminado;

    private int filas;
    private int columnas;

    public Juego() {
        teclado = new Scanner(System.in);
        juegoTerminado = false;
    }

    public void iniciarJuego() {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    nuevaPartida();
                    break;
                case 2:
                    mostrarInstrucciones();
                    break;
                case 3:
                    System.out.println("\nGracias por jugar.");
                    break;
                default:
                    System.out.println("\nOpción inválida.");
            }
        } while (opcion != 3);
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("======================================");
        System.out.println("              PAC - MAN");
        System.out.println("======================================");
        System.out.println("1. Nueva partida");
        System.out.println("2. Instrucciones");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void nuevaPartida() {

        System.out.print("\nNombre del jugador: ");
        String nombre = teclado.nextLine();

        do {
            System.out.print("Filas (mínimo 10): ");
            filas = leerEntero();
        } while (filas < 10);

        do {
            System.out.print("Columnas (mínimo 20): ");
            columnas = leerEntero();
        } while (columnas < 20);
        jugador = new Jugador(nombre);
        tablero = new Tablero(filas, columnas);
        tablero.generarTablero();
        controlEnemigos = new ControlEnemigos();
        controlEnemigos.generarEnemigos(tablero);
        juegoTerminado = false;
        ejecutarJuego();
    }

    private void ejecutarJuego() {

        while (!juegoTerminado) {

            limpiarPantalla();

            mostrarEstadoGeneral();

            tablero.mostrarTablero(jugador);

            System.out.println();
            System.out.println("=========== CONTROLES ===========");
            System.out.println("W -> Arriba");
            System.out.println("S -> Abajo");
            System.out.println("A -> Izquierda");
            System.out.println("D -> Derecha");
            System.out.println("X -> Salir");
            System.out.print("Movimiento: ");

            String movimiento = teclado.nextLine().toUpperCase();

            if (movimiento.equals("X")) {
                juegoTerminado = true;
                continue;
            }

            jugador.mover(movimiento, tablero);

            verificarPuntos();

            verificarPoderes();

            controlEnemigos.moverEnemigos(jugador, tablero);

            controlEnemigos.verificarColisiones(jugador);

            if (!jugador.estaVivo()) {
                limpiarPantalla();
                tablero.mostrarTablero(jugador);

                System.out.println();
                System.out.println("==================================");
                System.out.println("          GAME OVER               ");
                System.out.println("==================================");
                juegoTerminado = true;
            }

            if (todosLosPuntosRecogidos()) {
                limpiarPantalla();
                tablero.mostrarTablero(jugador);
                System.out.println();
                System.out.println("==================================");
                System.out.println("        ¡GANASTE!                 ");
                System.out.println("==================================");

                juegoTerminado = true;
            }
        }
    }

    private void mostrarEstadoGeneral() {
        System.out.println("======================================");
        System.out.println("Jugador : " + jugador.getNombre());
        System.out.println("Vida    : " + jugador.getVida());
        System.out.println("Puntaje : " + jugador.getPuntaje());
        System.out.println("Velocidad : " + jugador.getVelocidad());

        if (jugador.isPoderActivo()) {
            System.out.println("Poder : ACTIVO");
        } else {
            System.out.println("Poder : Ninguno");
        }
        System.out.println("======================================");
    }

    private void verificarPuntos() {

        Punto[] puntos = tablero.getPuntos();

        for (int i = 0; i < puntos.length; i++) {
            if (!puntos[i].estaRecogido()) {
                if (jugador.getFila() == puntos[i].getFila()
                        && jugador.getColumna() == puntos[i].getColumna()) {

                    jugador.recogerPunto(puntos[i]);
                }
            }
        }
    }

    private void verificarPoderes() {

        Poder[] poderes = tablero.getPoderes();

        for (int i = 0; i < poderes.length; i++) {
            if (!poderes[i].estaRecogido()) {
                if (jugador.getFila() == poderes[i].getFila()
                        && jugador.getColumna() == poderes[i].getColumna()) {
                    jugador.usarPoder(poderes[i]);
                }
            }
        }
    }

    private boolean todosLosPuntosRecogidos() {
        Punto[] puntos = tablero.getPuntos();

        for (int i = 0; i < puntos.length; i++) {
            if (!puntos[i].estaRecogido()) {
                return false;
            }
        }
        return true;
    }

    private void mostrarInstrucciones() {

        System.out.println();
        System.out.println("========== INSTRUCCIONES ==========");
        System.out.println("Objetivo:");
        System.out.println("- Recoge todos los puntos.");
        System.out.println("- Evita a los enemigos.");
        System.out.println("- Usa los poderes.");
        System.out.println();
        System.out.println("Controles:");
        System.out.println("W -> Arriba");
        System.out.println("S -> Abajo");
        System.out.println("A -> Izquierda");
        System.out.println("D -> Derecha");
        System.out.println("X -> Salir");
        System.out.println("===================================");
        System.out.println();

    }

    private void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    private int leerEntero() {
        while (!teclado.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            teclado.next();
        }
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }

}