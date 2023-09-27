package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OtherResponses {
    public void initializeResponses(Map<String, List<String>> responses) {
        responses.put("what is your name", new ArrayList<>(List.of(
            "I am Bottweida, your friendly chatbot")));
        responses.put("gender", new ArrayList<>(List.of(
            "I'm a chatbot, no gender here!")));
        responses.put("love you", new ArrayList<>(List.of(
            "I'm Feeling Shy :) Love you too", "Aw, that's sweet! Love you too!")));
        responses.put("bye", new ArrayList<>(List.of(
            "Too Soon :( Anyway\nSTAY HOME STAY SAFE", "Take care! Stay safe!", "Goodbye! Have a great day!")));
        responses.put("tell me a joke", new ArrayList<>(List.of(
            "Why don't scientists trust atoms? Because they make up everything!",
            "Parallel lines have so much in common. It's a shame they'll never meet.",
            "I told my wife she was drawing her eyebrows too high. She seemed surprised.")));
        responses.put("thank you", new ArrayList<>(List.of(
                "No problem!", "You are welcome!", "Anytime!")));
        responses.put("thanks", new ArrayList<>(List.of(
        		"No problem!", "You are welcome!", "Anytime!")));
       
       
    }
}