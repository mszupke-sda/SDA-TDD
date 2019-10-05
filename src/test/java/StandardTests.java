import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class StandardTests {

    private static int testValue = 99;

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll: test value = " + testValue++);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach: test value = " + testValue++);
    }

    @Test
    void succeedingTest() {
        System.out.println("succeedingTest: test value = " + testValue);
    }

    @Test
    void failingTest() {
        System.out.println("failingTest: test value = " + testValue);
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        System.out.println("skippedTest: test value = " + testValue);
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach: test value = " + testValue++);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll: test value = " + testValue++);
    }
}
