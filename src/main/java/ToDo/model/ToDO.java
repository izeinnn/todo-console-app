package ToDo.model;

public class ToDO {
    private Integer id;
    private String title;
    private Status status;

    public enum Status {InProgress, Done}



    public ToDO(Integer id, String title, Status status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public ToDO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tasks: \n" +
                "id= \n" + id +
                "title= \n" + title + '\'' +
                "status= \n" + status ;
    }
}


