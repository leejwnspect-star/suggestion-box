package com.example.suggestionbox;

import org.springframework.data.jpa.repository.JpaRepository;

// 자바가 이 인터페이스를 보면 자동으로 데이터 저장/삭제 기능을 다 만들어 줍니다! 엄청 편하죠?
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
}