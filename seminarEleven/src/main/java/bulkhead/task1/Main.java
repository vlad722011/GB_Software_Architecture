package bulkhead.task1;

// Класс для запуска примера
public class Main {
    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool(3);

        // Запускаем работников в пуле
        threadPool.execute(0); // Worker 1 is performing work.
        threadPool.execute(1); // Worker 2 is performing work.
        threadPool.execute(2); // Worker 3 is performing work.

        // Попытка запустить несуществующего работника
        threadPool.execute(3); // Invalid worker index.

    }
}
