public class Patternmatching{
    public static void identifyObjectType(Object obj){
        String res=switch(obj){
            case Integer i ->"It's an Integer with value"+i;
            case String s ->"It's a String with value \""+s+"\"";
            case Double d ->"It's a Double with value"+d;
            case null ->"It's null";
            default ->"Unknown type:"+obj.getClass().getSimpleName();
        };
        System.out.println(res);
    }
    public static void main(String[] args){
        identifyObjectType(42);
        identifyObjectType("Java");
        identifyObjectType(3.14159);
        identifyObjectType(true);  
        identifyObjectType(null);
    }
}
