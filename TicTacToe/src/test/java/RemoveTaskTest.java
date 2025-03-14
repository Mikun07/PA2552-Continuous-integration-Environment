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
    void testRemoveTask() {
        // Arrange
        Task newTask = new Task("Buy groceries");
        tasks.add(newTask);

        // Act
        boolean removed = tasks.remove(newTask);

        // Assert
        assertTrue(removed, "Task should be removed successfully");
        assertEquals(0, tasks.size(), "Task list should be empty after removal");
    }
}
