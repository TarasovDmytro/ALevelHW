package models.implModels;

import lombok.Getter;
import models.Gadget;
import models.GadgetRequest;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;

import java.util.Objects;
import java.util.UUID;

@Getter
public final class Phone extends Gadget {

    private final UUID id;
    private final String title;
    private final String manufacturerName;
    private final String modelName;
    private final double price;
    private final Screen screen;
    private final FormFactor formFactor;

    public Phone(String title, String manufacturerName, String modelName, double price, Screen screen,
                 FormFactor formFactor) {

        this.id = UUID.randomUUID();
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.price = price;
        this.screen = screen;
        this.formFactor = formFactor;
    }

    public Phone(UUID id, String title, String manufacturerName, String modelName, double price,
                 Screen screen, FormFactor formFactor) {
        this.id = id;
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.price = price;
        this.screen = screen;
        this.formFactor = formFactor;
    }

    public Phone(GadgetRequest request) {

        this.id = UUID.randomUUID();
        this.title = request.getTitle();
        this.manufacturerName = request.getManufacturerName();
        this.modelName = request.getModelName();
        this.price = request.getPrice();
        this.screen = request.getScreen();
        this.formFactor = request.getFormFactor();
    }

    @Override
    public Phone clone() {

        return new Phone(this.id,
                         this.title,
                         this.manufacturerName,
                         this.modelName,
                         this.price,
                         new Screen(this.screen.getTypeOfScreen(), this.screen.getSizeOfScreen()),
                         this.formFactor);
    }


    @Override
    public String toString() {
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
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Double.compare(phone.getPrice(), getPrice()) == 0 && getId().equals(phone.getId())
                && Objects.equals(getTitle(), phone.getTitle()) && Objects.equals(getManufacturerName(),
                phone.getManufacturerName()) && Objects.equals(getModelName(), phone.getModelName())
                && Objects.equals(getScreen(), phone.getScreen()) && getFormFactor() == phone.getFormFactor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getManufacturerName(), getModelName(), getPrice(), getScreen(), getFormFactor());
    }
}
