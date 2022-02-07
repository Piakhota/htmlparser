package com.piakhota.htmlparser;

import com.piakhota.htmlparser.model.Link;
import com.piakhota.htmlparser.model.Word;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserByLink {
    private Link link;

    public ParserByLink(Link link) {
        this.link = link;
    }

    public List<Word> toParse() {
        String delimeters = "[ ,.!?\";:\\[\\]\\(\\)\n\r\t]";
        return getUniqueWords(toSplitText(getBody(),delimeters));
    }

    public String getBody() {
        String body = "";
        try {
            body = Jsoup.parse(new URL(link.getLink()), 10_000).text().toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public String[] toSplitText(String text, String delimeters) {
        String[] wordsArray = text.split(delimeters);
        return wordsArray;
    }

    public List<Word> getUniqueWords(String[] wordsArray) {
        Map<String, Integer> uniqueWordsMap = new HashMap<>();
        for (String word: wordsArray) {
            if (!word.equals("")){
                uniqueWordsMap.put(word, uniqueWordsMap.getOrDefault(word, 0) + 1);
            }
        }
        List<Word> wordList = new ArrayList<>();
        for (String key: uniqueWordsMap.keySet()) {
            Word word = new Word();
            word.setWordName(key);
            word.setWordCount(uniqueWordsMap.get(key));
            wordList.add(word);
        }
        return wordList;
    }
}
