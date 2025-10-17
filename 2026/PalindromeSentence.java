// Question 3

// Write a program to accept a sentence which may be terminated by either." "?" or "!" only. The words may be separated by a single blank space and should be case-insensitive.

// Perform the following tasks:

// (a) Check if the sentence is a Palindrome Sentence.

// [A sentence is a Palindrome Sentence if, after removing spaces and punctuation, the letters

// read the same forward and backward.]

// Example: " Never odd or even

// (b) Display the first-occurring most frequent word in the sentence (in lower-case). If there is a tie, choose the word that appears first in the sentence and if no words are repeated then print NONE.

// Test your program for the following data and some random data:

// Example 1

// INPUT:

// No lemon no melon.

// OUTPUT:

// IT IS A PALINDROME SENTENCE

// MOST FREQUENT WORD:

// no

// Example 2

// INPUT:

// Was it a car or a cat I saw?

// OUTPUT:

// IT IS A PALINDROME SENTENCE

// MOST FREQUENT WORD: a

// Example 3

// INPUT:

// It is a rainy day!

// OUTPUT:

// IT IS NOT A PALINDROME SENTENCE

// MOST FREQUENT WORD:

// NONE

// Example 4

// INPUT:

// Always be careful#

// OUTPUT:

// INVALID INPUT pls
import java.util.Scanner;

public class PalindromeSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine().trim();
        if (!(sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!"))) {
            System.out.println("INVALID INPUT");
            return;
        }
        for (int i = 0; i < sentence.length() - 1; i++) {
            char c = sentence.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                System.out.println("INVALID INPUT");
                return;
            }
        }
        String cleaned = sentence.substring(0, sentence.length() - 1).replace(" ", "").toLowerCase();
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }

        if (cleaned.equals(reversed)) {
            System.out.println("IT IS A PALINDROME SENTENCE");
        } else {
            System.out.println("IT IS NOT A PALINDROME SENTENCE");
        }

        String[] words = sentence.substring(0, sentence.length() - 1).toLowerCase().split(" ");
        int maxFreq = 0;
        String mostFreqWord = "NONE";

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > 1 && count > maxFreq) {
                maxFreq = count;
                mostFreqWord = words[i];
            }
        }

        System.out.println("MOST FREQUENT WORD:");
        System.out.println(mostFreqWord);
    }
}
