import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TickIterable implements Iterable<Tick>{

    private TickIterator tickIterator;

    public TickIterable(String filename) throws FileNotFoundException {
        tickIterator = new TickIterator(filename);
    }

    @Override
    public Iterator<Tick> iterator() {
        return tickIterator;
    }

    public static void main(String[] args) throws IOException {
        String filename = ".\\src\\small_ticks.csv";
        Iterable<Tick> ticks = new TickIterable(filename);
        for (Tick tick : ticks) {
            System.out.println(tick);
        }
    }
}
