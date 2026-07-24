# 1단계: 빌드 환경
FROM gradle:7.6-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build -x test --no-daemon

# 2단계: 실행 환경
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
