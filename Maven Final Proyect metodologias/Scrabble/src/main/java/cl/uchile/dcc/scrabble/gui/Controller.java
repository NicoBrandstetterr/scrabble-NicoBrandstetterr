package cl.uchile.dcc.scrabble.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextField TextBuild;

    //Operators Buttons
    @FXML
    public Button SumButton;
    @FXML
    public Button ResButton;
    @FXML
    public Button DivideButton;
    @FXML
    public Button MultButton;
    @FXML
    public Button AndButton;
    @FXML
    public Button OrButton;
    @FXML
    public Button NotButton;


    //Numbers buttons
    @FXML
    public Button Button1;
    @FXML
    public Button Button0;
    @FXML
    public Button Button5;
    @FXML
    public Button Button4;
    @FXML
    public Button Button3;
    @FXML
    public Button Button2;
    @FXML
    public Button Button6;
    @FXML
    public Button Button9;
    @FXML
    public Button Button8;
    @FXML
    public Button Button7;


    //ScrabbleTypeButtons
    @FXML
    public Button BinaryButton;
    @FXML
    public Button IntButton;
    @FXML
    public Button StringButton;
    @FXML
    public Button BooleanButton;
    @FXML
    public Button FloatButton;


    //AbecedaryButtons
    @FXML
    public Button ButtonM;

    @FXML
    public Button ButtonL;

    @FXML
    public Button ButtonK;

    @FXML
    public Button ButtonJ;

    @FXML
    public Button ButtonQ;

    @FXML
    public Button ButtonÑ;

    @FXML
    public Button ButtonP;

    @FXML
    public Button ButtonO;

    @FXML
    public Button ButtonN;

    @FXML
    public Button ButtonE;

    @FXML
    public Button ButtonB;

    @FXML
    public Button ButtonD;

    @FXML
    public Button ButtonC;

    @FXML
    public Button ButtonI;

    @FXML
    public Button ButtonH;

    @FXML
    public Button ButtonG;

    @FXML
    public Button ButtonF;
    @FXML
    public Button ButtonA;
    @FXML
    public Button ButtonZ;
    @FXML
    public Button ButtonU;

    @FXML
    public Button ButtonT;

    @FXML
    public Button ButtonS;

    @FXML
    public Button ButtonR;

    @FXML
    public Button ButtonY;

    @FXML
    public Button ButtonX;

    @FXML
    public Button ButtonW;

    @FXML
    public Button ButtonV;

    @FXML
    public Button SpaceButton;

    //Transformations Buttons
    @FXML
    public Button ToStringButton;
    @FXML
    public Button ToFloatButton;
    @FXML
    public Button ToIntButton;
    @FXML
    public Button ToBooleanButton;
    @FXML
    public Button ToBinaryButton;

    //Action Buttons
    @FXML
    public Button ResultButton;
    @FXML
    public Button ButtonPoint;
    @FXML
    public Button CancelButton;
    @FXML
    public Button Button01; //  (
    @FXML
    public Button Button011;//  )

    public static String Ans = "";

    /**
     * @param event is the event generated by a button
     * add a value on the TextField
     */
    @FXML
    public void AddValue(ActionEvent event){
        if (!((Button) event.getSource()).getText().equals("SPACE")) {
            TextBuild.setText(TextBuild.getText() + ((Button) event.getSource()).getText());
            Ans = Ans + ((Button) event.getSource()).getText();
        }
        else{
            TextBuild.setText(TextBuild.getText() + " ");
            Ans = Ans + " ";
        }
    }

    /**
     * @param event is the event generated by a logic operation button
     * add a logic operation on the TextField
     */
    @FXML
    public void AddLogicOperation(ActionEvent event){
        switch (((Button) event.getSource()).getText()){
            case "AND":
                TextBuild.setText(TextBuild.getText() + ")"+ "&");
                Ans = Ans + "))"+"&";
                break;
            case "OR":
                TextBuild.setText(TextBuild.getText() + ")"+ "°");
                Ans = Ans + "))"+"°";
                break;
            case "NOT":
                TextBuild.setText(TextBuild.getText() + "¬"+"(");
                Ans = Ans +"¬"+"(";
                break;
        }
    }

    /**
     * @param event is the event generated by a operation button
     * Add an operation on the TextField
     */
    @FXML
    public void AddOperation(ActionEvent event){
        TextBuild.setText(TextBuild.getText() + ")"+ ((Button) event.getSource()).getText());
        Ans = Ans + "))"+((Button) event.getSource()).getText();
    }

    /**
     * @param event is the event generated by a button
     * Add a ScrabbleType on the TextField
     */
    @FXML
    public void SelectScrabbleType(ActionEvent event){
        switch (((Button) event.getSource()).getText()) {
            case "BINARY":
                TextBuild.setText(TextBuild.getText() + "bin(");
                Ans = Ans + "Sc.use(bin(";
                break;
            case "BOOLEAN":
                TextBuild.setText(TextBuild.getText() + "bool(");
                Ans = Ans + "Sc.use(bool(";
                break;
            case "FLOAT":
                TextBuild.setText(TextBuild.getText() + "float(");
                Ans = Ans + "Sc.use(float(";
                break;
            case "INT":
                TextBuild.setText(TextBuild.getText() + "int(");
                Ans = Ans + "Sc.use(int(";
                break;
            case "STRING":
                TextBuild.setText(TextBuild.getText() + "str(");
                Ans = Ans + "Sc.use(str(";
                break;
            default:
        }
    }

    /**
     * @param event is the event generated by a button
     * Add a transformation on the TextField
     */
    @FXML
    public void MakeTransformation(ActionEvent event){
        switch (((Button) event.getSource()).getText()) {
            case "TO BINARY":
                TextBuild.setText(TextBuild.getText() + ").ToBinary()");
                Ans = Ans + ")).ToBinary()";
                break;
            case "TO BOOLEAN":
                TextBuild.setText(TextBuild.getText() + ").ToBool()");
                Ans = Ans + ")).ToBool()";
                break;
            case "TO FLOAT":
                TextBuild.setText(TextBuild.getText() + ").ToFloat()");
                Ans = Ans + ")).ToFloat()";
                break;
            case "TO INT":
                TextBuild.setText(TextBuild.getText() + ").ToInt()");
                Ans = Ans + ")).ToInt()";
                break;
            case "TO STRING":
                TextBuild.setText(TextBuild.getText() + ").ToStr()");
                Ans = Ans + ")).ToStr()";
                break;
            default:
        }
    }

    /**
     * Delete() Clean the TextField erasing everything inside it.
     */
    @FXML
    public void Delete(){
        TextBuild.setText("");
        Ans = "";
    }

    /**
     * MakeResult() set on the TextBuild the result obtained in the class ReadResult() from the ModelScrabble Class.
     */
    @FXML
    public void MakeResult(){
        TextBuild.setText(ModelScrabble.ReadResult(Ans));
        //extBuild.setText(Ans);  This comment is for the programmers, if something go wrong, you can apply that code, so you the calculator will return the internal code that the model use.
    }
}