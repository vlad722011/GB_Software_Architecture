package MVI.model;

/**
 * TaskCompletedIntent - намерение отметить задачу как завершенную.
 */
public class TaskCompletedIntent implements Intent {

    int taskId;

    public TaskCompletedIntent( int taskId){
            this.taskId = taskId;
        }

        public int getTaskId () {
            return taskId;
        }
    }
