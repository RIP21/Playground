package com.los;

public class StripHtmlTags {

    public String stripHtmlTags(String html) {
        final String openOrClosingTag = "(<|</)";
        final String anyWord = "\\w+";
        final String tagClose = ">";
        final String matchAnyHtmlTag = openOrClosingTag + anyWord + tagClose;
        final String allSpaces = "\\s+";
        return html
                .replaceAll(matchAnyHtmlTag, " ")
                .replaceAll(allSpaces, " ")
                .trim();
    }
}
