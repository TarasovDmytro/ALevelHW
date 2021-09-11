package factories.factoryImpl;

import builders.BuildOfGadgetDirector;
import factories.GadgetFactory;
import lombok.Setter;
import lombok.ToString;
import models.Gadget;
import models.GadgetRequest;

@Setter
@ToString
public class GadgetFactoryByRequest implements GadgetFactory {

    private GadgetRequest request;
    private final BuildOfGadgetDirector director = new BuildOfGadgetDirector();

    public GadgetFactoryByRequest() {
    }

    @Override
    public Gadget createGadget() {

        return director.getBuilder(request)
                .setTitle(request.getTitle())
                .setManufacturer(request.getManufacturerName())
                .setModel(request.getModelName())
                .setPrice(request.getPrice())
                .setScreen(request.getScreen().getTypeOfScreen(), request.getScreen().getSizeOfScreen())
                .setFormFactor(request.getFormFactor())
                .getGadget();
    }
}

