import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;




public class Main {
    private String filename = ".\\src\\test_ticks_no_header.csv";


    void a1() throws FileNotFoundException {
        // Aufgabe 1
        int counter = 0;
        Iterable<Tick> ticks = new TickIterable(filename);
        long before = System.currentTimeMillis();
        System.out.println("start");
        for (Tick tick : ticks) {
            counter++;
        }
        System.out.println(counter);
        System.out.println(System.currentTimeMillis()-before);
    }

    void a2() throws FileNotFoundException {
        Iterable<Tick> ticks = new TickIterable(filename);
        Stream<Tick> stream = StreamSupport.stream(ticks.spliterator(), false);

        long before = System.currentTimeMillis();
        System.out.println("start");
        System.out.println(
                stream
                .parallel()
                .count()
        );
        System.out.println(System.currentTimeMillis()-before);
    }

    void a2b() throws FileNotFoundException {
        Iterable<Tick> ticks = new TickIterable(filename);
        Stream<Tick> stream = StreamSupport.stream(ticks.spliterator(), false);

        List<Tick> ticksList = stream.collect(Collectors.toList());
        Set<String> postfixSet = ticksList.stream()
                .map(tick -> tick.getSymbol().replaceAll(".*\\.",""))
                .collect(Collectors.toSet());

        System.out.println(postfixSet.size());
    }

    void a3() throws FileNotFoundException {

    }




    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        //main.a1();
        //main.a2();
        main.a2b();
    }
}
