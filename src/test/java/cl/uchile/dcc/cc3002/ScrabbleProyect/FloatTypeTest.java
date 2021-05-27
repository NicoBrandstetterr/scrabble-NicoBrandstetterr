package cl.uchile.dcc.cc3002.ScrabbleProyect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FloatTypeTest {

    private int seed;
    private Random rng;
    private double DoubleNumber;
    private double RandomValue;
    private FloatType floatExample;
    private FloatType expectedDouble;
    private FloatType RandomExample;
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        DoubleNumber = Math.random() * (10000 - 0) + 0;
        RandomValue = rng.nextDouble();
        floatExample = new FloatType(DoubleNumber);
        expectedDouble = new FloatType(DoubleNumber);
        RandomExample = new FloatType(RandomValue);
    }
    @Test
    void constructorTest(){
        assertEquals(expectedDouble, floatExample);
        assertEquals(expectedDouble.hashCode(), floatExample.hashCode(),"failed hashcode test");
        var differentIntNumber = new FloatType(RandomValue);
        assertNotEquals(differentIntNumber, floatExample);
    }

    @RepeatedTest(20)
    void setADouble() {
        assertEquals(RandomValue, RandomExample.getADouble(), "Values dont match. Seed: "+seed);
        assertNotEquals(RandomExample.getADouble(),floatExample.getADouble(),"Values match. Seed: "+seed);
        //we change the value of intExample to RandomValue, the differentIntNumber value
        RandomExample.setADouble(DoubleNumber);
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(RandomExample.getADouble(),floatExample.getADouble(), "Values dont match. Seed: "+seed);
    }

    @Test
    void testToString() {
        String StringTest = "test";
        assertNotEquals(((Object) floatExample.getADouble()).getClass().getSimpleName(), ((Object) StringTest).getClass().getSimpleName());
        var StringTestNumber = RandomExample.ToString();
        var StringIntExample = floatExample.ToString();
        assertTrue(StringTestNumber instanceof StringType,"Classes Dont Match");
        assertTrue(StringIntExample instanceof StringType,"Classes Dont Match");
        assertEquals(StringTestNumber.getAString().getClass().getSimpleName(),StringTest.getClass().getSimpleName());
        assertEquals(StringIntExample.getAString().getClass().getSimpleName(),StringTestNumber.getAString().getClass().getSimpleName());
    }

    @Test
    void toFloat() {
    }

    @Test
    void toInt() {
    }

    @Test
    void toBinary() {
    }

    @Test
    void add() {

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