package smarthome.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import smarthome.managers.ThingController;
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
        ThingController thingManager = (ThingController) context.getBean("thingManager");
        thingManager.setThings(dao.selectThings());
        for (int i = 0; i < thingManager.getSize(); i++) {
            System.out.println(thingManager.getThingByIndex(i).getName());
        }

    }

}