import java.util.HashMap;
import java.util.Scanner;
public class Hashmap{
    public static void main(String[] args){
        HashMap<Integer, String> studentMap=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        String input;
        int id;
        System.out.println("Add student entries (type 'done' to stop):");
        while (true){
            System.out.print("Enter student ID:");
            input=sc.nextLine();
            if (input.equalsIgnoreCase("done")){
                break;
            }
            try{
                id = Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("Invalid ID. Please enter a valid integer.");
                continue;
            }
            System.out.print("Enter student name:");
            String name=sc.nextLine();
            studentMap.put(id, name);
            System.out.println("Entry added.\n");
        }
        System.out.print("Enter student ID to retrieve name: ");
    try {
            int searchId = Integer.parseInt(sc.nextLine());
            if (studentMap.containsKey(searchId)){
                System.out.println("Student Name: "+studentMap.get(searchId));
            } else {
                System.out.println("No student found with ID "+searchId);
            }
    }catch(NumberFormatException e){
            System.out.println("Invalid input");
        }sc.close();
    }
}
