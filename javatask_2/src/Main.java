public class Main {

    public static void main(String[] args) {

        String[] dataset = {
                "Name: John Doe, Email: john.doe@example.com, Phone: +1234567890",
                "Name: Jane Smith, Email: jane.smith@example.com, Phone: +0987654321",
                "Name: Invalid User, Email: invalid-email, Phone: 12345"
        };

        int validCount = 0;
        int invalidCount = 0;

        for (String record : dataset) {

            System.out.println("\nProcessing record: " + record);

            try {
                String[] parts = StringUtils.splitData(record);

                String name = StringUtils.cleanText(parts[0].split(":")[1]);
                String email = StringUtils.cleanText(parts[1].split(":")[1]);
                String phone = StringUtils.cleanText(parts[2].split(":")[1]);

                boolean nameValid = StringUtils.isValidName(name);
                boolean emailValid = StringUtils.isValidEmail(email);
                boolean phoneValid = StringUtils.isValidPhoneNumber(phone);

                System.out.println("Name: " + name + " Valid: " + nameValid);
                System.out.println("Email: " + email + " Valid: " + emailValid);
                System.out.println("Phone: " + phone + " Valid: " + phoneValid);

                if (nameValid && emailValid && phoneValid) {
                    validCount++;
                } else {
                    invalidCount++;
                }

            } catch (Exception e) {
                System.out.println("Error processing record: " + e.getMessage());
                invalidCount++;
            }

            System.out.println("--------------------------------------------------");
        }

        // Final Summary (THIS impresses)
        System.out.println("\n===== FINAL REPORT =====");
        System.out.println("Total Records: " + dataset.length);
        System.out.println("Valid Records: " + validCount);
        System.out.println("Invalid Records: " + invalidCount);
    }
}