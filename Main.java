import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n=== Daily Task Reminder ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Pending Tasks");
            System.out.println("3. View Completed Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();

                    System.out.println("Enter Due Time:");
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Month: ");
                    int month = scanner.nextInt();
                    System.out.print("Day: ");
                    int day = scanner.nextInt();
                    System.out.print("Hour: ");
                    int hour = scanner.nextInt();
                    System.out.print("Minute: ");
                    int minute = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    LocalDateTime dueTime = LocalDateTime.of(year, month, day, hour, minute);
                    Task task = new Task(name, desc, dueTime);
                    manager.addTask(task);
                    System.out.println("✅ Task added.");
                    break;

                case 2:
                    System.out.println("\n📋 Pending Tasks:");
                    manager.displayTasks(false);
                    break;

                case 3:
                    System.out.println("\n✅ Completed Tasks:");
                    manager.displayTasks(true);
                    break;

                case 4:
                    System.out.println("\nEnter Task Number to Mark as Completed:");
                    manager.displayTasks(false);
                    System.out.print("Task number: ");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (manager.markTaskCompleted(completeIndex)) {
                        System.out.println("✅ Task marked as completed.");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("\nEnter Task Number to Delete:");
                    manager.displayTasks(false);
                    System.out.print("Task number: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (manager.deleteTask(deleteIndex)) {
                        System.out.println("🗑 Task deleted.");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                    break;

                case 6:
                    System.out.println("👋 Exiting... Stay productive!");
                    return;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}