package umlExample;

// Класс для Presenter
public class CalculatorPresenter implements ViewObserver {
    protected CalculatorView calculatorView;
    protected CalculatorModel calculatorModel;

    public void onCalculate(String operation, double a, double b) {
        double result = 0;
        switch (operation) {
            case "add":
                result = calculatorModel.add(a, b);
                break;
            case "subtract":
                result = calculatorModel.subtract(a, b);
                break;
            case "multiply":
                result = calculatorModel.multiply(a, b);
                break;
            case "divide":
                result = calculatorModel.divide(a, b);
                break;
        }
        calculatorView.updateResult(result);
    }

    public void onClear() {
        calculatorView.clearScreen();
    }
}
