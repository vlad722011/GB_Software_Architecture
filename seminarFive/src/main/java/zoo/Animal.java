package zoo;

// Горизонтальные уровни архитектуры
class Animal {
    // Базовый класс для всех животных
    String name;
    int age;

    void eat() {
        // Реализация еды для всех животных
    }
}

class NonPredator extends Animal {
    // Горизонтальный уровень для травоядных
    void graze() {
        // Логика пастбища для травоядных
    }
}

class Predator extends Animal {
    // Горизонтальный уровень для хищников
    String huntingMethod;

    void hunt() {
        // Логика охоты для хищников
    }
}

// Вертикальные срезы архитектуры
class Lion extends Predator {
    // Вертикальный срез для львов
    void roar() {
        // Львиный рев
    }
}

class Eagle extends Predator {
    // Вертикальный срез для орлов
    void soar() {
        // Полет орла
    }
}