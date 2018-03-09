package me.abebe.demo;

import me.abebe.demo.model.AppUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category")
    private Category category;

    @Column (name = "topic")
    private String topic;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> users;

    public Profile(String topic) {
        this.topic = topic;
        this.users = new HashSet<>();
    }
    public void addUser (AppUser user){
        this.users.add(user);
    }

    public Profile() {
        this.users = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", category=" + category +
                ", topic='" + topic + '\'' +
                ", users=" + users +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
