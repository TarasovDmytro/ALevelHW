package ua.tarasov.hw9;

import java.util.Scanner;

public class ChessMove {

    int indexI;
    int indexJ;
    ConverterChessCoordinatesToIndexes converter;

    ChessMove() {
    }

    public ChessMove(String location) {
        this.converter = new ConverterChessCoordinatesToIndexes(location);
        this.indexI = converter.getIndexI();
        this.indexJ = converter.getIndexJ();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите начальное расположение фигуры Конь на шахматной доске (в формате: а1):");
        String firstLocation = scan.next();
        System.out.println("Введите предполагаемое расположение фигуры Конь на шахматной доске (в формате: а1):");
        String nextLocation = scan.next();
        validateMove(firstLocation, nextLocation);
    }

    static void validateMove(String firstLocation, String nextLocation) {

        ChessMove start = new ChessMove(firstLocation);
        ChessMove finish = new ChessMove(nextLocation);
        ChessKnight validate = new ChessKnight();

        if (start.indexI < 0 || finish.indexI < 0) {
            System.out.println("Это за пределами шахматной доски!");
        }

        if (validate.checkTurn(start.indexI, start.indexJ, finish.indexI, finish.indexJ)) {
            System.out.println("Да, такой ход возможен!");
        } else {
            System.out.println("Такой ход не возможен!");
        }
    }

}

