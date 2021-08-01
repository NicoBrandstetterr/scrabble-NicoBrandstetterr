/*
 * "Scrabble" (c) by Ignacio Slater M.
 * "Scrabble" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.cc3002.ScrabbleProyect;
import java.lang.*;
import java.util.Random;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations.*;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.*;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Tree;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations.*;
import cl.uchile.dcc.cc3002.ScrabbleProyect.FlyWeight.FlyweightTypeFactory;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.BinaryType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.IntType;
import cl.uchile.dcc.scrabble.gui.ModelScrabble;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public class JUnitTest {
  FlyweightTypeFactory Sc = new FlyweightTypeFactory();
  private String StrTreeEnunciado;
  private String StrTree1;
  private String Int1;
  private String Int2;
  private String Fl1;
  private String Fl2;
  private String Str1;
  private String Bool;
  private String Bin1;
  private String Bin2;
  private Tree tree;
  private Tree tree0;
  private String StrTree0;
  private Tree tree2;
  private Tree tree3;
  private String StrTree;
  private String StrTree2;
  private String StrTree3;
  @BeforeEach
  void SetUp(){
    Int1 = "int(" + new Random().nextInt() + ")";
    Int2 = "int(" + (new Random(new Random().nextInt())).nextInt(10000) + ")";
    Fl1 = "float(" + Math.random() * 10000 + ")";
    Fl2 = "float(" + Math.random() * 2102 + ")";
    Str1 = "str(Test)";
    Bool = "bool(" + new Random().nextBoolean() + ")";
    Bin1 = "bin(10100110)";
    Bin2 = "bin(01011)";
    StrTreeEnunciado ="Sc.use(float(6.9))+(Sc.use(bin(1000))°((Sc.use(int(25))-Sc.use(bin(0101))).ToBinary()))";
    StrTree1 ="(Sc.use(str(HO))+Sc.use(str(LA)))+(((Sc.use(int(2))).ToStr())+(((Sc.use(bin(101))-(Sc.use(int(10))*Sc.use(bin(1010))))&Sc.use(bin(1010)))°Sc.use(bool(false))))";
    tree0 = new Tree(new Add(new Sub(new Add(new Add(Sc.use(Int2), Sc.use(Bin1)).ToInt(), new Divide(new Multiply(Sc.use(Int1),Sc.use(Bin1)).ToInt(),new Sub(Sc.use(Int1),Sc.use(Int2)).ToInt())).ToBinary(), new Divide(Sc.use(Int1), Sc.use(Bin2)).ToBinary()).ToString(),new Add(new Or(Sc.use(Bin2),Sc.use(Bool)).ToString(),new Add(new And(Sc.use(Bin1),Sc.use(Bin2)).ToString(),new Divide(new And(Sc.use(Bin2),Sc.use(Bin1)).ToFloat(),new Or(Sc.use(Bin1),Sc.use(Bin1)).ToFloat()).ToString()))));
    StrTree0 = "((((((Sc.use("+Int2+")+Sc.use("+Bin1+")).ToInt())+(((Sc.use("+Int1+")*Sc.use("+Bin1+")).ToInt())/((Sc.use("+Int1+")-Sc.use("+Int2+")).ToInt()))).ToBinary())-((Sc.use("+Int1+")/Sc.use("+Bin2+")).ToBinary())).ToStr())+(((Sc.use("+Bin2+")°Sc.use("+Bool+")).ToStr())+(((Sc.use("+Bin1+")&Sc.use("+Bin2+")).ToStr())+((((Sc.use("+Bin2+")&Sc.use("+Bin1+")).ToFloat())/((Sc.use("+Bin1+")°Sc.use("+Bin1+")).ToFloat())).ToStr())))";
    tree = new Tree(new Multiply(new Sub(new Add(Sc.use(Fl2), Sc.use(Bin1)).ToFloat(), Sc.use(Fl1)).ToFloat(), new Divide(Sc.use(Int1), Sc.use(Bin2)).ToInt()).ToFloat());
    StrTree = "(((((Sc.use("+Fl2+")+Sc.use("+Bin1+")).ToFloat())-Sc.use("+Fl1+")).ToFloat())*((Sc.use("+Int1+")/Sc.use("+Bin2+")).ToInt())).ToFloat()";
    tree2 = new Tree(new Add(new Add(Sc.use(Str1), Sc.use(Str1)), new Add(Sc.use(Int2), new Or(new And(new Sub(Sc.use(Bin1), new Multiply(Sc.use(Int1), Sc.use(Bin2)).ToBinary()), Sc.use(Bin2)).ToBinary(), Sc.use(Bool)).ToInt()).ToString()));
    StrTree2 = "(Sc.use("+Str1+")+Sc.use("+Str1+"))+((Sc.use("+Int2+")+(((((Sc.use("+Bin1+")-((Sc.use("+Int1+")*Sc.use("+Bin2+")).ToBinary()))&Sc.use("+Bin2+")).ToBinary())°Sc.use("+Bool+")).ToInt())).ToStr())";
    tree3 = new Tree(new Add(Sc.use(Str1), new Multiply(Sc.use(Fl1), new Divide(Sc.use(Int1), new Sub(Sc.use(Int2), new And(Sc.use(Bin1), new Or(Sc.use(Bin2), Sc.use(Bool)).ToBinary()).ToInt())).ToFloat()).ToString()));
    StrTree3 ="Sc.use("+Str1+")+((Sc.use("+Fl1+")*((Sc.use("+Int1+")/(Sc.use("+Int2+")-((Sc.use("+Bin1+")&((Sc.use("+Bin2+")°Sc.use("+Bool+")).ToBinary())).ToInt()))).ToFloat())).ToStr())";
  }
  @Test
  public void test() {
    assertEquals("2.9000000000000004",ModelScrabble.ReadResult(StrTreeEnunciado));
    assertEquals("HOLA20111000",ModelScrabble.ReadResult(StrTree1));
    assertEquals(new Tree(new Negation(new BinaryType("0111000"))).Evaluate().getNodeInfo(),ModelScrabble.ReadResult("¬(Sc.use(bin(0111000)))"));
    assertEquals("",ModelScrabble.ReadResult(""));
    assertEquals("SyntaxError",ModelScrabble.ReadResult("Sc.us(3"));
    assertEquals("ParenthesisError",ModelScrabble.ReadResult("Sc.use(455))"));
  }
  @RepeatedTest(40)
    public void RTest() {
    assertEquals(tree3.Evaluate().ToString().getInfo(), ModelScrabble.ReadResult(StrTree3));
    assertEquals(tree2.Evaluate().ToString().getInfo(),ModelScrabble.ReadResult(StrTree2));
    assertEquals(tree.Evaluate().ToString().getInfo(),ModelScrabble.ReadResult(StrTree));
    assertEquals(tree0.Evaluate().ToString().getInfo(),ModelScrabble.ReadResult(StrTree0));


  }

}