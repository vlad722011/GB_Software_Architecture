package abstractFactory;

public class Main {
    public static void main(String[] args) {
        // Создаем фабрику для африканских животных
        AnimalFactory africanFactory = new AfricanAnimalFactory();

        // Создаем африканского льва и африканскую утку
        Lion africanLion = africanFactory.createLion();
        Duck africanDuck = africanFactory.createDuck();

        // Выводим звуки и действия африканских животных
        africanLion.roar(); // Вывод: Lion roars!
        ((AfricanLion) africanLion).hunt(); // Вывод: African Lion hunts for prey!
        africanDuck.quack(); // Вывод: Duck quacks!

        // Создаем фабрику для азиатских животных
        AnimalFactory asianFactory = new AsianAnimalFactory();

        // Создаем азиатского льва и азиатскую утку
        Lion asianLion = asianFactory.createLion();
        Duck asianDuck = asianFactory.createDuck();

        // Выводим звуки и действия азиатских животных
        asianLion.roar(); // Вывод: Lion roars!
        ((AsianLion) asianLion).performTrick(); // Вывод: Asian Lion performs a trick!
        asianDuck.quack(); // Вывод: Duck quacks!
    }
}