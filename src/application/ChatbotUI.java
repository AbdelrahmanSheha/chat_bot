package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class ChatbotUI {
    private TextArea chatArea = new TextArea();
    private TextField inputField = new TextField();
    private Button sendButton = new Button("SEND");
    private ChatbotController chatbotController = new ChatbotController(chatArea, inputField);
    
    public VBox getLayout() {
        chatArea.setEditable(false);
        chatArea.setPrefSize(600, 400);
        chatArea.setStyle("-fx-control-inner-background: white; -fx-text-fill: grey;");
        
        inputField.setPrefSize(600, 20);
        
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chatbotController.handleSendButton();
            }
        });
        
        // Enter key press
        inputField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    chatbotController.handleSendButton();
                }
            }
        });

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: grey;");
        layout.getChildren().addAll(chatArea, inputField, sendButton);
        
        return layout;
    }
}

