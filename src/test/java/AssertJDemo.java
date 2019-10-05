import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJDemo {

    @Nested
    @DisplayName("When boolean is true")
    class WhenBooleanIsTrue {

        @Test
        @DisplayName("should be true")
        void shouldBeTrue() {
            assertThat(true).isTrue();
        }
    }

    @Nested
    @DisplayName("when boolean is false")
    class WhenBooleanIsFalse {

        @Test
        @DisplayName("should be false")
        void shouldBeFalse() {
            assertThat(false).isFalse();
        }
    }

    @Nested
    @DisplayName("when object is null")
    class WhenObjectIsNull {

        private final Object NULL = null;

        @Test
        @DisplayName("should be null")
        void shouldBeNull() {
            assertThat(NULL).isNull();
        }
    }

    @Nested
    @DisplayName("when object is not null")
    class WhenObjectIsNotNull {

        @Test
        @DisplayName("should not be null")
        void shouldNotBeNull() {
            assertThat(new Object()).isNotNull();
        }
    }

    @Nested
    @DisplayName("when objects are integers")
    class WhenObjectsAreIntegers {

        private final Integer ACTUAL = 9;
        private final Integer EXPECTED = 9;
        private final Integer EXPECTED2 = 4;

        @Test
        @DisplayName("should be equal")
        void shouldBeEqual() {
            assertThat(ACTUAL).isEqualByComparingTo(EXPECTED);
        }

        @Test
        @DisplayName("should not be equal")
        void shouldNotBeEqual() {
            assertThat(ACTUAL).isNotEqualByComparingTo(EXPECTED2);
        }
    }

    @Nested
    @DisplayName("writing assertions for objects")
    class ObjectAssertionTest {

        private final Object ACTUAL = new Object();
        private final Object EXPECTED = ACTUAL;
        private final Object EXPECTED2 = new Object();

        @Test
        @DisplayName("should refer to same object")
        void shouldReferToSameObject() {
            assertThat(ACTUAL).isSameAs(EXPECTED);
        }

        @Test
        @DisplayName("should not refer to same object")
        void shouldNotReferToSameObject() {
            assertThat(ACTUAL).isNotSameAs(EXPECTED2);
        }
    }

    @Nested
    @DisplayName("When we write assertions directly to the thrown exception")
    class ExceptionAssertionTest {

        @Test
        @DisplayName("Should throw the correct exception")
        void shouldThrowCorrectException() {
            assertThatThrownBy(() -> { throw new NullPointerException(); }).isExactlyInstanceOf(NullPointerException.class);
        }
    }
}
