package models.implModels;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import models.Gadget;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Phone extends Gadget {

    private Screen screen;
    private FormFactor formFactor;

    public Phone() {
        super();
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "\n(" +
                "title = " + getTitle() + ", " +
                "\nmanufacturer = " + getManufacturerName() + ", " +
                "\nmodel = " + getModelName() + ", " +
                "\nprice = " + getPrice() + ", " +
                "\nscreen = " + screen + ", " +
                "\nform factor = " + formFactor + ")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Phone clonedGadget = (Phone) super.clone();
        clonedGadget.setScreen(new Screen(clonedGadget.getScreen().getTypeOfScreen(),
                clonedGadget.getScreen().getSizeOfScreen()));
        return clonedGadget;
    }
}
