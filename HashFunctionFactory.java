///Estudiante1 Carlos Alburez #231311
public class HashFunctionFactory {
    public static IHashFunction createHashFunction(String type) {
        switch (type) {
            case "MD5":
                return new MD5HashFunction();
            case "SHA-1":
                return new SHA1HashFunction();
            case "Orgánica":
                return new OrganicHashFunction();
            default:
                throw new IllegalArgumentException("Tipo de función hash no válido: " + type);
        }
    }
}
