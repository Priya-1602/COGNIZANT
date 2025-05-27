public class Methodoverloading{
 public static int add(int a,int b){
    return a + b;
}
public static double add(double a,double b){
        return a + b;
    }
public static int add(int a,int b,int c){
        return a + b + c;
}
public static void main(String[] args) {
    int sum1 = add(5, 10);
    System.out.println("Sum of two integers (5 + 10):"+sum1);
    double sum2 = add(3.5, 4.7);
    System.out.println("Sum of two doubles (3.5 + 4.7):"+sum2);
    int sum3 = add(1, 2, 3);
    System.out.println("Sum of three integers (1 + 2 + 3):"+sum3);
    }
}

