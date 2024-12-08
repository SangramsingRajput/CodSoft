import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    
    
    public static boolean playRound(int maxAttempts) {
        
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        
     
        int attemptsLeft = maxAttempts;
        
       
        Scanner sc = new Scanner(System.in);
        
        while (attemptsLeft > 0) {
            System.out.println("\nYou have " + attemptsLeft + " attempts left. Enter your guess:");
            int guess = sc.nextInt();
            
            
            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + numberToGuess);
                return true;
            }
            
            attemptsLeft--;
        }
        
       
        System.out.println("\nSorry, you've run out of attempts! The correct number was " + numberToGuess + ".");
        return false; 
    }
    
    public static void main(String[] args) {
        int totalRounds = 0;
        int roundsWon = 0;
        int maxAttempts = 10;
        
        Scanner sc = new Scanner(System.in);
        
       
        while (true) {
            totalRounds++;
            System.out.println("\nRound " + totalRounds);
            
            
            if (playRound(maxAttempts)) {
                roundsWon++;
            }
            
            
            System.out.println("\nWould you like to play again? (y/n): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }
        
       
        System.out.println("\nGame Over! You played " + totalRounds + " rounds and won " + roundsWon + " round(s).");
    }
}
