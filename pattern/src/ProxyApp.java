import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orest on 15.04.2016.
 */
public class ProxyApp {

    public static void main(String[] args) {
        Reklama view1 = new ReklamaProxy();
        // Reklama view2 = new ReklamaProxy();
        System.out.println(view1.getView("Honda.mp4"));
        //  System.out.println(view2.getView("Sky.jpg"));
    }
}

interface Reklama {
    String getView(String rekName);
}


class RealRekalama implements Reklama {
    @Override
    public String getView(String rekName) {
        System.out.println("HONDA - The power of dreams");
        return String.format("loading...", rekName);
    }
}


class ReklamaProxy implements Reklama {

    private Reklama realRekalama = new RealRekalama();
    private Map loadedReklama = new HashMap();

    @Override
    public String getView(String rekName) {
        if (loadedReklama.get(rekName) != null) {
            return (String) loadedReklama.get(rekName);
        } else {
            String reklama = realRekalama.getView(rekName);
            loadedReklama.put(rekName, reklama);
            return reklama;
        }
    }
}


