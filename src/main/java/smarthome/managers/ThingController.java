package smarthome.managers;

import smarthome.model.Thing;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public interface ThingController {
    public ArrayList<Thing> getThings();
    public void setThings(ArrayList<Thing> things);
    public Thing getThingByIndex(int index);
    public int getSize();
}
