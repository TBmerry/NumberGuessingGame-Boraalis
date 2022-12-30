import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        in Java in which we want the user to guess a number randomly
        chosen by the program between 0-100 We are making a "Number Guessing Game" .
         */

        Random rand = new Random();
        int number = rand.nextInt(100);
        /*
        Alternative choice => int number = (int) (Math.random() * 100);
         */

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected = 0;
        int [] wrong = new int[6];
        boolean isWin = false;
        boolean isWrong = false;

        while (right < 6){
            System.out.println("Please enter your guess : ");
            selected = input.nextInt();
            if (selected <= 0 || selected >= 100){
                System.out.println("Value range not accepted!! Enter between 0-100");
                if (isWrong){
                    right++;
                    System.out.println("You entered incorrectly! Your Right " + (6 - right));
                }else {
                    isWrong = true;
                    System.out.println("You will be deducted from your next wrong entry.");
                }
                continue;
            }

            if (selected == number){
                System.out.println("congrats correct guess");
                isWin = true;
                break;
            }else{
                System.out.println("Incorrect guess");
                if (selected > number){
                    System.out.println(selected + " number, greater than the number you choose");
                }else {
                    System.out.println(selected + " number, smaller than the number you choose");
                }

                wrong[right++] = selected;
                System.out.println("Your Right => " + (6 - right));
            }
        }

        if (!isWin){
            System.out.println("Your Losers");
            if (!isWrong){
                System.out.println("Your choose" + Arrays.toString(wrong));
            }
        }


    }
}