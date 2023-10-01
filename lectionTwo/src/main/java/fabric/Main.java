package fabric;

public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal dog = animalFactory.createAnimal("dog");
        dog.makeSound(); // Вывод: Собака лает

        Animal cat = animalFactory.createAnimal("cat");
        cat.makeSound(); // Вывод: Кошка мяукает
    }
}