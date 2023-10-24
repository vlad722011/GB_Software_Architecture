package MVPVM.presenter;

import MVPVM.view.TaskView;
import MVPVM.model.Task;
import MVPVM.viewModel.TaskViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskPresenter {
    private List<Task> tasks = new ArrayList<>();
    private TaskView view;

    public TaskPresenter(TaskView view) {
        this.view = view;
        tasks.add(new Task("Помыть посуду"));
        tasks.add(new Task("Постирать белье"));
    }

    public void displayTasks() {
        List<TaskViewModel> taskViewModels = tasks.stream()
                .map(TaskViewModel::new)
                .collect(Collectors.toList());
        view.showTasks(taskViewModels);
    }

    public void completeTask(int index) {
        tasks.get(index).complete();
        displayTasks();
    }
}
