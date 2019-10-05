import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
public class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name")
    void testWithCustomName() {

    }

    @Test
    @DisplayName("Another test case")
    void anotherTestWithCustomName() {

    }
}
