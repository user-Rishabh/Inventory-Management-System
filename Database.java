import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Database {

    private static final String FILE_PATH = "data.json";

   
    public void writeJSONFile(JSONArray array) {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(array.toJSONString());
            file.close();
        } catch (IOException e) {}
    }

    
    public JSONArray readJSONFile() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(FILE_PATH);
            return (JSONArray) parser.parse(reader);
        } catch (Exception e) {
            return new JSONArray(); 
        }
    }

    
    public void addItem(String name, String qty, String price) {
        JSONArray arr = readJSONFile();

        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("qty", qty);
        obj.put("price", price);

        arr.add(obj);
        writeJSONFile(arr);
    }

    
    public void deleteItem(int index) {
        JSONArray arr = readJSONFile();
        arr.remove(index);
        writeJSONFile(arr);
    }
}
