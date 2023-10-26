package circuitBreaker;

// Класс для запуска примера
public class Main {
    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker(false, 3, 0);
        UserService userService = new UserService(circuitBreaker);

        System.out.println("_________________________________________________________");
        // Имитируем 10 запросов, включая три ошибки
        System.out.println("Имитируем 10 запросов, включая три ошибки (запросы 3-4-5).");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int userID = i + 1;
            System.out.print("Запрос №" + (i + 1) + ". ");
            // Имитируем три ошибки
            if ((i >= 2 && i <= 5)) {
                circuitBreaker.setOpen(true);
                if (circuitBreaker.getFailureCount() == 3) {
                    circuitBreaker.reset();
                } else {
                    userService.reportFailure();
                    circuitBreaker.setFailureCount(circuitBreaker.getFailureCount());
                }
            }
            String userInfo = userService.getUserInfo(userID);
            System.out.println(userInfo);
        }
        System.out.println("_________________________________________________________");
        System.out.println();

        // Сбрасываем Circuit Breaker
        System.out.println("Сбрасываем Circuit Breaker");
        userService.resetCircuitBreaker();

        // Пробуем снова после сброса
        System.out.println();
        System.out.println("Пробуем снова после сброса получить информацию о пользователе.");
        String userInfoAfterReset = userService.getUserInfo(123);
        System.out.println(userInfoAfterReset);
    }
}