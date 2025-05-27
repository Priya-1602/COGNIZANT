import java.util.Scanner;
public class Arraysumandaverage {
 public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements:");
        int n=sc.nextInt();
        if(n<=0){
            System.out.println("Number should be positive.");
            sc.close();
            return;
        }
    int[] numbers=new int[n];
        System.out.println("Enter"+n+"integers:");
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }
        int sum=0;
        for (int num:numbers){
          sum += num;
        }
        double avg=(double)sum/n;
        System.out.println("Sum of array elements:"+sum);
        System.out.println("Average of array elements:"+avg);
        sc.close();
    }
}
