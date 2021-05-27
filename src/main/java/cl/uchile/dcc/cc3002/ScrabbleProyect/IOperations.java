package cl.uchile.dcc.cc3002.ScrabbleProyect;

//We define an interface that allows define the operations between each type
public interface IOperations {

    /*
    Add
     */
    //we define a method that allows add a type with another type
    IOperations Add (IOperations addedType);

    //sums that can occur
    StringType AddedByString (StringType AString);
    FloatType AddedByFloat (FloatType AFloat);
    IOperations AddedByInt (IntType AnInt);
    BinaryType AddedByBinary (BinaryType ABinary);

    /*
    Subtract
     */
    //we define a method that allows subtract a type with another type
    IOperations Subtract (IOperations subtractedType);

    /*Subtractions that can occur
    represent the left side of the operation
     */
    FloatType SubtractedByFloat(FloatType AFloat);
    IOperations SubtractedByInt(IntType AnInt);
    BinaryType SubtractedByBinary(BinaryType ABinary);

    /*
    Multiplication
     */
    //we define a method that allows multiply a type with another type
    IOperations Multiply (IOperations MultipliedType);

    //Multiplies that can occur
    FloatType MultipliedByFloat(FloatType AFloat);
    IOperations MultipliedByInt(IntType AnInt);
    BinaryType MultipliedByBinary(BinaryType ABinary);

    /*
    Division
     */
    //we define a method that allows divide a type with another type
    IOperations Divide (IOperations DividedType);

    //Divisions that can occur
    FloatType DividedByFloat(FloatType AFloat);
    IOperations DividedByInt(IntType AnInt);
    BinaryType DividedByBinary(BinaryType ABinary);
}
