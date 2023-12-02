package lab8_p1_erickhernandez;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab8_P1_ErickHernandez {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static int[][] llenarRandom() {
        int[][] temporal = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    temporal[i][j] = 0;
                } else {
                    temporal[i][j] = random.nextInt(0, 2);
                }
            }
        }
        return temporal;
    }

    public static ArrayList<String> listaCoordenadas(int[][] matriz) {
        ArrayList<String> temporal = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] == 1) {
                    String coordenada = "(" + i + ":" + j + ") ";
                    temporal.add(coordenada);
                }
            }
        }

        return temporal;
    }

    public static int[][] matriz2() {
        int[][] temporal = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temporal[i][j] = 0;

            }
        }
        return temporal;
    }

    public static int[][] generarSiguiente(int[][] matriz2) {
        int[][] temporal = matriz2;
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {

                int contador = 0;
                int contador2 = 0;

                if (i - 1 > 0) {
                    if (j - 1 > 0) {
                        if (j + 1 <= 9) {
                            if (i + 1 <= 9) {
                                
                                if (matriz2[i][j] == 1) {
                                    if (matriz2[i - 1][j - 1] == 1 || (matriz2[i + 1][j + 1] == 1) || (matriz2[i + 1][j] == 1) || (matriz2[i][j - 1] == 1) || (matriz2[i - 1][j] == 1) || (matriz2[i - 1][j + 1] == 1) || (matriz2[i + 1][j - 1] == 1) || (matriz2[i][j + 1] == 1)) {
                                        contador++;
                                    }

                                    if (contador > 2) {
                                        matriz2[i][j] = 0;
                                    } else if (contador == 2) {
                                        matriz2[i][j] = 1;
                                    } else if (contador < 2) {
                                        matriz2[i][j] = 0;
                                    } else {
                                        continue;
                                    }

                                } else if (matriz2[i][j] == 0) {
                                    
                                    if (matriz2[i - 1][j - 1] == 1 || (matriz2[i + 1][j + 1] == 1) || (matriz2[i + 1][j] == 1) || (matriz2[i][j - 1] == 1) || (matriz2[i - 1][j] == 1) || (matriz2[i - 1][j + 1] == 1) || (matriz2[i + 1][j - 1] == 1) || (matriz2[i][j + 1] == 1)) {
                                        contador2++;
                                    }
                                    
                                    if (contador2 == 3) {
                                        matriz2[i][j] = 1;
                                    } else {
                                        continue;
                                    }
                                }

                            }
                        }
                    }
                }

            }
        }
        return temporal;
    }

    public static void main(String[] args) {
        System.out.print("[1] Game of life \n[2]Salir del programa \nIngrese opcion: ");
        int opcion = sc.nextInt();

        int[][] matriz;
        int[][] matriz2;

        while (opcion != 2) {
            switch (opcion) {

                case 1:

                    System.out.print("Numero de rondas: ");
                    int rondas = sc.nextInt();
                    matriz = llenarRandom();
                    System.out.println("Coordenadas iniciales: ");
                    ArrayList<String> Coordenadas = listaCoordenadas(matriz);

                    for (String coordenada : Coordenadas) {
                        System.out.print(coordenada);
                    }
                    System.out.println("");
                    imprimir(matriz);

                    for (int i = 0; i < rondas; i++) {
                        System.out.println("Ronda " + (i + 1));

                        matriz2 = generarSiguiente(matriz);
                        ArrayList<String> Coordenadas2 = listaCoordenadas(matriz2);
                        for (String coordenada : Coordenadas2) {
                            System.out.print(coordenada);
                        }
                        System.out.println("");
                        imprimir(matriz2);

                        matriz = matriz2;
                    }
                    break;

                default:
                    System.out.println("Opcion invalida!");
            }
            System.out.print("\n[1] Game of life \n[2]Salir del programa \nIngrese opcion: ");
            opcion = sc.nextInt();
        }
        System.out.println("Fin del programa");

    }

}
