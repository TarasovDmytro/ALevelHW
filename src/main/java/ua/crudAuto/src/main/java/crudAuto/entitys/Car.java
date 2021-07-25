package crudAuto.entitys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "sell_date")
    private LocalDate sellDate;

    @Column(name = "gear_type")
    private String gearType;

    @Column(name = "fuel_volume")
    private double fuelVolume;

    public Car(String title, double price, LocalDate manufactureDate, LocalDate sellDate, String gearType, double fuelVolume) {

        this.title = title;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.sellDate = sellDate;
        this.gearType = gearType;
        this.fuelVolume = fuelVolume;
    }

    public Car() {
    }
}
