import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orest on 20.04.2016.
 */
public class Mediator2App {
    public static void main(String[] args) {

        Chanel chanel = new Efir();

        Efir chanel24 = new Efir();

        chanel24.setChanel(chanel);
        Viewer v1 = new ConcreteViewer();
        Viewer v2 = new ConcreteViewer();

        chanel24.addViewer(v1);
        chanel24.addViewer(v2);

        v1.viewReklama(" реклам \"Коли\" ");
        v2.changeReklama(" реклама \"Пепсі\" ");
        chanel24.transReklama(" реклама на каналі новин 24 ");

    }
}

interface Chanel {
    void transReklama(String video);
}

interface Viewer {
    void viewReklama(String video);

    void changeReklama(String video);
}

class Efir implements Chanel {
    Chanel chanel;

    List<Viewer> viewers = new ArrayList<>();

    public Efir() {
    }

    public void addViewer(Viewer viewer) {
        this.viewers.add(viewer);
    }

    public void setChanel(Chanel chanel) {
        this.chanel = chanel;
    }

    @Override
    public void transReklama(String video) {

        for (Viewer viewer1 : viewers) {
            viewer1.viewReklama(video);
        }


    }
}

class ConcreteViewer implements Viewer {
    Viewer viewer;

    public ConcreteViewer() {
    }

    @Override
    public void viewReklama(String video) {
        System.out.println("дивиться" + video);
    }

    @Override
    public void changeReklama(String video) {
        System.out.println("переключає" + video);
    }
}
