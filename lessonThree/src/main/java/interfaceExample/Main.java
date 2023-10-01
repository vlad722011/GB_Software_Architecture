package interfaceExample;

import java.util.ArrayList;
import java.util.List;

// Интерфейс для всех летающих существ
interface Flyable {
    void takeOff();
    void land();
    void fly();
}

// Класс, реализующий интерфейс Flyable
class Bird implements Flyable {
    public void takeOff() {
        System.out.println("Bird takes off");
    }

    public void land() {
        System.out.println("Bird lands");
    }

    public void fly() {
        System.out.println("Bird flies");
    }
}

// Класс, реализующий интерфейс Flyable
class Airplane implements Flyable {
    public void takeOff() {
        System.out.println("Airplane takes off");
    }

    public void land() {
        System.out.println("Airplane lands");
    }

    public void fly() {
        System.out.println("Airplane flies");
    }
}

public class Main {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        Flyable airplane = new Airplane();

        List<Flyable> flyableList = new ArrayList<>();
        flyableList.add(bird);
        flyableList.add(airplane);

        for (Flyable f : flyableList) {
            f.takeOff();
            f.fly();
            f.land();
        }

        bird.takeOff();      // Output: "Bird takes off"
        bird.fly();          // Output: "Bird flies"
        bird.land();         // Output: "Bird lands"

        airplane.takeOff();  // Output: "Airplane takes off"
        airplane.fly();      // Output: "Airplane flies"
        airplane.land();     // Output: "Airplane lands"
    }
}
