package builders.builderImpl;

import builders.GadgetBuilder;
import models.parametersOfGadget.FormFactor;
import models.GadgetRequest;
import models.parametersOfGadget.Screen;
import models.implModels.Computer;
import models.parametersOfGadget.TypeOfScreen;

public class ComputerBuilder extends GadgetBuilder {

    private String title;
    private String manufacturerName;
    private String modelName;
    private Screen screen;
    private FormFactor formFactor;
    private double price;

    public ComputerBuilder(GadgetRequest request) {

        this.title = request.getTitle();
        this.manufacturerName = request.getManufacturerName();
        this.modelName = request.getModelName();
        this.screen = request.getScreen();
        this.formFactor = request.getFormFactor();
        this.price = request.getPrice();
    }

    @Override
    public GadgetBuilder setTitle(String title) {

        this.title = title;
        return this;
    }

    @Override
    public GadgetBuilder setManufacturer(String manufacturerName) {

        this.manufacturerName = manufacturerName;
        return this;
    }

    @Override
    public GadgetBuilder setModel(String modelName) {

        this.modelName = modelName;
        return this;
    }

    @Override
    public GadgetBuilder setPrice(double price) {

        this.price = price;
        return this;
    }

    @Override
    public GadgetBuilder setScreen(String typeOfScreen, double sizeOfScreen) {

        TypeOfScreen type;
        if (typeOfScreen.equalsIgnoreCase("tft")) {
            type = TypeOfScreen.TFT;
        } else if (typeOfScreen.equalsIgnoreCase("ips")) {
            type = TypeOfScreen.IPS;
        } else throw new RuntimeException(typeOfScreen + " is unknown type of screen");
        this.screen = new Screen(type, sizeOfScreen);
        return this;
    }

    @Override
    public GadgetBuilder setFormFactor(FormFactor formFactor) {

        this.formFactor = formFactor;
        return this;
    }

    @Override
    public Computer getGadget() {

        return new Computer(title, manufacturerName, modelName, price, screen, formFactor);
    }
}
