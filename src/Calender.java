
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Calender {
    Scanner sc = new Scanner(System.in);
    public String[] scheduleDate = new String[100];
    public String[] scheduleDateMonth = new String[100];
    public String[] scheduleDateYear = new String[100];
    public String[] scheduleTime = new String[100];
    public String[] scheduleDescription = new String[100];
    public int monthNumber;
    public int yearNumber;
    public int daysOfMonth;
    public int option;
    public int scheduleCounter = 0;
    public String week[] = {"Sun" , "Mon" , "Tue" , "Wed" , "Thu" , "Fri" , "Sat"};
    public String month[] = {"" , "January" , "February" , "March", " April" , "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};
    public void scheduleEvent(){
        System.out.print("Enter event date  (YYYY-MM-DD) : ");
        String a = sc.nextLine();
        scheduleDate[scheduleCounter] = month[(a.charAt(5)-48)*10+(a.charAt(6)-48)];
        scheduleDateMonth[scheduleCounter] = a.substring(8,10);
        scheduleDateYear[scheduleCounter]= a.substring(0,4);
        System.out.print("Enter event time (HH:MM) : ");
        scheduleTime[scheduleCounter] = sc.nextLine();
        System.out.print("Enter event description : ");
        scheduleDescription[scheduleCounter] = sc.nextLine();
        System.out.println("Event scheduled successfully!");
        scheduleCounter = scheduleCounter + 1;
    }
    public void viewCalender(){
        System.out.print("Enter the month (1-12): ");
        monthNumber = sc.nextInt();
        System.out.print("Enter the year: ");
        yearNumber = sc.nextInt();
        YearMonth yearMonth = YearMonth.of(yearNumber,monthNumber);
        daysOfMonth = yearMonth.lengthOfMonth();
        System.out.printf("%s %d\n",month[monthNumber],yearNumber);
        for(int i = 0;i < 7; i++){
            System.out.printf("%6s",week[i]);
        }
        System.out.println();
        LocalDate startDay = yearMonth.atDay(1);
        DayOfWeek startDayOfWeek = startDay.getDayOfWeek();
        // System.out.print(" ");
        for(int i = 0 ; i < startDayOfWeek.getValue(); i++){
            System.out.print("      ");
        }
        for(int i = 1 ; i<=7-startDayOfWeek.getValue() ; i++)
            System.out.printf("%6d",i);
        System.out.println();
        int c = 0;
        for(int i =7-startDayOfWeek.getValue()+1 ; i <= daysOfMonth ; i++){
            System.out.printf("%6d",i);
            c++;
            if(c==7){
                System.out.println();
                c=0;
            }
        }
        System.out.println();
    }
    public void displayReminder(){
        System.out.println("Upcoming Event Reminders: ");
        for(int i = 0 ; i < scheduleCounter ; i ++){
            System.out.printf("%d. %s - %s %s, %s, %s\n",i+1,scheduleDescription[i],scheduleDate[i],scheduleDateMonth[i],scheduleDateYear[i],scheduleTime[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calender cal = new Calender();
        System.out.println("Welcome to the Console-based Calender!");
        System.out.println("1. Schedule Event");
        System.out.println("2. View Calendar");
        System.out.println("3. Display Reminders");
        System.out.println("4. Exit");
        do{
            System.out.print("Please select an option: ");
            cal.option = sc.nextInt();
            switch (cal.option){
                case 1:
                    cal.scheduleEvent();
                    break;
                case 2:
                    cal.viewCalender();
                    break;
                case 3:
                    cal.displayReminder();
                    break;
                case 4:
                    System.out.println("Thank you for using the Console-based Calendar!");
                    break;
                default:
                    System.out.println("Invalid number");
                    break;
            }
        }while(cal.option!=4);
    }
}