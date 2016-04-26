/**
 * Created by Orest on 26.04.2016.
 */
public class MementoApp {
    public static void main(String[] args) {

        Originator originator = new Originator();
        originator.set("Реклама перша", 10);
        System.out.println(originator);

        File file = new File();
        file.setMemento(originator.memento());

        originator.set("Реклама друга", 15);
        System.out.println(originator);

        System.out.println("Повернення до попереднього місця");

        originator.load(file.getMemento());
        System.out.println(originator);

    }
}

class Originator {
    private String name;
    private int time;

    public void set(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public void load(Memento memento) {
        name = memento.getName();
        time = memento.getTime();
    }

    public Memento memento() {
        return new Memento(name, time);
    }


    @Override
    public String toString() {
        return "Originator{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}

class Memento {
    private final String name;
    private final int time;

    public Memento(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

}

class File {
    Memento memento;

    public Memento getMemento() {
        return this.memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }


}