package me.abebe.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
private long id;
private String title;

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
