package com.piakhota.htmlparser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="words")
public class Word {
    @Id
    @Column(name="word_name")
    private String wordName;

    @Column(name="word_count")
    private int wordCount;

    public Word() {
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String word) {
        this.wordName = word;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
