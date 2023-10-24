package bce;

import java.util.Scanner;

// Граница (Boundary)
class UserInterface {
    void displayMessage(String message) {
        // Отображение сообщения пользователю
        System.out.println(message);
    }

    String getUserInput() {
        // Получение ввода от пользователя
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

// Управление (Control)
class UserController {
    private UserInterface ui;

    UserController(UserInterface ui) {
        this.ui = ui;
    }

    void processUserInput() {
        String userInput = ui.getUserInput();
        // Логика обработки ввода
        ui.displayMessage("Результат: " + userInput);
    }
}

// Сущность (Entity)
class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}