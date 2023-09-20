package test.additionalInformation;

// Интерфейс с абстрактным методом
interface Payable {
    // Абстрактный метод (Abstract Method)
    void payTuition();
}

// Класс с реализацией интерфейса
class CollegeStudent extends Student implements Payable {
    // Атрибут с модификатором final (Final Attribute)
    final String collegeName;

    // Конструктор
    public CollegeStudent(String name, int age, String id, String collegeName) {
        super(name, age, id);
        this.collegeName = collegeName;
    }

    // Реализация абстрактного метода
    @Override
    public void payTuition() {
        System.out.println("Paying college tuition.");
    }
}

// Главный класс (Main Class)
/*
 * Дополнительная информация часто представлена в виде атрибутов
 * и методов внутри классов, а также модификаторов доступа
 * и аннотаций. Вот пример кода на Java, который включает эти элементы:
 * В этом примере дополнительная информация включает:
 *
 * Видимость: Модификаторы public, protected, и private показывают уровень доступа к атрибутам и методам.
 * Статические методы: staticMethod является статическим методом класса Student.
 * Финальные атрибуты: В классе CollegeStudent, collegeName является финальным атрибутом.
 * Аннотации: Используется аннотация @Override для переопределения метода toString.
 * Эти детали также можно визуализировать на UML-диаграмме
 * для более полного понимания структуры кода.
 */
public class Main {
    public static void main(String[] args) {
        // Использование объектов (Usage)
        Student student = new Student("John", 20, "S123");
        CollegeStudent collegeStudent = new CollegeStudent("Emily", 22, "C456", "Some College");

        // Вызов методов
        student.study();
        collegeStudent.payTuition();
    }
}
