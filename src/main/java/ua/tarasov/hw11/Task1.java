package ua.tarasov.hw11;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя планеты солнечной системы, колличество спутников которой Вы хотите узнать:");
        String planet = scan.next();
        int numberOfSatellite = switch (planet) {
            case ("Меркурий") -> Planet.MERCURY.getNumberOfSatellite();
            case ("Венера") -> Planet.VENUS.getNumberOfSatellite();
            case ("Земля") -> Planet.EARTH.getNumberOfSatellite();
            case ("Марс") -> Planet.MARS.getNumberOfSatellite();
            case ("Юпитер") -> Planet.JUPITER.getNumberOfSatellite();
            case ("Сатурн") -> Planet.SATURN.getNumberOfSatellite();
            case ("Уран") -> Planet.URANUS.getNumberOfSatellite();
            case ("Нептун") -> Planet.NEPTUNE.getNumberOfSatellite();
            default -> throw new IllegalStateException("Unexpected value: " + planet);
        };
        System.out.println("У планеты " + planet + " " + numberOfSatellite + " спутников");
    }
}
