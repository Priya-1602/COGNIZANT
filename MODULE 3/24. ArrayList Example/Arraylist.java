import java.util.ArrayList;
import java.util.Scanner;
public class Arraylist{
  public static void main(String[] args){
        ArrayList<String> studentNames=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String input;
        System.out.println("Enter student names (type 'over' to finish):");
        while (true){
            System.out.print("Enter name:");
            input=sc.nextLine();
            if(input.equalsIgnoreCase("over")){
                break;
            }
            studentNames.add(input);
        }
        System.out.println("\nList of student names:");
        for (String name:studentNames){
            System.out.println(name);
        }
        sc.close();
    }
}

