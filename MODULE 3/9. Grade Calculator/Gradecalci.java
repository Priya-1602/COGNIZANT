import java.util.Scanner;
public class Gradecalci{
 public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter marks:");
    int marks=sc.nextInt();
    char grade;
    if(marks>=90 && marks<=100){
     grade='A';
    }else if(marks>=80 && marks<=89){
    grade='B';
    }else if(marks>=70 && marks<=79){
    grade = 'C';
    }else if(marks>=60 && marks<=69){
    grade = 'D';
    }else if(marks>=0 && marks<60){
    grade = 'F';
    }else{
    System.out.println("Invalid marks");
    sc.close();
    return;
      }
    System.out.println("Grade:"+grade);
    sc.close();
}
}
