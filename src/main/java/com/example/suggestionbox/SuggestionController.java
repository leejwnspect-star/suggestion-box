package com.example.suggestionbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SuggestionController {

    @Autowired
    private SuggestionRepository suggestionRepository; // DB 리모컨 가져오기

    @GetMapping("/suggestion")
    public String showSuggestionPage() {
        return "suggestion";
    }

    @PostMapping("/submit-suggestion")
    @ResponseBody
    public String submitSuggestion(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("content") String content) {

        try {
            // 1. 새로운 건의사항 객체 껍데기 생성
            Suggestion suggestion = new Suggestion();
            suggestion.setTitle(title);
            suggestion.setAuthor(author);
            suggestion.setContent(content);

            // 2. 리모컨으로 DB에 영구 저장! (메모장 대신 진짜 창고에 저장됨)
            suggestionRepository.save(suggestion);

            return "<h1>제출 성공!</h1><p>건의사항이 안전하게 전송 및 저장되었습니다.</p><a href='/suggestion'>돌아가기</a>";

        } catch (Exception e) {
            e.printStackTrace();
            return "<h1>제출 실패 ㅠㅠ</h1><p>오류가 발생했습니다.</p>";
        }
    }
}