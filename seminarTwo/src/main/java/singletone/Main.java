package singletone;

public class Main {
    public static void main(String[] args) {
        // Получаем экземпляр Singleton
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton1);
        System.out.println(singleton);

        // Вызываем методы
        singleton.doSomething();
    }
}
