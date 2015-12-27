package smarthome.managers;

import smarthome.model.Thing;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class ThingManager implements ThingController {

    private static final ThingManager instance = new ThingManager();

    protected static ArrayList<Thing> Things = new ArrayList<Thing>();

    private ThingManager() {
    }

    public static ThingManager getInstance() {
        return instance;
    }

    public ArrayList<Thing> getThings() {
        return this.Things;
    }

    public Thing getThingByIndex(int index) {
        return Things.get(index);
    }

    public void setThings(ArrayList<Thing> things) {
        this.Things = things;
        return;
    }

    public int getSize() {
        return this.Things.size();
    }

    public Thing getThingInstance(int id, String name, int power) {
        // Unique safe check of ArrayList Things missing
        return new Thing(id, name, power);
    }
}
