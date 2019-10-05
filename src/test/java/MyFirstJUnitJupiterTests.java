import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class MyFirstJUnitJupiterTests {

    @Test
    void additionTest() {
        assertEquals(2, 1 + 1);
        assertTrue(2 == 1 + 1);
    }
}
