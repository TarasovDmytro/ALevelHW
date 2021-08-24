package builders;

import models.parametersOfGadget.FormFactor;
import models.GadgetRequest;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfGadget;
import models.parametersOfGadget.TypeOfScreen;

public class GadgetRequestBuilder {

    private TypeOfGadget typeOfGadget;
    private String title;
    private String manufacturerName;
    private String modelName;
    private Screen screen;
    private FormFactor formFactor;
    private double price;

    public GadgetRequestBuilder setTypeOfGadget(String typeOfGadget) {

        if (typeOfGadget.equalsIgnoreCase("computer")) {
            this.typeOfGadget = TypeOfGadget.COMPUTER;
        } else if (typeOfGadget.equalsIgnoreCase("phone")) {
            this.typeOfGadget = TypeOfGadget.PHONE;
        } else if (typeOfGadget.equalsIgnoreCase("tv")) {
            this.typeOfGadget = TypeOfGadget.TV;
        } else throw new RuntimeException(typeOfGadget + " is unknown type of gadget");
        return this;
    }

    public GadgetRequestBuilder setTitle(String title) {

        this.title = title;
        return this;
    }

    public GadgetRequestBuilder setManufacturer(String manufacturerName) {

        this.manufacturerName = manufacturerName;
        return this;
    }

    public GadgetRequestBuilder setModel(String modelName) {

        this.modelName = modelName;
        return this;
    }

    public GadgetRequestBuilder setPrice(double price) {

        this.price = price;
        return this;
    }

    public GadgetRequestBuilder setScreen(String typeOfScreen, double sizeOfScreen) {

        TypeOfScreen type;
        if (typeOfScreen.equalsIgnoreCase("tft")) {
            type = TypeOfScreen.TFT;
        } else if (typeOfScreen.equalsIgnoreCase("ips")) {
            type = TypeOfScreen.IPS;
        } else throw new RuntimeException(typeOfScreen + " is unknown type of screen");
        this.screen = new Screen(type, sizeOfScreen);
        return this;
    }

    public GadgetRequestBuilder setFormFactor(String formFactor) {

        if (formFactor.equalsIgnoreCase("desktop")) {
            this.formFactor = FormFactor.DESKTOP;
        } else if (formFactor.equalsIgnoreCase("laptop")) {
            this.formFactor = FormFactor.LAPTOP;
        } else if (formFactor.equalsIgnoreCase("smartphone")) {
            this.formFactor = FormFactor.SMARTPHONE;
        } else throw new RuntimeException(typeOfGadget + " is unknown factor of form");
        return this;
    }

    public GadgetRequest getGadget() {

        return new GadgetRequest(typeOfGadget, title, manufacturerName, modelName, screen, formFactor, price);
    }
}
