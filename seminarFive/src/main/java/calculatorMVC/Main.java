package calculatorMVC;

import calculatorMVC.view.ConsoleView;
import calculatorMVC.view.IView;

public class Main {
    public static void main(String[] args) {
        IView view = new ConsoleView();
        view.runCalculator();
    }
}

