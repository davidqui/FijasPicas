/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fijaspicas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author David Antonio Quijano Ramos
 */
public class FijasPicas {

    static char numGen[] = new char[4]; //arreglo que almacenara el numero de 4 digitos generado 
    static int fijas, picas, paso;

    static String numIngresado = "";

    public static void main(String[] args) {
        int num = 0;
        int intentos = 0;
        generarAleatorio(num);
        System.out.println("Numero generado: " + String.valueOf(numGen));
        do {
            if (fijas != 4) {
                intentos++;
            }
            System.out.println("Ingrese un numero de 4 digitos : ");
            Scanner scanner = new Scanner(System.in);
            numIngresado = scanner.nextLine();

            System.out.println(accion(numIngresado));
            System.out.println("Numero de intentos :"+ intentos);

        } while (fijas != 4);

    }

    static boolean comparar(String numIngresado) {

        int i, j;
        char[] arrIngr = numIngresado.toCharArray();
        fijas = picas = 0;
        for (i = 0; i < numGen.length; i++) {
            for (j = 0; j < 4; j++) {
                if (i == j) {
                    if (numGen[i] == arrIngr[j]) {
                        fijas++;
                        break;
                    }
                } else {
                    if (numGen[i] == arrIngr[j]) {
                        picas++;
                        break;
                    }
                }
            }
        }
        return false;

    }

    public static int generarAleatorio(int num) {
        Random aleatorio = new Random();
        int i = 0;

        while (i < 4) {
            paso = 0;
            num = aleatorio.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (numGen[j] == (char) (num + 48)) {
                    paso = 1;
                }
            }
            if (paso == 0) {
                numGen[i] = (char) (num + 48);
                i++;
            }
        }
        return num;
    }

    public static String accion(String numIngresado) {

        boolean estado = false;

        int num = 0;

        if (estado) {
            estado = true;

        } else {

            if (numIngresado.length() == 4) {
                comparar(numIngresado);
                if (fijas == 4) {
                    System.out.println("Numero: " + numIngresado + " Picas: " + picas + "  Fijas: " + fijas);
                    System.out.println("Has ganado!!! , FIN DEL JUEGO :");

                } else {
                    System.out.println("Numero: " + numIngresado + "   Picas: " + picas + "   Fijas:" + fijas);

                }
            } else {
                System.out.println("Son 4 Digitos!!!! , Cantidad de Digitos diferente");
            }
        }
        if (estado) {
            estado = false;

        }
        return numIngresado;
    }
}
