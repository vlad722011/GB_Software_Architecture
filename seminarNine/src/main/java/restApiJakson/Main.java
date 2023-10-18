package restApiJakson;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonExample.Book;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    // Эмулируем базу данных с использованием списка в памяти.
    private static List<restApiJakson.Main.User> users = new ArrayList<>();
    private static AtomicInteger idGenerator = new AtomicInteger(1); // Генератор ID для пользователей.

    public static void main(String[] args) throws IOException {

        // SERVER

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // Привязываем обработчик к пути "/users". Каждый раз, когда будет делаться запрос к этому пути,
        // будет вызываться метод handle() экземпляра класса UsersHandler.
        server.createContext("/users", new UsersHandler());
        // Запускаем сервер.
        server.start();
        System.out.println("Server started on port 8080");


        // USER
/*
        // Создаем объект ObjectMapper для работы с JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Создаем новый объект User
        User user = new User();
        System.out.println(user.toString());

        // Сериализуем объект Book в строку JSON
        String jsonString = objectMapper.writeValueAsString(user);
        System.out.println("Serialized JSON: " + jsonString);

        // Сохраняем JSON строку в файл
        Files.write(Paths.get("user.json"), jsonString.getBytes());

        // Чтение JSON строки из файла
        String readJson = new String(Files.readAllBytes(Paths.get("user.json")));

        // Десериализация JSON строки из файла обратно в объект

        User deserializedUser = objectMapper.readValue(jsonString, User.class);
        System.out.println("Deserialized Object from File: " + deserializedUser);

 */


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

    static class UsersHandler implements HttpHandler {
        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                // Возвращаем список всех пользователей.
                String responseBody = users.toString();
                exchange.sendResponseHeaders(200, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Добавляем нового пользователя.
                int newId = idGenerator.getAndIncrement();
                User newUser = new User(newId, "User" + newId);
                users.add(newUser);
                String responseBody = objectMapper.writeValueAsString(newUser);
                exchange.sendResponseHeaders(201, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                // Удаляем пользователя по ID.
                String[] pathParts = exchange.getRequestURI().getPath().split("/");
                if (pathParts.length == 3) {
                    int userId = Integer.parseInt(pathParts[2]);
                    users.removeIf(user -> user.getId() == userId);
                    String responseBody = "User with ID " + userId + " removed.";
                    exchange.sendResponseHeaders(200, responseBody.length());
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                }
            } else {
                String responseBody = "Method not allowed";
                exchange.sendResponseHeaders(405, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        }


    }


}


