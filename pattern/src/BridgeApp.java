/**
 * Created by Orest on 15.04.2016.
 */
public class BridgeApp {

    public static void main(String[] args) {

        IBridgeReklama hondaBridge = new BridgeHonda();
        AbstractChanel bridge = new Chanel24(hondaBridge, "Реклама на телеканалі новин 24");
        bridge.info();
        bridge.Text();

    }
}

abstract class AbstractChanel implements IBridgeReklama {

    protected String text;
    protected IBridgeReklama bridge;

    protected AbstractChanel(IBridgeReklama bridgeReklama, String text) {
        this.text = text;
        this.bridge = bridgeReklama;
    }

    public void Text() {
        System.out.println(text);
    }

    @Override
    public void info() {
        bridge.info();
    }
}

class Chanel24 extends AbstractChanel {
    public Chanel24(IBridgeReklama bridge, String text) {
        super(bridge, text);
    }
}


interface IBridgeReklama {
    void info();
}

class BridgeSubaru implements IBridgeReklama {
    @Override
    public void info() {
        System.out.println("I am SUBARU");
    }
}

class BridgeHonda implements IBridgeReklama {
    @Override
    public void info() {
        System.out.println("I am HONDA");
    }
}