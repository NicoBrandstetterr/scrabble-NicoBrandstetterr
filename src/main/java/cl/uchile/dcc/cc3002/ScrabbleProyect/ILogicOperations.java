package cl.uchile.dcc.cc3002.ScrabbleProyect;

public interface ILogicOperations {
    /*
    Logic Conjunction
     */
    //we define a method that allows the conjunction between type with another type
    ILogicOperations Conjunction (ILogicOperations integratedType);

    //Conjunctions that can occur
    ILogicOperations AndByBool(BooleanType ABoolean);
    BinaryType AndByBinary(BinaryType ABinary);

    /*
    Logic Disjunction
     */
    //we define a method that allows the Disjunction between type with another type
    ILogicOperations Disjunction (ILogicOperations disjunctionType);

    //Disjunctions that can occur
    ILogicOperations OrByBool(BooleanType ABoolean);
    BinaryType OrByBinary(BinaryType ABinary);

    /*
    Logic negation
     */
    //we define a method that allows the negation
    ILogicOperations Negation();

}
