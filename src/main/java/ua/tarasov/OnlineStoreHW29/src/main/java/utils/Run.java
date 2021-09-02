package utils;

import models.Gadget;
import models.GadgetRequest;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.TypeOfGadget;
import models.parametersOfGadget.TypeOfScreen;
import services.GadgetService;

public class Run {

    private final GadgetService service = new GadgetService();

    public void run() throws CloneNotSupportedException {

        GadgetRequest request = createRequest(TypeOfGadget.TV);
        Gadget gadget = service.createGadgetByRequest(request);
        Gadget clonedGadget = (Gadget) gadget.clone();
        System.out.println(clonedGadget);
    }

    public static GadgetRequest createRequest (TypeOfGadget typeOfGadget){

        GadgetRequest request = GadgetRequest.getBuilder()
                .setTypeOfGadget(typeOfGadget)
                .setTitle(typeOfGadget.toString())
                .setManufacturer(typeOfGadget + " producer")
                .setModel("My " + typeOfGadget)
                .setFormFactor(FormFactor.LAPTOP)
                .setScreen(TypeOfScreen.IPS, 15 )
                .setPrice(12000)
                .getRequest();
        System.out.println(request);

        return request;
    }
}
