///Nery Molina 23218
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void testTreeMap() {
        Map<String, Student> treeMap = MapFactory.createMap("TreeMap");
        assertTrue(treeMap instanceof TreeMap);
    }
}
