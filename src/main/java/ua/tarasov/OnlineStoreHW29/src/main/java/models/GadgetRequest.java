package models;

import lombok.Getter;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfGadget;
import models.parametersOfGadget.TypeOfScreen;
import org.jetbrains.annotations.NotNull;

@Getter
public class GadgetRequest {

    private TypeOfGadget typeOfGadget;
    private String title;
    private String manufacturerName;
    private String modelName;
    private Screen screen;
    private FormFactor formFactor;
    private double price;

    public GadgetRequest(TypeOfGadget typeOfGadget, String title, String manufacturerName, String modelName,
                         Screen screen, FormFactor formFactor, double price) {

        this.typeOfGadget = typeOfGadget;
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.screen = screen;
        this.formFactor = formFactor;
        this.price = price;
    }

    public void setTypeOfGadget(@NotNull String typeOfGadget) {

        if (typeOfGadget.equalsIgnoreCase("computer")) {
            this.typeOfGadget = TypeOfGadget.COMPUTER;
        } else if (typeOfGadget.equalsIgnoreCase("phone")) {
            this.typeOfGadget = TypeOfGadget.PHONE;
        } else if (typeOfGadget.equalsIgnoreCase("tv")) {
            this.typeOfGadget = TypeOfGadget.TV;
        } else throw new RuntimeException(typeOfGadget + " is unknown type of gadget");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public GadgetRequest setScreen(@NotNull String typeOfScreen, double sizeOfScreen) {

        TypeOfScreen type;
        if (typeOfScreen.equalsIgnoreCase("tft")) {
            type = TypeOfScreen.TFT;
        } else if (typeOfScreen.equalsIgnoreCase("ips")) {
            type = TypeOfScreen.IPS;
        } else throw new RuntimeException(typeOfScreen + " is unknown type of screen");
        this.screen = new Screen(type, sizeOfScreen);
        return this;
    }

    public void setFormFactor(@NotNull String formFactor) {

        if (formFactor.equalsIgnoreCase("desktop")) {
            this.formFactor = FormFactor.DESKTOP;
        } else if (formFactor.equalsIgnoreCase("laptop")) {
            this.formFactor = FormFactor.LAPTOP;
        } else if (formFactor.equalsIgnoreCase("smartphone")) {
            this.formFactor = FormFactor.SMARTPHONE;
        } else throw new RuntimeException(typeOfGadget + " is unknown factor of form");
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "\n(" +
                "type of gadget = " + typeOfGadget + ", " +
                "\ntitle = " + title + ", " +
                "\nmanufacturer = " + manufacturerName + ", " +
                "\nmodel = " + modelName + ", " +
                "\nprice = " + price + ", " +
                "\nscreen = " + screen + ", " +
                "\nform factor = " + formFactor + ")";
    }
}
