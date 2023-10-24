package patterns.compositeTwo;

import java.util.ArrayList;
import java.util.List;

// Общий интерфейс для файлов и папок
interface FileSystemItem {
    void print();
}

// Конкретный класс для файлов
class File implements FileSystemItem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Файл: " + name);
    }
}

// Конкретный класс для папок
class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    @Override
    public void print() {
        System.out.println("Папка: " + name);
        for (FileSystemItem item : items) {
            item.print();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем файлы
        FileSystemItem file1 = new File("file1.txt");
        FileSystemItem file2 = new File("file2.txt");
        FileSystemItem file3 = new File("file3.txt");

        // Создаем папки
        Folder folder1 = new Folder("Папка 1");
        Folder folder2 = new Folder("Папка 2");

        // Добавляем файлы в папки
        folder1.addItem(file1);
        folder1.addItem(file2);
        folder2.addItem(file3);

        // Создаем верхний уровень файловой системы
        Folder root = new Folder("Корневая папка");

        // Добавляем папки в корневую папку
        root.addItem(folder1);
        root.addItem(folder2);

        // Выводим структуру файловой системы
        root.print();
    }
}
