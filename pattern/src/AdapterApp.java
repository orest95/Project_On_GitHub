/**
 * Created by Orest on 15.04.2016.
 */
public class AdapterApp {


    public static void main(String[] args) {

        ToyotaReklama toyotaReklama = new SupraReklamaAdapterToToyota();
        toyotaReklama.MaxSpeedToyota();
        toyotaReklama.AccelerationToyota();
    }
}

interface ToyotaReklama {
    void MaxSpeedToyota();

    void AccelerationToyota();
}


class SupraReklama {
    void MaxSpeedSupra() {
        System.out.println("Max speed - 280 km/h");
    }

    void AccelerationSupra() {
        System.out.println("Acceleration 0-100 km/h - 3.1 sec");
    }
}

class SupraReklamaAdapterToToyota extends SupraReklama implements ToyotaReklama {
    @Override
    public void MaxSpeedToyota() {
        MaxSpeedSupra();
    }

    @Override
    public void AccelerationToyota() {
        AccelerationSupra();
    }
}