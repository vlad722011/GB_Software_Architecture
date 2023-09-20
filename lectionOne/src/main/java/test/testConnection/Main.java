package test.testConnection;

// Абстрактный класс (Abstract Class)
abstract class Animal {
    void breathe() {
        System.out.println("Breathing...");
    }
}

// Интерфейс (Interface)
interface Eatable {
    void eat();
}

// Класс (Class) с наследованием (Inheritance)
class Mammal extends Animal {
}

// Класс (Class) с реализацией интерфейса (Realization)
class Human extends Mammal implements Eatable {
    // Агрегация (Aggregation): Human может иметь одну или несколько кошек, но не владеет ими
    Cat petCat;

    // Методы (Methods)
    @Override
    public void eat() {
        System.out.println("Eating food.");
    }

    void ownCat(Cat cat) {
        this.petCat = cat;
    }
}

// Класс (Class) для демонстрации агрегации
class Cat {
    void meow() {
        System.out.println("Meow...");
    }
}

// Класс (Class) с композицией (Composition)
class House {
    // Композиция: House владеет Room объектами
    Room room = new Room();

    House() {
        System.out.println("House created with a room.");
    }
}

// Класс (Class) для демонстрации композиции
class Room {
    void description() {
        System.out.println("This is a room.");
    }
}

// Главный класс (Main Class) для демонстрации зависимости (Dependency)
/**
 * комментарии указывают на различные типы связей между классами,
 * которые могут быть представлены на диаграмме классов UML
 * В этом примере представлены следующие типы связей:
 *
 * Наследование (Inheritance): Mammal наследуется от Animal, Human наследуется от Mammal.
 * Реализация (Realization): Human реализует интерфейс Eatable.
 * Агрегация (Aggregation): Human может иметь Cat в качестве домашнего животного,
 * но не владеет им.
 * Композиция (Composition): House владеет Room.
 * Зависимость (Dependency): Главный класс Main зависит от Human
 * и Cat для своего выполнения.
 * */
public class Main {
    public static void main(String[] args) {
        // Зависимость: Main зависит от Human и Cat для выполнения
        Human human = new Human();
        Cat cat = new Cat();
        human.ownCat(cat);

        // Ассоциация: Human и Cat связаны через агрегацию
        human.petCat.meow();

        // Композиция: House и Room связаны через композицию
        House house = new House();
        house.room.description();
    }
}
