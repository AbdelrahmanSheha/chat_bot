package application;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToDoListManager {
    private String filePath = "src/application/MyList.txt";

    public String readToDoList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder toDoList = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                toDoList.append(line).append("\n");
            }
            reader.close();
            return toDoList.toString();
        } catch (IOException e) {
            return "Oops! There was a problem reading the to-do list.";
        }
    }

    public String updateToDoList(List<String> newItems) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (String item : newItems) {
                writer.write(item + "\n");
            }
            writer.close();
            return "To-do list updated!";
        } catch (IOException e) {
            return "Oops! There was a problem updating the to-do list.";
        }
    }

    public String addItem(String newItem) {
        List<String> currentItems = new ArrayList<>(Arrays.asList(readToDoList().split("\n")));
        currentItems.add(newItem);
        String updateResponse = updateToDoList(currentItems);
        return updateResponse;
    }

    public String deleteItem(String itemToDelete) {
        List<String> currentItems = new ArrayList<>(Arrays.asList(readToDoList().split("\n")));
        boolean found = currentItems.remove(itemToDelete);
        if (found) {
            String updateResponse = updateToDoList(currentItems);
            return updateResponse;
        } else {
            return "Item not found in the to-do list.";
        }
    }
    
    public String updateEntireToDoList(String updatedList) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(updatedList);
            writer.close();
            return "To-do list updated!";
        } catch (IOException e) {
            return "Oops! There was a problem updating the to-do list.";
        }
    }
}
