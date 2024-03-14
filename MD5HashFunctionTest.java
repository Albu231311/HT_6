///Estudiante1 Carlos Alburez #231311
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MD5HashFunctionTest {

    @Test
    public void testMD5Hash() {
        MD5HashFunction md5HashFunction = new MD5HashFunction();
        String input = "HelloWorld";
        String expectedHash = "68e109f0f40ca72a15e05cc22786f8e6";
        assertEquals(expectedHash, md5HashFunction.hash(input));
    }
}
