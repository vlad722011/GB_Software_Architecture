package circuitBreaker;

// Класс, представляющий сервис пользователя
class UserService {
    private CircuitBreaker circuitBreaker;

    // Конструктор, принимающий экземпляр Circuit Breaker
    public UserService(CircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    // Метод для получения информации о пользователе
    public String getUserInfo(int userId) {
        if (!circuitBreaker.allowRequest()) {
            return "Сервис получения информации о пользовтале недоступен. Блокируется - Circuit Breaker. Запросы недоступны.";
        }

        // Здесь был бы код для получения информации о пользователе
        // В данном примере мы просто имитируем успешный запрос
        System.out.println("Вызван метод: - getUserInfo(). Пытаемся получить информацию о пользователе:");
        return "Успех. Информация о пользователе: - User " + userId;
    }

    // Метод для сообщения об ошибке в Circuit Breaker
    public void reportFailure() {
        circuitBreaker.recordFailure();
        System.out.println("reportFailure() method is called.");
    }

    // Метод для сброса состояния Circuit Breaker
    public void resetCircuitBreaker() {
        circuitBreaker.reset();
        System.out.println("resetCircuitBreaker() method is called.");
    }
}