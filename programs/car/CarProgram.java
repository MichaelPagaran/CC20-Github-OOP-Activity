package programs.car;

import core.ProgramInterface;

public class CarProgram implements ProgramInterface {

    // Inner Car class
    class Car {
        private String brand;
        private String color;
        private int year;

        public Car(String brand, String color, int year) {
            this.brand = brand;
            this.color = color;
            this.year = year;
        }

        public void startEngine() {
            System.out.println(brand + " engine is starting...");
        }

        public String getDetails() {
            return "Brand: " + brand + ", Color: " + color + ", Year: " + year;
        }
    }

    // Methods required by ProgramInterface
    @Override
    public String getName() {
        return "Car OOP Program";
    }

    @Override
    public String getDescription() {
        return "Demonstrates OOP using a Car class with attributes, constructor, and methods.";
    }

    @Override
    public String getAuthor() {
        return "Mark Jan M. Ostrea";
    }

    @Override
    public void run() {
        Car car1 = new Car("Toyota", "Red", 2022);
        Car car2 = new Car("Honda", "Blue", 2023);

        car1.startEngine();
        System.out.println(car1.getDetails());

        car2.startEngine();
        System.out.println(car2.getDetails());
    }
}
