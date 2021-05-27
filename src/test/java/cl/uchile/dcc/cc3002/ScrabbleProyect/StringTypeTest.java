package cl.uchile.dcc.cc3002.ScrabbleProyect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringTypeTest {

    private int seed;
    private Random rng;
    @Test
    void testHashCode() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void getAString() {
    }

    @Test
    void setAString() {
    }

    @Test
    void testToString() {
    }

    //@Test
    //void toString() {
    //}

    @Test
    void add() {
        int RandomValue = rng.nextInt();;
        var TestNumber = new IntType(RandomValue);
        String StrTest = "Test";
        var StringTest = new StringType(StrTest);
        var VAdd = StringTest.Add(TestNumber);
        assertTrue(VAdd instanceof StringType);
        System.out.println("variable: "+RandomValue+ "  " +((StringType) VAdd).getAString());
    }


    @Test
    void subtract() {
    }

    @Test
    void subtractedByFloat() {
    }

    @Test
    void subtractedByInt() {
    }

    @Test
    void subtractedByBinary() {
    }

    @Test
    void multiply() {
    }

    @Test
    void multipliedByFloat() {
    }

    @Test
    void multipliedByInt() {
    }

    @Test
    void multipliedByBinary() {
    }

    @Test
    void divide() {
    }

    @Test
    void dividedByFloat() {
    }

    @Test
    void dividedByInt() {
    }

    @Test
    void dividedByBinary() {
    }
}