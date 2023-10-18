package jsonExample;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDemo {
    public static void main(String[] args) throws Exception {
// Создаем объект ObjectMapper для преобразования между объектами Java и JSON
        ObjectMapper objectMapper = new ObjectMapper();

// 1. Создаем новый объект Book
        Book book = new Book("1984", "George Orwell", 1949);

// 2. Сериализуем объект Book в строку JSON
        String jsonString = objectMapper.writeValueAsString(book);
        System.out.println("Serialized JSON: " + jsonString);

// 3. Десериализуем строку JSON обратно в объект Book
        Book deserializedBook = objectMapper.readValue(jsonString, Book.class);
        System.out.println("Deserialized Object: " + deserializedBook);
    }
}
