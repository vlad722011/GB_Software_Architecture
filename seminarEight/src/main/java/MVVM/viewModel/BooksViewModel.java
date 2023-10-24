package MVVM.viewModel;

import MVVM.model.Book;

import java.util.List;

public class BooksViewModel {
    private final List<Book> books;

    public BooksViewModel(List<Book> books) {
        this.books = books;
    }

    public String getDisplayableBooks() {
        StringBuilder builder = new StringBuilder("Список книг:\n");
        for (int i = 0; i < books.size(); i++) {
            builder.append((i + 1)).append(". ").append(books.get(i).toString()).append("\n");
        }
        return builder.toString();
    }

    public void markBookAsRead(int index) {
        books.get(index).markAsRead();
    }
}
