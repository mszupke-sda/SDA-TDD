import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RepeatedTestDemo {

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo, TestReporter testReporter) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getDisplayName();
        testReporter.publishEntry(String.format("About to execute repetition %d of %d for %s", currentRepetition, totalRepetitions, methodName));
    }

    @RepeatedTest(10)
    void repeatedTest(TestInfo testInfo) {

    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        assertEquals("Repeat! 1/1", testInfo.getDisplayName());
    }
}
