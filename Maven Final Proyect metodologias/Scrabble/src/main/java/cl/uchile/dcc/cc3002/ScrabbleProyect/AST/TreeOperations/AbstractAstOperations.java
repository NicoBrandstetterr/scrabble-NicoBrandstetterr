package cl.uchile.dcc.cc3002.ScrabbleProyect.AST.TreeOperations;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.*;

public abstract class AbstractAstOperations extends ScrabbleType implements Node {
    protected Node left;
    protected Node right;
    /**
     * @return method that return a True if the class is an Extern Node, else, return a False if the class is an Internal Node
     */
    @Override
    public boolean IsENode() {
        return false;
    }

    @Override
    public Node getLeft(){
        return this.left;
    }

    @Override
    public Node getRight(){
        return this.right;
    }


}
