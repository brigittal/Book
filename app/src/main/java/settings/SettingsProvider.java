import java.util.ArrayList;
import java.util.List;
public class SettingsProvider {
    private static final int SET_COUNT = 6;
    private static final String DEF_OP = "Option #%s";

    public static List<Settings> getSettings(){
        List<Settings> list = new ArrayList<>();
        for (int i=0; i<SET_COUNT; i++){
            Settings settings = new Settings (i, String.format(DEF_OP, i+1),String.format(DEF_OP, i+2));
            list.add(settings);
        }
        return list;
    }
}

class Settings {
    Settings(int id, String world, String translate) {
        this.id = id;
        this.world = world;
        this.translate = translate;
    }

    private int id;
    private String world;
    private String translate;
}
