///Estudiante1 Carlos Alburez #231311
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SHA1HashFunctionTest {

    @Test
    public void testSHA1Hash() {
        SHA1HashFunction sha1HashFunction = new SHA1HashFunction();
        String input = "HelloWorld";
        String expectedHash = "2ef7bde608ce5404e97d5f042f95f89f1c232871";
        assertEquals(expectedHash, sha1HashFunction.hash(input));
    }
}
