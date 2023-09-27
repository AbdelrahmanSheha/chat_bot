package application;

// import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ResponseManager {
    private Map<String, List<String>> responses = new HashMap<>();
    private IntroductionResponses introResponses = new IntroductionResponses();
    private OtherResponses otherResponses = new OtherResponses();

    public ResponseManager() {
        initializeResponses();
    }
 
    public void initializeResponses() {
        introResponses.initializeResponses(responses);
        otherResponses.initializeResponses(responses);
            
    }

    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase();

        for (String keyword : responses.keySet()) {
            if (userInput.contains(keyword)) {
                List<String> possibleResponses = responses.get(keyword);
                if (!possibleResponses.isEmpty()) {
                    Random random = new Random();
                    int index = random.nextInt(possibleResponses.size());
                    return possibleResponses.get(index);
                }
            }
        }
        return "I Can't Understand";
    }

    public Set<String> getKeywords() {
        return responses.keySet();
    }
}
