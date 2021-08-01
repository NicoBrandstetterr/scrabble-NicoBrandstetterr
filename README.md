# scrabble-NicoBrandstetterr
scrabble-NicoBrandstetterr created by GitHub Classroom
In this project, native Java types were pigeonholed into classes for easier future
access. as here they will be differentiated from native Java types by calling them
Scrabble types. Currently, this project has 4 main functions. The first one is about
taking Scrabble types and giving them the ability to morph into as many other Scrabble
types as possible. The second function is the ability to operate between the different
types of Scrabble, being able to add, subtract, multiply, divide and operate according
to logical operators according to each case. The third Function, added in the current
installment of homework 2, was given the ability for the program to be able to build and 
evaluate an AST using the types and operations defined in the previous functions. The 4th
function was the implementation of a functionality that allows the program to store the values
that have been created so that it does not have to create them again.

The graphical interface is made up of the model named as: "ModelScrabble",
the controller named as: "Controller", and the view which is called "App".

The app works like a calculator. When entering the data, the following rules must be taken into
consideration:
- when entering a value you must first enter the Scrabble type to which this value belongs, which must be enclosed in parentheses.
- Unless it is an individual value (for example bin (1010)), it is very important that both the left and right side of an operation are enclosed in parentheses.
  Example: (....) + ((....). ToInt ())
  - the operations and the transformations add automatically the parenthesis on the left side, so if you will add more operations, you
  don´t have to add parenthesis.
- if The last number on the expression don´t have a transformation, you have to add 2 parenthesis.
  Ej: int(25)+int(4))
  
Is VERY important consider that everything work around parenthesis, so it is very important to consider that.

The Operator NOT has to be applied before the expression that you want to negate. If you want to negate 
a binary number for example, in the end of the expression you will have to add 3 parenthesis
