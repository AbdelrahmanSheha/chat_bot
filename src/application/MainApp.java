package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author Abdelrahman Sheha
 * 
 * Die Hauptmethode ist der Ausgangspunkt der Anwendung.
 * Es handelt sich um die Methode, 
 * die beim Starten der Anwendung aufgerufen wird.
 *
 */
public class MainApp extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * 
     */

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bottweida");

        ChatbotUI chatbotUI = new ChatbotUI();
        Scene scene = new Scene(chatbotUI.getLayout(), 800, 500);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
