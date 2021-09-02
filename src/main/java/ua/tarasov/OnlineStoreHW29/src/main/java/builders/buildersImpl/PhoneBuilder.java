package builders.buildersImpl;

import builders.GadgetBuilder;
import models.implModels.Phone;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfScreen;

public class PhoneBuilder extends GadgetBuilder {

    private final Phone phone;

    public PhoneBuilder() {

        this.phone = new Phone();
    }

    @Override
    public GadgetBuilder setTitle(String title) {
        phone.setTitle(title);
        return this;
    }

    @Override
    public GadgetBuilder setManufacturer(String manufacturerName) {
        phone.setManufacturerName(manufacturerName);
        return this;
    }

    @Override
    public GadgetBuilder setModel(String modelName) {
        phone.setModelName(modelName);
        return this;
    }

    @Override
    public GadgetBuilder setPrice(double price) {
        phone.setPrice(price);
        return this;
    }

    @Override
    public GadgetBuilder setScreen(TypeOfScreen typeOfScreen, double sizeOfScreen) {
        phone.setScreen(new Screen(typeOfScreen, sizeOfScreen));
        return this;
    }

    @Override
    public GadgetBuilder setFormFactor(FormFactor formFactor) {
        phone.setFormFactor(formFactor);
        return this;
    }

    @Override
    public Phone getGadget() {
        return phone;
    }
}
