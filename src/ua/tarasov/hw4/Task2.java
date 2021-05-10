package ua.tarasov.hw4;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] intArray = new int[1000];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt();
        }
        System.out.println("В массиве " + countPrime(intArray) + " простых чисел");
    }

    private static int countPrime(int[] intArray) {
        int count = 0;
        boolean primeNum = false;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 1) {
                for (int j = 2; j < intArray[i]; j++) {
                    if (intArray[i] % j == 0) {
                        primeNum = false;
                        break;
                    } else {
                        primeNum = true;
                    }
                }
                if (primeNum) {
                    count++;
                }
            }
        }
        return count;
    }
}