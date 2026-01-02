# --- Stage 1: Build ứng dụng bằng Maven ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# Lệnh này sẽ build ra file .jar và bỏ qua bước test để tiết kiệm thời gian
RUN mvn clean package -DskipTests

# --- Stage 2: Chạy ứng dụng bằng JDK ---
# Lưu ý: Nếu bạn dùng Java 21 thì sửa số 17 thành 21
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy file .jar từ Stage 1 sang Stage 2
COPY --from=build /app/target/*.jar app.jar

# Mở port 8080 (chỉ để khai báo)
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]