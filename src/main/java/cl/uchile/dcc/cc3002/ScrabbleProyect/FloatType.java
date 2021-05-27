package cl.uchile.dcc.cc3002.ScrabbleProyect;

import java.util.Objects;

public class FloatType implements ITransformationNumber,IOperations {
    private double aDouble;
    /*
    if two objects are equals, then their hashCodes are equals
     */
    @Override
    public int hashCode(){
        return Objects.hash(FloatType.class);
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof FloatType){
            var o = (FloatType) obj;
            return o.aDouble == this.aDouble;
        }
        return false;
    }

    // Constructor
    public FloatType(double aDouble){
        this.aDouble =aDouble;
    }

    //get and set
    public double getADouble() {
        return this.aDouble;
    }
    public void setADouble(double aDouble) {
        this.aDouble = aDouble;
    }

    @Override
    public String toString(){
        return "FloatNumber{"+ aDouble +"}";
    }

    @Override
    public StringType ToString() {
        String s = String.valueOf(this.aDouble);
        return new StringType(s);
    }

    @Override
    public FloatType ToFloat() {
        return this;
    }

    @Override
    public IntType ToInt() {
        return null;
    }
    @Override
    public BinaryType ToBinary() {
        return null;
    }

    @Override
    public IOperations Add(IOperations addedType) {

        return addedType.AddedByFloat(this);
    }
    @Override
    public StringType AddedByString(StringType AString) {
        var add = AString.getAString() + this.ToString().getAString();
        return new StringType(add);
    }
    @Override
    public FloatType AddedByFloat(FloatType AFloat) {
        var add = AFloat.getADouble()+this.getADouble();
        return new FloatType(add);
    }

    @Override
    public IOperations AddedByInt(IntType AnInt) {
        var add = AnInt.getAnInt()+this.getADouble();
        return new FloatType(add);
    }

    @Override
    public BinaryType AddedByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public IOperations Subtract(IOperations subtractedType) {
        return subtractedType.SubtractedByFloat(this);
    }

    @Override
    public FloatType SubtractedByFloat(FloatType AFloat) {
        var subtract = AFloat.getADouble()-this.getADouble();
        return new FloatType(subtract);
    }

    @Override
    public IOperations SubtractedByInt(IntType AnInt) {
        var subtract = AnInt.getAnInt()-this.getADouble();
        return new FloatType(subtract);
    }

    @Override
    public BinaryType SubtractedByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public IOperations Multiply(IOperations MultipliedType) {
        return MultipliedType.MultipliedByFloat(this);
    }

    @Override
    public FloatType MultipliedByFloat(FloatType AFloat) {
        var multiply = AFloat.getADouble()*this.getADouble();
        return new FloatType(multiply);
    }

    @Override
    public IOperations MultipliedByInt(IntType AnInt) {
        var multiply = AnInt.getAnInt()*this.getADouble();
        return new FloatType(multiply);
    }

    @Override
    public BinaryType MultipliedByBinary(BinaryType ABinary) {
        return null;
    }

    @Override
    public IOperations Divide(IOperations DividedType) {
        return DividedType.DividedByFloat(this);
    }

    @Override
    public FloatType DividedByFloat(FloatType AFloat) {
        var divide = AFloat.getADouble()/this.getADouble();
        return new FloatType(divide);
    }

    @Override
    public IOperations DividedByInt(IntType AnInt) {
        var divide = AnInt.getAnInt()/this.getADouble();
        return new FloatType(divide);
    }

    @Override
    public BinaryType DividedByBinary(BinaryType ABinary) {
        return null;
    }
}
