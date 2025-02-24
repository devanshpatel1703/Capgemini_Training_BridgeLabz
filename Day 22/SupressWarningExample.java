import java.util.ArrayList;

class WarningSuppressor {
    @SuppressWarnings("unchecked")
    public void uncheckedWarningExample() {
        ArrayList list = new ArrayList(); 
        list.add("Hello");
        list.add(123);
        
        System.out.println(list);
    }
}

public class SupressWarningExample {
    public static void main(String[] args) {
        WarningSuppressor suppressor = new WarningSuppressor();
        suppressor.uncheckedWarningExample();
    }
}
