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
class time
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the normal hour");
        int h=sc.nextInt();
        System.out.println("enter the min");
        int m=sc.nextInt();
        System.out.println("enter wheter am or pm");
        String a=sc.next();
        int i=h+12;
        if(h>=13)
        System.out.println("error");
        if(m>=60)
        System.out.println("error");
        else if(a.equals("am"))
        {
        System.out.println("railway time is ");
        System.out.println(h+":"+m+a);
        }
        else 
        {
        System.out.println("railway time is ");
        System.out.println(i+":"+m+a);
        }
    }
}
    }
}
