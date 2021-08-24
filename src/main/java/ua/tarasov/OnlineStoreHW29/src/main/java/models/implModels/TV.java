package models.implModels;

import lombok.Getter;
import models.Gadget;
import models.GadgetRequest;
import models.parametersOfGadget.Screen;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

@Getter
public final class TV extends Gadget {

    private final UUID id;
    private final String title;
    private final String manufacturerName;
    private final String modelName;
    private final double price;
    private final Screen screen;

    public TV(String title, String manufacturerName, String modelName, double price, Screen screen) {

        this.id = UUID.randomUUID();
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.price = price;
        this.screen = screen;
    }

    public TV(UUID id, String title, String manufacturerName, String modelName, double price, Screen screen) {

        this.id = id;
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.price = price;
        this.screen = screen;
    }

    public TV(@NotNull GadgetRequest request) {

        this.id = UUID.randomUUID();
        this.title = request.getTitle();
        this.manufacturerName = request.getManufacturerName();
        this.modelName = request.getModelName();
        this.price = request.getPrice();
        this.screen = request.getScreen();
    }

    @Override
    public @NotNull String toString() {
        return "\n" + getClass().getSimpleName() + "\n(" +
                "id = " + id + ", " +
                "\ntitle = " + title + ", " +
                "\nmanufacturer = " + manufacturerName + ", " +
                "\nmodel = " + modelName + ", " +
                "\nprice = " + price + ", " +
                "\nscreen = " + screen + ")";
    }

    @Contract(" -> new")
    @Override
    public @NotNull TV clone(){

        return new TV(this.id,
                      this.title,
                      this.manufacturerName,
                      this.modelName,
                      this.price,
                      new Screen(this.screen.getTypeOfScreen(), this.screen.getSizeOfScreen()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TV)) return false;
        TV tv = (TV) o;
        return Double.compare(tv.getPrice(), getPrice()) == 0 && getId().equals(tv.getId()) && Objects.equals(getTitle(),
                tv.getTitle()) && Objects.equals(getManufacturerName(), tv.getManufacturerName())
                && Objects.equals(getModelName(), tv.getModelName()) && Objects.equals(getScreen(), tv.getScreen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getManufacturerName(), getModelName(), getPrice(), getScreen());
    }
}
