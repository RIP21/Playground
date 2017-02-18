package com.los;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StripHtmlTagsTest {

    @Test
    @DisplayName("Smoke Test")
    void stripHtmlTags() {
        //given
        String html = "<h1>Hello World!</h1> <p>something</p>";
        //when
        String result = new StripHtmlTags().stripHtmlTags(html);
        //then
        assertTrue("Hello World! something".equals(result));
    }

}