/**
 * Created by Orest on 14.04.2016.
 */
public class TemplateMethodApp {
    public static void main(String[] args) {
        TemplateReklama reklamamorning = new ReklamaMorning();
        reklamamorning.method();

        System.out.println();

        TemplateReklama reklamanight = new ReklamaNight();
        reklamanight.method();
    }
}

abstract class TemplateReklama {
    void method() {
        System.out.println("Reklama Subaru");
        tempS();
        System.out.println("Reklama Coca-Cola");
    }

    void tempS() {
    }
}

class ReklamaMorning extends TemplateReklama {
    void tempS() {
        System.out.println("Reklama MSI");
    }
}

class ReklamaNight extends TemplateReklama {
    void tempS() {
        System.out.println("Reklama Asus");
    }
}
