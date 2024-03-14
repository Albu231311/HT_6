///Nery Molina 23218
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import java.util.HashMap;

public class HashMapTest {

    @Test
    public void testHashMap() {
        Map<String, Student> hashMap = MapFactory.createMap("HashMap");
        assertTrue(hashMap instanceof HashMap);
    }
}
