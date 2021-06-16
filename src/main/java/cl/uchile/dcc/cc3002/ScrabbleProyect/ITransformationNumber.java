package cl.uchile.dcc.cc3002.ScrabbleProyect;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.BinaryType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.FloatType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.IntType;
import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.StringType;

public interface ITransformationNumber {
    /**
     * we define the conversions the Numbers can do
     */

    /**
     *  convert the Number in a String
     * @return
     */
    StringType ToString();

    /**
     *  convert the Number in a Double
     * @return
     */
    FloatType ToFloat();

    /**
     * convert the Number in a Int
     * @return
     */
    IntType ToInt();

    /**
     * convert the Number in a Binary
     * @return
     */
    BinaryType ToBinary();
}
