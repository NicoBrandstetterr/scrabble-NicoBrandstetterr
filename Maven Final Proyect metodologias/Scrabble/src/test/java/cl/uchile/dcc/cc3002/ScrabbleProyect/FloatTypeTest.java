package cl.uchile.dcc.cc3002.ScrabbleProyect;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.BinaryType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.FloatType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.IntType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.StringType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FloatTypeTest {

    private int seed;
    private double DoubleNumber;
    private double RandomValue;
    private int intTest;
    private FloatType floatExample;
    private FloatType expectedDouble;
    private FloatType RandomExample;
    private IntType intTypeTest;
    private BinaryType BinaryTestNumber;


    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        Random rng = new Random(seed);
        DoubleNumber = Math.random() * 10000;
        RandomValue = rng.nextDouble();
        intTest = rng.nextInt();
        floatExample = new FloatType(DoubleNumber);
        expectedDouble = new FloatType(DoubleNumber);
        RandomExample = new FloatType(RandomValue);
        intTypeTest = new IntType(intTest);
        BinaryTestNumber = intTypeTest.ToBinary();
    }
    @Test
    void constructorTest(){
        assertEquals(expectedDouble, floatExample);
        assertEquals(expectedDouble.hashCode(), floatExample.hashCode(),"failed hashcode test");
        var differentIntNumber = new FloatType(RandomValue);
        assertNotEquals(differentIntNumber, floatExample);
        assertFalse(RandomExample.equals(intTypeTest));
    }

    @RepeatedTest(20)
    void setADouble() {
        assertEquals(RandomValue, RandomExample.getInfo(), "Values dont match. Seed: "+seed);
        assertNotEquals(RandomExample.getInfo(),floatExample.getInfo(),"Values match. Seed: "+seed);
        //we change the value of intExample to RandomValue, the differentIntNumber value
        RandomExample.setADouble(DoubleNumber);
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(RandomExample.getInfo(),floatExample.getInfo(), "Values dont match. Seed: "+seed);
    }

    @Test
    void testToString() {
        String StringTest = "test";
        assertNotEquals(((Object) floatExample.getInfo()).getClass().getSimpleName(), ((Object) StringTest).getClass().getSimpleName());
        var StringTestNumber = RandomExample.ToString();
        var StringIntExample = floatExample.ToString();
        assertTrue(StringTestNumber instanceof StringType,"Classes Dont Match");
        assertTrue(StringIntExample instanceof StringType,"Classes Dont Match");
        assertEquals(StringTestNumber.getInfo().getClass().getSimpleName(),StringTest.getClass().getSimpleName());
        assertEquals(StringIntExample.getInfo().getClass().getSimpleName(),StringTestNumber.getInfo().getClass().getSimpleName());
    }

    @Test
    void toFloat() {
        assertTrue(floatExample instanceof FloatType);
        assertEquals(floatExample.getClass().getSimpleName(),floatExample.ToFloat().getClass().getSimpleName());
        assertEquals(((Object) floatExample.ToFloat().getInfo()).getClass().getSimpleName(),((Object) RandomExample.getInfo()).getClass().getSimpleName());
    }

    @RepeatedTest(20)
    void toInt() {
        assertNull(floatExample.ToInt());
    }

    @RepeatedTest(20)
    void toBinary() {
        assertNull(floatExample.ToBinary());
    }
    @Test
    void addFloatTest() {
        assertTrue(floatExample.Add(intTypeTest) instanceof FloatType);
        assertTrue(floatExample.Add(RandomExample) instanceof FloatType);
        assertTrue(floatExample.Add(BinaryTestNumber) instanceof FloatType);
        assertEquals(DoubleNumber+intTest, ((FloatType) floatExample.Add(intTypeTest)).getInfo());
        assertEquals(RandomValue+DoubleNumber,((FloatType) floatExample.Add(RandomExample)).getInfo());
        assertEquals(DoubleNumber+ BinaryTestNumber.ToFloat().getInfo(), ((FloatType) floatExample.Add(BinaryTestNumber)).getInfo());

    }
    @Test
    void subtractFloatTest() {
        assertTrue(floatExample.Subtract(intTypeTest) instanceof FloatType);
        assertTrue(floatExample.Subtract(RandomExample) instanceof FloatType);
        assertTrue(floatExample.Subtract(BinaryTestNumber) instanceof FloatType);
        assertEquals(DoubleNumber-intTest, ((FloatType) floatExample.Subtract(intTypeTest)).getInfo());
        assertEquals(DoubleNumber-RandomValue,((FloatType) floatExample.Subtract(RandomExample)).getInfo());
        assertEquals(DoubleNumber- BinaryTestNumber.ToFloat().getInfo(), ((FloatType) floatExample.Subtract(BinaryTestNumber)).getInfo());
    }

    @Test
    void multiplyFloatTest() {
        assertTrue(floatExample.Multiply(intTypeTest) instanceof FloatType);
        assertTrue(floatExample.Multiply(RandomExample) instanceof FloatType);
        assertTrue(floatExample.Multiply(BinaryTestNumber) instanceof FloatType);
        assertEquals(DoubleNumber*intTest, ((FloatType) floatExample.Multiply(intTypeTest)).getInfo());
        assertEquals(DoubleNumber*RandomValue,((FloatType) floatExample.Multiply(RandomExample)).getInfo());
        assertEquals(DoubleNumber*BinaryTestNumber.ToFloat().getInfo(), ((FloatType) floatExample.Multiply(BinaryTestNumber)).getInfo());
    }

    @Test
    void divideFloatTest() {
            assertTrue(floatExample.Divide(intTypeTest) instanceof FloatType);
            assertTrue(floatExample.Divide(RandomExample) instanceof FloatType);
            assertTrue(floatExample.Divide(BinaryTestNumber) instanceof FloatType);
            assertEquals(DoubleNumber / intTest, ((FloatType) floatExample.Divide(intTypeTest)).getInfo());
            assertEquals(DoubleNumber / RandomValue, ((FloatType) floatExample.Divide(RandomExample)).getInfo());
            assertEquals(DoubleNumber / BinaryTestNumber.ToFloat().getInfo(), ((FloatType) floatExample.Divide(BinaryTestNumber)).getInfo());
        }
    }

