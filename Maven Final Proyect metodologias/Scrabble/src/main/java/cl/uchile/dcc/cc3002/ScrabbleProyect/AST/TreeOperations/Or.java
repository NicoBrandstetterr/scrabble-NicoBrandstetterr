package cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations;


import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;
import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Tree;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.BinaryType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.FloatType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.IntType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.StringType;

public class Or extends AbstractAstOperations{
    public Or (Node left, Node right){
        this.left = left;
        this.right = right;
    }

    /**
     * @return return the value contained in the external Node
     */
    @Override
    public Object getNodeInfo() {
        return "Or";
    }
    /**
     * convert the Number in a String
     *
     * @return
     */
    @Override
    public StringType ToString() {
        return new Tree(new Or(left,right)).Evaluate().ToString();
    }

    /**
     * convert the Number in a Double
     *
     * @return
     */
    @Override
    public FloatType ToFloat() {
        return new Tree(new Or(left,right)).Evaluate().ToFloat();
    }

    /**
     * convert the Number in a Int
     *
     * @return
     */
    @Override
    public IntType ToInt() {
        return new Tree(new Or(left,right)).Evaluate().ToInt();
    }

    /**
     * convert the Number in a Binary
     *
     * @return
     */
    @Override
    public BinaryType ToBinary() {
        return new Tree(new Or(left,right)).Evaluate().ToBinary();
    }
}
