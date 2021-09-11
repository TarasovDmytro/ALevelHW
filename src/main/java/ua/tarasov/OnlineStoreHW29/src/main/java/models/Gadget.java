package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Gadget {

    private final UUID id;
    private String title;
    private String manufacturerName;
    private String modelName;
    private double price;

    public Gadget(){
        this.id = UUID.randomUUID();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}