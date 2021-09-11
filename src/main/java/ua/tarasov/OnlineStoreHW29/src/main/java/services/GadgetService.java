package services;

import factories.factoryImpl.GadgetFactoryByRequest;
import models.Gadget;
import models.GadgetRequest;

public class GadgetService {

    private final GadgetFactoryByRequest gadgetFactory = new GadgetFactoryByRequest();

    public Gadget createGadgetByRequest(GadgetRequest request) {
        gadgetFactory.setRequest(request);
        Gadget gadget = gadgetFactory.createGadget();
        System.out.println("\n" + gadget);
        return gadget;
    }
}
