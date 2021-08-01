package cl.uchile.dcc.cc3002.ScrabbleProyect.FW;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Tree;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations.*;
import cl.uchile.dcc.cc3002.ScrabbleProyect.FlyWeight.FlyweightTypeFactory;
import cl.uchile.dcc.cc3002.ScrabbleProyect.FlyWeight.TypeException;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ObjectStreamClass;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlyWeightTest {
    FlyweightTypeFactory Sc = new FlyweightTypeFactory();

    //usaré los mismos test de AST
    private Tree tree;
    private Tree tree2;
    private Tree tree3;
    private Tree treeEnunciado;
    private String Int1;
    private String Int2;
    private String Fl1;
    private String Fl2;
    private String Str1;
    private String Bool;
    private String Bin1;
    private String Bin2;

    @BeforeEach
    void setUp() {
        Int1 = "int(" + new Random().nextInt() + ")";
        Int2 = "int(" + (new Random(new Random().nextInt())).nextInt(10000) + ")";
        Fl1 = "float(" + Math.random() * 10000 + ")";
        Fl2 = "float(" + Math.random() * 2102 + ")";
        Str1 = "string(Test)";
        Bool = "bool(" + new Random().nextBoolean() + ")";
        Bin1 = "bin(10100110)";
        Bin2 = "bin(01011)";
        tree = new Tree(new Multiply(new Sub(new Add(Sc.use(Fl2), Sc.use(Bin1)), Sc.use(Fl1)), new Divide(Sc.use(Int1), Sc.use(Bin2))));
        tree2 = new Tree(new Add(new Add(Sc.use(Str1), Sc.use(Str1)), new Add(Sc.use(Int2), new Or(new And(new Sub(Sc.use(Bin1), new Multiply(Sc.use(Int1), Sc.use(Bin2))), Sc.use(Bin2)), Sc.use(Bool)))));
        tree3 = new Tree(new Add(Sc.use(Str1), new Multiply(Sc.use(Fl1), new Divide(Sc.use(Int1), new Sub(Sc.use(Int2), new And(Sc.use(Bin1), new Or(Sc.use(Bin2), Sc.use(Bool))))))));
        treeEnunciado = new Tree(new Add(Sc.use("float(6.9)"), new Or(Sc.use("bin(1000)"), new Add(Sc.use("bin(1011)"), Sc.use("int(25)")))));
    }


    @RepeatedTest(100)
    void EvaluateAstTest() {
        var TreeExpected = (FloatType) ((Sc.use(Fl2).Add(Sc.use(Bin1))).Subtract(Sc.use(Fl1))).Multiply((Sc.use(Int1).Divide(Sc.use(Bin2))));
        var Tree2Expected = (StringType) (Sc.use(Str1).Add(Sc.use(Str1))).Add(Sc.use(Int2).Add((IOperations) (((ILogicOperations) Sc.use(Bin1).Subtract(Sc.use(Int1).Multiply(Sc.use(Bin2)))).Conjunction(Sc.use(Bin2))).Disjunction(Sc.use(Bool))));
        var Tree3Expected = (StringType) Sc.use(Str1).Add(Sc.use(Fl1).Multiply(Sc.use(Int1).Divide(Sc.use(Int2).Subtract((IOperations) Sc.use(Bin1).Conjunction(Sc.use(Bin2).Disjunction(Sc.use(Bool)))))));
        assertEquals(TreeExpected.getInfo(), tree.Evaluate().getNodeInfo());
        assertEquals(Tree2Expected.getInfo(), tree2.Evaluate().getNodeInfo());
        assertEquals(Tree3Expected.getInfo(), tree3.Evaluate().getNodeInfo());
        assertEquals(2.9, Math.round((((Double) treeEnunciado.Evaluate().getNodeInfo()) * 1000.0)) / 1000.0); // I Use Math.round because the Tree.Evaluate() return 2.9000003
    }

    @Test
    void testTypeException() {
        try {
            Sc.use("Err(20)");// is an error Type, for that reason the method will throw an exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
