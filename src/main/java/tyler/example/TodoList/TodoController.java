package tyler.example.TodoList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos") // Đường dẫn gốc là /todos
public class TodoController {

    private List<Todo> todoList = new ArrayList<>();

    // Tạo dữ liệu giả để test
    public TodoController() {
        todoList.add(new Todo(1, "Học Java Spring Boot", false));
        todoList.add(new Todo(2, "Làm bài tập về nhà", true));
    }

    @GetMapping // Khi truy cập GET /todos
    public List<Todo> getTodos() {
        return todoList;
    }
}