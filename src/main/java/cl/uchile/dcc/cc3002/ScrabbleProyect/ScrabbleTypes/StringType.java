package cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes;

import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;

import java.util.Objects;

public class StringType extends ScrabbleType {
    private String AString;
    /*
    if two objects are equals, then their hashCodes are equals
     */
    @Override
    public int hashCode(){
        return Objects.hash(StringType.class);
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof StringType){
            var o = (StringType) obj;
            return o.AString == this.AString;
        }
        return false;
    }

    // Constructor
    public StringType(String AnString){
        this.AString =AnString;
    }

    //get and set
    public String getInfo() {
        return this.AString;
    }

    public void setAString(String AString) {
        this.AString = AString;
    }

    @Override
    public String toString(){
        return "{"+ AString +"}";
    }


    public StringType ToString() {
        return this;
    }


    @Override
    public IOperations Add(IOperations addedType) {

       return addedType.AddedByString(this);
    }

    @Override
    public StringType AddedByString(StringType AString) {
        return new StringType(AString.AString+this.AString);
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
    public IOperations DividedByInt(IntType AnInto) {
        return null;
    }

    @Override
    public BinaryType DividedByBinary(BinaryType ABinary) {
        return null;
    }

    /**
     * @return return the value contained in the external Node else return None
     */
    @Override
    public Object getNodeInfo() {
        return this.getInfo();
    }
}

