import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTestDemo {

    @Test
    @EnabledOnOs(OS.MAC)
    void onlyOnMacOs() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void testOnLinuxOrWindows() {

    }

    @Test
    @DisabledOnOs(OS.MAC)
    void notOnMacOs() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_12)
    void onlyOnJava12() {

    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitecture() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void onlyOnDeveloperWorkstation() {

    }

    @Test
    @EnabledIf("2 * 3 == 7")
    void willBeExecuted() {

    }
}
