package adapter;

import java.util.ArrayList;
import java.util.List;

// Интерфейс, ожидаемый клиентским кодом
interface Soundable {
    void makeSound();
}

// Класс Lion (лев)
class Lion {
    public void roar() {
        System.out.println("Lion roars!");
    }
}

// Класс Duck (утка)
class Duck {
    public void quack() {
        System.out.println("Duck quacks!");
    }
}

// Адаптер для класса Lion
class LionAdapter implements Soundable {
    private Lion lion;

    public LionAdapter(Lion lion) {
        this.lion = lion;
    }

    @Override
    public void makeSound() {
        // Преобразование вызова метода makeSound() в roar()
        lion.roar();
    }
}

// Адаптер для класса Duck
class DuckAdapter implements Soundable {
    private Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void makeSound() {
        // Преобразование вызова метода makeSound() в quack()
        duck.quack();
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Lion и Duck
        Lion lion = new Lion();
        Duck duck = new Duck();

        // Создаем адаптеры для Lion и Duck
        List<Soundable> listSound = new ArrayList<>();
        listSound.add(new LionAdapter(lion));
        listSound.add(new DuckAdapter(duck));
//        Soundable lionAdapter = new LionAdapter(lion);
//        Soundable duckAdapter = new DuckAdapter(duck);

        // Клиентский код ожидает объекты с интерфейсом Animal,
        // но может использовать адаптеры для вызова метода makeSound()
//        lionAdapter.makeSound(); // Вывод: Lion roars!
//        duckAdapter.makeSound(); // Вывод: Duck quacks!

        for (Soundable animal: listSound) {
            animal.makeSound();
        }
    }
}
