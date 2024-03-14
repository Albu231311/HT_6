///Nery Molina 23218
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import java.util.LinkedHashMap;
public class LinkedHashMapTest {

    @Test
    public void testLinkedHashMap() {
        Map<String, Student> linkedHashMap = MapFactory.createMap("LinkedHashMap");
        assertTrue(linkedHashMap instanceof LinkedHashMap);
    }
}
