package builders;

import builders.buildersImpl.ComputerBuilder;
import builders.buildersImpl.PhoneBuilder;
import builders.buildersImpl.TVBuilder;
import models.GadgetRequest;
import models.parametersOfGadget.TypeOfGadget;

public final class BuildOfGadgetDirector {

    public GadgetBuilder getBuilder(GadgetRequest request) {
        TypeOfGadget typeOfGadget = request.getTypeOfGadget();
        GadgetBuilder builder;

        switch (typeOfGadget){

            case COMPUTER -> builder = new ComputerBuilder();
            case PHONE -> builder = new PhoneBuilder();
            case TV -> builder = new TVBuilder();
            default ->
                    throw new RuntimeException(typeOfGadget + " is unknown type of gadget");
        }
        return builder;
    }
}
