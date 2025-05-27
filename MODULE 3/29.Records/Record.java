import java.util.List;
import java.util.stream.Collectors;
public class Record{
    public record Person(String name,int age){}
    public static void main(String[] args){
        Person p1=new Person("Priya", 30);
        Person p2=new Person("Devi", 20);
        Person p3=new Person("Thou", 25);
        System.out.println("Persons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        List<Person> people=List.of(p1, p2, p3);
        List<Person> filtered=people.stream()
                .filter(person ->person.age() >= 25)
                .collect(Collectors.toList());
        System.out.println("\nFiltered(age >= 25):");
        filtered.forEach(System.out::println);
    }
}
