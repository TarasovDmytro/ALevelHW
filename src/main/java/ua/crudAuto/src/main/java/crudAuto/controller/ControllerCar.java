package crudAuto.controller;

import crudAuto.entitys.Car;
import crudAuto.services.CarService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class ControllerCar {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private Car currentCar = null;
    private final CarService service = new CarService();

    public void run() {

        String action = "";
        while (!action.equals("0")) {

            System.out.println("""

                     Select an action, please:
                     _______________________________________
                     enter 1  if you want to create auto
                     enter 2  if you want to update auto
                     enter 3  if you want to fetch auto by id
                     enter 4  if you want to fetch auto by name
                     enter 5  if you want to fetch auto by price range
                     enter 6  if you want to fetch all autos
                     enter 7  if you want to delete the auto by id
                     enter 8  if you want to delete all autos
                     enter 0  if you want to exit
                     _______________________________________
                    """);

            try {
                action = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\n");

            switch (action) {
                case "1" -> createAuto(bufferedReader);
                case "2" -> updateAuto(bufferedReader);
                case "3" -> fetchById(bufferedReader);
                case "4" -> fetchByName(bufferedReader);
                case "5" -> fetchByPriceRange(bufferedReader);
                case "6" -> fetchAll();
                case "7" -> deleteAuto(bufferedReader);
                case "8" -> deleteAllAutos();
                case "0" -> System.out.println("Thank you, bye");
                default -> System.out.println("Something wrong, please try again");

            }
        }
    }

    void createAuto(BufferedReader bufferedReader) {

        currentCar = new Car();
        System.out.println("Create auto:\n");
        try {
            System.out.println("Please, enter the title of auto:");
            currentCar.setTitle(bufferedReader.readLine());
            System.out.println("Please, enter the price of auto");
            String stringPrise = bufferedReader.readLine();
            if (!stringPrise.equals("")) {
                currentCar.setPrice(Double.parseDouble(stringPrise));
            }
            System.out.println("Please, enter dates in format 'yyyy-MM-dd'\nDate of manufacture:");
            String dateOfManufacture = bufferedReader.readLine();
            if (!dateOfManufacture.equals("")) {
                currentCar.setManufactureDate(LocalDate.parse(dateOfManufacture));
            }
            System.out.println("Date of sell:");
            String dateOfSell = bufferedReader.readLine();
            if (!dateOfSell.equals("")) {
                currentCar.setSellDate(LocalDate.parse(dateOfSell));
            }
            System.out.println("Please, enter the gear type of auto:");
            currentCar.setGearType(bufferedReader.readLine());
            System.out.println("Please, enter the fuel volume of auto:");
            String stringFuelVolume = bufferedReader.readLine();
            if (!stringFuelVolume.equals("")) {
                currentCar.setFuelVolume(Double.parseDouble(stringFuelVolume));
            }
            service.createAuto(currentCar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateAuto(BufferedReader bufferedReader) {

        currentCar = new Car();
        int carId;
        try {
            System.out.println("Please, enter the id of auto, which you want to change");
            carId = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Please, enter parameters of auto, which you want to change");
            System.out.println("(if you don't need to change the parameter, just press enter)");
            System.out.println("\nThe title of auto:");
            currentCar.setTitle(bufferedReader.readLine());
            System.out.println("The price of auto");
            String stringPrise = bufferedReader.readLine();
            if (!stringPrise.equals("")) {
                currentCar.setPrice(Double.parseDouble(stringPrise));
            }
            System.out.println("Dates in format 'yyyy-MM-dd'\nDate of manufacture:");
            String dateOfManufacture = bufferedReader.readLine();
            if (!dateOfManufacture.equals("")) {
                currentCar.setManufactureDate(LocalDate.parse(dateOfManufacture));
            }
            System.out.println("Date of sell:");
            String dateOfSell = bufferedReader.readLine();
            if (!dateOfSell.equals("")) {
                currentCar.setSellDate(LocalDate.parse(dateOfSell));
            }
            System.out.println("The gear type of auto:");
            currentCar.setGearType(bufferedReader.readLine());
            System.out.println("The fuel volume of auto:");
            String stringFuelVolume = bufferedReader.readLine();
            if (!stringFuelVolume.equals("")) {
                currentCar.setFuelVolume(Double.parseDouble(stringFuelVolume));
            }
            service.updateAuto(carId, currentCar);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void fetchById(BufferedReader bufferedReader) {

        currentCar = new Car();
        System.out.println("Please, enter the id of auto, which you want to receive");
        try {
            int carId = Integer.parseInt(bufferedReader.readLine());
            currentCar = service.fetchById(carId, currentCar);
            System.out.println("The auto with id = " + carId + " :\n" + currentCar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fetchByName(BufferedReader bufferedReader) {

        System.out.println("Please, enter the title of the cars you want to receive:");
        try {
            String carTitle = bufferedReader.readLine();
            List carsByName = service.fetchByName(carTitle);
            if (carsByName.isEmpty()) {
                System.out.println("The auto '" + carTitle + "' is absent");
            } else {
                carsByName.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fetchByPriceRange(BufferedReader bufferedReader) {

        try {
            System.out.println("Please, enter the minimum automobile price:");
            double minPrice = Double.parseDouble(bufferedReader.readLine());
            System.out.println("Please, enter the maximum automobile price:");
            double maxPrice = Double.parseDouble(bufferedReader.readLine());
            List carsByRange = service.fetchByPriceRange(minPrice, maxPrice);
            if (carsByRange.isEmpty()) {
                System.out.println("The auto in the price range from " + minPrice + " to " + maxPrice + " is absent");
            } else {
                carsByRange.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fetchAll() {

        List<Car> allCars = service.fetchAll();
        if (allCars.isEmpty()) {
            System.out.println("The database is empty");
        } else {
            allCars.forEach(System.out::println);
        }
    }

    public void deleteAuto(BufferedReader bufferedReader) {

        System.out.println("Please, enter the id of auto, which you want to delete");
        try {
            int carId = Integer.parseInt(bufferedReader.readLine());
            service.deleteAuto(carId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllAutos() {

        service.deleteAllAutos();
    }
}

