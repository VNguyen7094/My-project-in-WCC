//Name: Viet Trinh Nguyen
//Date: 2/27/24
//Class: CS & 141A Face-to-Fact
//Assignment: Lab #5 - Mad Libs
//Purpose: create mad-lib game.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class lab5{
   public static void main(String[] args) throws IOException {
   
      Scanner scanner = new Scanner(System.in);
      boolean playOneGame = true;
      
      // call instructions intro main method
      intro();
      System.out.println();
      while (playOneGame) {
         playOneGame = mainMenu(scanner); 
      }
      System.out.println("Thanks for playing!");
         
   }//end of main method


public static void intro() { // explaination for the game
   System.out.println("Welcome to the game of Mad Libs");
   System.out.println("I will Ask your to provide various words");
   System.out.println("and phrases to fill in a story.");
   System.out.println("The result will be written to an output file");

}//end of intro method

public static boolean mainMenu (Scanner scanner) throws IOException{// user choose the letters
   System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
   boolean result = true;
   String choice = scanner.next();

   if (choice.charAt(0) == 'c'){
      create(scanner);
   }
   else if (choice.charAt(0) == 'v'){
      view(scanner);
   }
   else if (choice.charAt(0) == 'q'){
      result = false;
   }
   return result;
}//end of mainMenu method

public static void create (Scanner scanner) throws IOException{//create file

   // create input 
   System.out.print("Input file name: ");
   boolean result = true;
   while(result){
      String inputFile = scanner.next();
      File myFile = new File(inputFile);
      
      if (myFile.exists()){
      
         //  create output 
         System.out.print("Output file name: ");
         String output = scanner.next();
         FileWriter outputwrite = new FileWriter(output);  // create a new file to write sth
         
        // read input
         Scanner readFile = new Scanner(myFile);
         while(readFile.hasNextLine()){
            
            // store each line in File in String data 
            String oneLine = readFile.nextLine();  
            
            // convert string data to array
            String oneLineData[] = oneLine.split(" ");
            
            // check each word in line
            for(int i = 0; i < oneLineData.length; i++){
               String testWord = oneLineData[i];
               
               if (testWord.charAt(0) == '<' && testWord.charAt(testWord.length() - 1) == '>'){
                  System.out.print("Please type " + testWord.substring( 1, testWord.length() - 1) + ": ");
                  String type = scanner.next();
                  outputwrite.write(type);
                  outputwrite.write(" ");
               }
               else{
                  outputwrite.write(testWord);
                  outputwrite.write(" ");
               }
            }
           
            
         }
         result = false;
         readFile.close();
         outputwrite.close();
      }
      else{
         System.out.print("File Not Found. Try Again");
      }
   }
   System.out.println("Your mad-lib has been created!\n");
}

// same with above
public static void view (Scanner scanner) throws FileNotFoundException{
   System.out.print("Input file name: ");
   boolean result = true;
   while(result){

      String inputFile = scanner.next();
      File myFile = new File(inputFile);
      if (myFile.exists()){
         Scanner readFile = new Scanner(myFile);
         while(readFile.hasNextLine()){
         
            String oneLine = readFile.nextLine();
            System.out.print(oneLine);
         result = false;   
         }
         readFile.close();
      }
      else{
      System.out.print("File not found. Try again:");
      }
   }
   System.out.println("\n");
}







}
