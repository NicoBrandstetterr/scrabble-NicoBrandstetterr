package cl.uchile.dcc.cc3002.ScrabbleProyect;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTypeTest {

    private int seed;
    private int IntNumber;
    private int RandomValue;
    private int intTest;
    private double DoubleNumber;
    private String StringExample;
    private BinaryType BinaryExample;
    private BinaryType expectedBinary;
    private BinaryType RandomExample;
    private IntType intTypeTest;
    private IntType BinaryInt;
    private BinaryType BinaryTestNumber;
    private IntType RandomInt;
    private FloatType floatExample;
    private int Aleatory;
    private int AleatoryTwo;
    public int Sign(int sign){
        if(sign == 0){
          return sign +2;
        }
        else{
            return sign;
        }
    }
    private boolean randomBool;
    private BooleanType TestBool;



    @BeforeEach
    void setUp() {

        seed = new Random().nextInt();
        Random rng = new Random(seed);
        Aleatory = (int)(Math.random()*(2+2+1)-2);
        AleatoryTwo = (int)(Math.random()*(2+2+1)-2);
        IntNumber =rng.nextInt(2000)*Sign(Aleatory);
        RandomValue = rng.nextInt(2000)*Sign(Aleatory);
        intTest = rng.nextInt(2000)*Sign(AleatoryTwo);
        BinaryInt = new IntType(IntNumber);
        StringExample = BinaryInt.ToBinary().getInfo();
        BinaryExample = new BinaryType(StringExample);
        expectedBinary = new BinaryType(StringExample);
        RandomInt = new IntType(RandomValue);
        RandomExample = new BinaryType(RandomInt.ToBinary().getInfo());
        intTypeTest = new IntType(intTest);
        BinaryTestNumber = intTypeTest.ToBinary();
        DoubleNumber = Math.random() * 10000;
        floatExample = new FloatType(DoubleNumber);
        randomBool = new Random().nextBoolean();
        TestBool = new BooleanType(randomBool);
    }

    @Test
    void constructorTest() {
        assertEquals(expectedBinary,BinaryExample);
        assertEquals(expectedBinary.hashCode(), BinaryExample.hashCode(), "failed hashcode test");;
        assertNotEquals(RandomExample, BinaryExample);
        assertFalse(RandomExample.equals(floatExample));
    }

    @RepeatedTest(20)
    void setABinary() {
        assertEquals(RandomInt.ToBinary().getInfo(), RandomExample.getInfo(), "Values dont match. Seed: " + seed);
        assertNotEquals(RandomExample.getInfo(), BinaryExample.getInfo(), "Values match. Seed: " + seed);
        //we change the value of intExample to RandomValue, the differentIntNumber value
        RandomExample.setABinary(StringExample);
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(RandomExample.getInfo(), BinaryExample.getInfo(), "Values dont match. Seed: " + seed);
    }

    @Test
    void testToString() {
        String StringTest = "test";
        assertNotEquals(BinaryExample.getClass(), StringTest.getClass());
        var StringTestNumber = RandomExample.ToString();
        var StringIntExample = BinaryExample.ToString();
        assertTrue(StringTestNumber instanceof StringType, "Classes Dont Match");
        assertTrue(StringIntExample instanceof StringType, "Classes Dont Match");
        assertEquals(StringTest.getClass().getSimpleName(),StringTestNumber.getInfo().getClass().getSimpleName());
       assertEquals(StringIntExample.getInfo().getClass().getSimpleName(), StringTestNumber.getInfo().getClass().getSimpleName());
    }

    @RepeatedTest(20)
    void toFloat() {
        assertTrue(BinaryExample.ToFloat() instanceof FloatType);
        // IntNumber is the value in decimal of the BinaryExample value
        assertEquals(IntNumber,BinaryExample.ToFloat().getInfo());
    }

    @RepeatedTest(20)
    void toInt() {
        assertTrue(BinaryExample.ToInt() instanceof IntType);
        // IntNumber is the value in decimal of the BinaryExample value
        assertEquals(IntNumber,BinaryExample.ToInt().getInfo());
    }

    @RepeatedTest(20)
    void toBinary() {
        assertEquals(BinaryExample,BinaryExample.ToBinary());
    }


    @RepeatedTest(30)
    void addBinaryTest() {
        assertTrue(BinaryExample.Add(intTypeTest) instanceof BinaryType);
        assertTrue(BinaryExample.Add(BinaryTestNumber) instanceof BinaryType);
        assertEquals(BinaryExample.Add(floatExample), null);
        assertEquals(new IntType(IntNumber + intTest).ToBinary().getInfo(), ((BinaryType) BinaryExample.Add(intTypeTest)).getInfo());
        assertEquals(new IntType(IntNumber+intTest).ToBinary().getInfo(),((BinaryType) BinaryExample.Add(BinaryTestNumber)).getInfo());

    }

    @RepeatedTest(20)
    void subtractBinaryTest() {
        assertTrue(BinaryExample.Subtract(intTypeTest) instanceof BinaryType);
        assertTrue(BinaryExample.Subtract(BinaryTestNumber) instanceof BinaryType);
        assertEquals(BinaryExample.Subtract(floatExample), null);
        assertEquals(new IntType(IntNumber - intTest).ToBinary().getInfo(), ((BinaryType) BinaryExample.Subtract(intTypeTest)).getInfo());
        assertEquals(new IntType(IntNumber-intTest).ToBinary().getInfo(),((BinaryType) BinaryExample.Subtract(BinaryTestNumber)).getInfo());
    }

    @RepeatedTest(20)
    void multiplyBinaryTest() {
        assertTrue(BinaryExample.Multiply(intTypeTest) instanceof BinaryType);
        assertTrue(BinaryExample.Multiply(BinaryTestNumber) instanceof BinaryType);
        assertEquals(BinaryExample.Multiply(floatExample), null);
        assertEquals(new IntType(IntNumber * intTest).ToBinary().getInfo(), ((BinaryType) BinaryExample.Multiply(intTypeTest)).getInfo());
        assertEquals(new IntType(IntNumber*intTest).ToBinary().getInfo(),((BinaryType) BinaryExample.Multiply(BinaryTestNumber)).getInfo());
    }

    @RepeatedTest(20)
    void DivideBinaryTest() {
        BinaryType DBinaryExample = (BinaryType) BinaryExample.Multiply(new IntType(100));
        assertTrue(DBinaryExample.Divide(intTypeTest) instanceof BinaryType);
        assertTrue(DBinaryExample.Divide(BinaryTestNumber) instanceof BinaryType);
        assertEquals(DBinaryExample.Divide(floatExample), null);
        assertEquals(new IntType(IntNumber*100 / intTest).ToBinary().getInfo(), ((BinaryType) DBinaryExample.Divide(intTypeTest)).getInfo(),"primero");
        assertEquals(new IntType(IntNumber*100/intTest).ToBinary().getInfo(),((BinaryType) DBinaryExample.Divide(BinaryTestNumber)).getInfo(),"segundo");
    }
    @RepeatedTest(20)
    void ConjunctionBinaryTest(){
        var BinaryExampleVar1 = new BinaryType( "1001101");
        var BinaryExampleVar2 = new BinaryType("0101");
        var BinaryExampleVar3 = new BinaryType("1110011001");
        var BinaryExampleVar4 = new BinaryType("1100001");
        assertTrue(BinaryExampleVar1.Conjunction(BinaryExampleVar2) instanceof BinaryType);
        assertTrue(BinaryExampleVar3.Conjunction(BinaryExampleVar4)instanceof BinaryType);
        assertTrue(BinaryExampleVar1.Conjunction(BinaryExampleVar4) instanceof BinaryType);
        assertTrue(BinaryExampleVar2.Conjunction(BinaryExampleVar3) instanceof BinaryType);
        assertTrue(BinaryExample.Conjunction(TestBool) instanceof BinaryType);
        assertTrue(BinaryExample.Conjunction(BinaryTestNumber) instanceof BinaryType);
        assertEquals("0000101",((BinaryType)BinaryExampleVar1.Conjunction(BinaryExampleVar2)).getInfo());
        assertEquals("1110000001",((BinaryType)BinaryExampleVar3.Conjunction(BinaryExampleVar4)).getInfo());
        assertEquals("1000001",((BinaryType) BinaryExampleVar1.Conjunction(BinaryExampleVar4)).getInfo());
        assertEquals("0000000001",((BinaryType)BinaryExampleVar2.Conjunction(BinaryExampleVar3)).getInfo());
        assertEquals("1110001001",((BinaryType)BinaryExampleVar1.Conjunction(BinaryExampleVar3)).getInfo());
        assertEquals(BinaryExampleVar1.getInfo(),((BinaryType)BinaryExampleVar1.Conjunction(new BooleanType(true))).getInfo());
        assertEquals("0",((BinaryType)BinaryExampleVar2.Conjunction(new BooleanType(false))).getInfo());
        }
    @RepeatedTest(20)
    void DisjunctionBinaryTest(){
        var BinaryExampleVar1 = new BinaryType( "1001101");
        var BinaryExampleVar2 = new BinaryType("0101");
        var BinaryExampleVar3 = new BinaryType("1110011001");
        var BinaryExampleVar4 = new BinaryType("1100001");
        assertTrue(BinaryExampleVar1.Disjunction(BinaryExampleVar2) instanceof BinaryType);
        assertTrue(BinaryExampleVar3.Disjunction(BinaryExampleVar4)instanceof BinaryType);
        assertTrue(BinaryExampleVar1.Disjunction(BinaryExampleVar4) instanceof BinaryType);
        assertTrue(BinaryExampleVar2.Disjunction(BinaryExampleVar3) instanceof BinaryType);
        assertTrue(BinaryExample.Disjunction(TestBool) instanceof BinaryType);
        assertTrue(BinaryExample.Disjunction(BinaryTestNumber) instanceof BinaryType);
        assertEquals("1001101",((BinaryType)BinaryExampleVar1.Disjunction(BinaryExampleVar2)).getInfo());
        assertEquals("1111111001",((BinaryType)BinaryExampleVar3.Disjunction(BinaryExampleVar4)).getInfo());
        assertEquals("1101101",((BinaryType) BinaryExampleVar1.Disjunction(BinaryExampleVar4)).getInfo());
        assertEquals("1110011101",((BinaryType)BinaryExampleVar2.Disjunction(BinaryExampleVar3)).getInfo());
        assertEquals("1111011101",((BinaryType)BinaryExampleVar1.Disjunction(BinaryExampleVar3)).getInfo());
        assertEquals("1111111",((BinaryType)BinaryExampleVar1.Disjunction(new BooleanType(true))).getInfo());
        assertEquals(BinaryExampleVar2.getInfo(),((BinaryType)BinaryExampleVar2.Disjunction(new BooleanType(false))).getInfo());
    }
    @Test
    void NegationBinaryTest() {
        var BinaryExampleVar1 = new BinaryType("1001101");
        var BinaryExampleVar2 = new BinaryType("0101");
        var BinaryExampleVar3 = new BinaryType("1110011001");
        var BinaryExampleVar4 = new BinaryType("1100001");
        assertTrue(BinaryExampleVar1.Negation() instanceof BinaryType);
        assertTrue(BinaryExampleVar2.Negation() instanceof BinaryType);
        assertTrue(BinaryExampleVar3.Negation() instanceof BinaryType);
        assertTrue(BinaryExampleVar4.Negation() instanceof BinaryType);
        assertEquals("0110010", ((BinaryType)BinaryExampleVar1.Negation()).getInfo());
        assertEquals("1010",((BinaryType)BinaryExampleVar2.Negation()).getInfo());
        assertEquals("0001100110",((BinaryType)BinaryExampleVar3.Negation()).getInfo());
        assertEquals("0011110",((BinaryType)BinaryExampleVar4.Negation()).getInfo());
        //test about the double negation
        assertEquals("1110011001",((BinaryType)BinaryExampleVar3.Negation().Negation()).getInfo());
    }


}
