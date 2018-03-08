package me.abebe.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Articles {

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Sources sources;
    private Date publishedAt;
    private Value value;
    private NewsApi newsApi;



    @Override
    public String toString() {
        return "Articles{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt=" + publishedAt +
                ", value=" + value +
                '}';
    }

    public NewsApi getNewsApi() {
        return newsApi;
    }

    public void setNewsApi(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Sources getSources() {
        return sources;
    }

    public void setSources(Sources sources) {
        this.sources = sources;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
