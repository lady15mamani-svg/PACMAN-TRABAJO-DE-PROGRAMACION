import java.util.Random;

public class Tablero {

    private int filas;
    private int columnas;

    private char[][] matriz;

    private Muro[] muros;
    private Punto[] puntos;
    private Poder[] poderes;

    private Random random;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;

        matriz = new char[filas][columnas];

        random = new Random();
    }

    public void generarTablero() {
        inicializarMatriz();
        crearBordes();
        crearMuros();
        agregarPuntos();
        agregarPoderes();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    private void crearBordes() {

        for (int i = 0; i < filas; i++) {
            matriz[i][0] = '#';
            matriz[i][columnas - 1] = '#';
        }

        for (int j = 0; j < columnas; j++) {
            matriz[0][j] = '#';
            matriz[filas - 1][j] = '#';
        }
    }

    private void crearMuros() {

        int cantidad = (filas * columnas) / 8;
        muros = new Muro[cantidad];

        int contador = 0;
        while (contador < cantidad) {

            int fila = random.nextInt(filas - 2) + 1;
            int columna = random.nextInt(columnas - 2) + 1;

            if (matriz[fila][columna] == ' ') {
                matriz[fila][columna] = '#';
                muros[contador] = new Muro(fila, columna);
                contador++;
            }
        }
    }

    private void agregarPuntos() {

        int cantidad = 0;

        for (int i = 1; i < filas - 1; i++) {
            for (int j = 1; j < columnas - 1; j++) {
                if (matriz[i][j] == ' ') {
                    cantidad++;
                }
            }
        }

        puntos = new Punto[cantidad];

        int indice = 0;

        for (int i = 1; i < filas - 1; i++) {
            for (int j = 1; j < columnas - 1; j++) {
                if (matriz[i][j] == ' ') {
                    puntos[indice] = new Punto(i, j, 10);
                    indice++;
                }
            }
        }
    }

    private void agregarPoderes() {

        poderes = new Poder[3];

        int cantidad = 0;

        while (cantidad < 3) {

            int fila = random.nextInt(filas - 2) + 1;
            int columna = random.nextInt(columnas - 2) + 1;

            if (matriz[fila][columna] == ' ') {

                if (cantidad == 0) {
                    poderes[cantidad] =
                            new Poder("Velocidad",5,fila,columna);
                } else if (cantidad == 1) {
                    poderes[cantidad] =
                            new Poder("Congelar",5,fila,columna);
                } else {
                    poderes[cantidad] =
                            new Poder("Vida",1,fila,columna);
                }
                cantidad++;
            }
        }
    }

    public void mostrarTablero(Jugador jugador) {

        char[][] copia = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                copia[i][j] = matriz[i][j];
            }
        }

        if (puntos != null) {
            for (Punto punto : puntos) {
                if (!punto.estaRecogido()) {
                    copia[punto.getFila()][punto.getColumna()]='.';
                }
            }
        }

        if (poderes != null) {
            for (Poder poder : poderes) {
                if (!poder.estaRecogido()) {
                    copia[poder.getFila()][poder.getColumna()]='*';
                }
            }
        }

        copia[jugador.getFila()][jugador.getColumna()]='P';

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(copia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean movimientoValido(int fila,int columna){

        if(fila<0 || fila>=filas){
            return false;
        }

        if(columna<0 || columna>=columnas){
            return false;
        }
        return matriz[fila][columna]!='#';
    }

    public int getFilas(){
        return filas;
    }

    public int getColumnas(){
        return columnas;
    }

    public char[][] getMatriz(){
        return matriz;
    }

    public Punto[] getPuntos(){
        return puntos;
    }

    public Poder[] getPoderes(){
        return poderes;
    }

    public Muro[] getMuros(){
        return muros;
    }
}