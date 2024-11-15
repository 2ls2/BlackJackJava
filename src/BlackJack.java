import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static String game(){
        Scanner s1 = new Scanner(System.in);
       
       
       
        String[] arr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        List<Integer> dealersHand = new ArrayList<Integer>();
        List<Integer> Playerhand = new ArrayList<Integer>();
        Random r = new Random();
        int PlayerHandSum = 0;
        int DealerHandSum = 0;
        System.out.println("Welcome to Black Jack. Your goal is to get 21, or as close as you can to it without going over 21!");

        System.out.println("Dealer's hand is:");
        //here we are adding 2 elements from "arr" at random using the nextInt function of the random object 'r'. 
        //Note: elements are members of a container, in this case each member is a number and the container is a List
        dealersHand.add(Integer.parseInt(arr[r.nextInt(arr.length)]));//parse sees that a string is written to be used a number and turns into an int to be used as a number.
        dealersHand.add(Integer.parseInt(arr[r.nextInt(arr.length)]));//single characters (A, 1, ?) are in single qoutes 'char' and strings are in double qoutes "string"
        System.out.println(dealersHand);
        // dealersHands = [1,2]
        int sum = 0;
        for (int number : dealersHand) {
            // first run, number = 1
            // second run, number =2
            sum += number;
            // sum = 3 at the end of the loop
        }

        System.out.println(sum);

        if (sum == 21) {
            System.out.println("Dealer wins");
            return "Lose.";
        }
        if (sum > 21) {
            System.out.println("Dealer Busts");
            return "Win.";
        }

        System.out.println("Your hand is: ");
        Playerhand.add(Integer.parseInt(arr[r.nextInt(arr.length)]));
        Playerhand.add(Integer.parseInt(arr[r.nextInt(arr.length)]));
        System.out.println(Playerhand);
        sum = 0;
        for (int number : Playerhand) {
            sum += number;
        }

        System.out.println(sum);
        if (sum == 21) {
            System.out.println("You win");
            return "Win.";
        }

        if (sum > 21) {
            System.out.println("You bust");
            return "Lose.";
        }
        
    
        char input = ' '; 
        while (input != 's') {

            System.out.print("Hit or Stand? Type h or s: ");
            Boolean isValid = false;// Boolean is a true or false statement

            while (isValid == false) {// a While loop is saying that while something is true itll keep looping till until it's false (while the car has gas it runs when it doesn't it doesnt
                                     

                input = s1.next().charAt(0);// char is a character single letter number or symbol (A, 1, ?)
                if (input == 'h' || input == 's' || input == 'S' || input == 'H') {
                    isValid = true;
                } else {
                    System.out.println("Invalid Input, please type 'h' or 's': ");

                }
            }
            //
            if (input== 'h') {
                Playerhand.add(Integer.parseInt(arr[r.nextInt(arr.length)]));
                System.out.println(Playerhand);
                sum = 0;
                for (int number : Playerhand) {
                    sum += number;
                }

                System.out.println(sum);
                if (sum == 21) {
                    System.out.println("You win");
                    return "Win.";
                }
                if (sum > 21) {
                    System.out.println("You bust");
                    return "Lose.";
                }
            }

            if (input == 's') {
                System.out.println("Stood");

            }
        }
            //If dealers hand is less than or equal 15 then the dealer MUST hit no matter what. if dealers hand is greater than or equal to 16 it will stand no matter what.
            //if the dealer draws 21 then it automatically wins and no action is executed.
            //if dealer's hand is less than or equal to 15 he must hit, if after the dealer hits his hand is over 21 he busts and the player wins
            //if the dealers hand is 16, 17 , 18 , 19 or 20 and the players hand is better the dealer loses.
            sum = 0;
            for (int number : dealersHand) {
                sum += number;
            }
            
            while(sum <= 15) { 
                dealersHand.add(Integer.parseInt(arr[r.nextInt(arr.length)]));
                sum = 0;
                for (int number : dealersHand) {
                    sum += number;
                
                }
                System.out.println(dealersHand);
                if(sum > 21) {
                    System.out.println("Dealer busts you win");
                    return "Win.";
                }
                if(sum == 21) {
                    System.out.println("Dealer wins");
                    return "Lose.";
                }

            }
               
                for (int number : dealersHand) {
                    DealerHandSum += number;
                
                }
                for (int number : Playerhand) {
                    PlayerHandSum += number;
                
                }
                System.out.println("Your hand is " + Playerhand + " = " + PlayerHandSum);
                System.out.println("Dealers hand is " + dealersHand + " = " + DealerHandSum);
                if(PlayerHandSum > DealerHandSum) { 
                    System.out.println("You win!");
                    return "Win.";
                }
                if(DealerHandSum > PlayerHandSum) { 
                    System.out.println("Dealer Won ");
                    return "Lose.";
                 }
                 if(DealerHandSum == PlayerHandSum) { 
                    System.out.println("Push, you get your bet back.");
                    return "Push.";
                }
                return null;
    }
    public static void main(String[] args) {
        int Balance = 500;
        int bet = 0;
        String gameresult;

        
        
        
        
        Scanner S2 = new Scanner(System.in);
        String input1 = "yes";
        while (input1.equals ("yes")){
            System.out.println("your balance is: $" + Balance);
            System.out.println("how much would you like to bet? ");
            bet = S2.nextInt();
            while(bet > Balance){
            System.out.println("Your max bet is: $" + Balance + ", how much would you like to bet?");
            bet = S2.nextInt();
        }
        
           
           
            Balance -= bet;
           gameresult = game();
           if(gameresult.equals ("Win." )) { 
            Balance += bet * 2;
            System.out.println("You Won : $" + bet);
        }           
            if(gameresult.equals("Lose.")) {
                System.out.println("You lost: $" + bet);
            }


        else if(gameresult.equals("Push.")) {
                Balance += bet * 1;
                
                System.out.println("Push, You got back your $" + bet);
            }

        
            System.out.println("Do you wanna play again? ");
            input1 = S2.next().toLowerCase();


             if(Balance <= 0){
                Balance = 500;
                System.out.println("You ran out of money because ur bad, heres another $500 try not to lose this one.");
             }
             
           
           
            }
        
    }
}
