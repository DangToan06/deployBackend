package tyler.example.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    // Chỉ cần viết thế này, Spring Boot tự động cho bạn các hàm:
    // .findAll() -> Lấy tất cả
    // .save()    -> Lưu mới
    // .delete()  -> Xóa
}