import java.util.*;

class Task {
    String name;
    String time;
    String priority;

    Task(String name, String time, String priority) {
        this.name = name;
        this.time = time;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task: " + name + " | Time: " + time + " | Priority: " + priority;
    }
}

public class ToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Task> highPriority = new ArrayList<>();
        List<Task> mediumPriority = new ArrayList<>();
        List<Task> lowPriority = new ArrayList<>();

        System.out.println("Welcome to your Daily To-Do List!");

        String choice;
        do {
            System.out.print("\nEnter task name: ");
            String name = sc.nextLine();

            System.out.print("Enter timing for the task (e.g., 10:00 AM): ");
            String time = sc.nextLine();

            String priority;
            while (true) {
                System.out.print("Enter priority (High/Medium/Low): ");
                priority = sc.nextLine().toLowerCase();
                if (priority.equals("high") || priority.equals("medium") || priority.equals("low")) {
                    break;
                } else {
                    System.out.println("Invalid priority! Please enter High, Medium, or Low.");
                }
            }

            Task newTask = new Task(name, time, capitalize(priority));

            // Categorize task
            switch (priority) {
                case "high":
                    highPriority.add(newTask);
                    break;
                case "medium":
                    mediumPriority.add(newTask);
                    break;
                case "low":
                    lowPriority.add(newTask);
                    break;
            }

            System.out.print("Do you want to add another task? (yes/no): ");
            choice = sc.nextLine().toLowerCase();

        } while (choice.equals("yes"));

        // Displaying the tasks
        System.out.println("\n---------- Your Daily To-Do List ----------");

        System.out.println("\n[High Priority Tasks]");
        displayTasks(highPriority);

        System.out.println("\n[Medium Priority Tasks]");
        displayTasks(mediumPriority);

        System.out.println("\n[Low Priority Tasks]");
        displayTasks(lowPriority);

        System.out.println("\nAll the best for your day! 😊");
        sc.close();
    }

    public static void displayTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
