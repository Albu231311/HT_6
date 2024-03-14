///Estudiante1 Carlos Alburez #231311

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrganicHashFunctionTest {
    @Test
    public void testOrganicHash() {
        OrganicHashFunction organicHashFunction = new OrganicHashFunction();
        String input = "Helloword";
        assertEquals(input, organicHashFunction.hash(input));
    }
}