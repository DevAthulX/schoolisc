import java.util.*;

public class ddat {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Arrays for date conversion (declared without final)
        int[] DTM = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        String[] MONTHS = {"", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", 
                                 "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        
        // --- Input ---
        System.out.print("D: "); int dayNum = sc.nextInt();
        System.out.print("Y: "); int year = sc.nextInt();
        System.out.print("N: "); int N = sc.nextInt();
        sc.close();

        // --- Initial Validation and Leap Check ---
        int maxDays = 365;
        // Calculate maxDays based on current year
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            maxDays = 366;
        }
        
        // Output error message and exit if invalid
        if (dayNum < 1 || dayNum > maxDays || N < 1 || N > 100) {
            System.out.println("\nOUTPUT:");
            if (dayNum < 1 || dayNum > maxDays) System.out.println("INCORRECT DAY NUMBER");
            if (N < 1 || N > 100) System.out.println("INCORRECT VALUE OF 'N'");
            return;
        }

        // --- Entered Date Conversion ---
        int d = dayNum;
        int m = 0; 
        for (int i = 1; i <= 12; i++) {
            int daysBefore = DTM[i];
            if (maxDays == 366 && i > 2) daysBefore++; // Adjust for Feb in leap year
            
            if (d > daysBefore) {
                m = i;
                d = dayNum - daysBefore;
            } else {
                break;
            }
        }
        String enteredDate = MONTHS[m] + " " + d + ", " + year;

        // --- Future Date Calculation ---
        int futureDayNum = dayNum + N;
        int futureYear = year;
        
        // Adjust year if date wraps
        if (futureDayNum > maxDays) {
            futureDayNum -= maxDays;
            futureYear++;
            
            // Recalculate maxDays for the new year
            maxDays = 365;
            if ((futureYear % 400 == 0) || (futureYear % 4 == 0 && futureYear % 100 != 0)) {
                maxDays = 366;
            }
            
            // Handle if it wraps again
            if (futureDayNum > maxDays) {
                 futureDayNum -= maxDays;
                 futureYear++;
            }
        }

        // --- Future Date Conversion ---
        d = futureDayNum; 
        m = 0;     
        
        // Recalculate maxDays for the final future year
        maxDays = 365;
        if ((futureYear % 400 == 0) || (futureYear % 4 == 0 && futureYear % 100 != 0)) {
            maxDays = 366;
        }

        for (int i = 1; i <= 12; i++) {
            int daysBefore = DTM[i];
            if (maxDays == 366 && i > 2) daysBefore++;
            
            if (d > daysBefore) {
                m = i;
                d = futureDayNum - daysBefore;
            } else {
                break;
            }
        }
        String futureDate = MONTHS[m] + " " + d + ", " + futureYear;

        // --- Final Output ---
        System.out.println("\nOUTPUT:");
        System.out.println("ENTERED DATE: " + enteredDate);
        System.out.println(N + " DAYS LATER: " + futureDate);
    }
}