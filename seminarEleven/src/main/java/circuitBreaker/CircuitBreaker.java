package circuitBreaker;
// Класс, представляющий паттерн Circuit Breaker
class CircuitBreaker {
    private boolean isOpen = false;         // Флаг, указывающий, открыт ли Circuit Breaker
    private int failureThreshold = 3;       // Количество ошибок для срабатывания Circuit Breaker
    private int failureCount = 0;           // Счетчик ошибок


    public CircuitBreaker(boolean isOpen, int failureThreshold, int failureCount) {
        this.isOpen = isOpen;
        this.failureThreshold = failureThreshold;
        this.failureCount = failureCount;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getFailureThreshold() {
        return failureThreshold;
    }

    public void setFailureThreshold(int failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(int failureCount) {
        this.failureCount = failureCount;
    }

    // Метод, разрешающий или блокирующий запросы в зависимости от состояния Circuit Breaker
    public boolean allowRequest() {
        if (isOpen) {
            System.out.println("Ошибка. Circuit Breaker блокирует запросы.");
            return false;
        }

        if (failureCount >= failureThreshold) {
            isOpen = true;
            System.out.println("Circuit Breaker opened");
            return false;
        }

        return true;
    }

    // Метод для записи ошибки в Circuit Breaker
    public void recordFailure() {
        failureCount++;
        System.out.print("Failure recorded. Failure count: " + failureCount + " ");
    }

    // Метод для сброса состояния Circuit Breaker
    public void reset() {
        isOpen = false;
        failureCount = 0;
        System.out.println("Circuit Breaker reset");
        System.out.println("Circuit Breaker closed. Request enabled");
    }
}