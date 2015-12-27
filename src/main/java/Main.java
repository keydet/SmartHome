/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class Main {

    public static void main(String args[]) {

        ThingManager thingManager = ThingManager.getInstance();
        System.out.println("Created ThingManager:" + thingManager.hashCode());
        System.out.println("Created things array:" + thingManager.getThings());
    }

}