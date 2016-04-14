/**
 * Created by Orest on 15.04.2016.
 */
public class PrototypeApp {
    public static void main(String[] args) throws CloneNotSupportedException {

        reklama1 first = reklama1.getOurInstace();

        reklama1 reklama1 = new reklama1();
//        Prototype prototype = reklama1.makePrototype();
//        Prototype prototype1 = reklama1.repeatPrototype(prototype);
//
//        System.out.println(prototype1.getName());
    }
}

class Prototype implements Cloneable {

    private int id;
    private String name;
    private String time;
    private String price;

    public Prototype(int id, String name, String time, String price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class reklama1 {

    private static reklama1 ourInstace = new reklama1();

    public reklama1() {
    }

    public void getInfo() {

    }

    public void Nissan() {
        System.out.println("id = 1");
        System.out.println("name = Nissan");
        System.out.println("time = 0.10");
        System.out.print("price = 1000");
    }

    public void Mazda() {
        System.out.println("id = 2");
        System.out.println("name = Mazda");
        System.out.println("time = 0.20");
        System.out.print("price = 2000");

    }

    public void Subaru() {
        System.out.println("id = 3");
        System.out.println("name = Subaru");
        System.out.println("time = 0.30");
        System.out.print("price = 3000");

    }

    public Prototype makePrototype() {
        return new Prototype(3, "Subaru", "0.30", "3000");
    }

    public Prototype repeatPrototype(Prototype prototype) throws CloneNotSupportedException {
        return (Prototype) prototype.clone();
    }

    public static reklama1 getOurInstace() {
        return ourInstace;
    }
}
