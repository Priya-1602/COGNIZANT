import java.util.Scanner;
public class Stringrev{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string:");
        String input=sc.nextLine();
        String rev=new StringBuilder(input).reverse().toString();
        System.out.println("Reversed string:"+rev);
        sc.close();
    }
}
