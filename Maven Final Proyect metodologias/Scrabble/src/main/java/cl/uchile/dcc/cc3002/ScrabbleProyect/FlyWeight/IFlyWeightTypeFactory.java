package cl.uchile.dcc.cc3002.ScrabbleProyect.FlyWeight;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.ScrabbleType;

public interface IFlyWeightTypeFactory {

    /**
     * @return the value given
     */
    ScrabbleType use(String str);


}
