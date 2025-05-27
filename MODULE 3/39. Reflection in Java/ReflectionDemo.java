import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("SampleClass");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            Parameter[] parameters = method.getParameters();
            System.out.print("Parameters: ");
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getSimpleName() + " ");
            }
            System.out.println();
            method.setAccessible(true);
            if (method.getName().equals("greet")) {
                method.invoke(obj, "Alice");
            } else if (method.getName().equals("add")) {
                Object result = method.invoke(obj, 10, 20);
                System.out.println("Result of add: " + result);
            } else if (method.getName().equals("secretMethod")) {
                method.invoke(obj);
            }
            System.out.println();
        }
    }
}

