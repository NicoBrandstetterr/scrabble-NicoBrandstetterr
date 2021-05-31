package cl.uchile.dcc.cc3002.ScrabbleProyect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IntTypeTest {
    private IntType intExample;
    private int seed;
    private Random rng;
    Random RandomNumber = new Random(2000);
    int IntNumber = RandomNumber.nextInt(10000);
    private String StringExample;
    private BinaryType BinaryExample;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        intExample = new IntType(IntNumber);
        StringExample = new IntType(IntNumber).ToBinary().getABinary();
        BinaryExample = new BinaryType(StringExample);
    }

    @Test
    void constructorTest(){
        int RandomValue = rng.nextInt(10000);
        var expectedInt = new IntType(IntNumber);
        assertEquals(expectedInt, intExample);
        assertEquals(expectedInt.hashCode(), intExample.hashCode(),"failed hashcode test");
        var differentIntNumber = new IntType(RandomValue);
        assertNotEquals(differentIntNumber, intExample);
        assertFalse(intExample.equals(BinaryExample));
    }
    @RepeatedTest(20)
    void Set_GetTest(){
        int RandomValue = rng.nextInt(10000);
        var differentIntNumber = new IntType(RandomValue);
        assertEquals(IntNumber, intExample.getAnInt(), "Values dont match. Seed: "+seed);
        assertNotEquals(intExample.getAnInt(),differentIntNumber.getAnInt(),"Values match. Seed: "+seed);
        //we change the value of intExample to RandomValue, the differentIntNumber value
        intExample.setAnInt(RandomValue);
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(intExample.getAnInt(),differentIntNumber.getAnInt(), "Values dont match. Seed: "+seed);
    }

    @RepeatedTest(20)
    void ToStringTest(){
        int RandomValue = rng.nextInt(10000);
        var TestNumber = new IntType(RandomValue);
        String StringTest = "test";
        assertNotEquals(((Object) intExample.getAnInt()).getClass().getSimpleName(), ((Object) StringTest).getClass().getSimpleName());
        var StringTestNumber = TestNumber.ToString();
        var StringIntExample = intExample.ToString();
        assertTrue(StringTestNumber instanceof StringType,"Classes Dont Match");
        assertTrue(StringIntExample instanceof StringType,"Classes Dont Match");
        assertEquals(StringTestNumber.getAString().getClass().getSimpleName(),StringTest.getClass().getSimpleName());
        assertEquals(StringIntExample.getAString().getClass().getSimpleName(),StringTestNumber.getAString().getClass().getSimpleName());
    }

    @RepeatedTest(20)
    void ToFloatTest(){
        int RandomValue = rng.nextInt(10000);
        //We define a double variable in order to use it as a double type comparator.
        double FloatNumberTest = 3;
        var TestNumber = new IntType(RandomValue);
        assertNotEquals(((Object) TestNumber.getAnInt()).getClass().getSimpleName(), ((Object) FloatNumberTest).getClass().getSimpleName());
        var FloatTestNumber = TestNumber.ToFloat();
        //test checking the types of the values
        assertEquals(((Object) FloatTestNumber.getADouble()).getClass().getSimpleName(), ((Object) FloatNumberTest).getClass().getSimpleName());
        assertEquals(((Object) FloatTestNumber.getADouble()).getClass().getSimpleName(), ((Object) intExample.ToFloat().getADouble()).getClass().getSimpleName());
        //test checking the classes
        assertEquals(((Object) FloatTestNumber).getClass().getSimpleName(),((Object) new FloatType(FloatTestNumber.getADouble())).getClass().getSimpleName());
    }
    @Test
    void ToIntTest(){
        int RandomValue = rng.nextInt();
        var TestNumber = new IntType(RandomValue);
        assertTrue(TestNumber instanceof IntType);
        assertEquals(TestNumber.getClass().getSimpleName(),TestNumber.ToInt().getClass().getSimpleName());
        assertEquals(((Object) TestNumber.ToInt().getAnInt()).getClass().getSimpleName(),((Object) intExample.getAnInt()).getClass().getSimpleName());
    }

    @RepeatedTest(20)
    void ToBinaryTest(){
        int RandomValue = rng.nextInt();;
        var TestNumber = new IntType(RandomValue);
        assertTrue(TestNumber.ToBinary() instanceof BinaryType);
        String value5 = "0101";
        String value44 = "0101100";
        String value150 = "010010110";
        String value0 = "0";
        String compValue150 = "101101010";
        String compValue44 = "1010100";
        String compValue5 = "1011";
        assertEquals(value5,new IntType(5).ToBinary().getABinary());
        assertEquals(value44,new IntType(44).ToBinary().getABinary());
        assertEquals(value150,new IntType(150).ToBinary().getABinary());
        assertEquals(value0,new IntType(0).ToBinary().getABinary());
        assertEquals(compValue5,new IntType(-5).ToBinary().getABinary());
        assertEquals(compValue44,new IntType(-44).ToBinary().getABinary());
        assertEquals(compValue150,new IntType(-150).ToBinary().getABinary());
        assertEquals(new IntType(IntNumber).ToBinary().getABinary(), BinaryExample.getABinary());
    }

    @RepeatedTest(20)
    void AddIntTypeTest(){
        int RandomValue = rng.nextInt();
        double DoubleTest = Math.random() * 10000;
        var TestNumber = new IntType(RandomValue);
        var IntTest = new IntType(IntNumber);
        var FloatTestNumber = new FloatType(DoubleTest);
        var BinaryTestNumber = TestNumber.ToBinary();
        assertTrue(TestNumber.Add(IntTest) instanceof IntType);
        assertTrue(TestNumber.Add(FloatTestNumber) instanceof FloatType);
        assertTrue(TestNumber.Add(BinaryTestNumber) instanceof IntType);
        assertEquals(RandomValue+IntNumber,((IntType) TestNumber.Add(IntTest)).getAnInt());
        assertEquals(RandomValue+DoubleTest,((FloatType) TestNumber.Add(FloatTestNumber)).getADouble());
        assertEquals(RandomValue+BinaryTestNumber.ToInt().getAnInt(),((IntType) TestNumber.Add(BinaryTestNumber)).getAnInt());
    }

    @RepeatedTest(20)
    void SubtractIntTypeTest() {
        int IntNumbers = rng.nextInt(2000);
        int RandomValue = rng.nextInt();
        double DoubleTest = Math.random() * (10000 - 0) + 0;
        var TestNumber = new IntType(RandomValue);
        var IntTest = new IntType(IntNumbers);
        var FloatTestNumber = new FloatType(DoubleTest);
        var BinaryTestNumber = TestNumber.ToBinary();
        assertTrue(TestNumber.Subtract(IntTest) instanceof IntType);
        assertTrue(TestNumber.Subtract(FloatTestNumber) instanceof FloatType);
        assertTrue(TestNumber.Subtract(BinaryTestNumber) instanceof IntType);
        assertEquals(RandomValue - IntNumbers, ((IntType) TestNumber.Subtract(IntTest)).getAnInt());
        assertEquals(RandomValue - DoubleTest, ((FloatType) TestNumber.Subtract(FloatTestNumber)).getADouble());
        assertEquals(RandomValue - BinaryTestNumber.ToInt().getAnInt(), ((IntType) TestNumber.Subtract(BinaryTestNumber)).getAnInt());
    }

    @RepeatedTest(20)
    void multiplyIntTypeTest() {
        int IntNumbers = rng.nextInt(2000);
        int RandomValue = rng.nextInt();
        double DoubleTest = Math.random() * (10000 - 0) + 0;
        var TestNumber = new IntType(RandomValue);
        var IntTest = new IntType(IntNumbers);
        var FloatTestNumber = new FloatType(DoubleTest);
        var BinaryTestNumber = TestNumber.ToBinary();
        assertTrue(TestNumber.Multiply(IntTest) instanceof IntType);
        assertTrue(TestNumber.Multiply(FloatTestNumber) instanceof FloatType);
        assertTrue(TestNumber.Multiply(BinaryTestNumber) instanceof IntType);
        assertEquals(RandomValue * IntNumbers, ((IntType) TestNumber.Multiply(IntTest)).getAnInt());
        assertEquals(RandomValue * DoubleTest, ((FloatType) TestNumber.Multiply(FloatTestNumber)).getADouble());
        assertEquals(RandomValue * BinaryTestNumber.ToInt().getAnInt(), ((IntType) TestNumber.Multiply(BinaryTestNumber)).getAnInt());
    }
    @RepeatedTest(20)
    void DivideIntTypeTest() {
        int IntNumbers = -rng.nextInt(2000);
        int RandomValue = rng.nextInt();
        double DoubleTest = Math.random() * (10000 - 0) + 0;
        var TestNumber = new IntType(RandomValue);
        var IntTest = new IntType(IntNumbers);
        var FloatTestNumber = new FloatType(DoubleTest);
        var BinaryTestNumber = IntTest.ToBinary();
        assertTrue(TestNumber.Divide(IntTest) instanceof IntType);
        assertTrue(TestNumber.Divide(FloatTestNumber) instanceof FloatType);
        assertTrue(TestNumber.Divide(BinaryTestNumber) instanceof IntType);
        assertEquals(RandomValue / IntNumbers, ((IntType) TestNumber.Divide(IntTest)).getAnInt());
        assertEquals(RandomValue / DoubleTest, ((FloatType) TestNumber.Divide(FloatTestNumber)).getADouble());
        assertEquals(RandomValue / BinaryTestNumber.ToInt().getAnInt(), ((IntType) TestNumber.Divide(BinaryTestNumber)).getAnInt());

    }
}