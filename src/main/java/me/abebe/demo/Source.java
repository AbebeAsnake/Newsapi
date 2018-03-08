package me.abebe.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {
    private String id;
    private String name;
    //private String description;
   // private String url;
    //private Category category;
    //private Language language;
    //private Country country;
    //private List<String> logos;
    //private List<Sorting> sortingMethods;

    /*public List<Sorting> getSortingMethods() {
        return sortingMethods;
    }

    public void setSortingMethods(List<Sorting> sortingMethods) {
        this.sortingMethods = sortingMethods;
    }*/

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Source() {
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

    /*public String getDescription() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
    }*/
}
