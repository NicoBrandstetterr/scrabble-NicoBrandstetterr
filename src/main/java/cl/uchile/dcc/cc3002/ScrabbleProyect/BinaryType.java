package cl.uchile.dcc.cc3002.ScrabbleProyect;

import java.util.Objects;

public class BinaryType implements ITransformationNumber,IOperations {
    private String ABinary;
    /*
    if two objects are equals, then their hashCodes are equals
     */
    @Override
    public int hashCode(){
        return Objects.hash(BinaryType.class);
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof BinaryType){
            var o = (BinaryType) obj;
            return o.ABinary == this.ABinary;
        }
        return false;
    }

    // Constructor
    public BinaryType(String ABinary){
        this.ABinary =ABinary;
    }

    //get and set
    public String getABinary() {
        return this.ABinary;
    }
    public void setABinary(String ABinary) {
        this.ABinary = ABinary;
    }
    @Override
    public StringType ToString() {
        return new StringType(this.ABinary);
    }
    @Override
    public FloatType ToFloat() {
        return this.ToInt().ToFloat();
    }

    @Override
    public IntType ToInt() {
        return new IntType(AuxToInt(this.getABinary()));
    }

    @Override
    public BinaryType ToBinary() {
        return this;
    }

    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    public int AuxToInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    @Override
    public IOperations Add(IOperations addedType) {
       return addedType.AddedByBinary(this);
    }

    @Override
    public StringType AddedByString(StringType AString) {
        //we use the implemented ToString Transformation
        var add = AString.getAString() + this.ToString().getAString();
        return new StringType(add);
    }

    @Override
    public FloatType AddedByFloat(FloatType AFloat) {
        var add = AFloat.getADouble() + this.ToFloat().getADouble();
        return new FloatType(add);
    }

    @Override
    public IOperations AddedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var add = aux.getAnInt()+AnInt.getAnInt();
        return new IntType(add);
    }

    @Override
    public BinaryType AddedByBinary(BinaryType ABinary) {
        var addIn = ABinary.ToInt().getAnInt()+this.ToInt().getAnInt();
        var add = new IntType(addIn);
        return add.ToBinary();
    }

    @Override
    public IOperations Subtract(IOperations subtractedType) {
        return subtractedType.SubtractedByBinary(this);
    }

    @Override
    public FloatType SubtractedByFloat(FloatType AFloat) {
        var subtract = AFloat.getADouble() - this.ToFloat().getADouble();
        return new FloatType(subtract);
    }
    @Override
    public IOperations SubtractedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var subtract = AnInt.getAnInt()-aux.getAnInt();
        return new IntType(subtract);
    }
    @Override
    public BinaryType SubtractedByBinary(BinaryType ABinary) {
        var subtractIn = ABinary.ToInt().getAnInt()-this.ToInt().getAnInt();
        var subtract = new IntType(subtractIn);
        return subtract.ToBinary();
    }

    @Override
    public IOperations Multiply(IOperations MultipliedType) {
        return MultipliedType.MultipliedByBinary(this);
    }

    @Override
    public FloatType MultipliedByFloat(FloatType AFloat) {
        var multiply = AFloat.getADouble() * this.ToFloat().getADouble();
        return new FloatType(multiply);
    }

    @Override
    public IOperations MultipliedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var multiply = AnInt.getAnInt()*aux.getAnInt();
        return new IntType(multiply);
    }

    @Override
    public BinaryType MultipliedByBinary(BinaryType ABinary) {
        var multiplyIn = ABinary.ToInt().getAnInt()*this.ToInt().getAnInt();
        var multiply = new IntType(multiplyIn);
        return multiply.ToBinary();
    }

    @Override
    public IOperations Divide(IOperations DividedType) {
        return DividedType.DividedByBinary(this);
    }

    @Override
    public FloatType DividedByFloat(FloatType AFloat) {
        var divide = AFloat.getADouble() / this.ToFloat().getADouble();
        return new FloatType(divide);
    }

    @Override
    public IOperations DividedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var divide = AnInt.getAnInt()/aux.getAnInt();
        return new IntType(divide);
    }

    @Override
    public BinaryType DividedByBinary(BinaryType ABinary) {
        var divideIn = ABinary.ToInt().getAnInt()*this.ToInt().getAnInt();
        var divide = new IntType(divideIn);
        return divide.ToBinary();
    }
}
