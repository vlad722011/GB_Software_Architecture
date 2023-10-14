package mvcExample;

import mvcExample.controller.PrinterController;
import mvcExample.model.PrinterUpperCase;
import mvcExample.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        PrinterUpperCase printerUpperCaseMODEL = new PrinterUpperCase();
        PrinterController printerControllerCONTROLLER = new PrinterController(printerUpperCaseMODEL);
        ConsoleView view = new ConsoleView(printerControllerCONTROLLER);
        view.run();
    }
}
