package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Tree;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations.*;
import cl.uchile.dcc.cc3002.ScrabbleProyect.FlyWeight.FlyweightTypeFactory;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.StringType;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class ModelScrabble {
    static FlyweightTypeFactory Sc = new FlyweightTypeFactory();

    /**
     * @param str contain the tree built
     * @return a String with the result of the expression in Str.
     */
    public static String ReadResult(String str) {
        if (str.length() == 0) {
            return "";
        } else if (str.length() <= 7) {
            return "SyntaxError";
        } else if(!Parenthesis(str)){
            return "ParenthesisError";
        }
        else{
            return (String) new Tree(ScrabbleReader(str)).Evaluate().ToString().getNodeInfo();
        }
    }

    /**
     * @param str contain a piece of pseudo-code
     * @return True if the str have the same amount of left and right parenthesis, and return False if their are not equals.
     */
    private static boolean Parenthesis(String str){
        return StringUtils.countMatches(str, '(')==StringUtils.countMatches(str, ')');
    }

    /**
     * @param str contain a piece of pseudo-code
     * @return A node that contain the code that makes the entered expression explicit, which can be added to a Tree
     */
    public static Node ScrabbleReader(String str) {
        String right;
        String left;
        if (NextOperator(str) == 100000000) {
            String newStr = StringUtils.substringBetween(StringUtils.left(str, ModelScrabble.NextOperator(str)), "Sc.use(", ")") + ")";
            return Sc.use(newStr);
        } else {
            if (str.charAt(ModelScrabble.NextOperator(str)) == '¬') {
                right = str.substring(ModelScrabble.NextOperator(str) + 1);
                if(ModelScrabble.NextOperator(right)==100000000){
                    return new Negation(ScrabbleReader(right));}
                else{
                    right = str.substring(ModelScrabble.NextOperator(str) + 2,str.length()-1);
                    return new Negation(ScrabbleReader(right));
                }
            }
            if (NextOperator(str.substring(0, ModelScrabble.NextOperator(str))) == 100000000) {
                left = str.substring(0, ModelScrabble.NextOperator(str));
            } else {
                left = str.substring(1, ModelScrabble.NextOperator(str) - 1);
            }
            if (NextOperator(str.substring(ModelScrabble.NextOperator(str) + 1)) == 100000000) {
                right = str.substring(ModelScrabble.NextOperator(str) + 1);
            } else {
                right = str.substring(ModelScrabble.NextOperator(str) + 2, str.length() - 1);
            }
            if (str.charAt(ModelScrabble.NextOperator(str)) == '+') {
                return new Add(ScrabbleReader(left), ScrabbleReader(right));
            }
            else if (str.charAt(ModelScrabble.NextOperator(str)) == '-') {
                return new Sub(ScrabbleReader(left), ScrabbleReader(right));
            }
            else if (str.charAt(ModelScrabble.NextOperator(str)) == '*') {
                return new Multiply(ScrabbleReader(left), ScrabbleReader(right));
            }
            else if (str.charAt(ModelScrabble.NextOperator(str)) == '/') {
                return new Divide(ScrabbleReader(left), ScrabbleReader(right));
            }
            else if (str.charAt(ModelScrabble.NextOperator(str)) == '&') {
                return new And(ScrabbleReader(left), ScrabbleReader(right));
            }
            else if (str.charAt(ModelScrabble.NextOperator(str)) == '°') {
                return new Or(ScrabbleReader(left), ScrabbleReader(right));
            }
            else if (str.startsWith("ToBinary()", ModelScrabble.NextOperator(str)+1)) {
                return ScrabbleReader(left).ToBinary();
            }
            else if (str.startsWith("ToBool()", ModelScrabble.NextOperator(str)+1)) {
                return ScrabbleReader(left).ToString();
            }
            else if (str.startsWith("ToFloat()", ModelScrabble.NextOperator(str)+1)) {
                return ScrabbleReader(left).ToFloat();
            }
            else if (str.startsWith("ToInt()", ModelScrabble.NextOperator(str)+1)) {
                return ScrabbleReader(left).ToInt();
            }
            else if (str.startsWith("ToStr()", ModelScrabble.NextOperator(str)+1)) {
                return ScrabbleReader(left).ToString();
            }
            else{
                return new StringType("Error");
            }
        }
    }

    /**
     * @param str is a pseudo code
     * the method found the next Operator that should be used
     * @return the position of the operator
     */
    public static int NextOperator(String str) {
        int ParentIzq = 0;
        int ParentDer = 0;
        int Contador = 0;
        if((str.charAt(0) =='¬')){
            return Contador;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                ParentIzq = ParentIzq + 1;
            } else if (str.charAt(i) == ')') {
                ParentDer = ParentDer + 1;
                if (ParentDer == ParentIzq) {
                    Contador = i;
                    break;
                }
            }
            Contador = i;
        }
        int add = str.indexOf("+");
        int sub = str.indexOf("-");
        int mul = str.indexOf("*");
        int div = str.indexOf("/");
        int And = str.indexOf("&");
        int Or = str.indexOf("°");
        int Not = str.indexOf("¬");
        int ToBin = str.indexOf("ToBinary()");
        int ToBool = str.indexOf("ToBool()");
        int ToFlt = str.indexOf("ToFloat()");
        int ToInt = str.indexOf("ToInt()");
        int ToStr = str.indexOf("ToStr()");
        int [] l = {add, sub,mul, div,And, Or, Not, ToBin, ToBool, ToFlt, ToInt, ToStr};
        for (int i = 0; i < 12; ++i) {
            if (l[i] <0){
                l[i]=100000000;
            }
        }
        Arrays.sort(l);
        if(l[0]==100000000){
            return l[0];
        }
        else if(l[1]==100000000&&StringUtils.contains(str,'-')&&StringUtils.containsAny(str.substring(str.indexOf('-')+1,str.indexOf('-')+2),"1234567890")){
            return 100000000;
        }
        else {
            return Contador + 1;
        }
    }
}
