import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task {
    private String name;
    private String description;
    private LocalDateTime dueTime;
    private String priority;
    private boolean isCompleted;

    public Task(String name, String description, LocalDateTime dueTime) {
        this.name = name;
        this.description = description;
        this.dueTime = dueTime;
        this.priority = classifyPriority();
        this.isCompleted = false;
    }

    private String classifyPriority() {
        long hoursLeft = LocalDateTime.now().until(dueTime, ChronoUnit.HOURS);
        if (containsUrgentKeywords(description) || hoursLeft < 4) {
            return "High";
        } else if (hoursLeft < 24) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    private boolean containsUrgentKeywords(String text) {
        String[] urgentKeywords = {"urgent", "asap", "important", "immediately", "now"};
        for (String word : urgentKeywords) {
            if (text.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void printTask(int index) {
        System.out.println(index + ". " + name);
        System.out.println("   Description: " + description);
        System.out.println("   Due: " + dueTime);
        System.out.println("   Priority: " + priority);
        System.out.println("   Status: " + (isCompleted ? "Completed ✅" : "Pending ⏳"));
    }
}