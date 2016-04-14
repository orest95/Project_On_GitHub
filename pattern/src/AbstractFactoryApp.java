/**
 * Created by Orest on 14.04.2016.
 */

public class AbstractFactoryApp {

    public static void main(String[] args) {

        ReklamaAbstractFactory factory = getFactoryByCountryCode("Eng");

        Subaru s = factory.getSubaru();
        Honda h = factory.getHonda();

        // s.sName();
        //  s.sProp();
        //  s.sMoney();

        h.hName();
        h.hProp();
        h.hMoney();

    }

    private static ReklamaAbstractFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "Ukr":
                return new UkrReklamaAbstractFactory();
            case "Eng":
                return new EngReklamalaAbstractFactory();
            default:
                throw new RuntimeException("Немає такої мови - " + lang);
        }
    }
}

interface Subaru {
    void sName();

    void sProp();

    void sMoney();
}

interface Honda {
    void hName();

    void hProp();

    void hMoney();
}


interface ReklamaAbstractFactory {
    Subaru getSubaru();

    Honda getHonda();
}


class EngReklamalaAbstractFactory implements ReklamaAbstractFactory {
    @Override
    public Subaru getSubaru() {
        return new EngSubaru();
    }

    @Override
    public Honda getHonda() {
        return new EngHonda();
    }
}

class UkrReklamaAbstractFactory implements ReklamaAbstractFactory {
    @Override
    public Subaru getSubaru() {
        return new UkrSubaru();
    }

    @Override
    public Honda getHonda() {
        return new UkrHonda();
    }
}


class UkrSubaru implements Subaru {
    @Override
    public void sName() {
        System.out.println("Реклама Субару Імпреза ВРХ СТІ");
    }

    @Override
    public void sProp() {
        System.out.println("Рік випуску - 2004. Мотор EJ257");
    }

    @Override
    public void sMoney() {
        System.out.println("Вартість реклами 3000$");
    }
}

class EngSubaru implements Subaru {
    @Override
    public void sName() {
        System.out.println("Reklama Subaru Impreza WRX STI");
    }

    @Override
    public void sProp() {
        System.out.println("Date of birthday - 2004. Engine EJ257 ");
    }

    @Override
    public void sMoney() {
        System.out.println("Price 3000$");
    }
}


class UkrHonda implements Honda {
    @Override
    public void hName() {
        System.out.println("Реклама Хонда Цівік 4д");
    }

    @Override
    public void hProp() {
        System.out.println("Рік випуску - 2008. Мотор 1.8 i-VTEC");
    }

    @Override
    public void hMoney() {
        System.out.println("Вартість реклами 1000 долярів ");
    }
}

class EngHonda implements Honda {
    @Override
    public void hName() {
        System.out.println("Reklama Honda Civic 4D");
    }

    @Override
    public void hProp() {
        System.out.println("Date of birthday - 2008. Engine 1.8 i-VTEC");
    }

    @Override
    public void hMoney() {
        System.out.println("Price 1000 dollars");
    }
}