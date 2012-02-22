package govhs.apsc.week22;

// You need to complete this program you will 
//not be able to run this program until you do.

import java.util.Scanner;

public class TestScoresView{

   private TestScoresModel model;

   public TestScoresView(TestScoresModel m){
      model = m;
      run();
   }

   // Menu-driven command loop
   private void run(){
      while (true){
      	 System.out.println("start of run method");
         System.out.println("Number of students: " + model.size());
         System.out.println("Index of current student: " +
                            model.currentPosition());
         displayMenu();
         int command = getCommand("Enter a number [1-11]: ", 1, 11);
         if (command == 11)
            break;
         runCommand(command);
      }
   }

   private void displayMenu(){
      System.out.println("MAIN MENU");
      System.out.println(" 1. Display the current student");
      System.out.println(" 2. Display the class average");
      System.out.println(" 3. Display the student with the highest grade");
      System.out.println(" 4. Display all of the students");
      System.out.println(" 5. Edit the current student");
      System.out.println(" 6. Add a new student");
      System.out.println(" 7. Move to the first student");
      System.out.println(" 8. Move to the last student");
      System.out.println(" 9. Move to the next student");
      System.out.println(" 10. Move to the previous student");      
      System.out.println("11. Quit the program");
   }

   // Prompts the user for a command number and runs until
   // the user enters a valid command number
   // Parameters: prompt is the string to display
   //             low is the smallest command number
   //             high is the largest command number
   // Returns: a valid command number
   private int getCommand(String prompt, int low, int high){
     // errors checking
      Scanner reader = new Scanner(System.in);
      int command = low - 1;
      while (command < low || command > high){
        
    	  System.out.print(prompt);
    	  command = reader.nextInt();
    	  if (command < low || command > high)
    		  System.out.println("Error: command must be between " +
    				  low + " and " + high);
       }
       return command;
   }

   // Selects a command to run based on a command number,
   // runs the command, and asks the user to continue by
   // pressing the Enter key
   private void runCommand(int command){
      switch (command) { // changed this to a switch because it is the logical thing to use in this situation
      case 1:
    	  displayStudent();
    	  break;
      case 2:
    	  System.out.println("Average score = " + model.getClassAverage());
    	  break;
      case 3:
    	  displayHighScore();
    	  break;
      case 4:
    	  model.toString();
    	  break;
      case 5:
    	  editStudent();
    	  break;
      case 6:
    	  addStudent();
    	  break;
      case 7: 
    	  model.first();
    	  break;
      case 8:
    	  model.last(); 
    	  break;
      case 9:
    	  model.next();
      case 10:
    	  model.previous();
      }
	       	     
   }

   private void displayStudent(){
      Student s = model.currentStudent();
      if (s == null)
         System.out.println("No student is currently available");
      else
         System.out.println(s);
   }

   private void displayHighScore(){
      Student s = model.getHighScore();
      if (s == null)
          System.out.println("No student is currently available");
      else
          System.out.println(s.getHighScore());
   }

   private void addStudent(){
      Student s = new Student();
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter the name: ");
      s.setName(reader.nextLine());
      for (int i = 1; i <= s.getNumberOfTests(); i++){
         System.out.print("\nEnter next test grade"); // prompt for test score
         s.setScore(i, reader.nextInt()); // set scores
      }
      String message = s.validateData();
      if (message != null)
         System.out.println(message);
      else{
         message = model.add(s);
         if (message != null)
            System.out.println(message);
         else
            System.out.println("Student added");
      } 
   }

   private void editStudent() {
	   
      Student s = model.currentStudent();
      if (s == null)
    	  System.out.println("No student is currently available");
      else {
    	  // Work on a temporary copy
    	  Student temp = new Student(s);
    	  String menu = "EDIT MENU\n" +
                       	"1. Change the name\n" +
                       	"2. Change a score\n" +
                       	"3. View the student\n" +
                       	"4. Quit this menu\n";
    	  Scanner reader = new Scanner(System.in);
    	  int command = 1;
    	  while (command != 4) {
    		  System.out.print(menu);
            	command = getCommand("Enter a number [1-4]: ", 1, 4);
            	if (command == 1) {         
            		System.out.print("Enter new name: "); // enters the new name
             		String name = reader.nextLine();
             		s.setName(name); // set name to the new one
             		System.out.println();
            	}
            	else if (command == 2) {
            		System.out.print("Which test would you like to change? "); // choose the test to edit
            		int number = reader.nextInt();
            		System.out.print("\nWhat would you like the new score to be? "); // choose new score
            		int newScore = reader.nextInt();
            		s.setScore(number, newScore); // set scores
            		System.out.println();
            	}
            	else if (command == 3) {
            		System.out.println(s); // print the student
            	}
    	  }
    	  System.out.print("Would you like to save the student (y/n)? "); // ask whether or not to save changes
    	  String answer = "";
    	  while ((answer.equals("y")) || (answer.equals("n"))) {
    		  answer = reader.next();
    	  }
    	  if (answer.equals("y")) {
    		  // Check for valid data before writing to database
    		  String message = temp.validateData();
    		  if (message != null)
    			  System.out.println(message);
    		  else
    			  model.replace(temp); 
    	  }
      }
   }
}

