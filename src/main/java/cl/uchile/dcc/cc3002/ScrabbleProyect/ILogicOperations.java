package cl.uchile.dcc.cc3002.ScrabbleProyect;

public interface ILogicOperations {
    /*
    Logic Conjunction
     */
    //we define a method that allows the conjunction between type with another type
    void Conjunction (ILogicOperations integratedType);

    //Conjunctions that can occur
    void AndByBool(BooleanType ABoolean);
    void AndByBinary(BinaryType ABinary);

    /*
    Logic Disjunction
     */
    //we define a method that allows the Disjunction between type with another type
    void Disjunction (ILogicOperations disjunctionType);

    //Disjunctions that can occur
    void OrByBool(BooleanType ABoolean);
    void OrByBinary(BinaryType ABinary);

    /*
    Logic negation
     */
    //we define a method that allows the negation between type with another type
    void Negation(ILogicOperations negatedType);

    //Negations that can occur
    void NotByBool(BooleanType ABoolean);
    void NotByBinary(BinaryType ABinary);

}
