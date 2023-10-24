package patterns.composite;

import java.util.ArrayList;
import java.util.List;

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

// Класс для группы животных (композиция)
class AnimalGroup implements IAnimalDescriber {
    private List<IAnimalDescriber> animals = new ArrayList<>();

    public void addAnimal(IAnimalDescriber animal) {
        animals.add(animal);
    }

    @Override
    public void describe() {
        for (IAnimalDescriber animal : animals) {
            animal.describe();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем отдельных животных
        BasicAnimal lion = new BasicAnimal("Лев");
        BasicAnimal elephant = new BasicAnimal("Слон");

        // Создаем группу животных и добавляем в нее отдельных животных
        AnimalGroup animalGroup = new AnimalGroup();
        animalGroup.addAnimal(lion);
        animalGroup.addAnimal(elephant);

        // Выводим описание отдельных животных и группы
        System.out.println("Отдельные животные:");
        lion.describe();
        elephant.describe();

        System.out.println("\nГруппа животных:");
        animalGroup.describe();
    }
}
