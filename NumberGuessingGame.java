import java.util.*;
public class NumberGuessingGame{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int minRange=1;
        int maxRange=100;
        int maxAttempts=10;
        int rounds=0;
        int totalscore=0;
        while(true){
            rounds++;
            int numToGuess=r.nextInt(maxRange-minRange+1)+minRange;
            int attempts=0;
            boolean guessedcorrectly=false;
            System.out.println("\nRound" + rounds);
            System.out.println("Guess the number between "+ minRange +" and  "+ maxRange +". You have  "+ maxAttempts +" attempts.");
            while(attempts<maxAttempts){
                System.out.print("Enter your guess: ");
                int guess =sc.nextInt();
                attempts++;
                if (guess<numToGuess){
                    System.out.println(" Your guess is too low");
                }
                else if(guess>numToGuess){
                    System.out.println(" Your guess is above the guessed number");
                }
                else{
                    System.out.println("Woohoo! You nailed it,That's correct!!") ; 
                                  guessedcorrectly=true;
                                  totalscore+=maxAttempts-attempts+1;
                               break;
              }
        }
       if(!guessedcorrectly){
        System.out.println( "Whoops, out of guesses! Correct answer is : " + numToGuess + ".");
       }
       System.out.println("Your current Score: "+totalscore);
       System.out.print("Do you want to play again? (yes/no): ");
       sc.nextLine();
       String playAgain =sc.nextLine().trim().toLowerCase();
       if(!playAgain.equals("yes")){
        break;
       }
       else{
        System.out.println("\nStarting round"+(rounds+1)+" ");
       }
       
           }
           System.out.println("Game over!! You played " + rounds+" "+ "rounds with a total Score of  " + totalscore+ ".");
    }
}
