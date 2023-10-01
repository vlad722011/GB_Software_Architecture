package ulmExample;

// Интерфейс для Observer
interface ViewObserver {
    void onCalculate(String operation, double a, double b);
    void onClear();
}
