package smarthome.managers;

import smarthome.model.Thing;
import smarthome.model.Zone;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public interface ThingController {
    void setThings(ArrayList<Thing> things);
    void setZones(ArrayList<Zone> zones);
    void initModel();
    ArrayList<Thing> findByZoneId(int zoneId);
}
