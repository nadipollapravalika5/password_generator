package guess;



import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Enter password length: ");
        int length = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = sc.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecials = sc.nextLine().equalsIgnoreCase("yes");

        // Character sets
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specials = "!@#$%^&*()-_=+<>?/";

        // Build allowed characters based on user choice
        String allowed = letters;
        if (includeNumbers) allowed += numbers;
        if (includeSpecials) allowed += specials;

        // Ensure password starts with a letter
        StringBuilder password = new StringBuilder();
        password.append(letters.charAt(rnd.nextInt(letters.length())));

        // Fill the rest randomly
        for (int i = 1; i < length; i++) {
            password.append(allowed.charAt(rnd.nextInt(allowed.length())));
        }

        System.out.println("\nGenerated Password: " + password);
        sc.close();
    }
}
