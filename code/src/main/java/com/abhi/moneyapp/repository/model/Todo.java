package com.abhi.moneyapp.repository.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "todo")
@Table(name = "todo_table")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name = "description", nullable = false)
    private String description;

//    @Column(name = "done", columnDefinition = "TINYINT(1)")
//    private boolean completionStatus;

    @Column(name = "todo_status",columnDefinition = "varchar(1) default 'O'")
    private String completionStatus;

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "user_todo_mapping",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "mapping_todo_tags",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();


    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }

    public void addTags(Tag tag){
        this.tags.add(tag);
        tag.getTodos().add(this);
    }

    public void removeTag(Tag tag){
        this.tags.remove(tag);
        tag.getTodos().remove(this);
    }


    public long getId() {
        return id;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public boolean isCompletionStatus() {
//        return completionStatus;
//    }
//
//    public void setCompletionStatus(boolean completionStatus) {
//        this.completionStatus = completionStatus;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
