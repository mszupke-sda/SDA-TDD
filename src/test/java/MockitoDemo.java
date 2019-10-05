import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static  org.junit.jupiter.api.Assertions.*;

public class MockitoDemo {

    @Mock
    private SimpleEntity globalSimpleEntity;

    public MockitoDemo() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        SimpleEntity simpleEntity = mock(SimpleEntity.class);
        // SimpleEntity simpleEntity = new SimpleEntity(new SecondEntity());

        when(simpleEntity.getUniqueId()).thenReturn(43).thenReturn(42);

        assertEquals(simpleEntity.getUniqueId(), 43);
        assertEquals(simpleEntity.getUniqueId(), 42);
    }

    @Test
    public void test2() {
        when(globalSimpleEntity.getUniqueId()).thenReturn(43);

        assertEquals(globalSimpleEntity.getUniqueId(), 43);
    }
}
