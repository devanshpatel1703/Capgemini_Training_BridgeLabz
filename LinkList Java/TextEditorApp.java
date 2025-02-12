import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState currentState;
    private int historySize = 10;
    private int currentSize = 0;

    TextEditor() {
        this.currentState = null;
    }

    void addState(String content) {
        TextState newState = new TextState(content);

        if (currentState == null) {
            currentState = newState;
        } else {
            if (currentSize == historySize) {
                removeOldestState();
            }
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
        }
        currentSize++;
    }

    void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current text state: " + currentState.content);
        } else {
            System.out.println("No text content.");
        }
    }

    private void removeOldestState() {
        if (currentState != null && currentState.prev != null) {
            currentState.prev = null;
            currentSize--;
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("Text Editor Options:");
            System.out.println("1. Type text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter text: ");
                String text = scanner.nextLine();
                editor.addState(text);
            } else if (choice == 2) {
                editor.undo();
            } else if (choice == 3) {
                editor.redo();
            } else if (choice == 4) {
                editor.displayCurrentState();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
