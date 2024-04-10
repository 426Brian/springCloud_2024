import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * ClassName: Test
 * Pacage: PACKAGE_NAME
 * Discription:
 *
 * @Author: Brian
 * @Create: 2024/4/10-17:49
 * Version: V1.0
 */
public class TestDemo {
    @Test
    public void test1(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
