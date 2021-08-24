package factories;

import factories.factoryImpl.ComputerFactory;
import factories.factoryImpl.PhoneFactory;
import factories.factoryImpl.TVFactory;
import models.GadgetRequest;
import models.parametersOfGadget.TypeOfGadget;

public class GadgetFactoryDirector {

    private GadgetFactory factory;

    public void setGadgetFactory(GadgetRequest request){

        TypeOfGadget typeOfGadget = request.getTypeOfGadget();

        switch (typeOfGadget){

            case COMPUTER -> this.factory = new ComputerFactory(request);
            case PHONE -> this.factory = new PhoneFactory(request);
            case TV -> this.factory = new TVFactory(request);
            default -> throw new RuntimeException(typeOfGadget + " is nonknown type of gadget");
        }
    }

    public GadgetFactory getGadgetFactory() {

        return factory;
    }
}
