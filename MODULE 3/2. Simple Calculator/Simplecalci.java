import java.util.Scanner;
public class Simplecalci {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    double num1 = sc.nextDouble();
    System.out.print("Enter the second number: ");
    double num2 = sc.nextDouble();
    System.out.println("Choose an operation: +, -, *, /");
    char operation = sc.next().charAt(0);
    double result;
    switch (operation) {
    case '+':
        result = num1 + num2;
        System.out.println("Result: " + result);
        break;
    case '-':
        result = num1 - num2;
        System.out.println("Result: " + result);
        break;
    case '*':
        result = num1 * num2;
        System.out.println("Result: " + result);
            break;
    case '/':
        if (num2 != 0) {
         result = num1 / num2;
         System.out.println("Result: " + result);
    } else {
        System.out.println("Error: Cannot divide by zero.");
    }break;
     default:
        System.out.println("Invalid operation.");
}
 sc.close();
}
}
