package MVVM.view;

import MVVM.model.Book;
import MVVM.viewModel.BooksViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MVVMPatternDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Властелин Колец"));
        books.add(new Book("1984"));
        books.add(new Book("Убить пересмешника"));

        BooksViewModel viewModel = new BooksViewModel(books);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(viewModel.getDisplayableBooks());
            System.out.print("Введите номер книги, чтобы отметить ее как прочитанную (или 'exit' для выхода): ");

            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int bookId = Integer.parseInt(input) - 1;
                viewModel.markBookAsRead(bookId);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите номер книги.");
            }
        }
    }
}
