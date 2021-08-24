package builders;

import builders.builderImpl.ComputerBuilder;
import builders.builderImpl.PhoneBuilder;
import builders.builderImpl.TVBuilder;
import models.GadgetRequest;
import models.parametersOfGadget.TypeOfGadget;

public final class BuildOfGadgetDirector {

    private GadgetBuilder builder;

    public void setBuilder(GadgetRequest request) {

        TypeOfGadget typeOfGadget = request.getTypeOfGadget();

        switch (typeOfGadget){

            case COMPUTER -> this.builder = new ComputerBuilder(request);
            case PHONE -> this.builder = new PhoneBuilder();
            case TV -> this.builder = new TVBuilder();
            default -> throw new RuntimeException(typeOfGadget + " is unknown type of gadget");
        }
    }

    public GadgetBuilder getBuilder() {
        return builder;
    }
}
