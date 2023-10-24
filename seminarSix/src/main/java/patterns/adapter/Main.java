package patterns.adapter;

// Класс Лев
class Lion {
    void roar() {
        System.out.println("Лев рычит");
    }
}

// Класс Слон
class Elephant {
    void trumpet() {
        System.out.println("Слон издает трубный звук");
    }
}

// Интерфейс, ожидаемый клиентским кодом
interface IAnimalSound {
    void makeSound();
}

// Адаптер для класса Лев
class LionAdapter implements IAnimalSound {
    private Lion lion;

    public LionAdapter(Lion lion) {
        this.lion = lion;
    }

    @Override
    public void makeSound() {
        lion.roar();
    }
}

// Адаптер для класса Слон
class ElephantAdapter implements IAnimalSound {
    private Elephant elephant;

    public ElephantAdapter(Elephant elephant) {
        this.elephant = elephant;
    }

    @Override
    public void makeSound() {
        elephant.trumpet();
    }
}

public class Main {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Elephant elephant = new Elephant();

        IAnimalSound lionAdapter = new LionAdapter(lion);
        IAnimalSound elephantAdapter = new ElephantAdapter(elephant);

        lionAdapter.makeSound();      // Вывод: Лев рычит
        elephantAdapter.makeSound();  // Вывод: Слон издает трубный звук
    }
}