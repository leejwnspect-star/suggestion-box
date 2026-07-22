# Java 17 공식 최신 이미지 사용
FROM eclipse-temurin:17-jdk-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 jar 파일 복사
COPY build/libs/*.jar app.jar

# 8080 포트 개방
EXPOSE 8080

# 앱 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
