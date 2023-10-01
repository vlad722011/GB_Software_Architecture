package prototype;

// Абстрактный класс Прототипа
abstract class Animal implements Cloneable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактный метод клонирования
    public abstract Animal clone();
}

// Конкретный класс животного (Прототип)
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Реализация метода клонирования для собаки
    @Override
    public Animal clone() {
        return new Dog(this.getName());
    }
}

// Конкретный класс животного (Прототип)
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Реализация метода клонирования для кошки
    @Override
    public Animal clone() {
        return new Cat(this.getName());
    }
}
