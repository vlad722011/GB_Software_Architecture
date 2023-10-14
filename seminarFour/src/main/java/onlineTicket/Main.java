package onlineTicket;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр пользователя
        User user = new User();

        // Предположим, что пользователь авторизован и выбран маршрут
        // и что у него есть достаточно средств для бронирования.

        // Пытаемся забронировать билет
        boolean isBookingSuccessful = user.reserveTicket();

        // Проверяем результат
        if (isBookingSuccessful) {
            System.out.println("Билет успешно забронирован.");
        } else {
            System.out.println("Не удалось забронировать билет.");
        }
    }
}
