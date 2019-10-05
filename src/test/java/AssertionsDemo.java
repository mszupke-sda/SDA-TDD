import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    private final static Calculator calculator = new Calculator();

    private final static Person person = new Person("Jane", "Doe");

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(3, calculator.add(2, 1), "The optional failure message");

        // assertEquals(4, calculator.minus(6, 2));
        // assertEquals(4, calculator.multiply(2, 2));
        // assertEquals(4, calculator.divide(8, 2));

        assertEquals(0, calculator.divide(1, 0));
    }

    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    System.out.println("start assertAll first name");

                    // wykona się gdy poprzednia asercja jest prawidłowa
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    // asercja grupująca, wykona się niezależnie od wyniku wcześniejszej asercji
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    System.out.println("start assertAll last name");

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
                );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());

        System.out.println(exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(2), () -> { });
    }

    @Test
    void timeoutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMinutes(2), () -> "a result");
        assertEquals(result, "a result");
    }

    @Test
    void timeoutNotExceededWithMethod() {
        String result = assertTimeout(Duration.ofMinutes(2), AssertionsDemo::greeting);
        int nine = assertTimeout(Duration.ofMinutes(2), AssertionsDemo::nine);

        assertEquals("Hello, World!", result);
        assertEquals(9, nine);
    }

    @Test
    void timeoutExceeded() {
        // uruchamia przekazany fragment kodu w tym samym wątku i czeka na jego zakończenie.
        // Po zakończeniu sprawdza czy założony czas został przekroczony
        assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(100));

        // execution exceeded timeout of 10 ms by 91 ms
    }

    @Test
    void timeoutExceededWithPreemptivelyTermination() {
        // uruchamia przekazany fragment kodu w innym wątku i kończy go natychmiast po przekroczeniu założonego czasu
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> Thread.sleep(100));

        // execution timed out after 10 ms
    }

    private static String greeting() {
        return "Hello, World!";
    }

    private static int nine() {
        return 9;
    }
}
