public class Tablero {
    private int filas;
    private int columnas;
    private int[][] mapa;

    public Tablero(int _filas, int _columnas){
        this.filas = _filas;
        this.columnas = _columnas;
        this.mapa = new int[filas][columnas];
        generarTableroDefecto();
    }

    private void generarTableroDefecto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 0 || i == filas - 1 || j == 0 || j == columnas - 1) {
                    mapa[i][j] = 1;
                } else {
                    mapa[i][j] = 2;
                }
            }
        }
    }
    public void mostrarTablero(enemigo1 enemigo) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (i == enemigo.getX() && j == enemigo.getY()) {
                    System.out.print("E ");
                } else if (mapa[i][j] == 1) {
                    System.out.print("# ");
                } else if (mapa[i][j] == 2) {
                    System.out.print(". ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }
}
