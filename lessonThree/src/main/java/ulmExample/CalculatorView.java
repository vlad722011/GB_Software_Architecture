package ulmExample;

import java.util.Observer;

// Интерфейс для View
interface CalculatorView {
    void setObserver(ViewObserver observer);
    void updateResult(double result);
    void clearScreen();
}
