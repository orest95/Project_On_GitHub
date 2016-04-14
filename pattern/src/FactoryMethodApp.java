/**
 * Created by Orest on 15.04.2016.
 */
public class FactoryMethodApp {

    public static void main(String[] args) {

        ReklamaFactoryMaker maker = getMakerByName("Subaru");

        ReklamaFactory reklamaFactory = maker.createReklamaFactory();
        reklamaFactory.showReklama();
    }

    public static ReklamaFactoryMaker getMakerByName(String maker) {
        if (maker.equals("Subaru"))
            return new SubaruFactoryMaker();
        else if (maker.equals("Nissan"))
            return new NissanFactoryMaker();

        throw new RuntimeException("нема реклами:  " + maker);
    }
}


interface ReklamaFactory {
    void showReklama();
}

class SubaruFactory implements ReklamaFactory {
    public void showReklama() {
        System.out.println("subaru reklama");
    }
}

class NissanFactory implements ReklamaFactory {
    public void showReklama() {
        System.out.println("nissan reklama");
    }
}


interface ReklamaFactoryMaker {
    ReklamaFactory createReklamaFactory();
}

class SubaruFactoryMaker implements ReklamaFactoryMaker {
    public ReklamaFactory createReklamaFactory() {
        return new SubaruFactory();
    }
}

class NissanFactoryMaker implements ReklamaFactoryMaker {
    public ReklamaFactory createReklamaFactory() {
        return new NissanFactory();
    }
}



