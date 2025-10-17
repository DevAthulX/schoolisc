// Question 3 2026

// Write a program to accept a sentence which may be terminated by either, "'or 't only. The words may be separated by a single blank space and should be case-insensitive.

// Perform the following tasks:

// (

// a) If the sentence is a pangram (a sentence or a phrase that uses every letter of the alphabet at least once), then print PANGRAM

// (b)

// If it misses exactly one letter of the alphabet, print PANGRAMMATIC LIPOGRAM and the missing letter.

// (c)

// Else print NEITHER and list all missing letters in alphabetical order.

// Test your program for the following data and some random data:

// Example 1

// INPUT:

// The quick brown fox jumps over the lazy dog!

// OUTPUT:

// IT IS A PANGRAM

// Example 2

// INPUT:

// A quick movement of the enemy will jeopardize.

// OUTPUT:

// PANGRAMMATIC LIPOGRAM

// MISSING: X

// Example 3

// INPUT:

// Hello world.

// OUTPUT:

// NEITHER

// MISSING: abcfgijkmnpqstuvxyz

// Example 4

// INPUT:

// Alas! it failed #

// OUTPUT:

// INVALID INPUT
import java.util.Scanner;

public class Panagram {
    String str = "";

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        str = sc.nextLine();
        sc.close();
    }

    void checkPanagram() {
        boolean present[] = new boolean[26];
        String notpresent = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                present[ch - 'A'] = true;
            } else if (ch >= 'a' && ch <= 'z') {
                present[ch - 'a'] = true;
            }
        }

    
        for (int i = 0; i < 26; i++) {
            if (!present[i]) {
                notpresent += (char) ('a' + i);
            }
        }

        if (notpresent.length() == 0) {
            System.out.println("pangram.");
        } else if (notpresent.length() == 1) {
            System.out.println("pangrammatic lipogram.");
            System.out.println("missing" + notpresent);
        } else {
            System.out.println("not both");
            System.out.println("missing" + notpresent);
        }
    }

    public static void main(String[] args) {
        Panagram p = new Panagram();
        p.input();
        p.checkPanagram();
    }
}
