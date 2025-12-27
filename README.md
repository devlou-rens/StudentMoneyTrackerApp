Project Title:  Student Money Tracker
 
Purpose/Description: The purpose of this program is to let students record, view, edit, and delete their expenses so they can track how much money they spend.
Programming Language: Java

Key Features
1.	The system allows students to add an expense with a name and amount.
2.	Students can view all their recorded expenses and see the total spent.
3.	They can edit the name or amount of any existing expense.
4.	They can delete an expense from the list if they no longer need it.
5.	The system checks all inputs to avoid empty or invalid entries.
6.	It uses try-catch to prevent errors when the user enters wrong input.
7.	The program continues running and only stops when the user chooses Exit.

C.	Command Interface Design

Define the execution command and the key interaction points.
EXECUTION	DESCRIPTION	

EXAMPLE USAGE
 
Running the Program	Use this step to start or run the Student Money Tracker App in the computer lab.	Open VS Code.
Open the file StudentMoneyTrackerApp.java.
Open the terminal.
Compile:
javac StudentMoneyTrackerApp.java
Run:
java StudentMoneyTrackerApp
User Interaction Flow	How the user interacts with the system by entering choices and typing the required information.	The app prompts:
"Expense Name:"
"Amount:"
"Choose option:"
"Enter number to edit:"
      "New Name:"
     "New Amount:"
"Enter number to delete:"
"Invalid choice." 
Output Display 
Shows the results of the user’s selected option during the program.
User chooses an option like '2' (View Expenses) or '3' (Edit Expense) and the program displays the result such as the list of expenses, the total amount, or the updated expense details.




