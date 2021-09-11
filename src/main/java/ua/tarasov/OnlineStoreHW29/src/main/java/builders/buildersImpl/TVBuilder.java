package builders.buildersImpl;

import builders.GadgetBuilder;
import models.implModels.TV;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfScreen;

public class TVBuilder extends GadgetBuilder {

    private final TV tv;

    public TVBuilder() {

        this.tv = new TV();
    }

    @Override
    public GadgetBuilder setTitle(String title) {
        tv.setTitle(title);
        return this;
    }

    @Override
    public GadgetBuilder setManufacturer(String manufacturerName) {
        tv.setManufacturerName(manufacturerName);
        return this;
    }

    @Override
    public GadgetBuilder setModel(String modelName) {
        tv.setModelName(modelName);
        return this;
    }

    @Override
    public GadgetBuilder setPrice(double price) {
        tv.setPrice(price);
        return this;
    }

    @Override
    public GadgetBuilder setScreen(TypeOfScreen typeOfScreen, double sizeOfScreen) {
        tv.setScreen(new Screen(typeOfScreen, sizeOfScreen));
        return this;
    }

    @Override
    public TV getGadget() {
        return tv;
    }
}
