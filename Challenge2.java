import java.util.Scanner;

public class Challenge2 {

    // Method to validate the credit card number using the Luhn algorithm
    public static boolean isValidCreditCard(String cardNumber) {
        char[] digits = cardNumber.toCharArray();
        int totalSum = 0;

        // Iterate over the digits of the card number
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] - '0';

            // Double every second digit from the right
            if ((digits.length - i) % 2 == 0) {
                digit *= 2;
                digit = digit / 10 + digit % 10; // Add the digits of the doubled number if it's greater than 9
            }

            // Sum up all digits
            totalSum += digit;
        }

        // Check if the total sum is divisible by 10
        return totalSum % 10 == 0;
    }

    // Method to determine the type of credit card based on its starting digits
    public static String getCardType(String cardNumber) {
        if (cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
            return "AMERICAN EXPRESS";
        } else if (cardNumber.startsWith("51") || cardNumber.startsWith("52") ||
                cardNumber.startsWith("53") || cardNumber.startsWith("54") ||
                cardNumber.startsWith("55")) {
            return "MASTERCARD";
        } else if (cardNumber.startsWith("4")) {
            return "VISA";
        } else {
            return "Error";
        }
    }

    // Main method to get user input and process the credit card validation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number: ");
        String cardNumber = scanner.nextLine();

        // Check if the credit card number is valid
        if (isValidCreditCard(cardNumber)) {
            // Determine and print the type of credit card
            String cardTypeStr = getCardType(cardNumber);
            System.out.println(cardTypeStr);
        } else {
            // Print "INVALID" if the credit card number is not valid
            System.out.println("INVALID");
        }

        scanner.close();
    }
}
