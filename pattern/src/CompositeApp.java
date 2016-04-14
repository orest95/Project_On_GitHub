import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orest on 15.04.2016.
 */
public class CompositeApp {

    public static void main(String[] args) {


        BlockReklamy br1 = new HondaComposite();
        BlockReklamy br2 = new HondaComposite();
        BlockReklamy br3 = new NissanComposite();

        BlockReklamy br4 = new SubatuComposite();
        BlockReklamy br5 = new SubatuComposite();
        BlockReklamy br6 = new SubatuComposite();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addFragment(br1);
        composite1.addFragment(br2);
        composite1.addFragment(br3);

        composite2.addFragment(br4);
        composite2.addFragment(br5);
        composite2.addFragment(br6);

        composite.addFragment(composite1);
        composite.addFragment(composite2);

        // composite.addFragment(new SubatuComposite());

        composite.view();
    }
}


interface BlockReklamy {
    void view();
}

class SubatuComposite implements BlockReklamy {
    @Override
    public void view() {
        System.out.println("SUBARU - confidence in motion");
    }
}

class HondaComposite implements BlockReklamy {
    @Override
    public void view() {
        System.out.println("HONDA - The power of dreams");
    }
}

class NissanComposite implements BlockReklamy {
    @Override
    public void view() {
        System.out.println("NISSAN - Innovation that excites");
    }
}

class Composite implements BlockReklamy {

    private List<BlockReklamy> fragments = new ArrayList<>();

    public void addFragment(BlockReklamy fragment) {
        fragments.add(fragment);
    }

    public void removeFragment(BlockReklamy fragment) {
        fragments.remove(fragment);
    }

    @Override
    public void view() {
        for (BlockReklamy fragment : fragments) {
            fragment.view();
        }
    }
}

