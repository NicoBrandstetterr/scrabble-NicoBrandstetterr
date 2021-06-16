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
        StringExample = new IntType(IntNumber).ToBinary().getInfo();
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
        assertEquals(IntNumber, intExample.getInfo(), "Values dont match. Seed: "+seed);
        assertNotEquals(intExample.getInfo(),differentIntNumber.getInfo(),"Values match. Seed: "+seed);
        //we change the value of intExample to RandomValue, the differentIntNumber value
        intExample.setAnInt(RandomValue);
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(intExample.getInfo(),differentIntNumber.getInfo(), "Values dont match. Seed: "+seed);
    }

    @RepeatedTest(20)
    void ToStringTest(){
        int RandomValue = rng.nextInt(10000);
        var TestNumber = new IntType(RandomValue);
        String StringTest = "test";
        assertNotEquals(((Object) intExample.getInfo()).getClass().getSimpleName(), ((Object) StringTest).getClass().getSimpleName());
        var StringTestNumber = TestNumber.ToString();
        var StringIntExample = intExample.ToString();
        assertTrue(StringTestNumber instanceof StringType,"Classes Dont Match");
        assertTrue(StringIntExample instanceof StringType,"Classes Dont Match");
        assertEquals(StringTestNumber.getInfo().getClass().getSimpleName(),StringTest.getClass().getSimpleName());
        assertEquals(StringIntExample.getInfo().getClass().getSimpleName(),StringTestNumber.getInfo().getClass().getSimpleName());
    }

    @RepeatedTest(20)
    void ToFloatTest(){
        int RandomValue = rng.nextInt(10000);
        //We define a double variable in order to use it as a double type comparator.
        double FloatNumberTest = 3;
        var TestNumber = new IntType(RandomValue);
        assertNotEquals(((Object) TestNumber.getInfo()).getClass().getSimpleName(), ((Object) FloatNumberTest).getClass().getSimpleName());
        var FloatTestNumber = TestNumber.ToFloat();
        //test checking the types of the values
        assertEquals(((Object) FloatTestNumber.getInfo()).getClass().getSimpleName(), ((Object) FloatNumberTest).getClass().getSimpleName());
        assertEquals(((Object) FloatTestNumber.getInfo()).getClass().getSimpleName(), ((Object) intExample.ToFloat().getInfo()).getClass().getSimpleName());
        //test checking the classes
        assertEquals(((Object) FloatTestNumber).getClass().getSimpleName(),((Object) new FloatType(FloatTestNumber.getInfo())).getClass().getSimpleName());
    }
    @Test
    void ToIntTest(){
        int RandomValue = rng.nextInt();
        var TestNumber = new IntType(RandomValue);
        assertTrue(TestNumber instanceof IntType);
        assertEquals(TestNumber.getClass().getSimpleName(),TestNumber.ToInt().getClass().getSimpleName());
        assertEquals(((Object) TestNumber.ToInt().getInfo()).getClass().getSimpleName(),((Object) intExample.getInfo()).getClass().getSimpleName());
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
        assertEquals(value5,new IntType(5).ToBinary().getInfo());
        assertEquals(value44,new IntType(44).ToBinary().getInfo());
        assertEquals(value150,new IntType(150).ToBinary().getInfo());
        assertEquals(value0,new IntType(0).ToBinary().getInfo());
        assertEquals(compValue5,new IntType(-5).ToBinary().getInfo());
        assertEquals(compValue44,new IntType(-44).ToBinary().getInfo());
        assertEquals(compValue150,new IntType(-150).ToBinary().getInfo());
        assertEquals(new IntType(IntNumber).ToBinary().getInfo(), BinaryExample.getInfo());
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
        assertEquals(RandomValue+IntNumber,((IntType) TestNumber.Add(IntTest)).getInfo());
        assertEquals(RandomValue+DoubleTest,((FloatType) TestNumber.Add(FloatTestNumber)).getInfo());
        assertEquals(RandomValue+BinaryTestNumber.ToInt().getInfo(),((IntType) TestNumber.Add(BinaryTestNumber)).getInfo());
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
        assertEquals(RandomValue - IntNumbers, ((IntType) TestNumber.Subtract(IntTest)).getInfo());
        assertEquals(RandomValue - DoubleTest, ((FloatType) TestNumber.Subtract(FloatTestNumber)).getInfo());
        assertEquals(RandomValue - BinaryTestNumber.ToInt().getInfo(), ((IntType) TestNumber.Subtract(BinaryTestNumber)).getInfo());
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
        assertEquals(RandomValue * IntNumbers, ((IntType) TestNumber.Multiply(IntTest)).getInfo());
        assertEquals(RandomValue * DoubleTest, ((FloatType) TestNumber.Multiply(FloatTestNumber)).getInfo());
        assertEquals(RandomValue * BinaryTestNumber.ToInt().getInfo(), ((IntType) TestNumber.Multiply(BinaryTestNumber)).getInfo());
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
        assertEquals(RandomValue / IntNumbers, ((IntType) TestNumber.Divide(IntTest)).getInfo());
        assertEquals(RandomValue / DoubleTest, ((FloatType) TestNumber.Divide(FloatTestNumber)).getInfo());
        assertEquals(RandomValue / BinaryTestNumber.ToInt().getInfo(), ((IntType) TestNumber.Divide(BinaryTestNumber)).getInfo());

    }
}