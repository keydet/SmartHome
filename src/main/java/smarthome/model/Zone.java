package smarthome.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class Zone {

    int zoneId;
    int thingId;
    String name;
    ArrayList<Thing> things = new ArrayList<Thing>();
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Context.xml");
    DAO dao = (DAO) context.getBean("dao");

    public Zone(int zoneId, int thingId, String name) {
        this.zoneId = zoneId;
        this.thingId = thingId;
        this.name = name;
    }

    public int getId(){
        return this.zoneId;
    }
    public int getThingId(){
        return this.thingId;
    }

}
