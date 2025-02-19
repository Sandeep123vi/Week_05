package PracticeProblems.MergingTwoJSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {
    public static void main(String[] args) {
        // Defining two JSON objects as strings
        String json1 = "{ \"name\": \"Raj\", \"age\": 13 }";
        String json2 = "{ \"email\": \"raj@yahoo.com\"}";

        // Printing result
        System.out.println("Merged JSON: \n\n " + getMergedJSON(json1, json2));
    }

    public static String getMergedJSON(String json1, String json2) {
        String mergedJson = null;

        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON strings into ObjectNode
            ObjectNode objectNode1 = (ObjectNode) objectMapper.readTree(json1);
            ObjectNode objectNode2 = (ObjectNode) objectMapper.readTree(json2);

            // Merge the second JSON object into the first
            objectNode1.setAll(objectNode2);

            // Convert the merged ObjectNode back to a JSON string
            mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode1);
        } catch (Exception e) {
            System.out.println(e);
        }

        return mergedJson;
    }
}
