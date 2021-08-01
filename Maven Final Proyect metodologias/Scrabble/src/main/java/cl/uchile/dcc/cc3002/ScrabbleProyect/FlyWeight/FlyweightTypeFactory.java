package cl.uchile.dcc.cc3002.ScrabbleProyect.FlyWeight;

import cl.uchile.dcc.cc3002.ScrabbleProyect.ScrabbleTypes.*;

import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public class FlyweightTypeFactory implements IFlyWeightTypeFactory{

    private static HashMap <String,ScrabbleType> hashMap = new HashMap<>();

            /** the key of the map is the string given, for example, if the str given is int(20), this is the key, and the value will be new Inttype(20)
             * @return the value given
             */
    @Override
    public ScrabbleType use(String str) {
        ScrabbleType Re = null;
        String type = str.split("\\(")[0];
        String value = StringUtils.substringBetween(str, "(", ")");
        try{
            if (hashMap.containsKey(str)) {
                Re = hashMap.get(str);
            }
            else {
                if ("int".equalsIgnoreCase(type)) {
                    Re = new IntType((Integer.parseInt(value)));
                    hashMap.put(str, new IntType((Integer.parseInt(value))));
                }
                else if ("float".equalsIgnoreCase(type)||"double".equalsIgnoreCase(type)){
                    Re = new FloatType(Double.parseDouble(value));
                    hashMap.put(str, new FloatType(Double.parseDouble(value)));
                }
                else if ("bin".equalsIgnoreCase(type)||"binary".equalsIgnoreCase(type)){
                    Re = new BinaryType(value);
                    hashMap.put(str, new BinaryType(value));
                }
                else if ("str".equalsIgnoreCase(type)||"string".equalsIgnoreCase(type)){
                    Re = new StringType(value);
                    hashMap.put(str, new StringType(value));
                }
                else if ("bool".equalsIgnoreCase(type)||"boolean".equalsIgnoreCase(type)){
                    Re = new BooleanType(Boolean.parseBoolean(value));
                    hashMap.put(str, new BooleanType(Boolean.parseBoolean(value)));
                }
                else{
                    throw new TypeException("error");
                }
            }
        }
        catch (TypeException e) {
            System.out.println("Invalid Type inserted "+type);
        }
        return Re;
    }

}
