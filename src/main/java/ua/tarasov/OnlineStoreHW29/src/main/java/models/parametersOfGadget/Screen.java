package models.parametersOfGadget;

import lombok.Getter;

@Getter
public final class Screen {

    private final TypeOfScreen typeOfScreen;
    private final double sizeOfScreen;

    public Screen(TypeOfScreen typeOfScreen, double sizeOfScreen) {
        this.typeOfScreen = typeOfScreen;
        this.sizeOfScreen = sizeOfScreen;
        validationOfSize(sizeOfScreen);
    }

    private void validationOfSize(double sizeOfScreen) {
        if (sizeOfScreen <= 0)
            throw new IllegalArgumentException("Size of screen can't be less then 0");
    }

    @Override
    public String toString() {
        return "Screen{" +
                "typeOfScreen = " + typeOfScreen +
                ", sizeOfScreen = " + sizeOfScreen +
                '}';
    }
}
