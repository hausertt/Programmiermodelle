import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tick {
    private final LocalDateTime time;
    private final String symbol;
    private final long price;

    static final File readFile = new File("D:\\Studium\\AIN 4\\Programmiermodelle\\Praktikum\\Aufgabenblätter\\Aufgabenblatt+02+2\\Aufgabenblatt 02\\small_ticks.csv");

    public Tick(LocalDateTime time, String symbol, long price) {
        this.time = time;
        this.symbol = symbol;
        this.price = price;
    }

    public String toString() {
        return "Tick{time=" + time + ", symbol='" + symbol + "', price=" + price +"}";
    }

    static Tick toTick(String line) {
        LocalDateTime extractedTime = null;
        String extractedDate = "";
        String extractedSymbol = null;
        long extractedPrice = 0;

        String patternString = "[^,]+";
        Pattern groupPattern = Pattern.compile(patternString);
        Matcher mainMatcher = groupPattern.matcher(line);
        int column = 0;
        while(mainMatcher.find()) {
            if (column == 0) {
                extractedSymbol = mainMatcher.group();
            } else if (column == 2) {
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                extractedDate = LocalDate.parse(mainMatcher.group(), formatter1).format(formatter2);
            } else if (column == 4) {
                extractedPrice = Long.parseLong(mainMatcher.group().replaceAll("\\.", ""));
            } else if (column == 3) {
                String datePart2 = mainMatcher.group();
                extractedTime = LocalDateTime.parse(extractedDate + "T" + datePart2);
            }
            column++;
        }
        Tick extractedTick = new Tick(extractedTime,extractedSymbol,extractedPrice);
        return extractedTick;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getPrice() {
        return price;
    }
}
