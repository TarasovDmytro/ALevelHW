package models.implModels;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import models.Gadget;
import models.parametersOfGadget.Screen;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TV extends Gadget implements Cloneable {

    private Screen screen;

    public TV() {
        super();
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "\n(" +
                "title = " + getTitle() + ", " +
                "\nmanufacturer = " + getManufacturerName() + ", " +
                "\nmodel = " + getModelName() + ", " +
                "\nprice = " + getPrice() + ", " +
                "\nscreen = " + screen + ")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TV clonedGadget = (TV) super.clone();
        clonedGadget.setScreen(new Screen(clonedGadget.getScreen().getTypeOfScreen(),
                clonedGadget.getScreen().getSizeOfScreen()));
        return clonedGadget;
    }
}

