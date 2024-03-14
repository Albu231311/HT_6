///Nery Molina 23218
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    public static Map<String, Student> createMap(String type) {
        switch (type) {
            case "HashMap":
                return new HashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de Mapa no válido: " + type);
        }
    }
}

