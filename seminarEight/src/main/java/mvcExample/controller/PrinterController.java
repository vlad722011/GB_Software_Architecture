package mvcExample.controller;

import mvcExample.model.PrinterUpperCase;

public class PrinterController {
    PrinterUpperCase printerUpperCase;

    public PrinterController(PrinterUpperCase printerUpperCase) {
        this.printerUpperCase = printerUpperCase;
    }

    public void print(String str) {
        printerUpperCase.print(str);
    }

}
