package ToDo.starter;

import ToDo.model.ToDO;
import ToDo.service.ToDoServiceImpl;

import java.util.Scanner;

public class Starter {
    final ToDO toDO;
    final ToDoServiceImpl toDoOperation;
    public Starter(ToDO toDO, ToDoServiceImpl toDoOperation) {
        this.toDO = toDO;
        this.toDoOperation = toDoOperation;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    Choose your steps:
                    1. See All Tasks
                    2. Add Task
                    3. Update Task
                    4. Remove Task
                    5. Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    toDoOperation.seeAllTask();
                    waitForEnter();
                }
                case 2 -> {
                    System.out.println("Enter task id:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter task title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter task status (1 for Done, 2 for InProgress):");
                    int statusInput = scanner.nextInt();
                    ToDO.Status s = (statusInput == 1) ? ToDO.Status.Done : ToDO.Status.InProgress;
                    toDoOperation.addTask(id, title,s );
                    waitForEnter();
                }
                case 3 -> {
                    System.out.println("Enter task id:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new task title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter task status (1 for Done, 2 for InProgress):");
                    int statusInput = scanner.nextInt();
                    ToDO.Status s = (statusInput == 1) ? ToDO.Status.Done : ToDO.Status.InProgress;
                    toDoOperation.updateTask(id, title, s);
                    waitForEnter();
                }
                case 4 -> {
                    System.out.println("Enter task id:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toDoOperation.removeTask(id);
                    waitForEnter();
                }
                case 5 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void waitForEnter() {
        System.out.println("Press Enter to return to the main menu...");
        new Scanner(System.in).nextLine(); // Wait for user to press Enter
    }
}