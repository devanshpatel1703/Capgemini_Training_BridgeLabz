import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ListManager {
   public void addElement(List<Integer> list, int element) {
       if (list != null) {
           list.add(element);
       }
   }

   public void removeElement(List<Integer> list, int element) {
       if (list != null) {
           list.remove(Integer.valueOf(element));
       }
   }

   public int getSize(List<Integer> list) {
       return (list == null) ? 0 : list.size();
   }
}


class ListManagerTest {
   private ListManager listManager;
   private List<Integer> testList;

   @BeforeEach
   void setUp() {
       listManager = new ListManager();
       testList = new ArrayList<>();
   }

   @Test
   void testAddElement() {
       listManager.addElement(testList, 5);
       assertTrue(testList.contains(5));
       assertEquals(1, testList.size());

       listManager.addElement(testList, 10);
       assertTrue(testList.contains(10));
       assertEquals(2, testList.size());
   }

   @Test
   void testRemoveElement() {
       testList.add(5);
       testList.add(10);

       listManager.removeElement(testList, 5);
       assertFalse(testList.contains(5));
       assertEquals(1, testList.size());

       listManager.removeElement(testList, 20); 
       assertEquals(1, testList.size());
   }

   @Test
   void testGetSize() {
       assertEquals(0, listManager.getSize(testList));

       testList.add(1);
       testList.add(2);
       assertEquals(2, listManager.getSize(testList));

       testList.clear();
       assertEquals(0, listManager.getSize(testList));
   }

   @Test
   void testNullList() {
       assertEquals(0, listManager.getSize(null));
       listManager.addElement(null, 5);
       listManager.removeElement(null, 5); 
}
}
package AssignmentRegexJUnit;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ListManager {
   public void addElement(List<Integer> list, int element) {
       if (list != null) {
           list.add(element);
       }
   }

   public void removeElement(List<Integer> list, int element) {
       if (list != null) {
           list.remove(Integer.valueOf(element));
       }
   }

   public int getSize(List<Integer> list) {
       return (list == null) ? 0 : list.size();
   }
}


class ListManagerTest {
   private ListManager listManager;
   private List<Integer> testList;

   @BeforeEach
   void setUp() {
       listManager = new ListManager();
       testList = new ArrayList<>();
   }

   @Test
   void testAddElement() {
       listManager.addElement(testList, 5);
       assertTrue(testList.contains(5));
       assertEquals(1, testList.size());

       listManager.addElement(testList, 10);
       assertTrue(testList.contains(10));
       assertEquals(2, testList.size());
   }

   @Test
   void testRemoveElement() {
       testList.add(5);
       testList.add(10);

       listManager.removeElement(testList, 5);
       assertFalse(testList.contains(5));
       assertEquals(1, testList.size());

       listManager.removeElement(testList, 20); 
       assertEquals(1, testList.size());
   }

   @Test
   void testGetSize() {
       assertEquals(0, listManager.getSize(testList));

       testList.add(1);
       testList.add(2);
       assertEquals(2, listManager.getSize(testList));

       testList.clear();
       assertEquals(0, listManager.getSize(testList));
   }

   @Test
   void testNullList() {
       assertEquals(0, listManager.getSize(null));
       listManager.addElement(null, 5); 
       listManager.removeElement(null, 5); 
   }
}
