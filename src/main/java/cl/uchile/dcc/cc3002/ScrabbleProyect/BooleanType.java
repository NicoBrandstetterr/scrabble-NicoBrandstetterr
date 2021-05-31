package cl.uchile.dcc.cc3002.ScrabbleProyect;

import java.util.Objects;

public class BooleanType implements ILogicOperations {
    private boolean aBoolean;
    @Override
    public int hashCode() {
        return Objects.hash(BooleanType.class);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BooleanType) {
            var o = (BooleanType) obj;
            return o.aBoolean == this.aBoolean;
        }
        return false;
    }
    // Constructor
    public BooleanType(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    //get and set
    public boolean getABoolean() {
        return this.aBoolean;
    }

    public void setABoolean(boolean aBoolean) {
        this.aBoolean=aBoolean;
    }

    public StringType ToString() {
        String s = String.valueOf(this.aBoolean);
        return new StringType(s);
    }
    public BooleanType ToBoolean() {
        return this;
    }

    @Override
    public ILogicOperations Conjunction(ILogicOperations integratedType) {
        return integratedType.AndByBool(this);
    }

    @Override
    public ILogicOperations AndByBool(BooleanType ABoolean) {
        return new BooleanType(this.aBoolean&&ABoolean.aBoolean);
    }

    @Override
    public BinaryType AndByBinary(BinaryType ABinary) {
        if (this.getABoolean() == true){
            return ABinary;
        }
        else{
            return new BinaryType("0");
        }
    }

    @Override
    public ILogicOperations Disjunction(ILogicOperations disjunctionType) {
        return disjunctionType.OrByBool(this);
    }

    @Override
    public ILogicOperations OrByBool(BooleanType ABoolean) {
        return new BooleanType(this.aBoolean||ABoolean.aBoolean);
    }

    @Override
    public BinaryType OrByBinary(BinaryType ABinary) {
        if (this.getABoolean() == true) {
            var length = ABinary.getABinary().length();
            int k = 0;
            String newBinary = "";
            while(k<length){
                newBinary = newBinary + 1;
                k+=1;
            }
            return new BinaryType(newBinary);
        }
        else {
            return ABinary;
        }
    }

    @Override
    public ILogicOperations Negation() {
        if(this.aBoolean == true) {
            return new BooleanType(false);
        }
        else{
            return new BooleanType(true);
        }
    }

}
