package builders;

import models.Gadget;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.TypeOfScreen;

public abstract class GadgetBuilder {

    public abstract GadgetBuilder setTitle(String title);

    public abstract GadgetBuilder setManufacturer(String manufacturerName);

    public abstract GadgetBuilder setModel(String modelName);

    public abstract GadgetBuilder setPrice(double price);

    public GadgetBuilder setScreen(TypeOfScreen typeOfScreen, double sizeOfScreen) {

        return this;
    }

    public GadgetBuilder setFormFactor(FormFactor formFactor) {

        return this;
    }
    public abstract Gadget getGadget();
}

