# 1단계: 빌드 환경 (Java 21 + 최신 Gradle)
FROM gradle:8.10-jdk21 AS builder
WORKDIR /app
COPY . .
# Toolchain 다운로드 무시 옵션 추가하여 빌드
RUN gradle build -x test --no-daemon -Porg.gradle.java.installations.auto-download=false

# 2단계: 실행 환경 (Java 21)
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
