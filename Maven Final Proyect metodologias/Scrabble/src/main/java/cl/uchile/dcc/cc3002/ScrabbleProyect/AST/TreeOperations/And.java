package cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;

public class And extends AbstractAstOperations {
    public And (Node left, Node right){
        this.left = left;
        this.right = right;
    }

    /**
     * @return return the value contained in the external Node
     */
    @Override
    public Object getNodeInfo() {
        return "And";
    }
}
