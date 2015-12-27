package smarthome.model;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class Thing {

    int id;
    int power;
    String name;
    ArrayList<Zone> zones = new ArrayList<Zone>();

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

    public void setName(String name) {
        this.name = name;
        return;
    }

    public int getPower() {return this.power;}

    public void setPower(int power) {
        this.power = power;
        return;
    }

    public ArrayList<Zone> getZones() {return this.zones;}

    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
        return;
    }

}
