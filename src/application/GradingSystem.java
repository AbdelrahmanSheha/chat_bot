package application;


// import java.util.Scanner;

public class GradingSystem {
   // private Scanner scanner = new Scanner(System.in);
    private String currentStep = "start";
    private String name = "";
    private int points = 0;
    private String subject = "";

    public String handleInput(String userInput) {
        if (userInput.equalsIgnoreCase("exit")) {
            return "Exiting the Grading System. If you need further assistance, let me know!";
        }

        String response = "";

        if (currentStep.equals("start")) {
            if (userInput.equalsIgnoreCase("yes")) {
                currentStep = "name";
                response = "To calculate your exam outcome, please provide your name:";
            } else if (userInput.equalsIgnoreCase("no")) {
                response = "Exiting the Grading System. If you need further assistance, let me know!";
            } else {
                response = "Please respond with 'yes' or 'no'.";
            }
        } else if (currentStep.equals("name")) {
            name = userInput;
            currentStep = "points";
            response = "Enter points (1-100):";
        } else if (currentStep.equals("points")) {
            try {
                points = Integer.parseInt(userInput);
                if (points < 1 || points > 100) {
                    response = "Invalid points. Please enter points between 1 and 100:";
                } else {
                    currentStep = "subject";
                    response = "Enter subject:";
                }
            } catch (NumberFormatException e) {
                response = "Invalid input. Please enter a valid number for points:";
            }
        } else if (currentStep.equals("subject")) {
            subject = userInput;
            Student student = new Student(name, points, subject);
            response = student.toString() + "\n\nTo calculate another exam outcome, type '1' or 'grading system'. To exit, type 'exit'.";
            currentStep = "start"; // Reset the process
        }

        return response;
    }
}


