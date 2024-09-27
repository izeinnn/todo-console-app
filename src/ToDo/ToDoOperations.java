package ToDo;

public interface ToDoOperations {
    void seeAllTask();
    void addTask(Integer id ,String title,  ToDO.Status s);
    void removeTask(Integer id);
    void updateTask(Integer id,String title,ToDO.Status s);
}
