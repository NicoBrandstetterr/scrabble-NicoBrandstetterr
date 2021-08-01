package cl.uchile.dcc.cc3002.ScrabbleProyect.AST;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations.*;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class AstTest {
    private Tree tree;
    private Tree tree2;
    private Tree tree3;
    private Tree treeEnunciado;
    private IntType Int1;
    private IntType Int2;
    private FloatType Fl1;
    private FloatType Fl2;
    private StringType Str1;
    private BooleanType Bool;
    private BinaryType Bin1;
    private BinaryType Bin2;

    @BeforeEach
    void setUp(){
        Int1 = new IntType(new Random().nextInt());
        Int2 = new IntType((new Random(new Random().nextInt())).nextInt(10000));
        Fl1 = new FloatType(Math.random() * 10000);
        Fl2 = new FloatType(Math.random()*2102);
        Str1 = new StringType("Test");
        Bool = new BooleanType(new Random().nextBoolean());
        Bin1= new BinaryType("10100110");
        Bin2 = new BinaryType("01011");
        tree = new Tree(new Multiply(new Sub(new Add(Fl2,Bin1),Fl1),new Divide(Int1,Bin2)));
        tree2 = new Tree(new Add(new Add(Str1,Str1),new Add(Int2,new Or(new And(new Sub(new Negation(Bin1),new Multiply(Int1,Bin2)),Bin2),Bool))));
        tree3 = new Tree(new Add(Str1,new Multiply(Fl1,new Divide(Int1,new Sub(Int2,new And(Bin1,new Or(Bin2,Bool)))))));
        treeEnunciado = new Tree(new Add(new FloatType(6.9),new Or(new BinaryType("1000"),new Add(new BinaryType("1011"),new IntType(25)))));
    }
    @RepeatedTest(40)
    void EvaluateAstTest(){
        BinaryType Bin1N = (BinaryType) Bin1.Negation();
        var TreeExpected = (FloatType)((Fl2.Add(Bin1)).Subtract(Fl1)).Multiply((Int1.Divide(Bin2)));
        var Tree2Expected = (StringType) (Str1.Add(Str1)).Add(Int2.Add((IOperations) (((ILogicOperations) Bin1N.Subtract(Int1.Multiply(Bin2))).Conjunction(Bin2)).Disjunction(Bool)));
        var Tree3Expected = (StringType) Str1.Add(Fl1.Multiply(Int1.Divide(Int2.Subtract((IOperations) Bin1.Conjunction(Bin2.Disjunction(Bool))))));
        assertEquals(TreeExpected.getInfo(),tree.Evaluate().getNodeInfo());
        assertEquals(Tree2Expected.getInfo(),tree2.Evaluate().getNodeInfo());
        assertEquals(Tree3Expected.getInfo(),tree3.Evaluate().getNodeInfo());
        assertEquals(2.9,Math.round((((Double)treeEnunciado.Evaluate().getNodeInfo())*1000.0))/1000.0); // I Use Math.round because the Tree.Evaluate() return 2.9000003

    }
}
