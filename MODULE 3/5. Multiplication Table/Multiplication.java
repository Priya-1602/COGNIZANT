import java.util.Scanner;
public class Multiplication{
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num=sc.nextInt();
    System.out.print("Enter a limit:");
    int k=sc.nextInt();
    System.out.println("Multiplication table for"+num+":");
    System.out.println("Limit:"+k+":");
    for(int i=1;i<=k;i++){
     System.out.println(num+"x"+i+"="+(num*i));
    }sc.close();
    }
}
