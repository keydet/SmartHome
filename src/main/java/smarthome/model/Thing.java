package smarthome.model;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class Thing {

    int id;
    int power;
    String name;

    public Thing(int id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public int getId() {return this.id;}

    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    public String getName() {return this.name;}

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public int getPower() {return this.power;}

    public int setPower(int power) {
        this.power = power;
        return this.power;
    }

}
