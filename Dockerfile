# --- Stage 1: Build ứng dụng bằng Maven ---
# Dùng maven kèm eclipse-temurin thay vì openjdk cũ
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --- Stage 2: Chạy ứng dụng ---
# Dùng eclipse-temurin bản chuẩn
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]