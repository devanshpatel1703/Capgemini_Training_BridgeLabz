import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    private Task head;
    private Task tail;

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 1; temp != tail && i < position - 1; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task not found!");
    }

    public void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task: " + head.taskName + " (Priority: " + head.priority + ", Due: " + head.dueDate + ")");
            head = head.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + " (Task ID: " + temp.taskId + ", Due Date: " + temp.dueDate + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with the given priority.");
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskCircularLinkedList taskList = new TaskCircularLinkedList();

        while (true) {
            System.out.println("\nTask Scheduler");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Due Date: ");
                    String dueDate = scanner.nextLine();
                    if (choice == 1) taskList.addTaskAtBeginning(taskId, taskName, priority, dueDate);
                    else if (choice == 2) taskList.addTaskAtEnd(taskId, taskName, priority, dueDate);
                    else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        taskList.addTaskAtPosition(taskId, taskName, priority, dueDate, position);
                    }
                    break;
                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    taskList.removeTask(scanner.nextInt());
                    break;
                case 5:
                    taskList.viewCurrentTask();
                    break;
                case 6:
                    taskList.displayTasks();
                    break;
                case 7:
                    System.out.print("Enter Priority: ");
                    taskList.searchTaskByPriority(scanner.nextInt());
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
