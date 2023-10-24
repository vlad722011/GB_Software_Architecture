package MVI;

import MVI.model.TaskCompletedIntent;
import MVI.presenter.TasksPresenter;
import MVI.view.BaseView;
import MVI.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseView view = new ConsoleView();
        TasksPresenter presenter = new TasksPresenter(view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            presenter.loadTasks();
            System.out.print("Введите номер задачи, чтобы отметить ее как завершенную (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int taskId = Integer.parseInt(input) - 1;
                presenter.dispatch(new TaskCompletedIntent(taskId));
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите номер задачи.");
            }
        }
    }
}
