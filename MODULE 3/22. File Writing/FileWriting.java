import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileWriting{
 public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string to write to the file:");
        String input=sc.nextLine();
        try{
            FileWriter writer=new FileWriter("output.txt");
            writer.write(input);
            writer.close();
            System.out.println("Data written to output.txt successfully.");
        }catch(IOException e){
            System.out.println("error.");
            e.printStackTrace();
        }finally{
            sc.close();
        }
    }
}

