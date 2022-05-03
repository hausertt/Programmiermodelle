import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import java.nio.file.Files;




public class Main {
    private static final String filename = ".\\src\\test_ticks_no_header.csv";


    public static void a1() {
        // Aufgabe 1
        int counter = 0;
        Iterable<Tick> ticks = null;
        try {
            ticks = new TickIterable(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        long before = System.currentTimeMillis();
        System.out.println("start");
        for (Tick tick : ticks) {
            counter++;
        }
        System.out.println(counter);
        System.out.println(System.currentTimeMillis()-before);
    }

    public static void a2() {
        Iterable<Tick> ticks = null;
        try {
            ticks = new TickIterable(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public static List<String> a2b() {
        Iterable<Tick> ticks = null;
        try {
            ticks = new TickIterable(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Stream<Tick> stream = StreamSupport.stream(ticks.spliterator(), false);

        List<String> postfixList = stream
                .map(tick -> tick.getSymbol().replaceAll(".*\\.",""))
                .distinct()
                .collect(Collectors.toList());

        //System.out.println(postfixList.size());

        return postfixList;
    }

    public static List<String> a3a() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(filename))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> postfixList = reader
                .lines()
                .map(v->Tick
                        .toTick(v)
                        .getSymbol()
                        .replaceAll(".*\\.",""))
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(postfixList.size());

        return postfixList;
    }

    public static List<Tick> a3b() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(filename))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Tick> bereinigteList = reader
                .lines()
                .map(v->Tick.toTick(v))
                .filter(v->v.getPrice() != 0)
                .collect(Collectors.toList());
        //System.out.println(bereinigteList.size());

        return bereinigteList;
    }

    public static Map<String, Long> a3c(List<Tick> bereinigteList) {
        Map<String,Long> symbolCount = new HashMap<String,Long>();

        bereinigteList.stream().
                collect(Collectors.toMap(v->v.getSymbol(),w->count(symbolCount, w),(existing, replacement) -> replacement));

        return symbolCount;
    }

    private static Long count(Map<String, Long> map, Tick w) {
        return map.merge(w.getSymbol(), (long)1, (currentCount, notUsed) -> ++currentCount);
    }

    public static long a3d(Map<String, Long> symbolCount) {
        return symbolCount.values().stream()
                .reduce((long)0, (subtotal, element) -> subtotal+element);
    }




    public static void main(String[] args) {
        //a1();
        //a2();
        //a2b();
        //a3a();
        //a3b();
        //System.out.println(a3c(a3b()).get("IRSH3.FR"));
        //System.out.println(a3d(a3c(a3b())));
    }
}
