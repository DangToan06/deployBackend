package tyler.example.TodoList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 1. Báo hiệu class này là một bảng (Table)
@Table(name = "todos") // 2. Tên bảng trong database là "todos"
public class Todo {

    @Id // 3. Khóa chính (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Id tự động tăng (1, 2, 3...)
    private Integer id;

    private String title;
    private Boolean completed;

    // --- BẮT BUỘC PHẢI CÓ Constructor rỗng (No-args constructor) cho JPA ---
    public Todo() {
    }

    // Constructor có tham số (để mình dùng cho tiện)
    public Todo(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // --- Getter và Setter (Bắt buộc để lấy và gán dữ liệu) ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }
}