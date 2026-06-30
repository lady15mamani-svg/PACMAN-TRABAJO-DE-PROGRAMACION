import java.util.Scanner
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- CONFIGURACION DEL TABLERO DE PACMAN ---");
        System.out.print("Ingresa el numero de filas: ");
        int filasUsuario = teclado.nextInt();

        System.out.print("Ingresa el numero de columnas: ");
        int columnasUsuario = teclado.nextInt();

        System.out.println("\nGenerando tablero dinámico...\n");
        Tablero miTablero = new Tablero(filasUsuario, columnasUsuario);
        enemigo1 miEnemigo = new enemigo1(3, 3);
        miTablero.mostrarTablero(miEnemigo);
        teclado.close();
    }
}