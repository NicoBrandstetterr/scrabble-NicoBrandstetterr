package cl.uchile.dcc.cc3002.ScrabbleProyect.AST;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.StringType;

public class Tree implements ITree {
    private Node anNode;

    public Tree(Node anNode){
        this.anNode = anNode;
    }

    /**
     * The Evaluate method allows obtaining the result of an equation contained in an AST using recursion
     * @return
     */
    @Override
    public Node Evaluate() {

        return AuxEvaluate(anNode);
    }
    public Node AuxEvaluate(Node AuxNode){
        if (AuxNode.IsENode()){
            return AuxNode;
        }
        else if(AuxNode.getNodeInfo() == "Add"){
            return (Node) AuxEvaluate(AuxNode.getLeft()).Add(AuxEvaluate(AuxNode.getRight()));
        }
        else if(AuxNode.getNodeInfo() == "And"){
            return (Node) AuxEvaluate(AuxNode.getLeft()).Conjunction(AuxEvaluate(AuxNode.getRight()));
        }
        else if(AuxNode.getNodeInfo() == "Divide"){
            return (Node) AuxEvaluate(AuxNode.getLeft()).Divide(AuxEvaluate(AuxNode.getRight()));
        }
        else if(AuxNode.getNodeInfo() == "Multiply"){
            return (Node) AuxEvaluate(AuxNode.getLeft()).Multiply(AuxEvaluate(AuxNode.getRight()));
        }
        else if(AuxNode.getNodeInfo() == "Or"){
            return (Node) AuxEvaluate(AuxNode.getLeft()).Disjunction(AuxEvaluate(AuxNode.getRight()));
        }
        else if(AuxNode.getNodeInfo() == "Negation"){
            return AuxEvaluate((Node) AuxNode.getRight().Negation());
        }
        else {
            return (Node) AuxEvaluate(AuxNode.getLeft()).Subtract(AuxEvaluate(AuxNode.getRight()));
        }
    }
}
