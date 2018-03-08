package me.abebe.demo;

import java.util.List;

public class Sources {
    private String id;
    private String name;
    private String description;
    private String url;
    private NewsCategory category;
    private Language language;
    private Country country;
    private List<String> logos;
    private List<Sorting> sortingMethods;

    public List<Sorting> getSortingMethods() {
        return sortingMethods;
    }

    public void setSortingMethods(List<Sorting> sortingMethods) {
        this.sortingMethods = sortingMethods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NewsCategory getCategory() {
        return category;
    }

    public void setCategory(NewsCategory category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<String> getLogos() {
        return logos;
    }

    public void setLogos(List<String> logos) {
        this.logos = logos;
    }
}
