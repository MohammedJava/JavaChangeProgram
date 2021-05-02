import java.util.Scanner;

public class JavaProgram2 {
    public static void main(String[] args) {
        //prompt and print
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the change machine");
        System.out.println("------------------------------");
        System.out.println("Enter an amount of money to receive change: ");
        double amount = input.nextDouble();
        String type = "";
        //The input for amount is assumed to be correct at first
        boolean wrongInput = false;

        //do-while loop for wrong input
        do {
            //amount as string, then as double again to get only the decimal part
            String amountAsString = Double.toString(amount);
            int decimalPlace = amountAsString.indexOf('.');

            //Getting the substring from index following "." to the end of the string;
            String decimalValueAsString = amountAsString.substring(decimalPlace + 1);
            int decimalValue = Integer.parseInt(decimalValueAsString); //decimal part

            //Verify amount is positive and the decimal part is of a maximum of 99 cents (e.g. 0.567 or 56.006)
            if (amount > 0 && decimalValueAsString.length() <= 2) {
                //If the condition is correct, the outer do-while loop must be exited
                wrongInput = false;
                System.out.println("What is the change you require? (\"Quarters\" 25\u00A2, \"Dimes\" 10\u00A2, \"Nickels\""
                        + "5\u00A2 or \"Pennies\" 1\u00A2)");

                //The input for type of change is assumed to be correct at first
                boolean wrongInput2 = false;
                do {
                    //Prompt the type of change desired
                    String typeOfChange = input.next();
                    String changeLowerCase = typeOfChange.toLowerCase();
                    type = changeLowerCase;
                    //Switch depending on the type of change
                    switch (changeLowerCase) {
                        case ("quarters"):
                            int numberOfQuarters = decimalValue / 25;
                            System.out.println("Number of quarters: " + numberOfQuarters);
                            int rest = decimalValue % 25;
                            int numberOfDimes = rest / 10;
                            System.out.println("Number of dimes: " + numberOfDimes);
                            rest %= 10;
                            int numberOfNickels = rest / 5;
                            System.out.println("Number of nickels: " + numberOfNickels);
                            rest %= 5;
                            int numberOfPennies = rest;
                            System.out.println("Number of pennies: " + numberOfPennies);
                            wrongInput2 = false;
                            break;

                        case ("dimes"):
                            int numberOfDimes2 = decimalValue / 10;
                            System.out.println("Number of dimes: " + numberOfDimes2);
                            int rest2 = decimalValue % 10;
                            int numberOfNickels2 = rest2 / 5;
                            System.out.println("Number of nickels: " + numberOfNickels2);
                            rest2 %= 5;
                            int numberOfPennies2 = rest2;
                            System.out.println("Number of pennies: " + numberOfPennies2);
                            wrongInput2 = false;
                            break;

                        case ("nickels"):
                            int numberOfNickels3 = decimalValue / 5;
                            System.out.println("Number of nickels: " + numberOfNickels3);
                            int rest3 = decimalValue % 5;
                            int numberOfPennies3 = rest3;
                            System.out.println("Number of pennies: " + numberOfPennies3);
                            break;

                        case ("pennies"):
                            System.out.println("Number of pennies: " + amount);
                            wrongInput2 = false;
                            break;

                        //default for any other input other than quarters, dimes, nickels and pennies
                        default:
                            wrongInput2 = true;
                            System.out.println("Please enter either Quarters, Dimes, Nickels or Pennies");
                            break;
                    }
                }
                while (wrongInput2);
            }
            //Message when amount entered is not correct
            else {
                System.out.println("Please enter a correct amount");
                amount = input.nextDouble();
                wrongInput = true;
            }
        } while (wrongInput);

        System.out.println("Do you want to receive change as well for your dollars?");
        String userAns = input.next();
        String userAnsLowerCase = userAns.toLowerCase();
        switch (userAnsLowerCase){
            case ("yes"):
                int integerValue = (int) amount; //integer part
                if (type.equals("quarters")) {
                    System.out.println(integerValue * 100 / 25);
                }
                else if (type.equals("dimes")) {
                    System.out.println(integerValue * 100 / 10);
                }
                else if (type.equals("nickels")){
                    System.out.println(integerValue * 100 / 5);
                }
                else if (type.equals("pennies")){
                    System.out.println(integerValue * 100);
                }
                break;
            case ("no"):
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Wrong input. Goodbye!");
        }
    }
}
