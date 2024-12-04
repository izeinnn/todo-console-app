package ToDo;

import ToDo.model.ToDO;
import ToDo.service.ToDoServiceImpl;
import ToDo.starter.Starter;

public class Main {
    public static void main(String[] args) throws Exception {
        Starter starter= new Starter(new ToDO(),new ToDoServiceImpl());
        starter.start();
    }
}