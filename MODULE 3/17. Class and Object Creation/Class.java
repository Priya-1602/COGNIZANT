public class Class{
    String make;
    String model;
    int year;
    Class(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
    public static void main(String[] args){
        Class car1 = new Class("Toyota", "Corolla", 2020);
        Class car2 = new Class("Honda", "Civic", 2021);
        car1.displayDetails();
        car2.displayDetails();
    }
}