
import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TestMain {
    @Test
    void testCopy() {
        byte src[] = {-34,83,-56,90,3,-5};
        ByteArrayInputStream bais = new ByteArrayInputStream(src);
        ByteArrayOutputStream baos = Main.copy(bais);
        byte dst[] = baos.toByteArray();
        Assertions.assertArrayEquals(src,dst);
    }

}