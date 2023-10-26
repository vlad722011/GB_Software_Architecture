package bulkhead.task1;

// Класс представляет компонент системы (работника)
public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    // Метод для выполнения работы компонента
    public void doWork() {
        if (name.equals("Worker 2")) {
            System.out.println("I am ill.");;
        }
        System.out.println(name + " is performing work.");
    }
}
