package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
            try{
            File ruta = new File("C:/Users/nicol/Documents/tareas DCC/Maven Final Proyect metodologias/Scrabble/src/main/java/cl/uchile/dcc/scrabble/gui");
            File file = new File(ruta,"ScrabbleBuilder.fxml");
            Parent root = FXMLLoader.load(file.toURL());
            stage.setTitle("Scrabble Final T3");
            int width = 536;
            int length = 711;
            var scene = new Scene(root, width, length);
            stage.setScene(scene);
            stage.show();
            }
            catch (Exception e){
                System.out.println("Algo salio mal "+e);
            }
    }

    public static void main(String[] args) {
        launch();
    }

}