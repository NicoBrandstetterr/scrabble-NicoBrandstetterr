package cl.uchile.dcc.cc3002.ScrabbleProyect.AST;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ITransformationNumber;

public interface Node extends IOperations, ILogicOperations, ITransformationNumber {

    /**
     * @return method that return a True if the class is an Extern Node, else, return a False if the class is an Internal Node
     */
    boolean IsENode();

    /**
     * @return return the value contained in the external Node
     */
    Object getNodeInfo();

    Node getLeft();

    Node getRight();


}
