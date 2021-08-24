package models;

import lombok.Getter;
import lombok.Setter;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;

@Getter
@Setter
public abstract class Gadget{

    private String title;
    private String manufacturerName;
    private String modelName;
    private double price;
    private Screen screen;
    private FormFactor formFactor;

    public abstract Gadget clone() throws CloneNotSupportedException;
}
