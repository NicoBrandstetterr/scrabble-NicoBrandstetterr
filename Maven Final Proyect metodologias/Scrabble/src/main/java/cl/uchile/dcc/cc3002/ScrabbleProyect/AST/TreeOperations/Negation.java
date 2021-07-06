package cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;

public class Negation extends AbstractAstOperations{

    public Negation (Node right){
        this.right = right;
    }
    /**
     * @return return the value contained in the external Node
     */
    @Override
    public Object getNodeInfo() {
        return "Negation";
    }
}
