import java.util.Scanner;

/**
 * Main class for stack testing
 */

public class Main {

    public static void main(String[] args) {

        LinkedListStack myStack = new LinkedListStack();  // Create new linked list to contain the stack

        Scanner scanner = new Scanner(System.in);

        // Instructions for the user
        System.out.println("Welcome to Stacks! \n" +
                "- List of commands \n" +
                "- Enter (a) plus an integer (leaving a blank space) if you wish to add to your stack \n" +
                "- Enter (+ or *) as an operator to be applied to the last two items added to your stack \n" +
                "- Enter (?) if you wish to see everything in your stack printed to the screen \n" +
                "- Enter (p) if you wish to remove the last item \n" +
                "- Enter (z) if you are done playing with stacks\n");

        //loop to run the program until the user decides to exit
        while (true) {

            System.out.println("Please enter your command: ");

            String input = scanner.nextLine();          // Take user's input
            String[] command = input.split(" ");  // Separate the command and the value in case of push (a)

            // check command and act accordingly
            switch (command[0]) {

                case ("a"):
                case ("A"):
                    myStack.push(Integer.parseInt(command[1]));   // call to push method using second element of split cast to int as param.
                    System.out.println("The value has been added to the stack!\n");
                    break;

                case ("p"):
                case ("P"):
                    if (myStack.size() == 0) {  // check if stack is empty
                        System.out.println("Nothing to remove, the stack is empty\n");
                    } else {

                        // call to pop method and confirmation
                        System.out.println("The value " + myStack.pop() + " has been removed from the stack!\n");
                    }
                    break;

                case ("+"):
                    // Check if we have at least 2 elements in the stack
                    if (myStack.size() < 2) {
                        System.out.println("We need at least 2 elements in the stack to perform this command\n");
                    } else {
                        // Call to addition method and confirmation
                        System.out.println("You have added the last two items in your stack and pushed the total: " +
                                myStack.addition() + "\n");
                    }
                    break;

                case ("*"):
                    // Check if we have at least 2 elements in the stack
                    if (myStack.size() < 2) {
                        System.out.println("We need at least 2 elements in the stack to perform this command\n");
                    } else {
                        // Call to multiply method and confirmation
                        System.out.println("You have multiplied the last two items in your stack and pushed the total: " +
                                myStack.multiply() + "\n");
                    }
                    break;

                case ("?"):
                    //print result of toString method
                    System.out.println(myStack.toString() + "\n");
                    break;

                case ("z"):
                case ("Z"):
                    // Exit program
                    System.out.println("Thank you for playing!");
                    System.exit(0);
            }
        }
    }
}
