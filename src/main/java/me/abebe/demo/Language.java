package me.abebe.demo;

public enum Language {
    ENGLISH("en"),
    GERMAN("de"),
    FRENCH("fr");

    private String languageCode;

    Language(final String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
