import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class ThingManager {

    private static final ThingManager instance = new ThingManager();

    public static ArrayList<Thing> Things = new ArrayList<Thing>();

    private ThingManager() {
    }

    public static ThingManager getInstance() {
        return instance;
    }

    public static ArrayList<Thing> getThings() {
        DatabaseManager dbManager = DatabaseManager.getInstance();
        Things = dbManager.getThings();
        return Things;
    }
}
