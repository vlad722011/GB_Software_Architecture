package mvcExample.view;

import mvcExample.controller.PrinterController;

import java.util.Scanner;

public class ConsoleView {
    PrinterController printerController;
    Scanner scanner = new Scanner(System.in);

    public ConsoleView(PrinterController printerController) {
        this.printerController = printerController;
    }

    public void run() {
        System.out.print("Введите сообщение для печати капсом: ");
        String input = scanner.nextLine();
        printerController.print(input);
    }


}
