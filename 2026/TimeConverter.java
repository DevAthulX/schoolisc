// SAMPLE PAPER 3

// Solve any one of the following Problems.

// Question 1

// are divided into two periods. The 24-hour clock format is the international standard. The 12-hour clock format (A.M/P.M.) is a time convention in which the 24 hours of the day

// Example: If time-9:35 PM, then output will be 21:35

// Write a program to accept a time in 12-hour clock format (HH:MM AM/PM) and convert it to 24-hour clock format (HH:MM).

// Test your program for the following data and some random data:

// Example 1

// INPUT:

// 11:30 PM

// OUTPUT:

// 23:30

// Example 2

// INPUT:

// 12:00 AM

// OUTPUT:

// 00:00

// Example 3

// INPUT:

// 1:45 AM

// OUTPUT:

// 01:45

// Example 4

// INPUT:

// 12:00 PM

// OUTPUT:

// 12:00

// Example 5

// INPUT:

// 13:30 AM

// OUTPUT:

// INVALID INPUT
import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter time (HH:MM AM/PM): ");
        String input = sc.nextLine().trim();

 
        if (!input.contains(" ")) {
            System.out.println("INVALID INPUT");
            return;
        }

        String[] parts = input.split(" ");
        if (parts.length != 2) {
            System.out.println("INVALID INPUT");
            return;
        }

        String time = parts[0];
        String period = parts[1];

        if (!period.equals("AM") && !period.equals("PM")) {
            System.out.println("INVALID INPUT");
            return;
        }

        if (!time.contains(":")) {
            System.out.println("INVALID INPUT");
            return;
        }

        String[] hm = time.split(":");
        if (hm.length != 2) {
            System.out.println("INVALID INPUT");
            return;
        }

        int hour, minute;
        try {
            hour = Integer.parseInt(hm[0]);
            minute = Integer.parseInt(hm[1]);
        } catch (NumberFormatException e) {
            System.out.println("INVALID INPUT");
            return;
        }

        if (hour < 1 || hour > 12 || minute < 0 || minute > 59) {
            System.out.println("INVALID INPUT");
            return;
        }
        if (period.equals("AM") && hour == 12) {
            hour = 0;
        } else if (period.equals("PM") && hour != 12) {
            hour += 12;
        }

        
        String hourStr = (hour < 10) ? "0" + hour : "" + hour;
        String minuteStr = (minute < 10) ? "0" + minute : "" + minute;

        System.out.println(hourStr + ":" + minuteStr);
    }
}
