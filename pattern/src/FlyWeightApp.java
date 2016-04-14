import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orest on 15.04.2016.
 */
public class FlyWeightApp {

    public static void main(String[] args) {

        FlyWeightFactory factory = FlyWeightFactory.getInstance();

        for (int i = 0; i < 5; i++) {
            IFlyWeight eng = factory.getFlyWeight("eng");
            eng.doRek(i, i);

            IFlyWeight ukr = factory.getFlyWeight("ukr");
            ukr.doRek(i, i);
        }

    }
}

interface IFlyWeight {
    public void doRek(int a, int b);
}

class EngReklama implements IFlyWeight {

    private String Eng;

    public EngReklama() {
        this.Eng = "English sound";
    }

    @Override
    public void doRek(int a, int b) {
        System.out.println(Eng);
    }
}

class UkrReklama implements IFlyWeight {

    private String Ukr;

    public UkrReklama() {
        this.Ukr = "Українська озвучка";
    }

    @Override
    public void doRek(int a, int b) {
        System.out.println(Ukr);
    }
}


class FlyWeightFactory {

    private static FlyWeightFactory instance;
    private Map<String, IFlyWeight> pool;

    public FlyWeightFactory() {
        this.pool = new HashMap<>();
    }


    public static FlyWeightFactory getInstance() {
        if (instance == null) {
            instance = new FlyWeightFactory();
        }
        return instance;
    }

    public IFlyWeight getFlyWeight(String key) {
        if (pool.containsKey(key)) {
            return pool.get(key);
        } else {
            if (key.equalsIgnoreCase("Ukr")) {
                return new UkrReklama();
            } else if (key.equalsIgnoreCase("Eng")) {
                return new EngReklama();


            } else {
                return null;
            }
        }
    }

}




