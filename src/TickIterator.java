import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class TickIterator implements Iterator<Tick> {
    private Scanner scanner;

    public TickIterator(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public Tick next() {
        return Tick.toTick(scanner.nextLine());
    }


    private void open() {
    }

    private void close(){
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        String filename = ".\\src\\small_ticks.csv";
        TickIterator iterator = new TickIterator(filename);
        iterator.open();
        while (iterator.hasNext()) {
            Tick tick=iterator.next();
            System.out.println(tick);
        }
        iterator.close();
    }


}
