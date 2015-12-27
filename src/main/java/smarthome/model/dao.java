package smarthome.model;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public interface DAO
{
    public void insertThing(Thing thing);
    public Thing findByThingId(int thingId);
    public ArrayList<Thing> selectThings();
}
