package Model;

import java.time.LocalDate;

public abstract class Animal {
    private String name;

    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Animal(){}

    @Override
    public String toString() {
        return name + "," + birthday;
    }
}
