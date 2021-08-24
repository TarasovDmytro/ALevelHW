package factories.factoryImpl;

import factories.GadgetFactory;
import models.Gadget;
import models.GadgetRequest;
import models.implModels.TV;

public class TVFactory implements GadgetFactory {

    private final GadgetRequest request;

    public TVFactory(GadgetRequest request) {

        this.request = request;
    }

    @Override
    public Gadget createGadget() {

        return new TV(request);
    }
}
