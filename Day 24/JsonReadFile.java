import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReadFile {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("data.json")));
        JSONObject jsonObject = new JSONObject(content);

        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}