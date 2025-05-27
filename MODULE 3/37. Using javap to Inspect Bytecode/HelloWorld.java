public class HelloWorld {
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        System.out.println(hw.add(3, 4));
    }
}
