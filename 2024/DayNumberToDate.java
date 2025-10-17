import java.util.Scanner;
// SAMPLE PAPER 2

// Solve any one of the following Problems.

// Question 1

// Write a program in JAVA to accept day number (between 1 and 366) and year (yyyy) from the user and display the corresponding date. Also accept 'N' from the user where (1<=N<=100) to compute and display the future date 'N' days after the given date. Display error message if the value of the day number or 'N' are not within the limit. Day number is calculated taking 1" January of the given year as 1.

// Test your program with given set of data and some random data

// Example 1

// INPUT:

// DAY NUMBER: 50

// YEAR: 2023

// N: 25

// OUTPUT:

// ENTERED DATE: FEBRUARY 19, 2023

// 25 DAYS LATER: MARCH 16, 2023

// Example 2

// INPUT:

// DAY NUMBER: 321

// YEAR: 2023

// N: 77

// OUTPUT:

// ENTERED DATE: NOVEMBER 17, 2023

// 77 DAYS LATER: FEBRUARY 2, 2024

// Example 3

// INPUT:

// DAY NUMBER: 400

// YEAR: 2023

// N: 125

// OUTPUT: INCORRECT DAY NUMBER

// INCORRECT VALUE OF 'N'
public class DayNumberToDate {
    
    
    static int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    static String[] monthNames = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE",
                                  "JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

   
    static String getDate(int dayNumber, int year) {
        if (dayNumber < 1 || dayNumber > (isLeapYear(year) ? 366 : 365)) {
            return "INCORRECT DAY NUMBER";
        }

        int month = 0;
        int day = dayNumber;

      
        if (isLeapYear(year)) daysInMonth[1] = 29;
        else daysInMonth[1] = 28;

        while (day > daysInMonth[month]) {
            day -= daysInMonth[month];
            month++;
        }

        return monthNames[month] + " " + day + ", " + year;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("DAY NUMBER: ");
        int dayNumber = sc.nextInt();

        System.out.print("YEAR: ");
        int year = sc.nextInt();

        System.out.print("N: ");
        int N = sc.nextInt();

        if (N < 1 || N > 100) {
            System.out.println("INCORRECT VALUE OF 'N'");
        }

        String enteredDate = getDate(dayNumber, year);
        System.out.println("ENTERED DATE: " + enteredDate);

        if (enteredDate.equals("INCORRECT DAY NUMBER") || N < 1 || N > 100) {
            return;
        }

        
        int futureDayNumber = dayNumber + N;
        int futureYear = year;

        
        while (futureDayNumber > (isLeapYear(futureYear) ? 366 : 365)) {
            futureDayNumber -= (isLeapYear(futureYear) ? 366 : 365);
            futureYear++;
        }

        String futureDate = getDate(futureDayNumber, futureYear);
        System.out.println(N + " DAYS LATER: " + futureDate);
    }
}
