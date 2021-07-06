package cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes;

import cl.uchile.dcc.cc3002.ScrabbleProyect.AST.Node;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;

public abstract class ScrabbleType implements Node {

    /**
     * @return method that return a True if the class is an Extern Node, else, return a False if the class is an Internal Node
     * In this case, all Scrabble Type are Extern Nodes
     */
    @Override
    public boolean IsENode() {
        return true;
    }

    @Override
    public Node getLeft() {
        return null;
    }

    @Override
    public Node getRight() {
        return null;
    }

    @Override
    public ILogicOperations Conjunction(ILogicOperations integratedType) {
        return null;
    }

    @Override
    public ILogicOperations AndByBool(BooleanType ABoolean) {
        return null;
    }

    @Override
    public BinaryType AndByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public ILogicOperations Disjunction(ILogicOperations disjunctionType) {
        return null;
    }

    @Override
    public ILogicOperations OrByBool(BooleanType ABoolean) {
        return null;
    }

    @Override
    public BinaryType OrByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public ILogicOperations Negation() {
        return null;
    }

    @Override
    public IOperations Add(IOperations addedType) {
        return null;
    }

    @Override
    public StringType AddedByString(StringType AString) {
        return null;
    }

    @Override
    public FloatType AddedByFloat(FloatType AFloat) {
        return null;
    }

    @Override
    public IOperations AddedByInt(IntType AnInt) {
        return null;
    }

    @Override
    public BinaryType AddedByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public IOperations Subtract(IOperations subtractedType) {
        return null;
    }

    @Override
    public FloatType SubtractedByFloat(FloatType AFloat) {
        return null;
    }

    @Override
    public IOperations SubtractedByInt(IntType AnInt) {
        return null;
    }

    @Override
    public BinaryType SubtractedByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public IOperations Multiply(IOperations MultipliedType) {
        return null;
    }

    @Override
    public FloatType MultipliedByFloat(FloatType AFloat) {
        return null;
    }

    @Override
    public IOperations MultipliedByInt(IntType AnInt) {
        return null;
    }

    @Override
    public BinaryType MultipliedByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public IOperations Divide(IOperations DividedType) {
        return null;
    }

    @Override
    public FloatType DividedByFloat(FloatType AFloat) {
        return null;
    }

    @Override
    public IOperations DividedByInt(IntType AnInt) {
        return null;
    }

    @Override
    public BinaryType DividedByBinary(BinaryType ABinary) {
        return null;
    }

    /**
     * convert the Number in a String
     *
     * @return
     */
    @Override
    public StringType ToString() {
        return null;
    }

    /**
     * convert the Number in a Double
     *
     * @return
     */
    @Override
    public FloatType ToFloat() {
        return null;
    }

    /**
     * convert the Number in a Int
     *
     * @return
     */
    @Override
    public IntType ToInt() {
        return null;
    }

    /**
     * convert the Number in a Binary
     *
     * @return
     */
    @Override
    public BinaryType ToBinary() {
        return null;
    }
}
