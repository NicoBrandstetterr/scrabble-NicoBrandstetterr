package cl.uchile.dcc.cc3002.ScrabbleProyect;

import java.util.Objects;

public class BooleanType {
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
}
