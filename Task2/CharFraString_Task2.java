
/**
 * Problem Statement: Given a string, output the frequency of each character in a compressed form.
 * Owner Name: Mayank Aitan
 * Date of Creation: September 3, 2024
 */
package Task2;

import java.util.Scanner;

public class CharFraString_Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the string (or 'exit' to quit):");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            String compressedString = compressString(input);
            System.out.println("Compressed String: " + compressedString);
        }

        scanner.close();
    }

    private static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                System.out.println("Invalid input. Please enter only letters.");
                return "";
            }
        }

        String compressedString = "";
        int count = 1;
        char currentChar = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);

            if (nextChar != currentChar) {
                compressedString += currentChar;
                compressedString += count;
                currentChar = nextChar;
                count = 1;
            } else {
                count++;
            }
        }

        compressedString += currentChar;
        compressedString += count;

        return compressedString;
    }
}
