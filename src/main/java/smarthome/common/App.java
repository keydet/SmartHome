package smarthome.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import smarthome.managers.ThingManager;
import smarthome.model.DAO;

public class App {

    public static void main(String args[]) {

        /* Non-spring part
        ThingManager thingManager = ThingManager.getInstance();
        System.out.println("Created ThingManager:" + thingManager.hashCode());
        System.out.println("Created things array:" + thingManager.getThings());
        */

        // Spring part
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        DAO dao = (DAO) context.getBean("dao");
        ThingManager thingManager = ThingManager.getInstance();
        //dao.insert(thingManager.getThingInstance(5, "Springer",0));

        thingManager.setThings(dao.selectThings());

        System.out.println(thingManager.getThings());

        for (int i = 0; i < thingManager.getSize(); i++) {
            System.out.println(thingManager.getThingByIndex(i).getName());
        }

    }

}