package Api;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static List<User> users = new ArrayList<>();
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private static ObjectMapper objectMapper = new ObjectMapper(); // Создаем объект ObjectMapper

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/users", new UsersHandler());
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Метод handle обрабатывает все HTTP-методы (GET, POST, DELETE) и другие методы.

            // Проверяем метод HTTP, который был использован в запросе.
            if ("GET".equals(exchange.getRequestMethod())) {
                // Если это GET-запрос, мы возвращаем список пользователей в формате JSON.

                // Преобразуем список пользователей в JSON-строку.
                String responseBody = objectMapper.writeValueAsString(users);

                // Устанавливаем заголовок Content-Type как "application/json".
                exchange.getResponseHeaders().set("Content-Type", "application/json");

                // Устанавливаем HTTP статус ответа 200 OK и длину тела ответа.
                exchange.sendResponseHeaders(200, responseBody.length());

                // Получаем OutputStream, чтобы записать тело ответа, и отправляем туда нашу JSON-строку.
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Если это POST-запрос, предполагается создание нового пользователя.

                // Генерируем новый уникальный ID.
                int newId = idGenerator.getAndIncrement();

                // Создаем нового пользователя с уникальным ID и именем.
                User newUser = new User(newId, "User" + newId);

                // Добавляем нового пользователя в список пользователей.
                users.add(newUser);

                // Преобразуем нового пользователя в JSON-строку.
                String responseBody = objectMapper.writeValueAsString(newUser);

                // Устанавливаем заголовок Content-Type как "application/json".
                exchange.getResponseHeaders().set("Content-Type", "application/json");

                // Устанавливаем HTTP статус ответа 201 Created и длину тела ответа.
                exchange.sendResponseHeaders(201, responseBody.length());

                // Получаем OutputStream, чтобы записать тело ответа, и отправляем туда нашу JSON-строку.
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                // Если это DELETE-запрос, предполагается удаление пользователя по ID.

                // Разбираем путь запроса для извлечения ID пользователя.
                String[] pathParts = exchange.getRequestURI().getPath().split("/");
                if (pathParts.length == 3) {
                    int userId = Integer.parseInt(pathParts[2]);

                    // Удаляем пользователя из списка по ID.
                    users.removeIf(user -> user.getId() == userId);

                    // Формируем сообщение об успешном удалении пользователя в JSON-формате.
                    String responseBody = "{\"message\":\"User with ID " + userId + " removed.\"}";

                    // Устанавливаем заголовок Content-Type как "application/json".
                    exchange.getResponseHeaders().set("Content-Type", "application/json");

                    // Устанавливаем HTTP статус ответа 200 OK и длину тела ответа.
                    exchange.sendResponseHeaders(200, responseBody.length());

                    // Получаем OutputStream, чтобы записать тело ответа, и отправляем туда наше сообщение.
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                }
            } else {
                // Если пришел другой HTTP метод, который не поддерживается, отправляем ответ "Method not allowed".

                // Формируем сообщение об ошибке в JSON-формате.
                String responseBody = "{\"error\":\"Method not allowed\"}";

                // Устанавливаем заголовок Content-Type как "application/json".
                exchange.getResponseHeaders().set("Content-Type", "application/json");

                // Устанавливаем HTTP статус ответа 405 Method Not Allowed и длину тела ответа.
                exchange.sendResponseHeaders(405, responseBody.length());

                // Получаем OutputStream, чтобы записать тело ответа, и отправляем туда наше сообщение.
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        }
    }

    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

