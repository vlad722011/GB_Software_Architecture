package prototype;

public class Main {
    public static void main(String[] args) {
        // Создаем собаку и кошку (оригинальные объекты)
        Dog originalDog = new Dog("Buddy");
        Cat originalCat = new Cat("Whiskers");

        // Клонируем собаку и кошку
        Dog clonedDog = (Dog) originalDog.clone();
        Cat clonedCat = (Cat) originalCat.clone();


        // Выводим имена клонированных животных
        System.out.println("Cloned Dog's Name: " + clonedDog.getName());
        System.out.println("Cloned Cat's Name: " + clonedCat.getName());
    }
}
