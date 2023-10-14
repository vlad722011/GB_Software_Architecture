package calculator;

// Горизонтальные уровни архитектуры калькулятора

import calculator.sum.SumOperation;

// Уровень ввода и вывода
class InputOutputLayer {
    String getInput() {
        // Чтение ввода пользователя
        return "";
    }

    void displayOutput(String result) {
        // Вывод результата на экран
    }
}

// Уровень вычислений
class CalculationLayer {
    double add(double a, double b) {
        SumOperation sumOperation = new SumOperation(a,b);
        return sumOperation.sum();
    }

    double subtract(double a, double b) {
        // Вычитание
        return 1.0;
    }

    double multiply(double a, double b) {
        // Умножение
        return 1.0;
    }

    double divide(double a, double b) {
        // Деление
        return 1.0;
    }
}

// Уровень управления
class ControlLayer {
    InputOutputLayer ioLayer;
    CalculationLayer calcLayer;

    ControlLayer() {
        ioLayer = new InputOutputLayer();
        calcLayer = new CalculationLayer();
    }

    void runCalculator() {
        String input = ioLayer.getInput();
        // Анализ ввода и управление вычислениями
        // Вывод результата с использованием ioLayer
    }
}