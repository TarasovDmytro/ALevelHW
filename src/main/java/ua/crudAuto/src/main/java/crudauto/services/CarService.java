package crudauto.services;

import crudauto.dao.DaoCar;
import crudauto.entitys.Car;

import java.util.List;

public class CarService {

    DaoCar actionCar = new DaoCar();

    public void createAuto(Car car) {

        if (actionCar.createAuto(car)) {
            System.out.println("The automobile:\n" + car + "\nwas created");
        } else {
            System.out.println("Something wrong. Please, try again.");
        }
    }

    public void updateAuto(int carId, Car currentCar) {

        if (actionCar.updateAuto(carId, currentCar)) {

            System.out.println("Automobile with id = " + carId + " updated");
        } else {
            System.out.println("Something wrong. Please, try again.");
        }
    }

    public Car fetchById(int id, Car currentCar) {

        return actionCar.fetchById(id, currentCar);
    }

    public List fetchByName(String carTitle) {

        return actionCar.fetchByName(carTitle);
    }

    public List fetchByPriceRange(double priceMin, double priceMax) {

        return actionCar.fetchByPriceRange(priceMin, priceMax);
    }

    public List<Car> fetchAll() {

        return actionCar.fetchAll();
    }

    public void deleteAuto(int id) {

        if (actionCar.deleteAuto(id)) {
            System.out.println("Auto with id = " + id + " was deleted");
        } else {
            System.out.println("Something wrong. Please, try again.");
        }
    }

    public void deleteAllAutos() {

        if (actionCar.deleteAllAutos()) {
            System.out.println("All autos was deleted");
        } else {
            System.out.println("Something wrong. Please, try again.");
        }
    }
}
