package cl.uchile.dcc.cc3002.ScrabbleProyect;


import java.util.Objects;

public class BinaryType implements ITransformationNumber,IOperations,ILogicOperations {
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
        var divideIn = ABinary.ToInt().getAnInt()/this.ToInt().getAnInt();
        var divide = new IntType(divideIn);
        return divide.ToBinary();
    }

    @Override
    public ILogicOperations Conjunction(ILogicOperations integratedType) {
        return integratedType.AndByBinary(this);
    }

    @Override
    public ILogicOperations AndByBool(BooleanType ABoolean) {
        if (ABoolean.getABoolean() == true){
            return this;
        }
        else{
            return new BinaryType("0");
        }
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
                if(this.getABinary().charAt(k) == ABinary.getABinary().charAt(k)){
                    strReturn = strReturn + this.getABinary().charAt(k);
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
        String strThis = "";
        String strOther = "";
        var strAux = "";
        //case where the length of the Binary that is on the right of the logic Operation is minor than the Binary on the left
        if(thisLength<otherLength){
            strThis = this.ABinary;
            strAux = String.valueOf(this.ABinary.charAt(0));
            int k = 0;
            //in the cycle,we add the first value of the Binary until the new Binary is equal to the another binary
            while(k<otherLength-thisLength){
                strThis = strAux + strThis;
                k+=1;
            }
            //now both Binaries have the same length
            String strReturn = "";
            k = 0;
            BinaryType newThis = new BinaryType(strThis);
            while(k<strThis.length()){
                //if the elements are equal, the result element is equal, else, is equal to 0
                if(newThis.getABinary().charAt(k) == ABinary.getABinary().charAt(k)){
                    strReturn = strReturn + newThis.getABinary().charAt(k);
                }
                else{
                    strReturn = strReturn+"0";
                }
                k+=1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        }
        else{
            int k = 0;
            strOther = ABinary.ABinary;
            strAux = String.valueOf(ABinary.ABinary.charAt(0));
            //in the cycle,we add the first value of the Binary until the new Binary is equal to the another binary
            while(k<thisLength-otherLength){
                strOther = strAux + strOther;
                k+=1;
            }
            //now both Binaries have the same length
            String strReturn = "";
            k = 0;
            BinaryType newOther = new BinaryType(strOther);
            while(k<strOther.length()){
                //if the elements are equal, the result element is equal, else, is equal to 0
                if(newOther.getABinary().charAt(k) == this.getABinary().charAt(k)){
                    strReturn = strReturn + newOther.getABinary().charAt(k);
                }
                else{
                    strReturn =strReturn+ "0";
                }
                k+=1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        }

    }

    @Override
    public ILogicOperations Disjunction(ILogicOperations disjunctionType) {
        return disjunctionType.OrByBinary(this);
    }

    @Override
    public ILogicOperations OrByBool(BooleanType ABoolean) {
        //if the boolean is true, then the result of OR operator is a binary with the same length but all the elements are 1
        if (ABoolean.getABoolean() == true) {
            var length = this.getABinary().length();
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
                if (this.getABinary().charAt(k) == ABinary.getABinary().charAt(k)) {
                    strReturn = strReturn + this.getABinary().charAt(k);
                } else {
                    strReturn = strReturn + "1";
                }
                k += 1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        }

        //if the function come here, means the binary length are different, so, we need to make the minor binary length turn the same length that the major.
        String strThis = "";
        String strOther = "";
        var strAux = "";
        //case where the length of the Binary that is on the right of the logic Operation is minor than the Binary on the left
        if (thisLength < otherLength) {
            strThis = this.ABinary;
            strAux = String.valueOf(this.ABinary.charAt(0));
            int k = 0;
            //in the cycle,we add the first value of the Binary until the new Binary is equal to the another binary
            while (k < otherLength - thisLength) {
                strThis = strAux + strThis;
                k += 1;
            }
            //now both Binaries have the same length
            String strReturn = "";
            k = 0;
            BinaryType newThis = new BinaryType(strThis);
            while (k < strThis.length()) {
                //if the elements are equal, the result element is equal, else, is equal to 1
                if (newThis.getABinary().charAt(k) == ABinary.getABinary().charAt(k)) {
                    strReturn = strReturn + newThis.getABinary().charAt(k);
                } else {
                    strReturn = strReturn + "1";
                }
                k += 1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        } else {
            int k = 0;
            strOther = ABinary.ABinary;
            strAux = String.valueOf(ABinary.ABinary.charAt(0));
            //in the cycle,we add the first value of the Binary until the new Binary is equal to the another binary
            while (k < thisLength - otherLength) {
                strOther = strAux + strOther;
                k += 1;
            }
            //now both Binaries have the same length
            String strReturn = "";
            k = 0;
            BinaryType newOther = new BinaryType(strOther);
            while (k < strOther.length()) {
                //if the elements are equal, the result element is equal, else, is equal to 1
                if (newOther.getABinary().charAt(k) == this.getABinary().charAt(k)) {
                    strReturn = strReturn + newOther.getABinary().charAt(k);
                } else {
                    strReturn = strReturn + "1";
                }
                k += 1;
            }
            var returnBin = new BinaryType(strReturn);
            return returnBin;
        }
    }

    /**
     * @return the inverted binary number
     */
    @Override
    public ILogicOperations Negation() {
        int k = 0;
        String binary = "";
        while (k <= this.getABinary().length()-1) {
            if (this.getABinary().charAt(k) == '0') {
                binary = binary+"1";
            }
            else {
                binary =binary+ "0";
            }
            k += 1;
        }
        return new BinaryType(binary);
    }
}
