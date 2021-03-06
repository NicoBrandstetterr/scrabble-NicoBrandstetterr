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

class StringTypeTest {
    private int seed;
    private Random rng;
    private int intExample;
    private String stringEx;
    private Double RandomValue;
    private StringType expectedString;
    private StringType stringExample;
    private StringType RandomString;
    private IntType OperationInt;
    private FloatType OperationFloat;
    private BinaryType OperationBinary;
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        Random rng = new Random(seed);
        intExample = rng.nextInt();
        stringEx = String.valueOf(intExample);
        expectedString = new StringType(stringEx);
        stringExample = new StringType(stringEx);
        RandomValue = rng.nextDouble();
        RandomString = new StringType(String.valueOf(RandomValue));
        OperationInt = new IntType(intExample);
        OperationFloat = new FloatType(RandomValue);
        OperationBinary = OperationInt.ToBinary();
    }
    @Test
    void constructor(){
        assertEquals(expectedString, stringExample);
        assertEquals(expectedString.hashCode(), stringExample.hashCode(),"failed hashcode test");
        assertNotEquals(RandomString, stringExample);
        assertFalse(expectedString.equals(OperationFloat));
    }

    @Test
    void setAString() {
        assertEquals(stringEx, stringExample.getInfo(), "Values dont match. Seed: "+seed);
        assertNotEquals(RandomString.getInfo(),stringExample.getInfo(),"Values match. Seed: "+seed);
        //we change the value of intExample to RandomValue, the differentIntNumber value
        stringExample.setAString(RandomString.getInfo());
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(stringExample.getInfo(),RandomString.getInfo(), "Values dont match. Seed: "+seed);

    }

    /**
     * This Test prove if a StringType is convert using ToString, the result is a StringType
     */
    @RepeatedTest(20)
    void testToString() {
        assertEquals(stringExample.getInfo().getClass().getSimpleName(),RandomString.getInfo().getClass().getSimpleName());
        assertEquals(stringExample.ToString().getClass().getSimpleName(),RandomString.getClass().getSimpleName());

    }


    @RepeatedTest(20)
    void addStringTest() {
        assertTrue(stringExample.Add(OperationInt) instanceof StringType);
        assertTrue(stringExample.Add(OperationFloat) instanceof StringType);
        assertTrue(stringExample.Add(OperationBinary) instanceof StringType);
        assertEquals(stringExample.getInfo()+intExample, ((StringType) stringExample.Add(OperationInt)).getInfo());
        assertEquals(stringExample.getInfo()+RandomValue,((StringType) stringExample.Add(OperationFloat)).getInfo());
        assertEquals(stringExample.getInfo()+ OperationBinary.getInfo(), ((StringType) stringExample.Add(OperationBinary)).getInfo());

    }
    @RepeatedTest(10)
    void addedByFloat(){
        assertNull(OperationFloat.Add(stringExample));
    }
    @RepeatedTest(10)
    void addedByInt(){
        assertNull(OperationInt.Add(stringExample));
    }
    @RepeatedTest(10)
    void addedByString(){
    assertTrue(stringExample.Add(RandomString) instanceof StringType);
    assertEquals(stringExample.getInfo()+RandomString.getInfo(), ((StringType) stringExample.Add(RandomString)).getInfo());
    }
    @RepeatedTest(10)
    void addedByBinary(){
        assertNull(OperationBinary.Add(stringExample));
    }

    @RepeatedTest(10)
    void subtractStringTest() {
        assertNull(stringExample.Subtract(OperationBinary));
        assertNull(stringExample.Subtract(OperationInt));
        assertNull(stringExample.Subtract(OperationFloat));

    }

    @RepeatedTest(10)
    void subtractedByFloat() {
        assertNull(OperationFloat.Subtract(stringExample));
    }

    @RepeatedTest(10)
    void subtractedByInt() {
        assertNull(OperationInt.Subtract(stringExample));
    }

    @RepeatedTest(10)
    void subtractedByBinary() {
        assertNull(OperationBinary.Subtract(stringExample));
    }

    @RepeatedTest(10)
    void multiply() {
        assertNull(stringExample.Multiply(OperationBinary));
        assertNull(stringExample.Multiply(OperationInt));
        assertNull(stringExample.Multiply(OperationFloat));
    }

    @RepeatedTest(10)
    void multipliedByFloat() {
        assertNull(OperationFloat.Multiply(stringExample));
    }

    @RepeatedTest(10)
    void multipliedByInt() {
        assertNull(OperationInt.Multiply(stringExample));
    }

    @RepeatedTest(10)
    void multipliedByBinary() {
        assertNull(OperationBinary.Multiply(stringExample));
    }

    @RepeatedTest(10)
    void divide() {
        assertNull(stringExample.Divide(OperationBinary));
        assertNull(stringExample.Divide(OperationInt));
        assertNull(stringExample.Divide(OperationFloat));
    }

    @RepeatedTest(10)
    void dividedByFloat() {
        assertNull(OperationFloat.Divide(stringExample));
    }

    @RepeatedTest(10)
    void dividedByInt() {
        assertNull(OperationInt.Divide(stringExample));
    }

    @RepeatedTest(10)
    void dividedByBinary() {
        assertNull(OperationBinary.Divide(stringExample));
    }
}