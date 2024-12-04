package ToDo.service;

import ToDo.model.ToDO;

public interface ToDoService {
    void seeAllTask();
    void addTask(Integer id ,String title,  ToDO.Status s);
    void removeTask(Integer id);
    void updateTask(Integer id,String title,ToDO.Status s);
}
