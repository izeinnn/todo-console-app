package ToDo;

public class Main {
    public static void main(String[] args) throws Exception {
        Starter starter= new Starter(new ToDO(),new ToDoOperation());
        starter.start();

    }

}