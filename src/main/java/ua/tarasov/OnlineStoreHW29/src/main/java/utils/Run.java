package utils;

import builders.GadgetRequestBuilder;
import models.Gadget;
import models.GadgetRequest;
import models.parametersOfGadget.FormFactor;
import services.GadgetService;

public class Run {

    private final GadgetRequestBuilder requestBuilder = new GadgetRequestBuilder();
    private final GadgetService service = new GadgetService();

    public void run() throws CloneNotSupportedException {

        GadgetRequest request = requestBuilder
                .setTypeOfGadget("computer")
                .setTitle("EliteBook")
                .setManufacturer("HP")
                .setModel("8560w")
                .setFormFactor("laptop")
                .setScreen("ips", 15 )
                .setPrice(12000)
                .getGadget();
        System.out.println(request);

        Gadget computer = service.getGadgetByRequest(request);
        System.out.println(computer);

        request = requestBuilder.setTypeOfGadget("phone").getGadget();
        System.out.println(request);

        Gadget phone = service.getGadgetByRequestNoParameters(request, "IPhone", "Apple", "12",
                        25000, FormFactor.SMARTPHONE, "ips", 5.5);
        System.out.println(phone);

        request = requestBuilder
                .setTypeOfGadget("tv")
                .setTitle("TV")
                .setManufacturer("Samsung")
                .setModel("123654")
                .setScreen("tft", 55)
                .setPrice(20000)
                .getGadget();
        System.out.println(request);

        Gadget tv = service.getGadgetByRequest(request);
        System.out.println(tv);

        Gadget cloneTV = tv.clone();
        System.out.println("\nCloned tv:" + cloneTV);

        System.out.println("\nequivalence check = " + tv.equals(cloneTV));
    }
}
