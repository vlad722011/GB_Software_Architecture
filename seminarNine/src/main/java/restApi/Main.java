package restApi;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


// проверка через консоль:
// curl -X POST http://localhost:8080/users
// curl -X GET http://localhost:8080/users
public class Main {
    public static void main(String[] args) throws IOException {
// Создаем экземпляр HTTP-сервера, который будет слушать порт 8080.
// Второй аргумент (0) указывает, что сервер будет автоматически устанавливать лимит ожидания для подключения.
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

// Привязываем обработчик к пути "/users". Каждый раз, когда будет делаться запрос к этому пути,
// будет вызываться метод handle() экземпляра класса UsersHandler.
        server.createContext("/users", new UsersHandler());

// Запускаем сервер.
        server.start();
        System.out.println("Server started on port 8080");
    }

    // Класс-обработчик для пути "/users"
    static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
// Проверяем, какой метод HTTP использовался при запросе.
// Здесь мы обрабатываем только GET и POST методы.

            if ("GET".equals(exchange.getRequestMethod())) {
// Если метод GET, мы просто отправляем строку "List of users" в качестве ответа.
                String responseBody = "List of users";
// Устанавливаем HTTP статус ответа (200 OK) и длину тела ответа.
                exchange.sendResponseHeaders(200, responseBody.length());
// Получаем OutputStream, чтобы записать тело ответа, и отправляем туда нашу строку.
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
// Если метод POST, представим, что мы добавили нового пользователя
// (хотя на самом деле мы просто отправляем строку "User added" в качестве ответа).
                String responseBody = "User added";
// Устанавливаем HTTP статус ответа (201 Created) и длину тела ответа.
                exchange.sendResponseHeaders(201, responseBody.length());
// Записываем тело ответа.
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else {
// Если пришел другой HTTP метод, который мы не поддерживаем, отправляем ответ "Method not allowed".
                String responseBody = "Method not allowed";
// Устанавливаем HTTP статус ответа (405 Method Not Allowed) и длину тела ответа.
                exchange.sendResponseHeaders(405, responseBody.length());
// Записываем тело ответа.
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        }
    }
}
