package smarthome.managers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import smarthome.model.DAO;
import smarthome.model.Thing;
import smarthome.model.Zone;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class ThingManager implements ThingController {

    private static final ThingManager instance = new ThingManager();

    public static ArrayList<Thing> Things = new ArrayList<Thing>();
    public static ArrayList<Zone> Zones = new ArrayList<Zone>();
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Context.xml");
    DAO dao = (DAO) context.getBean("dao");

    private ThingManager() {
    }

    public static ThingManager getInstance() {
        return instance;
    }

    public ArrayList<Thing> getThings() {
        return Things;
    }

    public Thing getThingByIndex(int index) {
        return Things.get(index);
    }

    public void setThings(ArrayList<Thing> things) {
        Things = things;
        return;
    }

    public int getSize() {
        return Things.size();
    }

    public Thing getThingInstance(int id, String name, int power) {
        // Unique safe check of ArrayList Things missing
        return new Thing(id, name, power);
    }

    public void setZones(ArrayList<Zone> zones) {
        Zones = zones;
        return;
    }

    public void initModel() {
        System.out.println("Initializing model...");
        this.setThings(dao.selectThings());
        System.out.println("Things set");
        this.setZones(dao.selectZones());
        System.out.println("Zones set");
        return;
    }

    public ArrayList<Thing> findByZoneId(int zoneId) {

        int a=0;

        ArrayList<Thing> things = new ArrayList<Thing>();

        for (int i = 0; i < Zones.size(); i++) {

            for (int j = 0; j < Things.size(); j++) {
                    if ((Zones.get(i).getId() == zoneId)&&(Things.get(j).getId() == Zones.get(i).getThingId())) {
                    things.add(Things.get(j));
                    }
            }
        }

        return things;
    }

    public ArrayList<Zone> getZonesById(int zoneId) {

        ArrayList<Zone> zones = new ArrayList<Zone>();

        for (int i = 0; i < Zones.size(); i++) {
            if (Zones.get(i).getId()==zoneId) {
                zones.add(Zones.get(i));
            }
        }
         return zones;

    }
}
