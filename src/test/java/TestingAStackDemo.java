import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;

@DisplayName("A stack")
public class TestingAStackDemo {

    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @DisplayName("when new")
    @Nested
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing")
        class AfterPushing {

            String element = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(element);
            }

            @Test
            @DisplayName("returns the element when popped and stack is empty")
            void testReturnElementWhenPopped() {
                assertEquals(element, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("return the element when peeked and stack is not empty")
            void testReturnElementWhenPeeked() {
                assertEquals(element, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
