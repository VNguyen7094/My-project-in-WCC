//Name: Viet Trinh Nguyen
//Date: 3/19/2024.
//CS 141
// Programming Assignment1: Calendar Part 3
// Description : Making calendar 

import java.util.Scanner;
import java.util.Calendar;
import java.util.*;
import java.io.*; //preps system for calendar functions and scanner functions
// import java.io.FileWriter;

public class Assigment3{
    
    public static int currentMonth = Calendar.getInstance().get(Calendar.MONTH); 
    public static int currentDay = Calendar.getInstance().get(Calendar.DATE); 
    public static String[][] calendarEvent = new String[12][31];

    public static void main(String[] args) throws IOException{
        
        
        Scanner console = new Scanner(System.in);
        readFile(console);
        
        // for (int i = 0 ; i < calendarEvent.length; i++){
        //     for (int j = 0; j < calendarEvent[0].length;j++){
        //         System.out.println(i + " " + j + " " + calendarEvent[i][j]);
        //     }
        // }
        System.out.println(getEventString(5, 28));
        boolean endProgram = true;
        while(endProgram){

            endProgram = menu(console);
        }

    }
    // asking user to prompt which date they wanna see 
    public static boolean menu(Scanner console) throws IOException{
        boolean fb = false;
        boolean result = true;
        System.out.printf("Please type a command%n");
        System.out.printf("    \"e\" to enter a date and display the corresponding calendar%n");
        System.out.printf("    \"t\" to get todays date and display today's calendar%n");
        System.out.printf("    \"n\" to display the next month%n");
        System.out.printf("    \"p\" to display the previous month%n");
        System.out.printf("    \"v\" to add an event to the calendar%n");
        System.out.printf("    \"f\" to print a month to a seperate text file%n");
        System.out.printf("    \"q\" to quit the program%n");
        String answer = console.next();
        answer = answer.toLowerCase();
        if (answer.charAt(0) == 'v'){
            addEvent(console);;
        }
        else if (answer.charAt(0) == 'e'  ){
            specificMonth(console);
        }
        else if (answer.charAt(0) == 't'){
            currentMonth();
        }
        else if (answer.charAt(0) == 'p'){
            previousMonth();
        }
        else if (answer.charAt(0) == 'n'){
            nextMonth();
        }
        
        else if (answer.charAt(0) == 'f' ){
            fb = true;
            userCalendar(console, fb);
            fb = false;
        }
        else if (answer.charAt(0) =='q'){
            result = false;
        }

        return result;
    }

    public static int userCalendar(Scanner input, boolean fb)throws IOException{
        PrintStream console = System.out;
        PrintStream writer = System.out;
        boolean endLoop = true; 
        String outputFile = "";
        int day = 0;
        int month = 0;
        
        while(endLoop){
            System.out.printf("What file would you like to print to? ");
            input.nextLine();
            outputFile = input.nextLine();
            File fileOut = new File(outputFile);
            //then it will switch the writer printstream to the output file
            writer = new PrintStream(fileOut);
            endLoop = false;
        }

        endLoop = true; 
        int k = 0;
        while (endLoop) {
            System.out.printf("What date would you like to look at? (mm/dd) ");
            if (k == 0 && !fb) {
                input.nextLine(); //consumes very first new line character
                k++;
            }
            String answer = input.nextLine().trim();

            month = Integer.parseInt(answer.substring(0, 2));
            day = Integer.parseInt(answer.substring(3, 5));
            printDate(day, month);
            printMonth(month);

            if (month > 0 && month < 13 && dayInMonth(month) > day && day > 0){
                endLoop = false;
            }
            else { 
                System.out.printf("Date invalid. Please try again.%n");
                
            }
        }

        //
        if (fb) {
            System.setOut(writer);
        }
        printDate(day, month);
        printMonth(month);
        if (fb) {
            System.setOut(console);
            System.out.printf("Calendar successfully printed to %s%n", outputFile);
        }
        return month;
    }

    // print date 
    public static void printDate(int day, int month){
        System.out.println("Month: " + month);
        System.out.println("Date: " + day);
    }

    // specific month 
    public static void specificMonth(Scanner console){
        
        System.out.print("Enter date: ");
        String answer = console.next();

        int month = Integer.parseInt(answer.substring(0, 2));
        int day = Integer.parseInt(answer.substring(3, 5));
        printDate(day, month);
        printMonth(month);
        
    }
    
    // currentMonth  
    public static void currentMonth(){
        int month = currentMonth + 1;
        printMonth(month);
        System.out.println("Current Month: " + month);
        System.out.println("Current Date : " + currentDay);
    }

    // previousMonth
    public static void previousMonth(){
        int previousMonth = currentMonth;
        printMonth(previousMonth);
        System.out.println("Previous Month: " + previousMonth);
    }

    // nextMonth
    public static void nextMonth(){
        int nextMonth = currentMonth + 2;
        printMonth(nextMonth);
        System.out.println("Next Month: " + nextMonth);
    }

    // Calculate the secon date on Sunday of the month 
    public static int secondSunday(int month){
        int secondSunday;
        int firstDay = dayStartOfMOnth(month);
        if (firstDay == 0){
            secondSunday = 8;
        }
        else{
            secondSunday = 1 + 7 - firstDay;
        }
        return secondSunday;
    }
    // Calculate the first date on Sunday of the month 
    public static int firstSunday(int month){
        int firstSunday;
        int firstDay = dayStartOfMOnth(month);
        if (firstDay == 0){
            firstSunday = 1 ;
        }
        else{
            firstSunday = 1 + dayInMonth(month - 1) - firstDay;
        }
        return firstSunday;
    }

