package com.example.springioc.event;


import javax.validation.constraints.*;

public class Event {
    Integer id;

    @NotEmpty
    String title;
    @NotNull @Min(0)// 최소 0이상 //@Size(min=0) // 최소 0 이상 collection size 주의
    Integer limit;
    @Email
    String email;

    public Event(Integer id) {
        this.id = id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", limit=" + limit +
                ", email='" + email + '\'' +
                '}';
    }
}
