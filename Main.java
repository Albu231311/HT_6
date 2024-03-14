/*Hoja de Trabajo #6
Carlos Alburez, Nery Molina
CLASE MAIN
 */
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargar estudiantes desde el archivo JSON
        List<Student> students = loadStudentsFromJSON("estudiantes.json");

        // Crear el mapa seleccionado por el usuario
        Map<String, Student> studentMap = createStudentMap(students);

        // Búsqueda por clave
        searchByKey(studentMap);

        // Búsqueda por nacionalidad
        searchByNationality(students);
    }

    private static List<Student> loadStudentsFromJSON(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Student>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private static Map<String, Student> createStudentMap(List<Student> students) {
        System.out.println("Seleccione el tipo de Mapa a utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume new line

        Map<String, Student> studentMap;
        switch (choice) {
            case 1:
                studentMap = new HashMap<>();
                break;
            case 2:
                studentMap = new TreeMap<>();
                break;
            case 3:
                studentMap = new LinkedHashMap<>();
                break;
            default:
                System.out.println("Opción no válida. Se utilizará HashMap por defecto.");
                studentMap = new HashMap<>();
                break;
        }

        System.out.println("Seleccione el tipo de función hash a utilizar:");
        System.out.println("1. MD5");
        System.out.println("2. SHA-1");
        System.out.println("3. Orgánica");

        int hashChoice = scanner.nextInt();
        scanner.nextLine(); // Consume new line

        IHashFunction hashFunction;
        switch (hashChoice) {
            case 1:
                hashFunction = new MD5HashFunction();
                break;
            case 2:
                hashFunction = new SHA1HashFunction();
                break;
            case 3:
                hashFunction = new OrganicHashFunction();
                break;
            default:
                System.out.println("Opción no válida. Se utilizará función hash orgánica por defecto.");
                hashFunction = new OrganicHashFunction();
                break;
        }

        // Llenar el mapa con estudiantes usando la función hash
        for (Student student : students) {
            String key = hashFunction.hash(student.getName()); // Utilizando el nombre como clave
            studentMap.put(key, student);
        }

        return studentMap;
    }

    private static void searchByKey(Map<String, Student> studentMap) {
        System.out.println("Ingrese el nombre para buscar al estudiante:");
        String key = scanner.nextLine();

        Student student = studentMap.get(key);
        if (student != null) {
            System.out.println("Estudiante encontrado:");
            System.out.println(student);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private static void searchByNationality(List<Student> students) {
        System.out.println("Ingrese la nacionalidad para buscar estudiantes:");
        String nationality = scanner.nextLine();

        // Utilizando función hash orgánica para manejar colisiones
        Map<String, List<Student>> nationalityMap = new HashMap<>();
        IHashFunction hashFunction = new OrganicHashFunction();
        for (Student student : students) {
            String key = hashFunction.hash(student.getNationality());
            List<Student> studentsWithSameNationality = nationalityMap.getOrDefault(key, new ArrayList<>());
            studentsWithSameNationality.add(student);
            nationalityMap.put(key, studentsWithSameNationality);
        }

        String searchKey = hashFunction.hash(nationality);
        List<Student> studentsByNationality = nationalityMap.getOrDefault(searchKey, new ArrayList<>());

        if (!studentsByNationality.isEmpty()) {
            System.out.println("Estudiantes con nacionalidad " + nationality + ":");
            for (Student student : studentsByNationality) {
                System.out.println(student);
            }
        } else {
            System.out.println("No se encontraron estudiantes con esa nacionalidad.");
        }
    }
}