    // Calculate the first day of specific month 
    // Acknowledging that 2024 start on MOnday 
    public static int dayStartOfMOnth(int month){
        
        int sum = 1; 
        for (int i = 1; i < month; i++){

            sum += dayInMonth(i);
        }
        
        int result = sum % 7;
        
        // specific month for December 2023
        if (month == 0){
            result = 5;
        }

        return result;
    }

    // calculate how many day from month 
    public static int dayInMonth(int month){

        int result = 31;
        // switch condition 
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: case 0: case 13:
                result = 31;
                break;
            case 4: case 6: case 9: case 11:
                result = 30;
                break ;
            case 2:
                result = 29;
                break; 

        } // end switch condition 
        return result;
    } 

    // printMonth method 
    public static void printMonth(int month){

        int firstSunday = firstSunday(month);
        int secondSunday = secondSunday(month);
        
        // print first week 
        if (firstSunday == 1){
            printWeek(month,firstSunday,month);
        }
        else{
            printWeek(month, firstSunday,month - 1);
        }

        int loopEnd = 5;
        // print the rest 
        if ((dayStartOfMOnth(month) > 4 && dayInMonth(month) == 31)
        |
        (dayStartOfMOnth(month) > 5 && dayInMonth(month) == 30)){
            loopEnd = 6;
        }
        for (int i = 1; i < loopEnd; i++){
            printWeek(i, secondSunday,month);
            secondSunday += 7;
        }
        // row 1
        for (int i = 0 ; i < 141; i++){
            System.out.print("=");
            
        }System.out.println();
    }

    // printWeek method -- print only one week 
    public static void printWeek(int week, int dayStart, int month1) {

        int day = dayStart;
        int month = month1;
        int dayForMonth = dayInMonth(month);
        
        // row 1
        for (int i = 0 ; i < 141; i++){
            System.out.print("=");
            
        }
        System.out.println();

        // row 2
        for (int i = 0; i < 134; i++){
            if (i % 19 == 0){
                System.out.print("|");
            }
            else if (i % 19 == 1){

                // if day over the month turn to 1 
                if (day > dayForMonth){
                    day = 1;
                    month = month + 1;
                }
                String dayy = "" + day;
                
                if (dayy.length() == 2){
                    System.out.print(day);
                    day += 1;
                }                    
                else{
                    System.out.print(day + " ");
                    day += 1;
                }
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
        // reset for prepare for the print event row 
        day = dayStart;
        month = month1;
        if (month == 0){
            month = 12;
        }
        String event;
        for (int i = 0; i < 7; i++){
            System.out.print("|");
            if (day > dayForMonth){
                day = 1;
                month = month + 1;
                if (month == 13){
                    month = 1;
                }
            }
            event = getEventString(month, day);

            if (event.length()== 0){
                System.out.print("                   ");
            }
            else{
                System.out.print(event);
                for (int j = 0; j < 19 - event.length();j++){
                    System.out.print(" ");
                }
            }
            day = day + 1;

        }
        System.out.println("|");
        //row 3 and 4 
        for (int j = 0; j < 5; j ++){
            for (int i = 0; i < 141; i++){
                if (i % 20 == 0){
                    System.out.print("|");
                }
                else{System.out.print(" ");}
            }
            System.out.println();
        }
        
    }

    public static String getEventString(int month, int day){

        String result = "";

        if (day > 0 && day < 32 && calendarEvent[month-1][day-1] != null){
            result = calendarEvent[month-1][day-1];
        }
        
        return result;
    }
    public static void readFile(Scanner sc) throws IOException{
        
        // read input
        File myFile = new File("calendarEvents.txt");
        Scanner readFile = new Scanner(myFile);

        // scan data and store it in our array 
        while(readFile.hasNextLine()){
            
            // split the data into three position
            String oneLine = readFile.nextLine();
           
            String oneLineData[] = oneLine.split(" ");

            // add the data to our array 
            int month = Integer.parseInt(oneLineData[0].substring(0, 2));
            int day = Integer.parseInt(oneLineData[0].substring(3, 5));

            calendarEvent[month - 1][day - 1] = oneLineData[1];
            
        }
        readFile.close();

    }
    public static void addEvent(Scanner sc){

        boolean endLoop = true;
        int i = 0;
        while(endLoop)
        {
            System.out.printf("Enter an event with the format (mm/dd event_title)%n");
                if (i == 0) {
                    sc.nextLine(); //consume very first newline character
                    i++;
                }

            String input = sc.nextLine();
            System.out.println(input);
            String oneLineData[] = input.split(" ");

            if (testValidateDateEvent(oneLineData)){
                int month = Integer.parseInt(oneLineData[0].substring(0, 2));
                int day = Integer.parseInt(oneLineData[0].substring(3, 5));

                calendarEvent[month - 1][day - 1] = oneLineData[1];
                System.out.printf("Event successfully stored.%n");
                endLoop = false;
            }
            else{
                System.out.println("Please enter a valid date for your event");
            }
        }
        
    }

    public static boolean testValidateDateEvent(String[] input){

        boolean result = false;
        if (Character.isDigit(input[0].charAt(0)) &&
            Character.isDigit(input[0].charAt(1)) &&
            Character.isDigit(input[0].charAt(3)) &&
            Character.isDigit(input[0].charAt(4)) &&
            input.length == 2)
            {
                int month = Integer.parseInt(input[0].substring(0, 2));
                int day = Integer.parseInt(input[0].substring(3, 5));
                if (month > 0 && month <= 12 && day <= dayInMonth(month) ){
                    result = true;
                }
            } 

        return result; 
    }
}