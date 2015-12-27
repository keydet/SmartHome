import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class ThingManager {

    private static final ThingManager instance = new ThingManager();

    public ArrayList<Thing> Things = new ArrayList<Thing>();

    private ThingManager() {

    }

    public static ThingManager getInstance() {
        return instance;
    }

    public ArrayList<Thing> getThings() {



        return Things;
    }

}
