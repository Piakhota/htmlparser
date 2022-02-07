package com.piakhota.htmlparser.service;

import com.piakhota.htmlparser.model.Word;
import com.piakhota.htmlparser.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word findByWordName(String wordName){
        return wordRepository.getById(wordName);
    }

    public List<Word> findAll(){
        return wordRepository.findAll();
    }

    public Word saveWord(Word word){
        return wordRepository.save(word);
    }

    public List<Word> saveAll(List<Word> wordList) {
        return wordRepository.saveAll(wordList);
    }

    public void deleteByWordName(String wordName) {
        wordRepository.deleteById(wordName);
    }

    public void deleteAll(){
        wordRepository.deleteAll();
    }
}
