import java.util.regex.*;

public class StringUtils {

    // Email validation
    public static boolean isValidEmail(String email) {
        if (email == null) return false;

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    // Phone number validation (supports + and 10–15 digits)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) return false;

        String phoneRegex = "^\\+?[0-9]{10,15}$";
        return Pattern.matches(phoneRegex, phoneNumber);
    }

    // Name validation (supports multiple words, no numbers)
    public static boolean isValidName(String name) {
        if (name == null) return false;

        String nameRegex = "^[A-Za-z]+( [A-Za-z]+)*$";
        return Pattern.matches(nameRegex, name.trim());
    }

    // Clean text (ONLY trim, no lowercase damage)
    public static String cleanText(String text) {
        if (text == null) return "";
        return text.trim();
    }

    // Safe split (handles missing commas better)
    public static String[] splitData(String data) {
        if (data == null) return new String[0];
        return data.split("\\s*,\\s*"); // trims spaces around commas
    }
}