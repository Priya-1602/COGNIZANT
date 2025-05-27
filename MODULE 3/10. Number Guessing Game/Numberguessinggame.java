import java.util.Scanner;
import java.util.Random;
public class Numberguessinggame{
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int targetnum=random.nextInt(100) + 1;
        int guess=0;
          System.out.println("Guess the number between 1 and 100");
          while (guess!=targetnum){
            System.out.print("Enter your guess:");
            guess=sc.nextInt();
             if(guess<targetnum){
                System.out.println("Too low try again");
            }else if(guess>targetnum){
                System.out.println("Too high try again");
            }else{
            System.out.println("Congratulations You guessed the number:"+targetnum);
            }
        }sc.close();
    }
}

