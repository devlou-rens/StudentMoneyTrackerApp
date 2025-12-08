import java.util.Scanner;

class Record {
    private String name;  
    private double amount;

    public Record(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    // Encapsulation: Getters/Setters
    public String getName() { 
        return name; 
    }
    public double getAmount() { 
        return amount; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public void setAmount(double amount) { 
        this.amount = amount; 
    }
}

class Expense extends Record {
    public Expense(String name, double amount) {
        super(name, amount);
    }
}

public class StudentMoneyTrackerApp{

    static Scanner sc = new Scanner(System.in);
    static Expense[] expenses = new Expense[50];
    static int count = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== STUDENT MONEY TRACKER APP ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": addExpense(); break;
                case "2": viewExpenses(); break;
                case "3": editExpense(); break;
                case "4": deleteExpense(); break;
                case "5": 
                    System.out.println("Goodbye!");
                    return;
                default: 
                    System.out.println("Invalid choice!");
            }
        }
    }
    static void addExpense() {

        if (count >= expenses.length) {
            System.out.println("Storage full!");
            return;
        }

        String name;
        double amount;

        // NAME VALIDATION
        while (true) {
            System.out.print("Expense Name: ");
            name = sc.nextLine().trim();

            if (name.isEmpty())
                System.out.println("Cannot be empty.");
            else if (!name.matches("[a-zA-Z ]+"))
                System.out.println("Letters only.");
            else break;
        }

        // AMOUNT VALIDATION
        while (true) {
            System.out.print("Amount: ");
            String input = sc.nextLine();

            try {
                amount = Double.parseDouble(input);
                if (amount > 0) break;
                else System.out.println("Must be > 0.");
            } catch (Exception e) {
                System.out.println("Numbers only.");
            }
        }

        expenses[count] = new Expense(name, amount);
        count++;

        System.out.println("Added!");
    }

    static void viewExpenses() {

        if (count == 0) {
            System.out.println("No expenses yet.");
            return;
        }

        System.out.println("\n--- EXPENSES ---");
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " +
                expenses[i].getName() + " - PHP" + expenses[i].getAmount());
            total += expenses[i].getAmount();
        }

        System.out.println("Total: PHP" + total);
    }

    static void editExpense() {

        viewExpenses();
        if (count == 0) return;

        int index;

        while (true) {
            System.out.print("Enter number to edit or press Enter if none: ");
            try {
                index = Integer.parseInt(sc.nextLine()) - 1;

                if (index < 0 || index >= count)
                    System.out.println("Invalid!");
                else break;

            } catch (Exception e) {
                System.out.println("Numbers only.");
            }
        }

        Expense e = expenses[index];

        // NEW NAME
        System.out.print("New Name (" + e.getName() + "): ");
        String nn = sc.nextLine().trim();
        if (!nn.isEmpty() && nn.matches("[a-zA-Z ]+"))
            e.setName(nn);

        // NEW AMOUNT
        System.out.print("New Amount (" + e.getAmount() + "): ");
        String na = sc.nextLine();

        try {
            if (!na.isEmpty()) {
                double amt = Double.parseDouble(na);
                if (amt > 0) e.setAmount(amt);
            }
        } catch (Exception ex) {
            System.out.println("Invalid amount.");
        }

        System.out.println("Updated!");
    }

    static void deleteExpense() {

        viewExpenses();
        if (count == 0) return;

        int index;

        while (true) {
            System.out.print("Enter number to delete: ");
            try {
                index = Integer.parseInt(sc.nextLine()) - 1;

                if (index < 0 || index >= count)
                    System.out.println("Invalid!");
                else break;

            } catch (Exception e) {
                System.out.println("Numbers only.");
            }
        }

        // SHIFT LEFT
        for (int i = index; i < count - 1; i++) {
            expenses[i] = expenses[i + 1];
        }
        count--;

        System.out.println("Deleted!");
    }
}
