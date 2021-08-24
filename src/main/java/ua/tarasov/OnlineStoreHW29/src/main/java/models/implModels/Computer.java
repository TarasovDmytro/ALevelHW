package models.implModels;

import lombok.Getter;
import models.Gadget;
import models.GadgetRequest;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

@Getter
public final class Computer extends Gadget {

    private final UUID id;

    private final String title;

    private final String manufacturerName;

    private final String modelName;

    private final double price;

    private final Screen screen;

    private final FormFactor formFactor;

    public Computer(String title, String manufacturerName, String modelName, double price, Screen screen,
                    FormFactor formFactor) {

        this.id = UUID.randomUUID();
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.price = price;
        this.screen = screen;
        this.formFactor = formFactor;
    }

    public Computer(UUID id, String title, String manufacturerName, String modelName, double price, Screen screen, FormFactor formFactor) {
        this.id = id;
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.price = price;
        this.screen = screen;
        this.formFactor = formFactor;
    }

    public Computer(@NotNull GadgetRequest request) {

        this.id = UUID.randomUUID();
        this.title = request.getTitle();
        this.manufacturerName = request.getManufacturerName();
        this.modelName = request.getModelName();
        this.price = request.getPrice();
        this.screen = request.getScreen();
        this.formFactor = request.getFormFactor();
    }

    @Contract(" -> new")
    @Override
    public @NotNull Computer clone() {

        return new Computer(this.id,
                            this.title,
                            this.manufacturerName,
                            this.modelName,
                            this.price,
                            new Screen(this.screen.getTypeOfScreen(), this.screen.getSizeOfScreen()),
                            this.formFactor);
    }

    @Override
    public @NotNull String toString() {
        return "\n" + getClass().getSimpleName() + "\n(" +
                "id = " + id + ", " +
                "\ntitle = " + title + ", " +
                "\nmanufacturer = " + manufacturerName + ", " +
                "\nmodel = " + modelName + ", " +
                "\nprice = " + price + ", " +
                "\nscreen = " + screen + ", " +
                "\nform factor = " + formFactor + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.getPrice(), getPrice()) == 0 && getId().equals(computer.getId())
                && Objects.equals(getTitle(), computer.getTitle()) && Objects.equals(getManufacturerName(),
                computer.getManufacturerName()) && Objects.equals(getModelName(), computer.getModelName())
                && Objects.equals(getScreen(), computer.getScreen()) && getFormFactor() == computer.getFormFactor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getManufacturerName(), getModelName(), getPrice(), getScreen(), getFormFactor());
    }
}

