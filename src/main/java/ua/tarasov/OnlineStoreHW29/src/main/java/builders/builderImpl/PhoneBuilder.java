package builders.builderImpl;

import builders.GadgetBuilder;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfScreen;
import models.implModels.Phone;

public class PhoneBuilder extends GadgetBuilder {

    private String title;
    private String manufacturerName;
    private String modelName;
    private Screen screen;
    private FormFactor formFactor;
    private double price;

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
    public Phone getGadget() {

        return new Phone(title, manufacturerName, modelName, price, screen, formFactor);
    }
}
