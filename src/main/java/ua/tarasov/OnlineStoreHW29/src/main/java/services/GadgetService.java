package services;

import builders.BuildOfGadgetDirector;
import factories.GadgetFactoryDirector;
import models.Gadget;
import models.GadgetRequest;
import models.parametersOfGadget.FormFactor;

public class GadgetService {

    private final BuildOfGadgetDirector director = new BuildOfGadgetDirector();
    private final GadgetFactoryDirector factoryDirector = new GadgetFactoryDirector();

    public Gadget getGadgetByRequest(GadgetRequest request){

        factoryDirector.setGadgetFactory(request);
        return factoryDirector.getGadgetFactory().createGadget();
    }

    public Gadget getGadgetByRequestNoParameters(GadgetRequest request, String title, String manufacturerName,
                                                  String model, double price, FormFactor formFactor, String typeOfScreen,
                                                  double sizeOfScreen){

        director.setBuilder(request);
        return director.getBuilder()
                .setTitle(title)
                .setManufacturer(manufacturerName)
                .setModel(model)
                .setPrice(price)
                .setFormFactor(formFactor)
                .setScreen(typeOfScreen, sizeOfScreen)
                .getGadget();
    }
}
