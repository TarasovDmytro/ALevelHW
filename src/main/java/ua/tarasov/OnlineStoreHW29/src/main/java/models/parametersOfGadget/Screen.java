package models.parametersOfGadget;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Screen {

    private final TypeOfScreen typeOfScreen;
    private final double sizeOfScreen;

    public Screen(TypeOfScreen typeOfScreen, double sizeOfScreen) {
        this.typeOfScreen = typeOfScreen;
        this.sizeOfScreen = sizeOfScreen;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "typeOfScreen = " + typeOfScreen +
                ", sizeOfScreen = " + sizeOfScreen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screen)) return false;
        Screen screen = (Screen) o;
        return Double.compare(screen.getSizeOfScreen(), getSizeOfScreen()) == 0 && getTypeOfScreen() == screen.getTypeOfScreen();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeOfScreen(), getSizeOfScreen());
    }
}
