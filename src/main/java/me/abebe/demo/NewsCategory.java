package me.abebe.demo;

public enum NewsCategory {
    BUSINESS("business"),
    ENTERTAINMENT("entertainment"),
    GENERAL("general"),
    HEALTH("health"),
    SCIENCE("science"),
    SPORT("sport"),
    TECHNOLOGY("technology");

    private final String categoryId;

    NewsCategory(final String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
}