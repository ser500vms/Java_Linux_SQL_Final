package Model;

import java.time.LocalDate;

public class Dog extends Animal{

    private String type = "Dog";
    private String PackOrHome = "Home";

    public String getType() {
        return type;
    }

    public String getPackOrHome() {
        return PackOrHome;
    }

    public Dog() {}

}
