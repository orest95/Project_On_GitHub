/**
 * Created by Orest on 15.04.2016.
 */
public class IteratorApp {
    public static void main(String[] args) {

        ConcreteAggregate c = new ConcreteAggregate();

        Iterator it = c.getIterator();

        while (it.hasNext()) {
            System.out.println((String) it.next());
        }

    }
}

interface Iterator {
    boolean hasNext();

    String next();
}

interface Aggregate {
    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate {
    String[] MassReklama = {"Reklama Subaru WRX", "Reklama Honda CR-X", "Reklama Nissan GT-R", "Reklama Mazda MX-5"};

    @Override
    public Iterator getIterator() {
        return new MassIterator();
    }

    private class MassIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < MassReklama.length) {
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            return MassReklama[index++];
        }
    }
}