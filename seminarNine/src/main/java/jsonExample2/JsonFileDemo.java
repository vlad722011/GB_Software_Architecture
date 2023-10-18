package jsonExample2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileDemo {

    public static void main(String[] args) throws Exception {
// Создаем объект ObjectMapper для работы с JSON
        ObjectMapper objectMapper = new ObjectMapper();

// Создаем новый объект Book
        Book book = new Book("1984", "George Orwell", 1949);

// Сериализуем объект Book в строку JSON
        String jsonString = objectMapper.writeValueAsString(book);
        System.out.println("Serialized JSON: " + jsonString);

// Сохраняем JSON строку в файл
        Files.write(Paths.get("book.json"), jsonString.getBytes());

// Чтение JSON строки из файла
        String readJson = new String(Files.readAllBytes(Paths.get("book.json")));

// Десериализация JSON строки из файла обратно в объект
        Book deserializedBook = objectMapper.readValue(readJson, Book.class);
        System.out.println("Deserialized Object from File: " + deserializedBook);
    }

    public static class Book {
        private String title;
        private String author;
        private int year;

        // Пустой конструктор необходим для Jackson
        public Book() {}

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

// Геттеры и сеттеры

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        public int getYear() { return year; }
        public void setYear(int year) { this.year = year; }

        @Override
        public String toString() {
            return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
        }
    }
}
