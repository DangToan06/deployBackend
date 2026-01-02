package tyler.example.TodoList;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Cho phép tất cả các đường dẫn
                .allowedOrigins("*") // TẠM THỜI cho phép mọi nơi truy cập (Frontend, Postman...)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false); // Nếu để allowedOrigins("*") thì cái này phải là false
    }
}