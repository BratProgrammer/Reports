FROM openjdk:22-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar файл
COPY target/reports.jar app.jar

# Открываем порт, который будет использовать приложение
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]

