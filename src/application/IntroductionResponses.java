package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IntroductionResponses {
    public void initializeResponses(Map<String, List<String>> responses) {
    	
    	  List<String> greetingKeywords = new ArrayList<>(List.of(
    	            "hi", "hello", "hallo", "hey", "hi there", "hey there"));

    	        // list of responses for greetings
    	        List<String> greetingResponses = new ArrayList<>(List.of(
    	            "Hello, I am here to assist you:), How can I help you?!", "Hi there! How can I assist you?",
    	            "Hey there! I’m here to help :)", "Hii, how can I help you?", "Greetings! I am here to assist you!"));

    	        
    	        for (String keyword : greetingKeywords) {
    	            responses.put(keyword, greetingResponses);
    	        }
        responses.put("how are you", new ArrayList<>(List.of(
            "I'm good, thanks!", "I'm doing well!", "Feeling great!", "I'm fantastic!", "All good here!")));
        
        List<String> helpPhrases = new ArrayList<>(List.of(
            "help", "assist me", "what can you do", "what do you provide", "what can you offer me"));
        
        List<String> helpResponses = new ArrayList<>(List.of(
            "Hey there! I'm Bottweida, your friendly helper. I can provide valuable insights on different subjects:"
            + "\n1. Grading System\n2. Weather\n3. To do list \n4. Other topics"));
        
        
        for (String phrase : helpPhrases) {
            responses.put(phrase, helpResponses);
        }
        
        List<String> gradingSystemKeywords = new ArrayList<>(List.of(
                "grading system", "1"
                ));

            List<String> gradingSystemResponses = new ArrayList<>(List.of(
                "Sure! Do you want to start the grading system? Respond with 'yes' or 'no'."));

            for (String keyword : gradingSystemKeywords) {
                responses.put(keyword, gradingSystemResponses);
                
            }
            
            List<String> weatherKeywords = new ArrayList<>(List.of(
                    "weather", "2"));

                List<String> weatherResponses = new ArrayList<>(List.of(
                    "Sure! Please enter the city name for weather information:"));

                for (String keyword : weatherKeywords) {
                    responses.put(keyword, weatherResponses); } 
            
    }
    
}	