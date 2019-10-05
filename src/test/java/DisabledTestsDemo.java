import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTestsDemo {

    @Test
    @Disabled("disabled until bug #99 has been fixed")
    void testWillBeSkipped() {

    }

    @Test
    void testWillBeExecuted() {

    }
}
