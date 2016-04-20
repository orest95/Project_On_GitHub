/**
 * Created by Orest on 18.04.2016.

public class MediatorApp {
    public static void main(String[] args) {

        Efir tv = new Efir();

        TV chanel24 = new Chanel(tv);
        Viewer v1 = new SViewer(tv);
        Viewer v2 = new SViewer(tv);


        tv.changeViewer(v1);
        tv.changeViewer(v2);

        v1.viewReklama(" реклам \"Коли\" ");
        v2.changeReklama(" реклама \"Пепсі\" ");
        //  chanel24.changeReklama(" реклама на каналі новин 24 ");
    }
}


interface TV {
    void changeReklama(String video, Viewer viewer);
}

interface Viewer {
    void changeReklama(String video);

    void viewReklama(String video);
}

class Chanel implements TV {
    TV tv;

    public Chanel(TV tv) {
        this.tv = tv;
    }


    @Override
    public void changeReklama(String video, Viewer viewer) {
        tv.changeReklama(video, viewer);
    }
}

class SViewer implements Viewer {
    TV tv;

    public SViewer(TV tv) {
        this.tv = tv;
    }

    @Override
    public void changeReklama(String video) {
        tv.changeReklama(video, this);
    }

    @Override
    public void viewReklama(String video) {
        System.out.println("Глядач дивиться рекламу - " + video + "!");
    }
}

class Efir implements TV {
    Viewer chanel;
    List<Viewer> viewers = new ArrayList<>();

    public void setChanel(Viewer chanel) {
        this.chanel = chanel;
    }

    public void changeViewer(Viewer v1) {
        viewers.add(v1);
    }

    @Override
    public void changeReklama(String video, Viewer viewer) {
        for (Viewer v11 : viewers) {
            v11.changeReklama(video);
        }
        chanel.changeReklama(video);
    }
}

 */