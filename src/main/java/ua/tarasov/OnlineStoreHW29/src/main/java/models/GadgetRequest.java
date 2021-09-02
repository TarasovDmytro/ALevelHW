package models;

import lombok.Getter;
import models.parametersOfGadget.FormFactor;
import models.parametersOfGadget.Screen;
import models.parametersOfGadget.TypeOfGadget;
import models.parametersOfGadget.TypeOfScreen;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Getter
public final class GadgetRequest {

    private final TypeOfGadget typeOfGadget;
    private final String title;
    private final String manufacturerName;
    private final String modelName;
    private final Screen screen;
    private final FormFactor formFactor;
    private final double price;

    private GadgetRequest(TypeOfGadget typeOfGadget, String title, String manufacturerName, String modelName,
                          Screen screen, FormFactor formFactor, double price) {

        this.typeOfGadget = typeOfGadget;
        this.title = title;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.screen = screen;
        this.formFactor = formFactor;
        this.price = price;
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull RequestBuilder getBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder {

        private TypeOfGadget typeOfGadget;
        private String title;
        private String manufacturerName;
        private String modelName;
        private Screen screen;
        private FormFactor formFactor;
        private double price;

        public RequestBuilder() {
        }

        public RequestBuilder setTypeOfGadget(TypeOfGadget typeOfGadget) {
            this.typeOfGadget = typeOfGadget;
            return this;
        }

        public RequestBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public RequestBuilder setManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
            return this;
        }

        public RequestBuilder setModel(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public RequestBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public RequestBuilder setScreen(TypeOfScreen typeOfScreen, double sizeOfScreen) {
            this.screen = new Screen(typeOfScreen, sizeOfScreen);
            return this;
        }

        public RequestBuilder setFormFactor(FormFactor formFactor) {
            this.formFactor = formFactor;
            return this;
        }

        @Contract(value = " -> new", pure = true)
        public @NotNull GadgetRequest getRequest() {
            return new GadgetRequest(typeOfGadget, title, manufacturerName, modelName, screen, formFactor, price);
        }
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "\n(" +
                "type of gadget = " + typeOfGadget + ", " +
                "\ntitle = " + title + ", " +
                "\nmanufacturer = " + manufacturerName + ", " +
                "\nmodel = " + modelName + ", " +
                "\nprice = " + price + ", " +
                "\nscreen = " + screen + ", " +
                "\nform factor = " + formFactor + ")";
    }
}
