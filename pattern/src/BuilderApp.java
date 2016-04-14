/**
 * Created by Orest on 15.04.2016.
 */
public class BuilderApp {


    public static void main(String[] args) {

        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Reklama3 reklama = director.BuildReklama();
        System.out.println(reklama);
    }
}

class Reklama3 {
    String name;
    String time;
    int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reklama3 = [name = " + name + ", time = " + time + ", price = " + price + " ]";
    }
}


abstract class ReklamaBuilder {
    Reklama3 reklama;

    void createReklama() {
        reklama = new Reklama3();
    }

    abstract void buildName();

    abstract void buildTime();

    abstract void buildPrice();

    Reklama3 getReklama() {
        return reklama;
    }
}


class SubaruBuilder extends ReklamaBuilder {

    void buildName() {
        reklama.setName("Subaru STI");
    }

    void buildTime() {
        reklama.setTime("00:40");
    }

    void buildPrice() {
        reklama.setPrice(3000);
    }
}

class NissanBuilder extends ReklamaBuilder {

    void buildName() {
        reklama.setName("Nissan Silvia");
    }

    void buildTime() {
        reklama.setTime("00.30");
    }

    void buildPrice() {
        reklama.setPrice(2000);
    }
}


class Director {
    ReklamaBuilder builder;

    void setBuilder(ReklamaBuilder b) {
        builder = b;
    }

    Reklama3 BuildReklama() {
        builder.createReklama();
        builder.buildName();
        builder.buildTime();
        builder.buildPrice();
        Reklama3 reklama = builder.getReklama();
        return reklama;
    }
}






