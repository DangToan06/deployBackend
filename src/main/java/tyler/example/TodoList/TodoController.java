package tyler.example.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos") // Đổi thành /api/todos cho chuẩn chuyên nghiệp
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // 1. Lấy danh sách (GET)
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 2. Thêm mới - Lưu vào Database (POST)
    // Đây chính là chức năng bạn yêu cầu
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        // Khi gọi lệnh này, Hibernate sẽ tự động sinh câu SQL: INSERT INTO todos...
        return todoRepository.save(todo);
    }

    // 3. Cập nhật trạng thái hoặc tên (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo todoDetails) {
        // Tìm xem todo có tồn tại không
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        // Cập nhật thông tin mới
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.getCompleted());

        // Lưu lại (Lúc này .save() sẽ đóng vai trò là UPDATE)
        final Todo updatedTodo = todoRepository.save(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    // 4. Xóa công việc (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.delete(todo);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }
}