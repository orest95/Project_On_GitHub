import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orest on 26.04.2016.
 */
public class ObserverApp {
    public static void main(String[] args) {
        ConcreteObserved chanel = new ConcreteObserved();

        chanel.addObserver(new RealObserver());

        chanel.setState("свято наближається", "Coca-Cola");
        chanel.setState("впевненість в русі", "Subaru");

    }
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class ConcreteObserved implements Observed {
    String volume;
    String image;

    List<Observer> observers = new ArrayList<>();

    public void setState(String v, String i) {
        volume = v;
        image = i;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(volume, image);
        }
    }
}

interface Observer {
    void handleEvent(String volume, String image);
}

class RealObserver implements Observer {
    @Override
    public void handleEvent(String volume, String image) {
        System.out.println("Почалась реклама: Звук - " + volume + ", Зображення на екрані - " + image);
    }
}