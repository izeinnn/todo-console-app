package ToDo.service;

import ToDo.model.ToDO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ToDoServiceImpl implements ToDoService {
    //DI  constructor injection.
    private ToDO toDO;
    public ToDoServiceImpl(ToDO toDO) {
        this.toDO = toDO;
    }
    //
    public ToDoServiceImpl() {}

    //JDBC
    String URL = "jdbc:postgresql://localhost:5432/tasks";
    String USER = "postgres";
    String PASS = "00000";
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }


    //Methods
    @Override
    public void seeAllTask() {
        System.out.println("*************************");
        String query = "SELECT * FROM task";
        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("*************************");
    }

    @Override
    public void addTask(Integer id ,String   title, ToDO.Status status) {
        String query = "INSERT INTO task (id, title,status) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setInt(1, id);
            st.setString(2, title);
            st.setString(3, status.name());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTask(Integer id, String t, ToDO.Status s) {
        String query = "UPDATE task SET title = ?, status = ? WHERE id = ?";
        try {
            Connection con= connect();
            PreparedStatement st=con.prepareStatement(query);
            st.setString(1,t);
            st.setString(2,s.name());
            st.setInt(3,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeTask(Integer id) {
        String query="DELETE  FROM task where id=?";
        try {
            Connection con= connect();
            PreparedStatement st=con.prepareStatement(query);
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
