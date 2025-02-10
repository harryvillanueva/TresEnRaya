import java.util.Random;
import java.util.Scanner;

public class tresEnRaya {

    private static final char JUGADOR = 'X'; // Buena práctica
    private static final char MAQUINA = 'O';
    private static final char VACIO = '-';
    private static  int contador;


    private static char[][] tablero ;
    private static boolean juegoTerminado = false;



    public static void main(String[] args) {

        contador = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean turnoJugador = true;

        inicializarTablero();

        do{
            mostrarTablero();
            System.out.println();

            if (turnoJugador){

                System.out.println("Ingrese fila y columna  del 1 al 3");
                int fila ;
                int columna ;
                char valor;

                do {
                    fila = scanner.nextInt();
                    columna = scanner.nextInt();
                    valor = tablero[fila-1][columna-1];
                }while (!estaVacio(valor));
                tablero[fila-1][columna-1] = JUGADOR;
                contador++;



            }
            else {
                System.out.println("Turno de la máquina...");
                int  fila ;
                int  columna;
                char valor;

                do {
                    fila = random.nextInt(3);
                    columna = random.nextInt(3);
                    valor = tablero[fila][columna];
                }
                while (!estaVacio(valor));
                tablero[fila][columna] = MAQUINA;
                contador++;

            }


            turnoJugador = !turnoJugador;

            if (contador==9){

                mostrarTablero();
                System.out.println("el juego ha terminado");
                juegoTerminado = true;

            }

        }while(!juegoTerminado);



    }


    private static void mostrarTablero(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static void inicializarTablero(){

        tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j]=VACIO;

            }

        }

    }

    private static  boolean estaVacio(char valor){

        boolean vacio;


        if (valor != VACIO){
            vacio = false;
        }
        else {
            vacio = true;
        }

        return vacio;
    }

}