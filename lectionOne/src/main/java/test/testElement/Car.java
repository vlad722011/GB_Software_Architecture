package test.testElement;

// Класс (Class) с реализацией интерфейса (Realization)
public class Car extends Vehicle implements Drivable {
    FuelType fuelType;

    // Атрибуты (Attributes)
    private int speed;
    public String color;

    // Методы (Methods)
    public void accelerate() {
        speed += 10;
    }

    public void brake() {
        speed -= 10;
    }

    // Реализация интерфейса
    public void drive() {
        System.out.println("Driving...");
    }

    // Реализация абстрактного метода
    void start() {
        System.out.println("Starting the car.");
    }
}
