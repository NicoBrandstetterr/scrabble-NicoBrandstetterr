package cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ILogicOperations;
import cl.uchile.dcc.cc3002.ScrabbleProyect.IOperations;

import java.util.Objects;

public class BinaryType extends ScrabbleType {
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
    public String getInfo() {
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
        return new IntType(AuxToInt(this.getInfo()));
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
        var add = AString.getInfo() + this.ToString().getInfo();
        return new StringType(add);
    }

    @Override
    public FloatType AddedByFloat(FloatType AFloat) {
        var add = AFloat.getInfo() + this.ToFloat().getInfo();
        return new FloatType(add);
    }

    @Override
    public IOperations AddedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var add = aux.getInfo()+AnInt.getInfo();
        return new IntType(add);
    }

    @Override
    public BinaryType AddedByBinary(BinaryType ABinary) {
        var addIn = ABinary.ToInt().getInfo()+this.ToInt().getInfo();
        var add = new IntType(addIn);
        return add.ToBinary();
    }

    @Override
    public IOperations Subtract(IOperations subtractedType) {
        return subtractedType.SubtractedByBinary(this);
    }

    @Override
    public FloatType SubtractedByFloat(FloatType AFloat) {
        var subtract = AFloat.getInfo() - this.ToFloat().getInfo();
        return new FloatType(subtract);
    }
    @Override
    public IOperations SubtractedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var subtract = AnInt.getInfo()-aux.getInfo();
        return new IntType(subtract);
    }
    @Override
    public BinaryType SubtractedByBinary(BinaryType ABinary) {
        var subtractIn = ABinary.ToInt().getInfo()-this.ToInt().getInfo();
        var subtract = new IntType(subtractIn);
        return subtract.ToBinary();
    }

    @Override
    public IOperations Multiply(IOperations MultipliedType) {
        return MultipliedType.MultipliedByBinary(this);
    }

    @Override
    public FloatType MultipliedByFloat(FloatType AFloat) {
        var multiply = AFloat.getInfo() * this.ToFloat().getInfo();
        return new FloatType(multiply);
    }

    @Override
    public IOperations MultipliedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var multiply = AnInt.getInfo()*aux.getInfo();
        return new IntType(multiply);
    }

    @Override
    public BinaryType MultipliedByBinary(BinaryType ABinary) {
        var multiplyIn = ABinary.ToInt().getInfo()*this.ToInt().getInfo();
        var multiply = new IntType(multiplyIn);
        return multiply.ToBinary();
    }

    @Override
    public IOperations Divide(IOperations DividedType) {
        return DividedType.DividedByBinary(this);
    }

    @Override
    public FloatType DividedByFloat(FloatType AFloat) {
        var divide = AFloat.getInfo() / this.ToFloat().getInfo();
        return new FloatType(divide);
    }

    @Override
    public IOperations DividedByInt(IntType AnInt) {
        var aux = this.ToInt();
        var divide = AnInt.getInfo()/aux.getInfo();
        return new IntType(divide);
    }

    @Override
    public BinaryType DividedByBinary(BinaryType ABinary) {
        var divideIn = ABinary.ToInt().getInfo()/this.ToInt().getInfo();
        var divide = new IntType(divideIn);
        return divide.ToBinary();
    }

    @Override
    public ILogicOperations Conjunction(ILogicOperations integratedType) {
        return integratedType.AndByBinary(this);
    }

    @Override
    public ILogicOperations AndByBool(BooleanType ABoolean) {
        if (ABoolean.getInfo() == true){
            return this;
        }
        else{
            return new BinaryType("0");
        }
    }

    /**
     * @return make the minor binary length turn the same length that the major.
     */
    private BinaryType EqualizeBinary(BinaryType minBinary, BinaryType maxBinary){
        var strAux = String.valueOf(minBinary.ABinary.charAt(0));
        int k = 0;
        String strMin = minBinary.getInfo();
        //in the cycle,we add the first value of the Binary until the new Binary is equal to the another binary
        while(k<maxBinary.getInfo().length()-strMin.length()){
            strMin = strAux + strMin;
            k+=1;
        }
        return new BinaryType(strMin);
    }
    @Override
    public BinaryType AndByBinary(BinaryType ABinary) {
        /*
        * We save the length of the Binaries in variables
         */
        var thisLength = this.ABinary.length();
        var otherLength = ABinary.ABinary.length();
        /*
        * Case where both Length are equals
         */
        if(thisLength==otherLength){
            String strReturn = "";
            int k = 0;
            while(k<thisLength){
                //if the elements are equal, the result element is equal, else, is equal to 0
                if(this.getInfo().charAt(k) == ABinary.getInfo().charAt(k)){
                    strReturn = strReturn + this.getInfo().charAt(k);
                }
                else{
                    strReturn = strReturn+"0";
                }
                k+=1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        }
        //if the function come here, means the binary length are different, so, we need to make the minor binary length turn the same length that the major.
        //case where the length of the Binary that is on the right of the logic Operation is minor than the Binary on the left
        if(thisLength<otherLength){
            BinaryType BStrThis = EqualizeBinary(this,ABinary);
            return BStrThis.AndByBinary(ABinary);
        }
        else{
            BinaryType BStrOther = EqualizeBinary(ABinary,this);
            return BStrOther.AndByBinary(this);
        }
    }
    @Override
    public ILogicOperations Disjunction(ILogicOperations disjunctionType) {
        return disjunctionType.OrByBinary(this);
    }

    @Override
    public ILogicOperations OrByBool(BooleanType ABoolean) {
        //if the boolean is true, then the result of OR operator is a binary with the same length but all the elements are 1
        if (ABoolean.getInfo() == true) {
            var length = this.getInfo().length();
            int k = 0;
            String newBinary = "";
            while(k<length){
                newBinary = newBinary + 1;
                k+=1;
            }
            return new BinaryType(newBinary);
        }
        else {
            return this;
        }
    }

    @Override
    public BinaryType OrByBinary(BinaryType ABinary) {
        /*
         * We save the length of the Binaries in variables
         */
        var thisLength = this.ABinary.length();
        var otherLength = ABinary.ABinary.length();
        /*
         * Case where both Length are equals
         */
        if (thisLength == otherLength) {
            String strReturn = "";
            int k = 0;
            while (k < thisLength) {
                //if the elements are equal, the result element is equal, else, is equal to 1
                if (this.getInfo().charAt(k) == ABinary.getInfo().charAt(k)) {
                    strReturn = strReturn + this.getInfo().charAt(k);
                } else {
                    strReturn = strReturn + "1";
                }
                k += 1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        }

        //if the function come here, means the binary length are different, so, we need to make the minor binary length turn the same length that the major.
        //case where the length of the Binary that is on the right of the logic Operation is minor than the Binary on the left
        if (thisLength < otherLength) {
            BinaryType BStrThis = EqualizeBinary(this,ABinary);
            return BStrThis.OrByBinary(ABinary);
        }
        else {
            BinaryType BStrOther = EqualizeBinary(ABinary,this);
            return BStrOther.OrByBinary(this);
        }
    }

    /**
     * @return the inverted binary number
     */
    @Override
    public ILogicOperations Negation() {
        int k = 0;
        String binary = "";
        while (k <= this.getInfo().length()-1) {
            if (this.getInfo().charAt(k) == '0') {
                binary = binary+"1";
            }
            else {
                binary =binary+ "0";
            }
            k += 1;
        }
        return new BinaryType(binary);
    }

    /**
     * @return return the value contained in the external Node else return None
     */
    @Override
    public Object getNodeInfo() {
        return this.getInfo();
    }
}
