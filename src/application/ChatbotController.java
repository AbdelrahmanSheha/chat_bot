package application;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import application.WeatherApp;

public class ChatbotController {
    private TextArea chatArea;
    private TextField inputField;
    private ResponseManager responseManager = new ResponseManager();
    private GradingSystem gradingSystem = new GradingSystem();
    private boolean inGradingSystemMode = false;
    private boolean isGradingSystemStarting = false;
    private boolean isWeatherSystemStarting = false;
    private ToDoListManager toDoListManager = new ToDoListManager();
    
    
    private boolean inEditMode = false;

    public ChatbotController(TextArea chatArea, TextField inputField) {
        this.chatArea = chatArea;
        this.inputField = inputField;
    }

    public void handleSendButton() {
        String userMessage = inputField.getText().toLowerCase();
        chatArea.appendText("You: " + userMessage + "\n");
        inputField.clear();

        if (isWeatherSystemStarting) {
            try {
                String weatherInfo = WeatherApp.getWeatherInfo(userMessage);
                showResponse(weatherInfo);
            } catch (IOException e) {
                showResponse("Sorry, I couldn't get the weather information.");
            }
            isWeatherSystemStarting = false;
        } else if (inGradingSystemMode) {
            if (isGradingSystemStarting) {
                if (userMessage.equals("yes")) {
                    showResponse("Sure! Please tell me your name to calculate your exam outcome:");
                    isGradingSystemStarting = false;
                } else if (userMessage.equals("no")) {
                    showResponse("Exiting the Grading System. Let me know if you need help!");
                    inGradingSystemMode = false;
                    isGradingSystemStarting = false;
                } else {
                    showResponse("Please reply with 'yes' or 'no'.");
                }
            } else {
                String gradingResponse = gradingSystem.handleInput(userMessage);
                showResponse(gradingResponse);
                if (gradingResponse.startsWith("Exiting the Grading System")) {
                    inGradingSystemMode = false;
                }
            } }else if (userMessage.equals("3") || userMessage.equals("to do list")) {
                // Display options for editing or checking
                showResponse("You can choose to 'edit' or 'check' the to-do list.");

            } else if (userMessage.equals("edit")) {
                // Read and display the current to-do list
                String currentToDoList = toDoListManager.readToDoList();
                showResponse("Here's your current to-do list:\n" + currentToDoList);
                showResponse("Please provide the updated to-do list:");
                showResponse(currentToDoList);

                // state to handle the user's updated input
                inEditMode = true;

            } else if (inEditMode) {
                // Update the to-do list with the user's input 
                String updateResponse = toDoListManager.updateToDoList(Arrays.asList(userMessage.split("\n")));
                showResponse(updateResponse);
                inEditMode = false;
            }  else if (userMessage.equals("check")) {
                // Display the content of the to-do list
                String currentToDoList = toDoListManager.readToDoList();
                showResponse("Here's your to-do list:\n" + currentToDoList);
            }
         else {
            List<String> matchedKeywords = findMatchingKeywords(userMessage);
            if (!matchedKeywords.isEmpty()) {
                if (matchedKeywords.contains("grading system") || matchedKeywords.contains("1")) {
                    inGradingSystemMode = true;
                    isGradingSystemStarting = true;
                    showResponse("Sure! Do you want to start the grading system? Reply with 'yes' or 'no'.");
                } else if (matchedKeywords.contains("weather") || matchedKeywords.contains("2")) {
                    isWeatherSystemStarting = true;
                    showResponse("Sure! Please type the city name for weather information:");
                } else {
                    List<String> combinedResponses = new ArrayList<>();
                    for (String keyword : matchedKeywords) {
                        String randomResponse = responseManager.getResponse(keyword);
                        combinedResponses.add(randomResponse);
                    }
                    String combinedResponse = String.join(" ", combinedResponses);
                    showResponse(combinedResponse);
                }
            } else {
                String response = responseManager.getResponse(userMessage);
                showResponse(response);
            }
        }
    }

    private List<String> findMatchingKeywords(String text) {
        List<String> matchedKeywords = new ArrayList<>();
        for (String keyword : responseManager.getKeywords()) {
            if (text.contains(keyword)) {
                matchedKeywords.add(keyword);
            }
        }
        return matchedKeywords;
    }

    private void showResponse(String response) {
        chatArea.appendText("Bot: " + response + "\n");
    }
}
