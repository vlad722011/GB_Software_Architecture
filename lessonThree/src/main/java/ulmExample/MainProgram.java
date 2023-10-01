package ulmExample;

// Главный класс программы
public class MainProgram {
    public static void main(String[] args) {
        // Инициализация объектов и установка связей
        CalculatorPresenter presenter = new CalculatorPresenter();
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorViewImpl(); // Предположим, что CalculatorViewImpl реализует CalculatorView

        presenter.calculatorView = view;
        presenter.calculatorModel = model;
        view.setObserver(presenter);

        // Далее идёт логика работы программы
    }
}
