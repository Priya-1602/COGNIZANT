import java.util.Scanner;
public class Palindrome{
 public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input=sc.nextLine();
        String clean=input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = true;
        int len=clean.length();
        for (int i=0;i<len/2;i++){
            if(clean.charAt(i)!=clean.charAt(len-1-i)){
                isPalindrome=false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("\""+input+"\"is palindrome.");
        }else{
            System.out.println("\""+input+"\"is not palindrome.");
        }sc.close();
    }
}
