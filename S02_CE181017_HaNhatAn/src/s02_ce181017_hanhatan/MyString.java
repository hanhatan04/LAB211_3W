/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyString class handles the logic to reverse a string by word order, including delimiters.
 */
package s02_ce181017_hanhatan;

import java.util.ArrayList;
import java.util.List;

/**
 * MyString class for reversing strings by word order
 *
 * @author hanha
 */
public class MyString {

    private String inputString; // Original string
    private String reversedString; // Reversed string
    /**
     * Sets the input string and reverses it
     */
    public void setInputString() {
        String input = MyLib.inputString();
        this.inputString = input;
        reverseByWords(); // Reverse the string by words
    }

    /**
     * Reverses the string by word order, including delimiters Algorithm: Split
     * into words and delimiters, reverse both, then join back
     */
    private void reverseByWords() {
        // Split the string into words and delimiters
        List<String> words = new ArrayList<>();
        List<String> delimiters = new ArrayList<>();

        // Parse the string to separate words and delimiters
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_' || c == ' ') {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
                delimiters.add(String.valueOf(c));
            } else {
                currentWord.append(c);
            }
        }
        // Add the last word if exists
        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        // Reverse the list of words
        int left = 0, right = words.size() - 1;
        while (left < right) {
            String temp = words.get(left);
            words.set(left, words.get(right));
            words.set(right, temp);
            left++;
            right--;
        }

        // Reverse the list of delimiters
        left = 0;
        right = delimiters.size() - 1;
        while (left < right) {
            String temp = delimiters.get(left);
            delimiters.set(left, delimiters.get(right));
            delimiters.set(right, temp);
            left++;
            right--;
        }

        // Rebuild the reversed string with reversed delimiters
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));
            if (i < delimiters.size()) {
                result.append(delimiters.get(i));
            }
        }
        this.reversedString = result.toString();
    }

    public void display() {
        System.out.println("The old string: " + inputString);
        System.out.println("The reversed string: " + reversedString);
        System.out.print("Press enter to continue another reverse, enter ESC to exit");
    }

    public boolean Choice() {
        String userChoice = MyLib.EnterOrExit("").toUpperCase(); // Get user input (empty prompt for Enter)
        if (userChoice.equals("ESC")) {
            System.out.println("Exiting program...");
            return true;
        } else {
            System.out.println("=================================");
            System.out.println("Continue reversing a new string: ");
            return false;
        }
    }
}
