/**
 * Created by Orest on 15.04.2016.
 */
public class DecoratorApp {

    public static void main(String[] args) {
        ViewerReklama viewerReklama = new DecoratorBanner(new DecoratorLogoTv(new ViewReklama("SUBARU - confidence in motion")));
        viewerReklama.view();
    }
}

interface ViewerReklama {
    void view();
}

class ViewReklama implements ViewerReklama {
    String value;

    public ViewReklama(String value) {
        this.value = value;
    }

    @Override
    public void view() {
        System.out.println(value);

    }
}

abstract class Decorator implements ViewerReklama {
    ViewerReklama component;

    public Decorator(ViewerReklama component) {
        this.component = component;
    }
}


class DecoratorBanner extends Decorator {
    public DecoratorBanner(ViewerReklama component) {
        super(component);
    }

    @Override
    public void view() {
        System.out.println("Інтернет магазин Rozetka. зайдеться все");
        component.view();

    }
}

class DecoratorLogoTv extends Decorator {
    public DecoratorLogoTv(ViewerReklama component) {
        super(component);
    }

    @Override
    public void view() {
        System.out.println(" 1 + 1 ");
        component.view();
    }
}