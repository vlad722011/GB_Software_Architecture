package test.testElement;

// Интерфейс (Interface)
interface Drivable {
    void drive();
}

// Абстрактный класс (Abstract Class)
abstract class Vehicle {
    String make;
    abstract void start();
}

// Перечисление (Enumeration)
enum FuelType {
    PETROL, DIESEL, ELECTRIC
}

// Класс (Class)
class ElectricCar extends Car {
    int batteryLife;

    // Методы (Methods)
    void charge() {
        System.out.println("Charging...");
    }

    // Переопределение (Override)
    @Override
    void start() {
        System.out.println("Starting the electric car.");
    }
}

// Главный класс (Main Class)
/**
 * пример кода на Java, который включает различные элементы,
 * которые можно было бы отобразить на диаграмме классов UML:
 * Этот код включает примеры различных элементов: пакет, интерфейс, абстрактный класс,
 * перечисление, классы, атрибуты и методы. Также он показывает реализацию интерфейса и
 * наследование. Вы можете использовать этот код для генерации UML-диаграммы с
 * помощью вашего плагина. Если нужно что-то ещё, дайте знать.
 * */
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        ElectricCar myElectricCar = new ElectricCar();

        // Использование объектов (Association)
        myCar.start();
        myElectricCar.start();
    }
}
