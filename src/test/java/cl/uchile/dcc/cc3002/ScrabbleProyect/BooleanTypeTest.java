package cl.uchile.dcc.cc3002.ScrabbleProyect;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.BinaryType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.BooleanType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.IntType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.StringType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanTypeTest {
    private boolean randomBool;
    private BooleanType TestBool;
    private BooleanType ExpectedBool;
    private BooleanType TrueBool = new BooleanType(true);
    private BooleanType FalseBool = new BooleanType(false);

    @BeforeEach
    void setUp() {
        randomBool = new Random().nextBoolean();
        TestBool = new BooleanType(randomBool);
        ExpectedBool = new BooleanType(randomBool);
    }

    @RepeatedTest(20)
    void constructorTest() {

        assertEquals(ExpectedBool, TestBool);
        assertEquals(ExpectedBool.hashCode(), TestBool.hashCode(), "failed hashcode test");
        assertFalse(TestBool.equals(new IntType(30)));
    }

    @Test
    void setABool() {
        assertNotEquals(TrueBool.getInfo(), FalseBool.getInfo());
        TrueBool.setABoolean(false);
        //Now, we corroborate IntExample value is equals to differentIntNumber value
        assertEquals(TrueBool.getInfo(), FalseBool.getInfo());
    }

    @Test
    void testToString() {
        String StringTest = "test";
        StringType TestString = new StringType(StringTest);
        assertNotEquals(TestBool.getClass(), TestString.getClass());
        assertEquals(TestBool.ToString().getClass(), TestString.getClass());
    }
    @RepeatedTest(20)
    void ToBoolTest(){
        assertEquals(TestBool,TestBool.ToBoolean());
    }
    @Test
    void ConjunctionBooleanTest(){
        var BinaryExampleVar1 = new BinaryType( "1001101");
        var BinaryExampleVar2 = new BinaryType("0101");
        assertTrue(TestBool.Conjunction(BinaryExampleVar1) instanceof BinaryType);
        assertEquals("1001101",((BinaryType)TrueBool.Conjunction(BinaryExampleVar1)).getInfo());
        assertEquals("0",((BinaryType)FalseBool.Conjunction(BinaryExampleVar1)).getInfo());
        assertEquals("0",((BinaryType)FalseBool.Conjunction(BinaryExampleVar2)).getInfo());
        assertEquals("0101",((BinaryType)TrueBool.Conjunction(BinaryExampleVar2)).getInfo());
        assertEquals(TestBool.getInfo()&& true,((BooleanType)TestBool.Conjunction(TrueBool)).getInfo());
        assertEquals(false,((BooleanType)TrueBool.Conjunction(FalseBool)).getInfo());
    }
    @Test
    void DisjunctionBooleanTest(){
        var BinaryExampleVar1 = new BinaryType( "1001101");
        var BinaryExampleVar2 = new BinaryType("0101");
        assertTrue(TestBool.Conjunction(BinaryExampleVar1) instanceof BinaryType);
        assertEquals("1111111",((BinaryType)TrueBool.Disjunction(BinaryExampleVar1)).getInfo());
        assertEquals("1001101",((BinaryType)FalseBool.Disjunction(BinaryExampleVar1)).getInfo());
        assertEquals("0101",((BinaryType)FalseBool.Disjunction(BinaryExampleVar2)).getInfo());
        assertEquals("1111",((BinaryType)TrueBool.Disjunction(BinaryExampleVar2)).getInfo());
        assertEquals(true,((BooleanType)TestBool.Disjunction(TrueBool)).getInfo());
        assertEquals(false,((BooleanType)FalseBool.Disjunction(FalseBool)).getInfo());

    }
    @RepeatedTest(20)
    void NegationBooleanTest(){
        assertEquals(false,((BooleanType)TrueBool.Negation()).getInfo());
        assertEquals(true,((BooleanType)FalseBool.Negation()).getInfo());
        assertNotEquals(TestBool,((BooleanType)TestBool.Negation()).getInfo());

    }
}
