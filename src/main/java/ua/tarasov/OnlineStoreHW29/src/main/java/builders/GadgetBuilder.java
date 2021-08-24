package builders;

import models.Gadget;
import models.parametersOfGadget.FormFactor;

public abstract class GadgetBuilder {

    Gadget gadget;

    public abstract GadgetBuilder setTitle(String title);

    public abstract GadgetBuilder setManufacturer(String manufacturerName);

    public abstract GadgetBuilder setModel(String modelName);

    public abstract GadgetBuilder setPrice(double price);

    public GadgetBuilder setScreen(String typeOfScreen, double sizeOfScreen) {

        return this;
    }

    public GadgetBuilder setFormFactor(FormFactor formFactor) {

        return this;
    }

    public Gadget getGadget() {

        return gadget;
    }
}

