package factories.factoryImpl;

import factories.GadgetFactory;
import models.Gadget;
import models.GadgetRequest;
import models.implModels.Computer;

public class ComputerFactory implements GadgetFactory {

    GadgetRequest request;

    public ComputerFactory(GadgetRequest request) {

        this.request = request;
    }

    @Override
    public Gadget createGadget() {

        return new Computer(request);
    }
}
