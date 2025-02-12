import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process tail;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
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
        System.out.println("Process not found!");
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes available for execution.");
            return;
        }
        Process temp = head;
        while (true) {
            if (temp.burstTime > 0) {
                System.out.println("Executing Process ID: " + temp.processId);
                if (temp.burstTime > timeQuantum) {
                    temp.burstTime -= timeQuantum;
                } else {
                    temp.burstTime = 0;
                    System.out.println("Process ID: " + temp.processId + " completed execution.");
                    removeProcess(temp.processId);
                }
            }
            temp = temp.next;
            if (head == null) break;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class CPUScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\nCPU Round Robin Scheduling");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Simulate Round Robin");
            System.out.println("4. Display Processes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processId = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = scanner.nextInt();
                    scheduler.addProcess(processId, burstTime, priority);
                    break;
                case 2:
                    System.out.print("Enter Process ID to Remove: ");
                    scheduler.removeProcess(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    scheduler.simulateRoundRobin(scanner.nextInt());
                    break;
                case 4:
                    scheduler.displayProcesses();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}