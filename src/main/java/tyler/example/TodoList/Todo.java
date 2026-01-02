package tyler.example.TodoList;

public class Todo {
    private int id;
    private String title;
    private boolean completed;

    // Constructor (Hàm khởi tạo)
    public Todo(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters và Setters (Để lấy và gán dữ liệu)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
}