import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoListTest {
    private ArrayList<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
    }

    @Test
    void testAddTask() {
        Task newTask = new Task("Buy groceries");
        tasks.add(newTask);
        Assertions.assertEquals(1, tasks.size(), "Task list should contain 1 task");
        Assertions.assertEquals("Buy groceries", tasks.get(0).description, "Task description should match");
        Assertions.assertFalse(tasks.get(0).isCompleted, "New task should not be marked as completed");
    }

    @Test
    void testRemoveTaskSuccessfully() {
        Task task1 = new Task("Buy groceries");
        Task task2 = new Task("Go to gym");

        tasks.add(task1);
        tasks.add(task2);

        // Remove a task
        tasks.remove(task1);

        Assertions.assertEquals(1, tasks.size(), "Task list should contain 1 task after removal");
        Assertions.assertFalse(tasks.contains(task1), "Removed task should not be in the list");
    }

    @Test
    void testRemoveNonExistentTask() {
        Task task1 = new Task("Buy groceries");
        tasks.add(task1);

        Task nonExistentTask = new Task("Read a book");
        boolean removed = tasks.remove(nonExistentTask);

        Assertions.assertFalse(removed, "Removing a non-existent task should return false");
        Assertions.assertEquals(1, tasks.size(), "Task list should remain unchanged");
    }

    @Test
    void testRemoveTaskFromEmptyList() {
        boolean removed = tasks.remove(new Task("Buy groceries"));
        Assertions.assertFalse(removed, "Should return false when removing from an empty list");
    }
}
