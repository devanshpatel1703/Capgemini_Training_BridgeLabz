import org.json.*;
import java.io.*;
import java.util.*;

public class ConvertJSONCSV {
    
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(jsonFile));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            br.close();
            
            JSONArray jsonArray = new JSONArray(jsonContent.toString());
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));
            bw.write("ID,Name,Age,Marks");
            bw.newLine();
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = jsonArray.getJSONObject(i);
                int id = student.getInt("id");
                String name = student.getString("name");
                int age = student.getInt("age");
                double marks = student.getDouble("marks");
                
                String record = id + "," + name + "," + age + "," + marks;
                bw.write(record);
                bw.newLine();
            }
            bw.close();
            System.out.println("CSV file created successfully: " + csvFile);
        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void csvToJson(String csvFile, String jsonFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String header = br.readLine(); 
            String line;
            JSONArray jsonArray = new JSONArray();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject student = new JSONObject();
                student.put("id", Integer.parseInt(data[0]));
                student.put("name", data[1]);
                student.put("age", Integer.parseInt(data[2]));
                student.put("marks", Double.parseDouble(data[3]));
                jsonArray.put(student);
            }
            br.close();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
            bw.write(jsonArray.toString(4)); 
            bw.close();
            System.out.println("JSON file created successfully: " + jsonFile);
        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        jsonToCsv(jsonFile, csvFile);

        String jsonOutputFile = "students_output.json";
        csvToJson(csvFile, jsonOutputFile);
    }
}
