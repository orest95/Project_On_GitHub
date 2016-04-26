import java.util.Arrays;

/**
 * Created by Orest on 26.04.2016.
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        String[] arr0 = {"Реклама Субару", "Хонда", "Будівельна компанія Ярковиця"};
        client.setStrategy(new ConcreteStrategyA());
        client.executeStrategy(arr0);

        String[] arr1 = {"Хонда", "Будівельна компанія Ярковиця", "Реклама Субару"};
        client.setStrategy(new ConcreteStrategyB());
        client.executeStrategy(arr1);

    }
}

class StrategyClient {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String[] arr) {
        strategy.operation(arr);
    }
}

interface Strategy {
    void operation(String[] arr);
}

class ConcreteStrategyA implements Strategy {
    @Override
    public void operation(String[] arr) {
        System.out.println("Порядок реклами зранку:" + Arrays.toString(arr));
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void operation(String[] arr) {
        System.out.println("Порядок реклами ввечері:" + Arrays.toString(arr));
    }
}