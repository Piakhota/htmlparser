package com.piakhota.htmlparser.repository;

import com.piakhota.htmlparser.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word,String> {
}
