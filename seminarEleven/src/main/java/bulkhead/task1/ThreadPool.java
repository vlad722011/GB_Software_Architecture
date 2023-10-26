package bulkhead.task1;

import java.util.ArrayList;
import java.util.List;

// Класс представляет пул потоков с изолированными работниками
public class ThreadPool {
    private List<Worker> workers = new ArrayList<>();     // Список изолированных работников

    // Конструктор, создающий пул из определенного числа работников
    public ThreadPool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            workers.add(new Worker("Worker " + (i + 1)));
        }
    }

    // Метод для выполнения работы с использованием изолированных работников
    public void execute(int workerIndex){
        if (workerIndex >= 0 && workerIndex < workers.size()) {
            Worker worker = workers.get(workerIndex);
            worker.doWork();
        } else {
            System.out.println("Invalid worker index.");
        }
    }
}
