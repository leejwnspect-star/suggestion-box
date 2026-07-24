package com.example.suggestionbox;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 이 클래스는 데이터베이스에 저장할 뼈대라는 뜻입니다.
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 데이터마다 붙는 고유 번호 (1번 글, 2번 글...)

    private String title;
    private String author;
    private String content;

    // --- 데이터를 넣고 빼기 위한 기본 기능들 (Getter / Setter) ---
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}