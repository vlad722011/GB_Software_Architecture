package hexagonalArchitecture;

// Бизнес-сущность
class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

// Порт для работы с пользователями
interface UserRepository {
    void saveUser(User user);
    User getUserByName(String name);
}

// Адаптер для работы с базой данных
class DatabaseUserRepository implements UserRepository {
    @Override
    public void saveUser(User user) {
        // Реализация сохранения в базе данных
    }

    @Override
    public User getUserByName(String name) {
        // Реализация получения пользователя из базы данных
        return null;
    }
}

// Порт для взаимодействия с пользовательским интерфейсом
interface UserInterface {
    void displayMessage(String message);
    String getUserInput();
}

// Адаптер для консольного пользовательского интерфейса
class ConsoleUserInterface implements UserInterface {
    @Override
    public void displayMessage(String message) {
        // Реализация отображения сообщения в консоли
    }

    @Override
    public String getUserInput() {
        // Реализация получения ввода пользователя из консоли
        return null;
    }
}
