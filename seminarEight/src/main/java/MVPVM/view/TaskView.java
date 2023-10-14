package MVPVM.view;

import MVPVM.viewModel.TaskViewModel;

import java.util.List;

public interface TaskView {
    void showTasks(List<TaskViewModel> taskViewModels);
}
