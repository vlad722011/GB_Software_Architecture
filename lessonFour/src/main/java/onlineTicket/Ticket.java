package onlineTicket;

import java.util.Date;

// Абстрактный класс и наследование
abstract class Ticket implements TicketActions {
    String routeId;
    Date departureTime;
    double price;
}
