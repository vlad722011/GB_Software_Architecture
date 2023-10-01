package onlineTicket;

import java.util.Date;

/**
 * Компонент: UserActions
 * Версия: 1.0.0
 *
 * Описание: Этот компонент определяет контракты для действий пользователя.
 *
 * Изменения:
 * - 1.0.0: Первая версия.
 * - 1.1.0: Добавлена поддержка новой функциональности.
 */
interface UserActions {
    boolean authorize(String username, String password);
    boolean selectRoute(String routeId, Date time);
    boolean checkTicketAvailability();
    boolean checkFunds();
}
