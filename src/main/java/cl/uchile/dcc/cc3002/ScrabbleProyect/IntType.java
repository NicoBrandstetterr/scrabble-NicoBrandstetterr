package cl.uchile.dcc.cc3002.ScrabbleProyect;

import java.util.Objects;

public class IntType implements ITransformationNumber,IOperations {
    private int AnInt;

    /*
    if two objects are equals, then their hashCodes are equals
     */
    @Override
    public int hashCode() {
        return Objects.hash(IntType.class);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntType) {
            var o = (IntType) obj;
            return o.AnInt == this.AnInt;
        }
        return false;
    }

    // Constructor
    public IntType(int AnInt) {
        this.AnInt = AnInt;
    }

    //get and set
    public int getAnInt() {
        return this.AnInt;
    }

    public void setAnInt(int anInt) {
        this.AnInt = anInt;
    }

    @Override
    public String toString() {
        return "IntNumber{" + AnInt + "}";
    }

    @Override
    public StringType ToString() {
        String s = String.valueOf(this.AnInt);
        return new StringType(s);
    }

    @Override
    public FloatType ToFloat() {
        double x = this.AnInt;
        return new FloatType(x);
    }

    @Override
    public IntType ToInt() {
        return this;
    }

    @Override
    public BinaryType ToBinary() {
        //we create a variable that contain the absolute value of the instance
        int abThis = Math.abs(this.AnInt);
        //we convert Decimal To Binary
        String binary = "";

        while (abThis > 0) {
            binary = abThis % 2 + binary;
            abThis = abThis / 2;
        }
        //then, if thi.AnInt is positive, we use the binary String result, else we invert each binary element and add 1
        if (this.AnInt >= 0) {
            binary = 0 + binary;
            return new BinaryType(binary);
        } else {
            int length = binary.length() - 1;
            int k = 0;
            while (k <= length) {
                if (binary.charAt(k) == '0') {
                    String New = new StringBuilder(binary).replace(k, k + 1, "1").toString();
                    binary = New;
                } else {
                    String aNew = new StringBuilder(binary).replace(k, k + 1, "0").toString();
                    binary = aNew;
                }
                k += 1;
            }
            int l = binary.length() - 1;
            while (l >= 0) {
                if (binary.charAt(l) == '0') {
                    String New = new StringBuilder(binary).replace(l, l + 1, "1").toString();
                    binary = New;
                    break;
                } else {
                    String aNew = new StringBuilder(binary).replace(l, l + 1, "0").toString();
                    binary = aNew;
                }
                l -= 1;
            }

            binary = 1 + binary;
            return new BinaryType(binary);
        }
    }


    @Override
    //the task of deciding how to proceed is delegated to the added type
    public IOperations Add(IOperations addedType) {
       return addedType.AddedByInt(this);
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
        var add = AnInt.getAnInt()+this.getAnInt();
        return new IntType(add);
    }

    @Override
    public BinaryType AddedByBinary(BinaryType ABinary) {
        var add = ABinary.ToInt().getAnInt()+this.getAnInt();
        IntType aux = new IntType(add);
        return aux.ToBinary();
    }

    @Override
    public IOperations Subtract(IOperations subtractedType) {
        return subtractedType.SubtractedByInt(this);
    }

    @Override
    public FloatType SubtractedByFloat(FloatType AFloat) {
        var subtract = AFloat.getADouble() - this.ToFloat().getADouble();
        return new FloatType(subtract);
    }

    @Override
    public IOperations SubtractedByInt(IntType AnInt) {
        var subtract = AnInt.getAnInt()-this.getAnInt();
        return new IntType(subtract);
    }

    @Override
    public BinaryType SubtractedByBinary(BinaryType ABinary) {
        var subtract = ABinary.ToInt().getAnInt()-this.getAnInt();
        IntType aux = new IntType(subtract);
        return aux.ToBinary();
    }

    @Override
    public IOperations Multiply(IOperations MultipliedType) {
        return MultipliedType.MultipliedByInt(this);

    }

    @Override
    public FloatType MultipliedByFloat(FloatType AFloat) {
        var multiply = AFloat.getADouble() * this.ToFloat().getADouble();
        return new FloatType(multiply);
    }

    @Override
    public IOperations MultipliedByInt(IntType AnInt) {
        var multiply = AnInt.getAnInt()*this.getAnInt();
        return new IntType(multiply);
    }

    @Override
    public BinaryType MultipliedByBinary(BinaryType ABinary) {
        var multiply = ABinary.ToInt().getAnInt()*this.getAnInt();
        IntType aux = new IntType(multiply);
        return aux.ToBinary();
    }

    @Override
    public IOperations Divide(IOperations DividedType) {
        return DividedType.DividedByInt(this);
    }

    @Override
    public FloatType DividedByFloat(FloatType AFloat) {
        var divide = AFloat.getADouble() / this.ToFloat().getADouble();
        return new FloatType(divide);
    }

    @Override
    public IOperations DividedByInt(IntType AnInt) {
        int multiply = AnInt.getAnInt()/this.getAnInt();
        return new IntType(multiply);
    }

    @Override
    public BinaryType DividedByBinary(BinaryType ABinary) {
        var divide = ABinary.ToInt().getAnInt()/this.getAnInt();
        IntType aux = new IntType(divide);
        return aux.ToBinary();
    }
}


