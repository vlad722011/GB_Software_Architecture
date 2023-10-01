package fabric;

public class AnimalFactory {
    // Фабричный метод, который создает экземпляры подклассов Animal
    public Animal createAnimal(String animalType) {
        if ("dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("cat".equalsIgnoreCase(animalType)) {
            return new Cat();
        } else {
            throw new IllegalArgumentException("Неподдерживаемый тип животного");
        }
    }
}
