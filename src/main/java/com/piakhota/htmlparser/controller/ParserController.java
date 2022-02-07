package com.piakhota.htmlparser.controller;

import com.piakhota.htmlparser.ParserByLink;
import com.piakhota.htmlparser.model.Link;
import com.piakhota.htmlparser.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParserController {
    private final WordService wordService;

    @Autowired
    public ParserController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("words", wordService.findAll());
        model.addAttribute("link", new Link());
        return "index";
    }

    @PostMapping
    public String newLink(Link link) {
        wordService.deleteAll();
        wordService.saveAll(new ParserByLink(link).toParse());
        return "redirect:/";
    }
}
