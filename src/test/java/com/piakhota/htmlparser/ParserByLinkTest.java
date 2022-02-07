package com.piakhota.htmlparser;

import com.piakhota.htmlparser.model.Link;
import org.junit.Test;


import static org.junit.Assert.*;

public class ParserByLinkTest {
    String text = "string1 string2.string3:,,string4?string5!string6;string7[string8:string9\tstring1(";
    String delimiters = "[ ,.!?\";:\\[\\]\\(\\)\n\r\t]";
    String[] wordsArray = {"string1", "string2", "string3", "", "","string4", "string5", "string6", "string7", "string8", "string9", "string1"};

    @Test
    public void toSplitTextTest() {
        String[] result = new ParserByLink(new Link()).toSplitText(text, delimiters);
        assertArrayEquals(wordsArray, result);
    }

}