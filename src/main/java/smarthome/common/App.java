package smarthome.common;

import smarthome.managers.ThingManager;
import smarthome.model.Thing;

import java.util.ArrayList;

public class App {

    public static void main(String args[]) {

        ThingManager thingManager = ThingManager.getInstance();
        thingManager.initModel();
        ArrayList<Thing> things = thingManager.findByZoneId(3);



        for (int i = 0; i < things.size(); i++) {
            System.out.println(things.get(i).getName());
        }

    }

}