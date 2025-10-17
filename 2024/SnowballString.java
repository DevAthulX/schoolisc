import java.util.Scanner;

// Question 3

// A snowball string is a sentence where each word is arranged in ascending order of their length and is also consecutive.

// For example "I am the Lord" is a snowball string as

// Length of word 'T' is 1

// Length of word 'am' is 2

// Length of word 'the' is 3

// Length of word 'Lord' is 4

// The length of each word is one more than the previous word. Hence they are consecutive and in ascending order.

// Write a program to enter any sentence and check if it is a snowball string or not. The words in the sentence may be separated by a one or more spaces and terminated by." or "?" only. The program will generate appropriate error message for any other terminating character.

// Test your program for the following data and some random data:

// Example 1

// INPUT: He may give bonus.

// OUTPUT: IT IS A SNOWBALL STRING

// Example 2

// INPUT: Is the cold water frozen?

// OUTPUT: IT IS A SNOWBALL STRING

// Example 3

// INPUT: Look before you leap.

// OUTPUT: IT IS NOT A SNOWBALL STRING

// Example 4

// INPUT:

// The child is father of the man!

// OUTPUT: INCORRECT TERMINATING CHARACTER. INVALID INPUT
public class SnowballString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().trim();

        
        if (!(sentence.endsWith(".") || sentence.endsWith("?"))) {
            System.out.println("INCORRECT TERMINATING CHARACTER. INVALID INPUT");
            return;
        }

       
        char terminator = sentence.charAt(sentence.length() - 1);
        sentence = sentence.substring(0, sentence.length() - 1);

     
        String[] words = new String[100]; 
        int wordCount = 0;
        String word = "";

        for (int i = 0; i < sentence.length(); i++) {
            while(sentence.charAt(i)!=' '){
                word += sentence.charAt(i);
                i++;
                if(i==sentence.length()) break; 
            }
            words[wordCount] = word;
            wordCount++;
            word = "";

        }
        
        if (!word.equals("")) {
            words[wordCount] = word;
            wordCount++;
        }

        
        boolean isSnowball = true;
        for (int i = 1; i < wordCount; i++) {
            if (words[i].length() != words[i - 1].length() + 1) {
                isSnowball = false;
                break;
            }
        }

        if (isSnowball) {
            System.out.println("IT IS A SNOWBALL STRING");
        } else {
            System.out.println("IT IS NOT A SNOWBALL STRING");
        }
    }
}
