import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks(boolean showCompleted) {
        boolean any = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.isCompleted() == showCompleted) {
                task.printTask(i + 1);
                any = true;
            }
        }
        if (!any) {
            System.out.println(showCompleted ? "No completed tasks." : "No pending tasks.");
        }
    }

    public boolean markTaskCompleted(int index) {
        if (index > 0 && index <= tasks.size()) {
            Task task = tasks.get(index - 1);
            task.markCompleted();
            return true;
        }
        return false;
    }

    public boolean deleteTask(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            return true;
        }
        return false;
    }

    public int getTotalTasks() {
        return tasks.size();
    }
}