import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ToDoListTest {
    private ArrayList<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>(); // Initialize before each test
    }

    @Test
    void testAddTask() {
        // Arrange
        Task newTask = new Task("Buy groceries");

        // Act
        tasks.add(newTask);

        // Assert
        assertEquals(1, tasks.size(), "Task list should contain 1 task");
        assertEquals("Buy groceries", tasks.get(0).description, "Task description should match");
        assertFalse(tasks.get(0).isCompleted, "New task should not be marked as completed");
    }
}
