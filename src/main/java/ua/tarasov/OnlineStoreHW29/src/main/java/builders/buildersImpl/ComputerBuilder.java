package builders.buildersImpl;

import builders.GadgetBuilder;
import models.implModels.Computer;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfScreen;

public class ComputerBuilder extends GadgetBuilder {

    private final Computer computer;

    public ComputerBuilder() {

        this.computer = new Computer();
    }

    @Override
    public GadgetBuilder setTitle(String title) {
        computer.setTitle(title);
        return this;
    }

    @Override
    public GadgetBuilder setManufacturer(String manufacturerName) {
        computer.setManufacturerName(manufacturerName);
        return this;
    }

    @Override
    public GadgetBuilder setModel(String modelName) {
        computer.setModelName(modelName);
        return this;
    }

    @Override
    public GadgetBuilder setPrice(double price) {
        computer.setPrice(price);
        return this;
    }

    @Override
    public GadgetBuilder setScreen(TypeOfScreen typeOfScreen, double sizeOfScreen) {
        computer.setScreen(new Screen(typeOfScreen, sizeOfScreen));
        return this;
    }

    @Override
    public GadgetBuilder setFormFactor(FormFactor formFactor) {
        computer.setFormFactor(formFactor);
        return this;
    }

    @Override
    public Computer getGadget() {
        return computer;
    }
}

