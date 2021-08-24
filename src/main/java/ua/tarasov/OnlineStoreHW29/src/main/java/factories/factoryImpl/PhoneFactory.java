package factories.factoryImpl;

import factories.GadgetFactory;
import models.Gadget;
import models.GadgetRequest;
import models.implModels.Phone;

public class PhoneFactory implements GadgetFactory {

    GadgetRequest request;

    public PhoneFactory(GadgetRequest request) {

        this.request = request;
    }

    @Override
    public Gadget createGadget() {

        return new Phone(request);
    }
}
