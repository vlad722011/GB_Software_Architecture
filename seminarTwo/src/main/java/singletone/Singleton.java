package singletone;

public class Singleton {

    // Приватное статическое поле для хранения единственного экземпляра класса
    private static Singleton instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private Singleton() {
        // Инициализация
    }

    // Публичный статический метод для получения экземпляра Singleton
    public static Singleton getInstance() {
        // Если экземпляр ещё не создан, создаем его
        if (instance == null) {
            instance = new Singleton();
        }
        // Возвращаем единственный экземпляр
        return instance;
    }

    // Другие методы и поля класса

    public void doSomething() {
        System.out.println("Вызван метод doSomething()");
    }
}
