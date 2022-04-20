import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FractionTest {


    @Test
    public void fractionImplementationTest(){

        FractionImplementation fractionImplementation = new FractionImplementation(1,2);
        assert (fractionImplementation.getNumerator() == 1);
        assert (fractionImplementation.getDenominator() == 2);
        fractionImplementation.setNumerator(4);
        assert (fractionImplementation.getNumerator() == 4);
        fractionImplementation.setDenominator(10);
        assert (fractionImplementation.getDenominator() == 10);
    }

    @Test
    public void unmodifiableFractionTest(){
        FractionImplementation fractionImplementation = new FractionImplementation(1,2);
        UnmodifiableFraction unmodifiableFraction = new UnmodifiableFraction(fractionImplementation);


        Assertions.assertThrows(UnsupportedOperationException.class,()->{
            unmodifiableFraction.setNumerator(2);
        });

        Assertions.assertThrows(UnsupportedOperationException.class,()->{
            unmodifiableFraction.setDenominator(10);
        });


        assert (unmodifiableFraction.getDenominator() == 2);
        assert (unmodifiableFraction.getNumerator() == 1);

        fractionImplementation.setDenominator(10);
        assert (unmodifiableFraction.getDenominator() == 10);

        fractionImplementation.setNumerator(3);
        assert (unmodifiableFraction.getNumerator() == 3);

    }
}
