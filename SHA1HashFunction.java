///Estudiante1 Carlos Alburez #231311
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1HashFunction implements IHashFunction {

    @Override
    public String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = digest.digest(input.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
