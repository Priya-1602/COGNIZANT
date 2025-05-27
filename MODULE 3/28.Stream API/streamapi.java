import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class streamapi{
    public static void main(String[] args){
        List<Integer> num=Arrays.asList(5, 12, 7, 8, 20, 3, 10, 15);
        System.out.println("Original list:"+num);
        List<Integer>evennum=num.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println("Even numbers:"+evennum);
    }
}
