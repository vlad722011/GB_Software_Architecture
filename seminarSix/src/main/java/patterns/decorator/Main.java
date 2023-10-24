package patterns.decorator;

// Интерфейс для животных
interface IAnimalDescriber {
    void describe();
}

// Реализация базового интерфейса для животных
class BasicAnimal implements IAnimalDescriber {
    private String description;

    public BasicAnimal(String description) {
        this.description = description;
    }

    @Override
    public void describe() {
        System.out.println(description);
    }
}

// Декоратор для добавления цвета животным
class ColorDecorator implements IAnimalDescriber {
    private IAnimalDescriber animal;
    private String color;

    public ColorDecorator(IAnimalDescriber animal, String color) {
        this.animal = animal;
        this.color = color;
    }

    @Override
    public void describe() {
        animal.describe();
        System.out.println("Цвет: " + color);
    }
}

// Декоратор для добавления размера животным
class SizeDecorator implements IAnimalDescriber {
    private IAnimalDescriber animal;
    private String size;

    public SizeDecorator(IAnimalDescriber animal, String size) {
        this.animal = animal;
        this.size = size;
    }

    @Override
    public void describe() {
        animal.describe();
        System.out.println("Размер: " + size);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем базового животного
        IAnimalDescriber basicAnimal = new BasicAnimal("Это животное");

        // Декорируем его цветом и размером
        IAnimalDescriber coloredAnimal = new ColorDecorator(basicAnimal, "красный");
        IAnimalDescriber sizedAnimal = new SizeDecorator(coloredAnimal, "большой");

        // Выводим описание животного с учетом декораций
        sizedAnimal.describe();
    }
}
