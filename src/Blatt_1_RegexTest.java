import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class Blatt_1_RegexTest {

	@Test
	public void testGleitkommazahlen() {

		String gerade = "\\d*[02468]";  // Hier Ihren regulären Ausdruck eintragen

		assertTrue(Pattern.matches(gerade, "22"));
		assertTrue(Pattern.matches(gerade, "2"));
		assertTrue(Pattern.matches(gerade, "4"));
		assertTrue(Pattern.matches(gerade, "10"));
		assertTrue(Pattern.matches(gerade, "108"));
		assertTrue(Pattern.matches(gerade, "278374"));
		assertTrue(Pattern.matches(gerade, "0"));


		assertFalse(Pattern.matches(gerade, "1"));
		assertFalse(Pattern.matches(gerade, "5"));
		assertFalse(Pattern.matches(gerade, "2131"));
		assertFalse(Pattern.matches(gerade, "9"));


	}
	
	@Test
	public void testGenPattern() {
		String genPattern = "ATG([ACGT]{3})+(TAA|TAG|TGA)";
		
		assertTrue(Pattern.matches(genPattern, "ATGTTTTAA"));
		assertTrue(Pattern.matches(genPattern, "ATGTTTGAGTGA"));
		assertTrue(Pattern.matches(genPattern, "ATGACGGCATAA"));

		assertFalse(Pattern.matches(genPattern, "ATGTAG"));
		assertFalse(Pattern.matches(genPattern, "ATGACGGCATAAATG"));
	}

	@Test
	public void testAddition() {

		String addition = "\\d+\\+\\d+";  // Hier Ihren regulären Ausdruck eintragen

		assertTrue(Pattern.matches(addition, "1+1"));
		assertTrue(Pattern.matches(addition, "11+1214"));
		assertTrue(Pattern.matches(addition, "22+214123"));

		assertFalse(Pattern.matches(addition, "213"));
		assertFalse(Pattern.matches(addition, "+2"));
		assertFalse(Pattern.matches(addition, "54+"));
	}

	@Test
	public void testkomischesPattern() {

		String pattern = ".*((XYYZ.*ZZXY)|(ZZXY.*XYYZ)).*";

		assertTrue(Pattern.matches(pattern,"IrgendwasXYYZoderSoZZXY"));
		assertTrue(Pattern.matches(pattern,"XYYZZZXY"));
		assertTrue(Pattern.matches(pattern,"ZZXYsdsXYYZ"));
		assertTrue(Pattern.matches(pattern,"ZZXYXYYZsds"));
		assertTrue(Pattern.matches(pattern,"sdsZZXYXYYZ"));

		assertFalse(Pattern.matches(pattern, "OHNE"));
		assertFalse(Pattern.matches(pattern, "NUREINSXYYZ"));
		assertFalse(Pattern.matches(pattern, "ZZXYeins"));
	}

	@Test
	public void testDatum() {

		String datumPattern = "\\d{4}-([1-9]|1[0-2])-([1-9]|[1-2]\\d|3[0-1])\\s(1?\\d|2[0-3])(:[1-5]?\\d){2}"; // Hier Ihren regulären Ausdruck eintragen

		assertTrue(Pattern.matches(datumPattern, "2020-12-24 18:11:59"));
		assertTrue(Pattern.matches(datumPattern, "2020-1-1 0:0:0"));
		assertTrue(Pattern.matches(datumPattern, "2020-12-24 18:11:59"));


		assertFalse(Pattern.matches(datumPattern, "2020-12-24 18:11:60"));
		assertFalse(Pattern.matches(datumPattern, "2020-13-24 24:11:59"));
		assertFalse(Pattern.matches(datumPattern, "2020-0-24 18:11:59"));
		assertFalse(Pattern.matches(datumPattern, "2020-12-0 18:11:59"));
		assertFalse(Pattern.matches(datumPattern, "202-12-24 0:11:59"));
	}
}