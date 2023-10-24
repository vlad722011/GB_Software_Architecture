package essences;

import java.util.List;

// Уровень сущностей (Entities)
class Animal {
    private int id;
    private String name;
    private String species;
    private int age;

    public Animal(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }
}

// Уровень интерфейсов (Interfaces)
interface AnimalRepository {
    void addAnimal(Animal animal);
    List<Animal> getAllAnimals();
}

// Уровень бизнес-логики (Use Cases)
class AnimalService {
    private AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public void addAnimal(String name, String species, int age) {
        Animal animal = new Animal(0, name, species, age);
        repository.addAnimal(animal);
    }

    public List<Animal> getAllAnimals() {
        return repository.getAllAnimals();
    }
}

// Уровень представления (не реализован в данном примере)

public class ZooApp {
    public static void main(String[] args) {
        // Создаем репозиторий для животных
        AnimalRepository repository = new InMemoryAnimalRepository();

        // Создаем сервис для работы с животными
        AnimalService service = new AnimalService(repository);

        // Добавляем животных
        service.addAnimal("Лев", "Млекопитающее", 5);
        service.addAnimal("Зебра", "Млекопитающее", 3);
        service.addAnimal("Попугай", "Птица", 1);

        // Получаем список всех животных и выводим на экран
        List<Animal> animals = service.getAllAnimals();
        for (Animal animal : animals) {
            System.out.println("ID: " + animal.getId());
            System.out.println("Имя: " + animal.getName());
            System.out.println("Вид: " + animal.getSpecies());
            System.out.println("Возраст: " + animal.getAge());
            System.out.println();
        }
    }
}
