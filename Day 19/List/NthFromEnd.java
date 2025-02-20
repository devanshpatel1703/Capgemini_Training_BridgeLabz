import java.util.LinkedList;
import java.util.Iterator;

public class NthFromEnd {
    public static String nthFromEnd(LinkedList list, int n) {
        if(n <= 0) return null;
        Iterator lead = list.iterator();
        Iterator follow = list.iterator();
        for(int i = 0; i < n; i++) {
            if(lead.hasNext())
                lead.next();
            else
                return null;
        }
        while(lead.hasNext()){
            lead.next();
            follow.next();
        }
        return (String)follow.next();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        int n = 2;
        System.out.println(nthFromEnd(list, n));
    }
}
