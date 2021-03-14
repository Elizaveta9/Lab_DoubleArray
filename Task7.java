package com.company;

import java.util.Scanner;


public class Task7 {

    public static void main(String[] args) {
        int indC = 0;
        int indL = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Количесво строк » ");
        int stroki = scan.nextInt();
        System.out.print("Количесво столбцов » ");
        int stolbcy = scan.nextInt();
        int[][] mat = new int[stroki][stolbcy];
        int max = 0;

        for (int i = 0; i != mat.length; i++) {
            for (int j = 0; j != mat[i].length; j++) {
                mat[i][j] = (int) (Math.random() * 100);
                if (mat[i][j] > max)
                    max = mat[i][j];
            }
        }

        prettyPrint(mat);

        for (int i = 0, i1 = 1; i != mat.length & i1 != 0; i++) {
            for (int j = 0; j != mat[i].length; j++) {
                if (max == mat[i][j]) {
                    indC = j;
                    indL = i;
                    i1 = 0;
                    break;
                }
            }
        }

        System.out.println("Индексы максимального числа: " + indL + " " + indC);
        System.out.println("Число: " + max);
        System.out.println("\nДвижение строк");

        while (indL != 0) {  //двигает строки
            int[] temp = mat[indL];
            mat[indL] = mat[indL - 1];
            mat[indL - 1] = temp;
            indL--;
            prettyPrint(mat);
        }

        System.out.println("\nДвижение столбцов");

        while (indC != 0) { //двигает столбцы
            for (int i = 0; i != mat.length; i++) {
                int temp1 = mat[i][indC];
                mat[i][indC] = mat[i][indC - 1];
                mat[i][indC - 1] = temp1;
            }
            indC--;
            prettyPrint(mat);
        }
    }

    static void prettyPrint(int[][] arr) {
        System.out.println("==================");
        for (int i = 0; i != arr.length; i++) {

            for (int j = 0; j != arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("==================");
    }
}


